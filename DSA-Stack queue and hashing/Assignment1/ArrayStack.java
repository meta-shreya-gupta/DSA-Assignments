package Assignment1;

public class ArrayStack<T> implements MyStack<T> {
    private T[] elements;
    private int top;
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity){
        elements = (T[]) new Object[capacity];
        top = -1;
    }

    /**
     * adds an object of custom type T into the stack
     * @param element Custom data type T 
     */
    @Override
    public void push(T element){
        if(top == elements.length - 1){
            throw new IllegalStateException("Stack is full");
        }
        elements[++ top] = element;
    }
    /**
     * if the stack is not empty then it removes the top element
     * @return element of custom type T
     */
    @Override
    public T pop(){
        if(isEmpty()){
            throw new IllegalStateException("There are no elements");
        }
        return elements[top --];
    }
    /**
     * gives the top element without removing it
     * @return top element of custom type T
     */
    @Override
    public T peek(){
        if(isEmpty()){
            throw new IllegalStateException("There are no elements");
        }
        return elements[top];
    }
    /**
     * counts the numner of element present in the stack
     * @return count of the element present in the stack
     */
    @Override
    public int size(){
        return top + 1;
    }
    /**
     * checks if the stack contains any element or not
     * @return true if it is empty else false
     */
    @Override
    public boolean isEmpty(){
        return top == -1;
    }
}
