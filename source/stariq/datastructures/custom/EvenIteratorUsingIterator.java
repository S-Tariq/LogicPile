package stariq.datastructures.custom;

import java.util.Iterator;

public class EvenIteratorUsingIterator<Integer> implements Iterator<Integer> {
    Iterator<Integer> itr;
    Integer next;

    EvenIteratorUsingIterator(Iterator<Integer> itr) {
        this.itr = itr;
        next = null;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        while(itr.hasNext()) {
            Integer val = itr.next();
            if(isEven(val)) {
                next = val;
                return next;
            }
        }
        next = null;
        return next;
    }

    public boolean isEven(Integer val) {
        return (int)val % 2 == 0;
    }
}
