package October.week4;

/*

 * explain:
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

 * url:

 https://leetcode.com/problems/linked-list-cycle-ii/description/
 * solution:
 https://discuss.leetcode.com/topic/2975/o-n-solution-by-using-two-pointers-without-change-anything
*/
public class DetectCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        Boolean isCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) return null;

        // TODO: why each point move one step they could reach the beginning of cycle??
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

}
