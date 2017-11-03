package November.week1;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    private Node head = null;
    private int cap = 0;
    private Map<Integer, Integer> valueHash = null;
    private Map<Integer, Node> nodeHash = null;

    public LFUCache(int capacity) {
        this.cap = capacity;
        valueHash = new HashMap<>();
        nodeHash = new HashMap<>();
    }

    public int get(int key) {
        if (valueHash.containsKey(key)) {
            increaseCount(key);
            return valueHash.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cap == 0) return;
        if (valueHash.containsKey(key)) {
            valueHash.put(key, value);
        } else {
            if ((valueHash.size() >= cap)) {
                removeOld();
            }
            valueHash.put(key, value);
            addToHead(key);
        }

        increaseCount(key);
    }

    private void addToHead(int key) {
        if (head == null) {
            head = new Node(0);
            head.keys.add(key);
        } else if (head.count > 0 ) {
            Node node = new Node(0);
            node.keys.add(key);
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            head.keys.add(key);
        }
        nodeHash.put(key, head);
    }

    private void increaseCount(int key) {
        Node node = nodeHash.get(key);
        node.keys.remove(key);

        if (node.next == null) {
            node.next = new Node(node.count + 1);
            node.next.prev = node;
            node.next.keys.add(key);
        } else if(node.next.count == node.count + 1) {
            node.next.keys.add(key);
        } else {
            Node temp = new Node(node.count + 1);
            temp.keys.add(key);
            temp.prev = node;
            temp.next = node.next;
            node.next.prev = temp;
            node.next = temp;
        }

        nodeHash.put(key, node.next);
        if (node.keys.size() == 0) remove(node);

    }

    private void removeOld() {
        if (head == null) return;
        int old = 0;
        for (int n: head.keys) {
            old = n;
            break;
        }

        head.keys.remove(old);
        if (head.keys.size() == 0) {
            remove(head);
        }
        valueHash.remove(old);
        nodeHash.remove(old);
    }

    private void remove(Node node) {
        // this node is head if the pre == null
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }



    class Node {
        // count means reference count
        public int count = 0;
        // Keys are the keys has the same reference count
        public LinkedHashSet<Integer> keys;
        public Node prev = null, next = null;

        public Node(int count) {
            this.count = count;
            keys = new LinkedHashSet<>();
            prev = next = null;
        }
    }

}
