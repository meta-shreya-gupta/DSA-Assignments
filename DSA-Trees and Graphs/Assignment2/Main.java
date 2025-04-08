package Assignment2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws QueueException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter capacity of the queue");
        int capacity = sc.nextInt();
        ArrayPriorityQueue queue = new ArrayPriorityQueue(capacity);
        System.out.println("1. enqueue \n2. dequeue \n3. find top element \n4. remove first element \n5. remove particular element \n6.check is empty \n7. check is full \n8. size of queue \n9. print queue \n10. exit");
        while(true){
            System.out.println("Enter choice");
            int choice = sc.nextInt();
            switch(choice){
                case 1 : 
                    System.out.println("Enter data to be added");
                    String data = sc.next();
                    System.out.print("Enter priority number");
                    int priority = sc.nextInt();
                    queue.enqueue(new Task(data,priority));
                    queue.printQueue();
                    break;
                case 2 :
                    Task task = queue.dequeue();
                    System.out.println("Removed element : " + task.getData());
                    queue.printQueue();
                    break;
                case 3 :
                    Task peek = queue.peek();
                    System.out.println("Peek element :" + peek.getData());
                    break;
                case 4 :
                    Task poll = queue.poll();
                    System.out.println("Poll element :" + poll.getData());
                    break;
                case 5 :
                    System.out.println("Enter data element to be removed");
                    String removeData = sc.next();
                    boolean remove = queue.remove(removeData);
                    System.out.println("Element removed : " + remove);
                    break;
                case 6 :
                    boolean checkEmpty = queue.isEmpty();
                    System.out.println("Is queue empty : " + checkEmpty);
                    break;
                case 7 :
                    boolean checkFull = queue.isFull();
                    System.out.println("Is queue full : " + checkFull);
                    break;
                case 8 :
                    int size = queue.size();
                    System.out.println("Number of elements present in the queue : " + size);
                    break;
                case 9 : 
                    queue.printQueue();
                    break;
                case 10 :
                    sc.close();
                    System.exit(0);
                default :
                    System.exit(0);
            }
        }
    }
}
