package Assignment2;

public interface MyPriorityQueue {
    /**
     * adds the data in the queue in ascending order of priority
     * @param data element that we want to add in the queue
     * @throws QueueException if there is no space left in the queue it throws exception it is full
     */
    void enqueue(Task data) throws QueueException;
    /**
     * removes an element from the queue with highest priority
     * @return element of Task type with highest priority
     * @throws QueueException if there are no elements in the queue then it throws exception that queue is empty
     */
    Task dequeue() throws QueueException;
    /**
     * counts the number of elements present in the queue
     * @return count of the elements
     */
    int size();
    /**
     * checks if the queue is empty or not
     * @return true if queue is empty else false
     */
    boolean isEmpty();
    /**
     * checks that the queue is full or not
     * @return true if the queue is full else false
     */
    boolean isFull();
    /**
     * extracts the element with the least priority
     * @return Task element with least priority
     * @throws QueueException if the queue is empty
     */
    Task poll() throws QueueException;
    /**
     * removes a Task element with specific data value 
     * @param data value which we want to remove from the queue
     * @return true if that particular data element exist in the queue or not
     */
    boolean remove(String data);
    /**
     * extracts the Task element from the queue with highest priority without removing it
     * @return Task with the highest priority
     * @throws QueueException if the queue is empty and there are no elements to remove from it
     */
    Task peek() throws QueueException;
}