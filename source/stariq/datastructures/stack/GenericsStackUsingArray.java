package stariq.datastructures.stack;

import java.util.EmptyStackException;

// https://www.techiedelight.com/stack-implementation-in-java/
public class GenericsStackUsingArray<E> {

    public static void main(String[] args) {
        GenericsStackUsingArray<Integer> stack = new GenericsStackUsingArray<>(3);
        stack.push(1);
        stack.push(2);

        stack.pop();
        stack.pop();
       // stack.pop();

        stack.push(3);
        stack.push(4);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        stack.print();
    }

    private E[] array;
    private int top; // Keeps track of top index.
    private int capacity;

    @SuppressWarnings({"unchecked"})
    public GenericsStackUsingArray(int size) {
        array = (E[]) new Object[size];
        capacity = size;
        top = -1;
    }

    public void push(E element) {
        if(isFull()) {
            System.out.println("Stack has reached capacity");
            return;
        }
        array[++top] = element;
    }

    public E pop() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return array[top--];
    }

    public E peek() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
        // return size() == capacity;
    }

    public int size() {
        return top + 1;
    }

    public void print() {
        for(int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
