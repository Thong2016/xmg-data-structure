package vip.tanghong.datastructure.leetcode.链表;

public class NodeUtils {

    public static String print(ListNode listNode) {
        ListNode tmp = listNode;
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (tmp != null) {
            if (tmp == listNode) {
                result.append(tmp.val);
            } else {
                result.append(",").append(tmp.val);
            }
            tmp = tmp.next;
        }
        result.append("]");
        return result.toString();
    }

}
