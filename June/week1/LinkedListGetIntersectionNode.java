package June.week1;

/**
 * Created by Alex_Xie on 03/06/2017.
 */
public class LinkedListGetIntersectionNode {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        //if a & b have different len, then we will stop the loop after second iteration
        while (nodeA != nodeB) {
            //for the end of first iteration, we just reset the pointer to the head of another LinkedList
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Integer lengthA = getLength(headA);
        Integer lengthB = getLength(headB);
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA --;
        }
        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB --;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private Integer getLength(ListNode head) {
        Integer length = 0;
        while (head!= null) {
            head = head.next;
            length++;
        }
        return length;
    }

}
