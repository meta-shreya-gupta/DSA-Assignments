package Assignment2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter capacity of queue");
        int capacity = sc.nextInt();
        ArrayQueue<Object> queue = new ArrayQueue<>(capacity);
        System.out.println("Available Operations \n1. add element \n2. remove element \n3. peek element \n4. check is empty \n5 . check is full \n6. exit");
        while(true){
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch(choice){
                case 1 : 
                    System.out.println("Enter the element you want to add");
                    Object addElement = sc.next();
                    queue.add(addElement);
                    break;
                case 2 :
                    Object removeElement = queue.remove();
                    System.out.println("Removed element = " + removeElement);
                    break;
                case 3 :
                    Object peekElement = queue.peek();
                    System.out.println("peek element = " + peekElement);
                    break;
                case 4 :
                    System.out.println("Queue is empty = " + queue.isEmpty());
                    break;
                case 5 :
                    System.out.println("Queue is full = " + queue.isFull());
                    break;
                case 6 :
                    sc.close();
                    System.exit(0);
                    break;
                default :
                    System.out.println("Enter valid choice");
            }
        }
    }
}
