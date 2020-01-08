package datastructures;

public class IntArrayList {

    private int[] array;
    private int size;

    public IntArrayList() {
        array = new int[1];
        size = 0;
    }

    public void add(int element) {
        if(array.length == size) {
            int[] temp = new int[size * 2];
            for(int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
        array[size] = element;
        size++;
    }

    public void add(int... elements) {
        for(int i : elements) {
            add(i);
        }
    }


    public int get(int index) {
        if(index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException(String.format(
                    "Size: %s, Index: %s", size, index));
        }
        return array[index];
    }

    public void set(int index, int element) {
        array[index] = element;
    }

    public void remove(int index) {
        for(int i = index; i < size - 1; i++){
            array[i] = array[i+1];
        }
        size--;
    }

    public int indexOf(int element) {
        for(int i = 0; i < size; i++) {
            if(array[i] == element){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int element) {
        for(int i = 0; i < size; i++){
            if(array[i] == element){
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }
}