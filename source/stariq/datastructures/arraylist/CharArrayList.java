package stariq.datastructures.arraylist;

public class CharArrayList {

    private char[] array;
    private int size;

    public CharArrayList() {
        array = new char[1];
        size = 0;
    }

    public void add(char element) {
        if(size == array.length) {
            char[] temp = new char[size * 2];
            for(int i = 0; i < array.length; i++){
                temp[i] = array[i];
            }
            array = temp;
        }
        array[size] = element;
        size++;
    }

    public void add(char... elements) {
        for(char c : elements) {
            add(c);
        }
    }

    public char get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Size: %s, Index: %s", size, index));
        } else {
            return array[index];
        }
    }

    public void set(int index, char element) {
        array[index] = element;
    }

    public void remove(int index) {
        for(int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public int indexOf(char element) {
        int index = -1;
        for(int i = 0; i < size; i++) {
            if(array[i] == element) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean contains(char element) {
        for(int i = 0; i < size; i++) {
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
