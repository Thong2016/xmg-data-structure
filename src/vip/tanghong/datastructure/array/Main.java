package vip.tanghong.datastructure.array;

import vip.tanghong.datastructure.interfaces.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);

        list.add(1, 50);
        System.out.println(list);
    }

}
