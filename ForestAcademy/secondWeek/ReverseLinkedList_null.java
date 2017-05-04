package ForestAcademy.secondWeek;

/**
 * Created by Alex_Xie on 20/02/2017.
 Reverse a singly linked list.

 Hint:
 A linked list can be reversed either iteratively or recursively. Could you implement both?

 https://leetcode.com/problems/reverse-linked-list/?tab=Description
 */
public class ReverseLinkedList_null {

    // TODO; have not complete
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        return null;
    }


}
