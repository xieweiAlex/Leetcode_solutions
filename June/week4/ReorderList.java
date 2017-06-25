package June.week4;

/**
 * Created by Alex_Xie on 23/06/2017.
 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.

 https://leetcode.com/problems/reorder-list/#/description
 */
public class ReorderList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {

        // 1. get middle
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // cause number of nodes are **odd**, slow has to be move forward a step
        // TODO: I didn't get here.
        if (fast != null) {
            slow = slow.next;
            fast.next = null;  // TODO: it should already be null, why assign again?
        }

        // 2. reverse second half part
        ListNode secondHead = reverse(slow);

        // 3. concatenate two half parts
        ListNode newHead = head;
        while (slow != null) {
            ListNode nextSlow = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            fast = slow.next;
            slow = nextSlow;
        }

    }

    private ListNode reverse(ListNode head) {

        ListNode pre = null;
        while (head != null) {
            ListNode node = head.next;
            head.next = pre;
            pre = head;
            head = node;
        }

        return pre;
    }

}
