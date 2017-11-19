package November.week3;

/*

 * explain:

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * url:
https://leetcode.com/problems/merge-k-sorted-lists/description/
 * solution:

*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode node: lists) {
            // TODO: lists is a ListNode[], why a node in list could be null???
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
        }


        return dummy.next;
    }

}




