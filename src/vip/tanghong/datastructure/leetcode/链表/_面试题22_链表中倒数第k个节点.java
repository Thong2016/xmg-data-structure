package vip.tanghong.datastructure.leetcode.链表;

import vip.tanghong.datastructure.leetcode.链表.ListNode;

public class _面试题22_链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
