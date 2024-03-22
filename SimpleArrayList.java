class SimpleArrayList {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public SimpleArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public void add(Object element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public void remove(Object element) {
        int index = indexOf(element);
        if (index != -1) {
            removeAtIndex(index);
        }
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return elements[index];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = elements[i];
            }
            elements = newArray;
        }
    }

    private int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }
}