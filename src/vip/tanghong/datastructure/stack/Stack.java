package vip.tanghong.datastructure.stack;

import vip.tanghong.datastructure.array.ArrayList;
import vip.tanghong.datastructure.interfaces.List;

public class Stack<E> {

    private List<E> list = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public E peek() {
        return list.get(list.size() - 1);
    }

    public void clear() {
        list.clear();
    }

}
