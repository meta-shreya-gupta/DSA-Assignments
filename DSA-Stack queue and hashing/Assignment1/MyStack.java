package Assignment1;

public interface MyStack<T>{
    void push(T element);
    T pop();
    T peek();
    int size();
    boolean isEmpty();
}
