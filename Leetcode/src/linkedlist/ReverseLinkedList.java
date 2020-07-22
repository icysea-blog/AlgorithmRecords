package linkedlist;

import utils.ListNode;

public class ReverseLinkedList {

    /**
     * Reverse a singly linked list.
     * <p>
     * Example:
     * <p>
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = newHead.next;
            newHead.next = tmp;
        }
        return newHead.next;
    }
}
