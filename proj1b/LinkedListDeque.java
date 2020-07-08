import org.junit.Test;

public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        private T item;
        private Node prev;
        private Node next;

        private Node() {
            item = null;
            prev = null;
            next = null;
        }
        private Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;


    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Creates a deep copy of other. */
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 1; i <= other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

    @Override
    public void addFirst(T item) {
        size += 1;
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    @Override
    public void addLast(T item) {
        size += 1;
        Node last = new Node(item, sentinel.prev, sentinel);
        sentinel.prev = last;
        last.prev.next = last;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        String result = "";
        Node p = sentinel.next;
        while (p != sentinel) {
            result += (" " + p.item);
            p = p.next;
        }
        System.out.println(result);
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T i = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return i;
    }


    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T i = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return i;
    }

    /** Gets the ith item of the LinkedListDeque iteratively */
    @Override
    public T get(int index) {
        if (index > size) {
            return null;
        }
        Node p = sentinel;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }


    /** Gets the ith item of the LinkedListDeque recursively. */
    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }
        return getRecursiveHelper(sentinel, index);
    }

    private T getRecursiveHelper(Node curr, int index) {
        if (index == 0) {
            return curr.item;
        }
        return getRecursiveHelper(curr.next, index - 1);
    }
}
