package beforeApril.firstDay.ForestAcademy.week2;

/**
 * Created by Alex_Xie on 20/02/2017.
 Reverse a singly linked list.

 Hint:
 A linked list can be reversed either iteratively or recursively. Could you implement both?

 https://leetcode.com/problems/reverse-linked-list/?tab=Description
 */
public class ReverseLinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode node;
        while (head != null) {
            node = head.next;
            head.next = pre;
            pre = head;
            head = node;
        }

        return pre;
    }


}
