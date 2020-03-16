package vip.tanghong.datastructure.array;

import vip.tanghong.datastructure.interfaces.List;

public class ArrayList<E> implements List<E> {
    //元素数量
    private int size;

    private E[] elements;

    private static final int ELEMENT_NOT_FOUND = -1;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds.");
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index + " is out of bounds.");
        }
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);

    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }

        //新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        return elements[index] = element;
    }

    @Override
    public E remove(int index) {
        E removeElement = get(index);
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return removeElement;
    }

    @Override
    public void clear() {
        //如果elements是基本类型的数组是不需要清内存的,因为基本类型存储的是值,不管清与否,数组占据的内存都是不会变的
        //如果elements是对象类型的数组则是需要清内存的,因为对象存储的是引用,将引用清除后才会释放对象所占据的内存
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}