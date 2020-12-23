package stariq.datastructures.queue;

import java.util.EmptyStackException;
import java.util.Stack;

// https://www.techiedelight.com/implement-a-queue-using-stack-data-structure/
public class QueueUsingTwoStacks<E> {

    public static void main(String[] args) {
        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.poll();

        queue.print();
    }

    private Stack<E> stack1;
    private Stack<E> stack2;

    QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void offer(E element) {
        // Move all elements from the first stack to the second stack.
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Push element into the first stack.
        stack1.push(element);

        // Move all elements back to the first stack from second stack.
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public E poll() {
        // If first stack is empty.
        if(stack1.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack1.pop();
    }

    public void print() {
        for(E e : stack1) {
            System.out.print(e + " ");
        }
    }
}
