package vip.tanghong.datastructure.leetcode.链表;

/**
 * 删除链表中等于给定值 val 的所有节点
 */
public class _203_移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        //该while执行完之后,首节点的值一定不等于val
        while (head != null && head.val == val) {
            head = head.next;
        }
        if(head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyNode = new ListNode(val - 1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        while (prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode removeElements3(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        head.next = removeElements3(head.next, val);
        if(head.val == val) {
            return head.next;
        }else {
            return head;
        }
    }

}
