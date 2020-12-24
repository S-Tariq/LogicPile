package stariq.datastructures.queue;

// https://www.youtube.com/watch?v=mcMXy4EH0MQ
public class PriorityQueueUsingGenericsArray<E> {

    public static void main(String[] args) {
        PriorityQueueUsingGenericsArray<Integer> queue = new PriorityQueueUsingGenericsArray<>(10);
        queue.offer(3);
        queue.offer(2);
        queue.offer(4);
        queue.offer(1);
        queue.offer(0);
        queue.offer(6);

        queue.poll();

        System.out.println("First element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        queue.print();
    }

    E[] array;
    int capacity;
    int size;

    @SuppressWarnings({"unchecked"})
    PriorityQueueUsingGenericsArray(int size) {
        array = (E[]) new Object[size];
        capacity = size;
    }

    public void offer(E element) {
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
        while(i >= 0 && (Integer)element > (Integer)array[i]) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = element;
        size++;
    }

    public E poll() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return array[--size];
    }

    public E peek() {
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
