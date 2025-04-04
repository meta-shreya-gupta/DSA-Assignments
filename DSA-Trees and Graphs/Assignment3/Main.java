package Assignment3;

import Assignment2.QueueException;
import Assignment2.Task;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws QueueException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter balls Virat can play");
        int balls = sc.nextInt();
        System.out.println("Enter number of bowlers left to bowl");
        int ballers = sc.nextInt();
        MinimumScore queue = new MinimumScore(ballers, balls);
        for (int index = 0; index < ballers; index++) {
            System.out.println("Enter name of bowler : ");
            String name = sc.next();
            System.out.println("Enter balls left to bowl : ");
            int ballsOfBowler = sc.nextInt();
            queue.getQueue().enqueue(new Task(name, ballsOfBowler));
        }
        queue.getList();
        queue.printOrder();
        sc.close();
    }
}
