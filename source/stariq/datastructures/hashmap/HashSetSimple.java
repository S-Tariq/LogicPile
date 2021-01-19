package stariq.datastructures.hashmap;

import java.util.ArrayList;
import java.util.List;

public class HashSetSimple {

    List<Integer> list;

    public HashSetSimple() {
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
