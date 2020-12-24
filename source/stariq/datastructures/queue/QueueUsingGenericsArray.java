package stariq.datastructures.queue;

// https://www.techiedelight.com/queue-implementation-in-java/
public class QueueUsingGenericsArray<E> {

    public static void main(String[] args) {
        QueueUsingGenericsArray<Integer> queue = new QueueUsingGenericsArray<>(3);
        queue.offer(3);
        queue.offer(2);
        queue.offer(4);

        queue.poll();

        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        queue.print();

    }

    private E array[];
    private int front;
    private int back;
    private int capacity;
    private int size;

    @SuppressWarnings({"unchecked"})
    QueueUsingGenericsArray(int size) {
        array = (E[]) new Object[size];
        capacity = size;
        front = 0;
        back = -1;
    }

    public void offer(E element) {
        if(isFull()) {
            System.out.println("Queue has reached capacity");
            return;
        }
        back = (back + 1) % capacity;
        array[back] = element;
        size++;
    }

    public E poll() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        E polled = array[front];
        front = (front + 1) % capacity;
        size--;
        return polled;
    }

    public E peek() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return array[front];
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
        for(int i = front; i <= back; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
