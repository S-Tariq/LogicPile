package stariq.datastructures.arraylist;

import java.util.HashMap;

public class ArrayListUsingGenerics<E> {

    private Object[] array;
    private int size;

    public ArrayListUsingGenerics() {
        array = new Object[1];
    }

    public ArrayListUsingGenerics(int capacity) {
        array = new Object[capacity];
    }

    public void add(E element) {
        if(array.length == size) {
            Object[] temp = new Object[size * 2];
            for(int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[size] = element;
        size++;
    }

    public void add(E... elements) {
        for(E element : elements) {
            add(element);
        }
    }

    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Invalid Index! Size: %s, Index: %s", size, index));
        }
        return (E)array[index];
    }

    public void set(int index, E element) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Invalid Index! Size: %s, Index: %s", size, index));
        }
        array[index] = element;
    }

    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Invalid Index! Size: %s, Index: %s", size, index));
        }
        for(int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public int indexOf(E element) {
        for(int i = 0; i < size; i++) {
            if(array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E element) {
        for(int i = 0; i < size; i++) {
            if(array[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
}
