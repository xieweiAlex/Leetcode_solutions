package June.week1;

/**
 * Created by Alex_Xie on 02/06/2017.
 Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?

 https://leetcode.com/problems/linked-list-cycle/#/description

 */
public class LinkedListHasCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }

        return false;
    }
}
