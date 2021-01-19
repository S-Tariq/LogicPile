package stariq.datastructures.design;

import java.util.*;

// Add or update the price of a stock to the data structure.
// Return the top k price stocks and their current prices.
public class StockTickerUsingSet {

    public static void main(String[] args) {
        StockTickerUsingSet st = new StockTickerUsingSet(3);
        st.addOrUpdate("a",100.0);
        st.addOrUpdate("b",110.0);
        st.addOrUpdate("c",120.0);
        System.out.println(st.top());
        st.addOrUpdate("d",130.0);
        st.addOrUpdate("d",140.0);
        System.out.println(st.top());
        st.addOrUpdate("a",150.0);
        System.out.println(st.top());
    }

    int k;
    Map<String, Double> map;
    Set<Map.Entry<String, Double>> set;

    StockTickerUsingSet(int k) {
        this.k = k;
        map = new HashMap<>();
        // Desc order
        set = new TreeSet<>(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> a, Map.Entry<String, Double> b) {
                int keyComp = b.getKey().compareTo(a.getKey());
                int valueComp = b.getValue().compareTo(a.getValue());
                if(valueComp == 0) {
                    return keyComp;
                }
                return valueComp;
            }
        });
    }

    public void addOrUpdate(String stock, double price) {
        if(map.containsKey(stock)) {
            set.remove(new AbstractMap.SimpleEntry<>(stock, map.get(stock)));
        }
        AbstractMap.SimpleEntry<String, Double> entry = new AbstractMap.SimpleEntry<>(stock, price);
        set.add(entry);
        map.put(stock, price);
    }

    public List<Map.Entry<String, Double>> top() {
        List<Map.Entry<String, Double>> list = new ArrayList<>();
        int i = 0;
        Iterator<Map.Entry<String, Double>> iterator = set.iterator();
        while(i < k && iterator.hasNext()) {
            list.add(iterator.next());
            i++;
        }
        return list;
    }
}
