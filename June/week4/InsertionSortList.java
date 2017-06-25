package June.week4;

/**
 * Created by Alex_Xie on 24/06/2017.

 Sort a linked list using insertion sort.
 https://leetcode.com/problems/insertion-sort-list/#/description
 */
public class InsertionSortList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // 1 -> 2 -> 6 -> 3 -> 4
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null && head.next != null) {
            if (head.val < head.next.val) {
                head = head.next;
            } else {
                ListNode curr = dummy;
                while (curr.next.val < head.next.val) {
                    curr = curr.next;
                }

                ListNode temp = head.next;
                head.next = temp.next;
                // TODO: why using head doesn't work?
                temp.next = curr.next;
                curr.next = temp;
            }
        }

        return dummy.next;
    }


}
