package stariq.datastructures.design;

import java.util.*;

// Add or update the price of a stock to the data structure.
// Return the top k price stocks and their current prices.
public class StockTickerUsingPriorityQueue {

    int k;
    Map<String, Double> map;
    PriorityQueue<Map.Entry<String, Double>> pq;

    StockTickerUsingPriorityQueue(int k) {
        this.k = k;
        map = new HashMap<>();
        // Desc order
        pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Double>>() {
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
        map.put(stock, price);
    }

    public List<Map.Entry<String, Double>> topK() {
        List<Map.Entry<String, Double>> list = new ArrayList<>();
        pq.clear();
        pq.addAll(map.entrySet());
        int i = 0;
        while(i < k) {
            list.add(pq.poll());
            i++;
        }
        return list;
    }
}
