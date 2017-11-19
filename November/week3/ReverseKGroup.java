package November.week3;

public class ReverseKGroup {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummy = head;
        int i = 0;
        while (i < k) {
            head = head.next;
        }
        ListNode temp = head.next;
        head.next = null;
        ListNode newHead = reverse(dummy);
        dummy.next = temp;

        return newHead;
    }


}
