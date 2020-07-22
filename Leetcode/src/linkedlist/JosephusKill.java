package linkedlist;

import utils.ListNode;

public class JosephusKill {
    /**
     * 据说著名犹太历史学家 Josephus有过以下故事:
     * 在罗马人占领乔塔帕特后,39个犹太人与Josephus及他的朋友躲到一个洞中,39个犹太人决定宁愿死也不要被敌人抓到,
     * 于是决定了一种自杀方式,41个人排成一个圆圏,由第1个人开始报数,报数到3的人就自杀,然后再由下个人重新报1,报数
     * 到3的人再自杀,这样依次下去,直到剩下最后一个人时,那个人可以自由选择自己的命运。这就是著名的约瑟夫问题。
     * <p>
     * 现在请用单向环形链表描述该结构并呈现整个自杀过程。
     * 输入:一个环形单向链表的头节点head和报数的值m。
     * 返回:最后生存下来的节点,且这个节点自己组成环形单向链表,其他节点都删掉。
     * TC：O(n*m)
     */
    public ListNode josephusKill(ListNode head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        ListNode lastNode = head;
        while (lastNode.next != head) {
            lastNode = lastNode.next;
        }
        int count = 0;
        while (lastNode != head) {
            if (++count == m) {
                lastNode.next = head.next;
                count = 0;
            } else {
                lastNode = lastNode.next;
            }
            head = lastNode.next;
        }
        return head;
    }

//    public ListNode josephusKillBigON(ListNode head, int m) {
//
//    }
}
