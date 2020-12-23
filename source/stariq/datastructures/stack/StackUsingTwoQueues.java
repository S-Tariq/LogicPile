package stariq.datastructures.stack;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

// https://www.techiedelight.com/implement-stack-using-queue-data-structure/
public class StackUsingTwoQueues<E> {

    public static void main(String[] args) {
        StackUsingTwoQueues<Integer> stack = new StackUsingTwoQueues<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.pop();

        stack.print();
    }

    Queue<E> queue1;
    Queue<E> queue2;

    StackUsingTwoQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(E element) {
        // Move all elements from the first queue to the second queue.
        while(!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        // Add element into the first queue.
        queue1.add(element);

        // Move all elements back to the first queue from the second queue.
        while(!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
    }

    public E pop() {
        // If the first queue is empty.
        if(queue1.isEmpty()) {
            throw new EmptyStackException();
        }
        return queue1.poll();
    }

    public void print() {
        for(E e : queue1) {
            System.out.print(e + " ");
        }
    }

}
