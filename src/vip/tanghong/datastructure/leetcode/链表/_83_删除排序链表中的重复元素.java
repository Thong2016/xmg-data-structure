package vip.tanghong.datastructure.leetcode.链表;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
public class _83_删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode prev = head;
        while (prev.next != null) {
            if(prev.val == prev.next.val) {
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }

}
