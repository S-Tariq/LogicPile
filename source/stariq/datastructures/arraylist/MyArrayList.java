package stariq.datastructures.arraylist;

public class MyArrayList<E> {

    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[1];
        size = 0;
    }

    public MyArrayList(int size) {
        array = new Object[size];
        this.size = size;
    }

    public void add(E element) {
        if(size >= array.length) {
            Object[] temp = new Object[size*2];
            for(int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[size] = element;
        size++;
        //Another way:
        //array[size++] = element;
    }

    public void add(E... elements) {
        for(E element : elements) {
            add(element);
        }
    }

    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Invalid Index! Size: %s, Index: %s", size, index));
        } else {
            return (E)array[index];
        }
    }

    public void set(int index, E element) {
        array[index] = element;
    }

    public void remove(int index) {
        for(int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    public boolean contains(E element) {
        for(int i = 0; i < size; i++) {
            if(array[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        for(int i = 0; i < size; i++) {
            if(array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }
}
