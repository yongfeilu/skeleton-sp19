public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private static final int INIT_CAPACITY = 8;
    private static final int RFACTOR = 2;
    private static final double MIN_USAGE_RATIO = 0.25;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[INIT_CAPACITY]; //???
        nextFirst = 4;
        nextLast = 5;

    }

    public ArrayDeque(ArrayDeque other) {
        size = other.size;
        items = (T[]) new Object[other.items.length];
        nextFirst = 4;
        nextLast = 5;
        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
        /*
        nextLast = other.nextLast;
        nextFirst = other.nextFirst;

        int start = plusOne(nextFirst);
        while (start != other.nextLast) {
            items[start] = (T) other.items[start];
            start = plusOne(start);
        } */


    }

    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        //System.arraycopy(items, 0, newArray, 0, size);
        int curr = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            newArray[i] = items[curr];
            curr = plusOne(curr);
        }

        items = newArray;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    @Override
    public void addFirst(T item){
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
    }

    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * RFACTOR);
        }
        size += 1;
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        String result = "";
        int i = plusOne(nextFirst);
        while (i != nextLast) {
            System.out.print(items[i] + " ");
            i = plusOne(i);
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T firstItem = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        size -= 1;
        nextFirst = plusOne(nextFirst);

        if (items.length >= 16 && size / items.length < MIN_USAGE_RATIO) {
            resize(items.length / 2);
        }
        return firstItem;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        int last = minusOne(nextLast);
        T lastItem = items[last];
        items[last] = null;
        size -= 1;
        nextLast = minusOne(nextLast);

        if (items.length >= 16 && size / items.length < MIN_USAGE_RATIO) {
            resize(items.length / 2);
        }
        return lastItem;
    }

    @Override
    public T get(int index) {
        if (index > size) {
            return null;
        }
        index = ((plusOne(nextFirst) + index) % items.length);
        return items[index];
    }
}

