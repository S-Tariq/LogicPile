package stariq.datastructures.design;

import java.util.*;

// Accumulate the volume of a stock to the data structure.
// Return the top k stocks according to their volume.
public class StockVolumeUsingSet {

    public static void main(String[] args) {
        StockVolumeUsingSet st = new StockVolumeUsingSet();
        st.addStocksVolume("a",100);
        st.addStocksVolume("b",110);
        st.addStocksVolume("c",120);
        System.out.println(st.top(3));
        st.addStocksVolume("d",130);
        st.addStocksVolume("d",140);
        System.out.println(st.top(3));
        st.addStocksVolume("a",150);
        System.out.println(st.top(3));
    }

    Map<String, Integer> map;
    Set<Map.Entry<String, Integer>> set;

    StockVolumeUsingSet() {
        map = new HashMap<>();
        // Desc order
        set = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                int keyComp = b.getKey().compareTo(a.getKey());
                int valueComp = b.getValue().compareTo(a.getValue());
                if(valueComp == 0) {
                    return keyComp;
                }
                return valueComp;
            }
        });
    }

    public void addStocksVolume(String stock, int volume) {
        if(map.containsKey(stock)) {
            set.remove(new AbstractMap.SimpleEntry<>(stock, map.get(stock)));
        }
        int prevVolume = map.getOrDefault(stock, 0);
        AbstractMap.SimpleEntry<String, Integer> entry = new AbstractMap.SimpleEntry<>(stock, prevVolume + volume);
        set.add(entry);
        map.put(stock, prevVolume + volume);
    }

    public List<Map.Entry<String, Integer>> top(int k) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        int i = 0;
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while(i < k && iterator.hasNext()) {
            list.add(iterator.next());
            i++;
        }
        return list;
    }
}
