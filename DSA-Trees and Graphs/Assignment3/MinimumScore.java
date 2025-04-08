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
    /**
     * gets the queue of the bowlers
     * @return queue of bowlers
     */
    public ArrayPriorityQueue getQueue(){
        return queue;
    }
    /**
     * checks if balls available with baller is sufficient for virat to play
     * @return true if there are ballers else false
     */
    public boolean validBallsLeft(){
        int sumOfBallesAvailable = 0;
        for(Task bowler : queue.getArray()){
            sumOfBallesAvailable += bowler.getPriority();
        }
        if(sumOfBallesAvailable < viratBalls){
            return false;
        }
        return true;        
    }
    /**
     * it finds the turns with which the ballers bowl
     * @throws QueueException if the queue gets empty and there are balls left for virat to play
     */
    public void getList() throws QueueException{
        if(validBallsLeft()){
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
    /**
     * it prints the order in which the ballers bowl
     */
    public void printOrder(){
        for(String name : minimumScore){
            System.out.println(name + "  ");
        }
    }
}
