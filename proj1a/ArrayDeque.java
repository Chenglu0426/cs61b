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
            resize(size * 2, 0, 0, size);
        }
        resize(items.length, 0, 1, size);
        size++;
        items[0] = item;

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
            if (items.length >= 16 && items.length >= 4 * size) {
                resize(items.length / 2, 0, 0, size);
            }
            return res;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T res = items[size - 1];
            resize(items.length, 0, 0, size - 1);
            size--;
            if (items.length >= 16 && items.length >= 4 * size) {
                resize(items.length / 2, 0, 0, size);
            }
            return res;
        }
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return items[index];
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }




/*    public static void main(String[] args) {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        int i = 1;
        while (i <= 9) {
            A.addLast(i);
            i += 1;
        }
        while (i < 15) {
            A.addFirst(i);
            i += 1;
        }
        System.out.println(A.removeFirst());
        System.out.println(A.removeLast());
        A.printDeque();
        System.out.println(A.get(8));
        System.out.println(A.get(7));
    }*/
}
