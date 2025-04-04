package Assignment3;

public class Bowler {
    String name;
    int balls;
    public Bowler(String name , int balls){
        this.name = name;
        this.balls = balls;
    }
    public String getName(){
        return name;
    }
    public int getBalls(){
        return balls;
    }
    public void setBalls(int balls){
        this.balls = balls - 1;
    }
}
