package June.week4;

/**
 * Created by Alex_Xie on 24/06/2017.

 Sort a linked list in O(n log n) time using constant space complexity.

 https://leetcode.com/problems/sort-list/#/description
 */
public class MergeSortLinkedlist {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;
        ListNode preMiddle = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            preMiddle = slow;
            slow = slow.next;
        }
        preMiddle.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }

        return dummy.next;
    }
}
