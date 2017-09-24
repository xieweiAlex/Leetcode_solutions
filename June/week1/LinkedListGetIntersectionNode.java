package June.week1;

/**
 * Created by Alex_Xie on 03/06/2017.

 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.

 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.

 https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class LinkedListGetIntersectionNode {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        //if a & b have different len, then we will stop the loop after second iteration
        while (nodeA != nodeB) {
            //for the end of first iteration, we just reset the pointer to the head of another LinkedList
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Integer lengthA = getLength(headA);
        Integer lengthB = getLength(headB);
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA --;
        }
        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB --;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private Integer getLength(ListNode head) {
        Integer length = 0;
        while (head!= null) {
            head = head.next;
            length++;
        }
        return length;
    }

}
