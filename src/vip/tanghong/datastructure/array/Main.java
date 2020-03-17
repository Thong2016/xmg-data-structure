package vip.tanghong.datastructure.array;

import vip.tanghong.datastructure.interfaces.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list.isEmpty());

        System.out.println(list);
        System.out.println(list.size());

        list.add(1, 50);
        System.out.println(list);
        System.out.println();

        list.add(0, 20);
        System.out.println(list);

        System.out.println(list.get(2));

        System.out.println(list.indexOf(20));
        list.set(0, 80);
        System.out.println(list.indexOf(20));
        System.out.println(list);
        System.out.println();

        System.out.println(list.contains(20));
        System.out.println(list.contains(100));
        System.out.println();

        list.remove(1);
        System.out.println(list);

        list.clear();

        System.out.println(list);
        System.out.println();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(null);

        System.out.println(list.indexOf(20));
        System.out.println(list.indexOf(null));

    }

}
