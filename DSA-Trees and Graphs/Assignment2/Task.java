package Assignment2;

public class Task {
    String data;
    int priority;
    public Task(String data , int priority){
        this.data = data;
        this.priority = priority;
    }
    /**
     * extracts the data from the queue
     * @return data of the queue
     */
    public String getData(){
        return data;
    }
    /**
     * it sets the data in the queue
     * @param data the value that we want to set in the queue
     */
    public void setData(String data){
        this.data = data;
    }
    /**
     * extracts the priority from the queue data
     * @return priority of the queue
     */
    public int getPriority(){
        return priority;
    }
    /**
     * it assigns specific priority to the queue data element
     * @param priority that we want to set to the data element
     */
    public void setPriority(int priority){
        this.priority = priority;
    }
}
