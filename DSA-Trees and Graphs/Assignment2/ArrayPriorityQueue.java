package Assignment2;

public class ArrayPriorityQueue implements MyPriorityQueue{
    int capacity;
    int count;
    Task[] tasks;
    public ArrayPriorityQueue(int capacity){
        this.capacity = capacity;
        this.tasks = new Task[capacity];
        this.count = 0;
    }
    /**
     * extracts the array of the tasks
     * @return tasks array
     */
    public Task[] getArray(){
        return tasks;
    }
    @Override
    public void enqueue(Task task) throws QueueException{
        if(isFull()){
            throw new QueueException("Queue is full!");
        }
        if(isEmpty()){
            tasks[0] = task;
            count ++;
            return ;
        }
        int index = 0;
        for(index = count - 1 ; index >= 0 && tasks[index].getPriority() > task.getPriority() ; index --){
            tasks[index + 1] = tasks[index];
        }
        tasks[index + 1] = task;
        count ++;
    }
    @Override
    public Task dequeue() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is empty");
        }
        Task task = tasks[count - 1];
        count -- ;
        return task;
    }
    @Override
    public Task peek() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Dosen't have peek as queue is empty");
        }
        Task task = tasks[0];
        return task;
    }
    @Override
    public Task poll() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is empty");
        }
        Task task = tasks[0];
        for(int index = 0 ; index < count - 1 ; index ++){
            tasks[index] = tasks[index + 1];
        }
        count --;
        return task;
    }
    @Override
    public boolean remove(String data){
        for(int index = 0 ; index < count ; index ++){
            if(tasks[index].getData().equals(data)){
                for(int newIndex = index ; newIndex < count - 1 ; newIndex ++){
                    tasks[newIndex] = tasks[newIndex + 1];
                }
                tasks[count - 1] = null;
                count --;
                return true;
            }
        }
        
        return false;
    }
    @Override
    public boolean isEmpty(){
        return count == 0;
    }
    @Override
    public boolean isFull(){
        return count == capacity;
    }
    @Override
    public int size(){
        return count;
    }
    /**
     * helper function to print the queue elements along with its priority
     */
    public void printQueue() {
        System.out.println("Queue");
        for(int index = 0 ; index < count ; index ++){
            System.out.println(tasks[index].getData() + " " + tasks[index].getPriority());
        }
    }
}
