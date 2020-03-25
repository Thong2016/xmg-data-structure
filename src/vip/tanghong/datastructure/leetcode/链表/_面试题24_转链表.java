package vip.tanghong.datastructure.leetcode.链表;

public class _面试题24_转链表 {

    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode prev = head;
        while (prev != null) {
            ListNode t = prev.next;
            prev.next = cur;
            cur = prev;
            prev = t;
        }
        return cur;
    }

    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode ret = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }

}
