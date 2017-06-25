package beforeApril.firstDay.ForestAcademy.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex_Xie on 15/02/2017.

 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.

 https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class DeleteDuplicates {

    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }


    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    // doesn't work!
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        Map<Integer, Integer> map = new HashMap<>();
        ListNode tempNode = head.next;
        while (tempNode != null) {
            Integer val = head.next.val;
            if (map.containsKey(val)) {
                tempNode = tempNode.next.next;
            } else {
                tempNode = tempNode.next;
            }
        }

        return head;
    }
}




