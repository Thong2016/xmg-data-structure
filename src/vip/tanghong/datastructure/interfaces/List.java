package vip.tanghong.datastructure.interfaces;

public interface List<E> {
    int ELEMENT_NOT_FOUND = -1;

    int size();

    boolean isEmpty();

    E get(int index);

    int indexOf(E element);

    boolean contains(E element);

    void add(E element);

    void add(int index, E element);

    E set(int index, E element);

    E remove(int index);

    void clear();

}
