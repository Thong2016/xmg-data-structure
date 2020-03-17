package vip.tanghong.datastructure.linked;

import vip.tanghong.datastructure.interfaces.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list);
    }

}
