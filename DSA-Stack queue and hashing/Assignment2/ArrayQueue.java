package Assignment2;

public class ArrayQueue<T> implements MyQueue<T> {
    private final int capacity;
    private T[] elements;
    private int front;
    private int rare;
    private int count;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if(capacity < 1){
            throw new IllegalStateException("Queue cannot be created with 0 or negative size");
        }
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
        front = 0;
        rare = 0;
        count = 0;
    }
    /**
     * adds the element to the queue if it contains space
     * @param element custom data type T whose object is added to the queue
     */
    @Override
    public void add(T element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        elements[rare] = element;
        rare = (rare + 1) % capacity;
        count++;
    }
    /**
     * dequeue the element from the queue from front positions 
     * @return element obtained after removing it from queue of custom data type T
     */
    @Override
    public T remove() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        T item = elements[front];
        front = (front + 1) % capacity;
        count --;
        return item;
    }
    /**
     * return the element at front position without removing it
     * @return the element at the front position of custom data type T
     */
    @Override
    public T peek() {
        if(isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        return elements[front];
    }
    /**
     * checks if the queue contains any element or not
     * @return true if there are no elements in the queue else false
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    /**
     * checks if there are any space for more elements to add or not
     * @return true if there is no more space else false
     */
    @Override
    public boolean isFull() {
        return count == capacity;
    }
}
