package vip.tanghong.datastructure.leetcode.链表;

public class _面试题_02_02_返回倒数第k个节点 {

    public int kthToLast(ListNode head, int k) {
        ListNode node = head;
        int total = 0;
        while (node != null) {
            total++;
            node = node.next;
        }
        for(int i = 0; i < total - k; i++) {
            head = head.next;
        }
        return head.val;
    }

    public int kthToLast2(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;

        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }

}
