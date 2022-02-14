public class ArrayDeque<T> {
    private int size;
    private T[] items;
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity, int start, int index, int length) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, start, a, index, length);
        items = a;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2, 0, 1, size);
        }

        items[0] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2, 0, 0, size);
        }
        items[size] = item;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T res = items[0];
            resize(items.length, 1, 0, size - 1);
            size--;
            return res;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T res = items[size - 1];
            resize(items.length, 0, 0, size - 1);
            return res;
        }
    }

    public T get(int index) {
        return items[index];
    }


}
