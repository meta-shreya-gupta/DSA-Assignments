package Assignment2;

public interface MyQueue<T> {
    void add(T element);
    T remove();
    T peek();
    boolean isEmpty();
    boolean isFull();
}
