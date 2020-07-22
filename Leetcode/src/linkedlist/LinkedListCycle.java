package linkedlist;

import utils.ListNode;

import java.util.List;

public class LinkedListCycle {
    /**
     * https://leetcode.com/problems/linked-list-cycle/
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
