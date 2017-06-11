package ForestAcademy.week1;

/**
 * Created by Alex_Xie on 16/02/2017.

 Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
           return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode mergeHead = null;
        if (l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

}



