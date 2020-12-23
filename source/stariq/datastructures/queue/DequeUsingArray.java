package stariq.datastructures.queue;

public class DequeUsingArray {

    public static void main(String[] args) {
        DequeUsingArray queue = new DequeUsingArray(10);
        queue.addFirst(3);
        queue.addFirst(2);
        queue.addLast(4);

        //queue.removeFirst();

        System.out.println("Front element: " + queue.peekFirst());
        System.out.println("Back element: " + queue.peekLast());
        System.out.println("Queue size: " + queue.size());
        queue.print();
    }

    private int array[];
    private int front;
    private int back;
    private int capacity;
    private int size;

    DequeUsingArray(int size) {
        array = new int[size];
        capacity = size;
        front = -1;
        back = 0;
    }

    public void addFirst(int element) {
        if(isFull()) {
            System.out.println("Deque has reached capacity");
            return;
        }
        if(front == -1) {
            front = 0;
        } else if(front == 0) {
            front = size - 1;
        } else {
            front = front - 1;
        }
        array[front] = element;
        size++;
    }

    public void addLast(int element) {
        if(isFull()) {
            System.out.println("Deque has reached capacity");
            return;
        }
        if(front == -1) {
            front = 0;
        } else if (back == size - 1) {
            back = 0;
        } else {
            back = back + 1;
        }
        array[back] = element;
        size++;
    }

    public void removeFirst() {
        if(isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        if(front == back) {
            front = -1;
            back = -1;
        } else if(front == size - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
        size--;
    }

    public void removeLast() {
        if(isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        if(front == back) {
            front = -1;
            back = -1;
        } else if(back == 0) {
            back = size - 1;
        } else {
            back = back - 1;
        }
        size--;
    }

    public int peekFirst() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return array[front];
    }

    public int peekLast() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return array[back];
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
