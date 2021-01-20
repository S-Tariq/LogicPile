package stariq.datastructures.design;

import java.util.HashMap;
import java.util.Map;

/*
Input: (1, "abcd"), (2, "efgh"), (4, "mnop"), (5, "qrst"), (3, "ijkl")
Write a program to output the data from the stream in order: 1,2,3,4,5
 */

// Assumption is that the order is consecutive.
// Min and max order number needs to be tracked so we can loop through the hashmap in order.

// For non-consecutive order, it is better to use treemap.
// Does not require min and max as the keys will be in order.
public class MessageStream {

    public static void main(String[] args) {
        MessageStream ms = new MessageStream();
        ms.input(1, "abcd");
        ms.input(2, "efgh");
        ms.input(4, "mnop");
        ms.input(5, "qrst");
        ms.input(3, "ijkl");
        ms.printMessages();
    }

    Map<Integer, String> map;
    int min;
    int max;

    MessageStream() {
        map = new HashMap<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    public void input(int order, String message) {
        min = Math.min(min, order);
        max = Math.max(max, order);
        map.put(order, message);
    }

    // Print messages in asc order.
    public void printMessages() {
        for(int i = min; i <= max; i++) {
            if(map.get(i) != null) {
                System.out.println(map.get(i));
            } else {
                throw new NullPointerException("Missing message(s)");
            }
        }
    }
}
