package linkedlist;

import utils.ListNode;

import java.util.List;

public class LinkedListCycleII {

    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode cycle = head;
                while (cycle != slow) {
                    cycle = cycle.next;
                    slow = slow.next;
                }
                return cycle;
            }
        }
        return null;
    }
}
