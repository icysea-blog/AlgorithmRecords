package linkedlist;

import utils.ListNode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int reverseLength = n - m + 1;
        ListNode preHead = null;
        ListNode result = head;
        while (head != null && --m != 0) {
            preHead = head;
            head = head.next;
        }
        ListNode reverseTail = head;
        ListNode reverseHead = new ListNode();
        while (head != null && reverseLength > 0) {
            ListNode next = head.next;
            head.next = reverseHead;
            reverseHead = head;
            head = next;
            reverseLength--;
        }
        reverseTail.next = head;
        if (preHead != null) {
            preHead.next = reverseHead;
        } else {
            result = reverseHead;
        }
        return result;
    }
}