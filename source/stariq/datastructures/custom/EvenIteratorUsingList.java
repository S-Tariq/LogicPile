package stariq.datastructures.custom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class EvenIteratorUsingList implements Iterator<Integer> {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(1);
        nums.add(6);
        nums.add(7);
        EvenIteratorUsingList iterator = new EvenIteratorUsingList(nums);
        while(iterator.hasNext()) {
            int num = iterator.next();
            System.out.print(num + " ");
        }
    }

    List<Integer> list;
    int current;

    EvenIteratorUsingList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return current < list.size();
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer element = list.get(current);
        identifyNext();
        return element;
    }

    private void identifyNext() {
        current++;
        while(current < list.size() && list.get(current) % 2 != 0) {
            current++;
        }
    }
}
