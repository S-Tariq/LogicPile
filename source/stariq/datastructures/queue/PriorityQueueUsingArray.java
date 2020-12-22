package stariq.datastructures.queue;

// https://www.youtube.com/watch?v=mcMXy4EH0MQ
public class PriorityQueueUsingArray {

    public static void main(String[] args) {
        PriorityQueueUsingArray queue = new PriorityQueueUsingArray(10);
        queue.add(3);
        queue.add(2);
        queue.add(4);
        queue.add(1);
        queue.add(0);
        queue.add(6);

        queue.poll();

        System.out.println("First element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        queue.print();
    }

    int[] array;
    int capacity;
    int size;

    PriorityQueueUsingArray(int size) {
        array = new int[size];
        capacity = size;
    }

    public void add(int element) {
        if(isFull()) {
            System.out.println("Queue has reached capacity");
            return;
        }
        if(isEmpty()) {
            array[size] = element;
            size++;
            return;
        }
        // Inserts element in descending order inside the array.
        int i = size - 1;
        while(i >= 0 && element > array[i]) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = element;
        size++;
    }

    public int poll() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return array[--size];
    }

    public int peek() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    public void print() {
        for(int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
