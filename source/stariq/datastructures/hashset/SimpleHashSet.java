package stariq.datastructures.hashset;

import java.util.ArrayList;
import java.util.List;

public class SimpleHashSet {

    List<Integer> list;

    public SimpleHashSet() {
        list = new ArrayList<>();
    }

    public void add(int key) {
        if(!list.contains(key)) {
            list.add(key);
        }
    }

    public void remove(int key) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == key) {
                list.remove(i);
                break;
            }
        }
    }

    public boolean contains(int key) {
        if(list.contains(key)) {
            return true;
        } else {
            return false;
        }
    }
}
