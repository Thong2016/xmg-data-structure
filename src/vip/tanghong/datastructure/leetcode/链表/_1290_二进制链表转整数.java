package vip.tanghong.datastructure.leetcode.链表;

public class _1290_二进制链表转整数 {

    public static int getDecimalValue(ListNode head) {
        ListNode node = head;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public static int getDecimalValue2(ListNode head) {
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            res = res * 2 + cur.val;
            cur = cur.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(1);
        head.next = one;
        one.next = two;
        System.out.println(getDecimalValue(head));
        System.out.println(getDecimalValue2(head));
    }

}
