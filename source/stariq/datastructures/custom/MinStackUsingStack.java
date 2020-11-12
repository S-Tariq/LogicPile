package stariq.datastructures.custom;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/
public class MinStackUsingStack {

    Stack<Integer> valueStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStackUsingStack() {

    }

    public void push(int val) {
        valueStack.push(val);
        if(minStack.isEmpty()) {
            minStack.push(val);
        } else {
            int min = minStack.peek();
            if(val <= min) {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        int pop = valueStack.pop();
        int min = minStack.peek();
        if(pop == min) {
            minStack.pop();
        }
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
