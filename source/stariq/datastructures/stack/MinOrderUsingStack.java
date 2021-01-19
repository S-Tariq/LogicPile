package stariq.datastructures.stack;

import java.util.Stack;

/*
Imagine you are a Front Office trader, whose job is to execute trades.
To simplify things, you only trade a single stock,
and the only input you receive for each trade is the amount.
As your Back Office is really impatient, you need to execute the trades in order,
such that the last request you have received is executed first.
Additionally, once in a while, your Back Office may ask you about the minimal order you have,
that is not executed yet.
Implement a data structure that supports the following operations:
- addOrder(int amount) : adds an order
- executeOrder() : executes an order (according to the rules above) and returns the amount associated with it
- extractMinOrder() : returns the amount of the current minimal order, without executing it
 */
public class MinOrderUsingStack {

    public static void main(String[] args) {
        MinOrderUsingStack orders = new MinOrderUsingStack();
        orders.addOrder(13);
        orders.addOrder(11);
        orders.addOrder(9);
        orders.addOrder(20);

        orders.extractMin(); // 9
        orders.executeOrder(); // 20
        orders.extractMin(); // 9
        orders.executeOrder(); // 9
        orders.extractMin(); // 11
        orders.addOrder(11);
        orders.extractMin(); // 11
        orders.executeOrder(); // 11
        orders.extractMin(); // 11
        orders.executeOrder(); // 11
        orders.extractMin(); // 13
        orders.executeOrder(); // 13
    }

    Stack<Integer> orderStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinOrderUsingStack() {

    }

    public void addOrder(int amount) {
        orderStack.push(amount);
        if(minStack.isEmpty()) {
            minStack.push(amount);
        } else {
            int min = minStack.peek();
            if(amount <= min) {
                minStack.push(amount);
            }
        }
    }

    public void executeOrder() {
        int pop = orderStack.pop();
        int min = minStack.peek();
        if(min == pop) {
            minStack.pop();
        }
        // System.out.println(pop);
    }

    public int extractMin() {
        // System.out.println(minStack.peek());
        return minStack.peek();
    }
}
