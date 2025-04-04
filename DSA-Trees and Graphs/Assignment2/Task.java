package Assignment2;

public class Task {
    String data;
    int priority;
    public Task(String data , int priority){
        this.data = data;
        this.priority = priority;
    }
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }
    public int getPriority(){
        return priority;
    }
    public void setPriority(int priority){
        this.priority = priority;
    }
}
