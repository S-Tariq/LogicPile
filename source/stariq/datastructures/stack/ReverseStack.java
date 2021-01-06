package stariq.datastructures.stack;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        for(int i : stack) {
            System.out.print(i + " ");
        }
    }

    // Recursion
    public static void reverse(Stack<Integer> stack) {
        if(!stack.isEmpty()) {
            int val = stack.pop();
            reverse(stack);
            insertAtBottom(val, stack);
        }
    }

    public static void insertAtBottom(int element, Stack<Integer> stack) {
        if(stack.isEmpty()) {
            stack.push(element);
        } else {
            int val = stack.pop();
            insertAtBottom(element, stack);
            stack.push(val);
        }
    }
}
