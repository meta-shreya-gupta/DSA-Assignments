package Assignment3;

import java.util.ArrayList;
import java.util.List;

import Assignment2.ArrayPriorityQueue;
import Assignment2.QueueException;
import Assignment2.Task;

public class MinimumScore {
    ArrayPriorityQueue queue;
    List<String> minimumScore;
    int viratBalls;
    public MinimumScore(int capacity , int viratBalls){
        this.queue = new ArrayPriorityQueue(capacity);
        minimumScore = new ArrayList<>();
        this.viratBalls = viratBalls;
    }
    public ArrayPriorityQueue getQueue(){
        return queue;
    }
    public boolean check(){
        int sumOfBallesAvailable = 0;
        for(Task bowler : queue.getArray()){
            sumOfBallesAvailable += bowler.getPriority();
        }
        if(sumOfBallesAvailable < viratBalls){
            return false;
        }
        return true;        
    }
    public void getList() throws QueueException{
        if(check()){
            while(viratBalls > 0){
                Task bowler = queue.dequeue();
                String nameOfBowler = bowler.getData();
                minimumScore.add(nameOfBowler);
                queue.enqueue(new Task(nameOfBowler , bowler.getPriority() - 1));
                viratBalls --;
            }
        }
        else{
            System.out.println("Insufficiant balls available for virat to play");
        }
    }
    public void printOrder(){
        for(String name : minimumScore){
            System.out.println(name + "  ");
        }
    }
}
