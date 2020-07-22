package linkedlist;

import utils.ListNode;

public class SwapNodesInPairs {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * <p>
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     * <p>
     * <p>
     * <p>
     * Example:
     * <p>
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dmy = new ListNode(0), pre = dmy;
        dmy.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next, suc = cur.next, tmp = suc.next;
            pre.next = suc;
            suc.next = cur;
            cur.next = tmp;
            pre = cur;
        }
        return dmy.next;
    }


    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }
}