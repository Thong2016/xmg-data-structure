package vip.tanghong.datastructure.leetcode.链表;

import vip.tanghong.datastructure.interfaces.List;

public class _876_链表的中间结点 {

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head;
        int i = 0;
        while (tmp != null) {
            i++;
            tmp = tmp.next;
        }
        int middle = i / 2 + 1;
        ListNode move = head;
        for (int c = 1; c < middle; c++) {
            move = move.next;
        }

        return move;
    }

    public static ListNode middleNode2(ListNode head) {
        ListNode[] nodeArr = new ListNode[100];
        int t = 0;
        while (head != null) {
            nodeArr[t++] = head;
            head = head.next;
        }
        return nodeArr[t / 2];
    }

    public static ListNode middleNode3(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow : slow.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
//        ListNode seven = new ListNode(7);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
//        six.next = seven;

        ListNode middleNode = middleNode3(one);
        System.out.println(NodeUtils.print(middleNode));
    }

}
