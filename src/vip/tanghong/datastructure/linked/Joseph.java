package vip.tanghong.datastructure.linked;

/**
 * 约瑟夫环
 * @param <E>
 */
public class Joseph<E> extends AbstractList<E> {
    private Node<E> first;

    private Node<E> last;

    private class Node<E> {
        Node<E> prev;

        E element;

        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this(null, element, null);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev == null) {
                sb.append("null");
            } else {
                sb.append(prev.element);
            }
            sb.append("_").append(element).append("_");
            if (next == null) {
                sb.append("null");
            } else {
                sb.append(next.element);
            }
            return sb.toString();
        }
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        //往最后一个节点的后面添加节点
        if (index == size) {
            Node<E> oldLast = last;
            last = new Node<>(oldLast, element, first);
            if (oldLast == null) {   //添加的是第一个节点
                first = last;
                first.prev = first;
                first.next = first;
            } else {
                oldLast.next = last;
                first.prev = last;
            }
        } else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;
            prev.next = node;
            if (next == first) {  //在第一个索引位置添加节点
                first = node;
            }
        }
        size++;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node<E> node = node(index);
        if (size == 1) {
            first = last = null;
        }else {
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;

            if(node == first) {
                first = next;
            }
            if(node == last) {
                last = prev;
            }
        }

        size--;
        return node.element;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private Node<E> node(int index) {
        rangeCheck(index);

        Node<E> node = first;
        int mid = size >> 1;
        if (index <= mid) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(size).append(",[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                sb.append(node.element);
            } else {
                sb.append(",").append(node.element);
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
