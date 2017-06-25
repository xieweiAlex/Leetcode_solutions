package June.week4;

/**
 * Created by Alex_Xie on 24/06/2017.

 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.

 https://leetcode.com/problems/rotate-list/#/description
 */
public class RotateRight {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 1. get the totally length of list
        int length = 0;
        while (fast.next != null) {
            fast = fast.next;
            length++;
        }

        // get the break down point
        for (int i = 0; i < length - k % length; i++) {
            slow = slow.next;
        }

        // 3. Rotate
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
