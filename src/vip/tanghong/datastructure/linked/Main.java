package vip.tanghong.datastructure.linked;

import vip.tanghong.datastructure.common.ListUtil;

public class Main {

    static void josephus() {
        Joseph<Integer> list = new Joseph<>();
        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }

        // 指向头结点（指向1）
        list.reset();

        while (list.size() != 1) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
        System.out.println("最后存活的是: " + list.get(0));
    }

    public static void main(String[] args) {
        //        ListUtil.testList(new LinkedList<>());
        //                ListUtil.testList(new LinkedList2<>());
        //        ListUtil.testList(new ArrayList<>());
        //        ListUtil.testList(new SingleCircleLinkedList<>());
//        ListUtil.testList(new DoubleLinkedList<>());
//        ListUtil.testList(new DoubleCircleLinkedList<>());
        josephus();
    }

}
