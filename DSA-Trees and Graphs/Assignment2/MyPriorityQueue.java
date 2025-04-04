package Assignment2;

public interface MyPriorityQueue {
    void enqueue(Task data) throws QueueException;
    Task dequeue() throws QueueException;
    int size();
    boolean isEmpty();
    boolean isFull();
    Task poll() throws QueueException;
    boolean remove(String data);
    Task peek() throws QueueException;
}