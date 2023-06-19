package stariq.datastructures.arraylist;

/*
- Add:
The add() method on average is O(1). When the array needs to be resized, it takes O(n)
but it does not happen often which is why it is called an amortized constant time.

- Index-specific Add & Remove:
Adding at a specific index and removing element from a specific index takes O(n).
This is because the elements after that index need to shift to the left by 1 (when removing an element)
or shift to the right by 1 (when adding an element) which can take O(n) time.

- Contains:
The contains() method takes O(n) as it needs to iterate to find the element.

- Get & Set:
The get() and set() methods are O(1) as it accesses the array using the index
which allows for random access. It does not need to iterate through all the elements.
 */

public class ArrayListUsingGenerics<E> {

    private Object[] array;
    private int size;

    public ArrayListUsingGenerics() {
        array = new Object[1];
    }

    // Capacity is not the same as size since the arraylist is empty on initialization.
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
