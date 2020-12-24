package stariq.datastructures.queue;

// https://ide.geeksforgeeks.org/A6MIHq
// Need to fix implementation of either removeLast or peekLast.
public class DequeUsingArray {

    public static void main(String[] args) {
        DequeUsingArray queue = new DequeUsingArray(10);
        queue.addFirst(3);
        queue.addFirst(2);
        queue.addLast(4);
        queue.addLast(6);
        queue.addFirst(1);

        queue.print();

        System.out.println();
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeLast());
        System.out.println(queue.removeLast());

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
        front = 0;
        back = 0;
    }

    public void addFirst(int element) {
        if(isFull()) {
            System.out.println("Deque has reached capacity");
            return;
        }
        int temp = back - 1;
        while(temp < 0) {
            temp += capacity;
        }
        back = temp % capacity;
        array[back] = element;
        size++;
    }

    public void addLast(int element) {
        if(isFull()) {
            System.out.println("Deque has reached capacity");
            return;
        }
        array[front] = element;
        front = (front + 1) % capacity;
        size++;
    }

    public int removeFirst() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int temp = back;
        back = (back + 1) % capacity;
        size--;
        return array[temp];
    }

    public int removeLast() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        front = (front - 1) % capacity;
        size--;
        return array[front];
    }

    public int peekFirst() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return array[back];
    }

    // Does not work if you removeLast() and there is only one element left.
    // Works fine if you removeFirst() and there is only one element left.
    public int peekLast() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        int temp = (front - 1) % capacity;
        return array[temp];
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
        for(int i = back; i != front; i = (i+1) % capacity) {
            System.out.print(array[i]+" ");
        }
    }
}
