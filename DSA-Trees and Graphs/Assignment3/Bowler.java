package Assignment3;

public class Bowler {
    String name;
    int balls;
    public Bowler(String name , int balls){
        this.name = name;
        this.balls = balls;
    }
    /**
     * finds the name of the baller
     * @return ballers name
     */
    public String getName(){
        return name;
    }
    /**
     * finds the number of balls left with the baller to play
     * @return number of balls left with baller to play
     */
    public int getBalls(){
        return balls;
    }
    /**
     * it decreases the ball count by 1 as the baller bowls
     * @param balls number of balls that the baller can bowl
     */
    public void setBalls(int balls){
        this.balls = balls - 1;
    }
}
