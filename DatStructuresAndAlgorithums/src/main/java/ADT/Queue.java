package ADT;

import java.util.NoSuchElementException;

public class Queue<T> {
    private T[] queueArray;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.capacity = capacity;
        this.queueArray = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = -1; // Indicates an empty queue
        this.size = 0;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full. Cannot enqueue item.");
        }
        rear = (rear + 1) % capacity; // Circular increment
        queueArray[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty. Cannot dequeue item.");
        }
        T item = queueArray[front];
        queueArray[front] = null; // Optional: clear the reference to allow garbage collection
        front = (front + 1) % capacity; // Circular increment
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty. No element to peek.");
        }
        return queueArray[front];
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

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);

        System.out.println("Is queue empty? " + queue.isEmpty()); // true

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek()); // 10
        System.out.println("Queue size: " + queue.size()); // 3

        System.out.println("Dequeued: " + queue.dequeue()); // 10
        System.out.println("Front element after dequeue: " + queue.peek()); // 20

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // This will throw IllegalStateException if capacity is 5

        System.out.println("Queue size: " + queue.size()); // 5
        System.out.println("Is queue full? " + queue.isFull()); // true

        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
        System.out.println("Is queue empty? " + queue.isEmpty()); // true
    }
}