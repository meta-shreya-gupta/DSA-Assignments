package Assignment3;

import java.util.ArrayList;
import java.util.List;

public class Program {
    String name;
    int capacity;
    List<Student> enrolledStudents;
    public Program(String name , int capacity){
        this.name = name;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }
    /**
     * extract the name of the program
     * @return name of the program
     */
    public String getProgramName(){
        return name;
    }
    /**
     * extracts the capacity of the program
     * @return capacity of the program
     */
    public int getCapacityOfProgram(){
        return capacity;
    }
    /**
     * checks that program can be allocation to a student or not
     * @return true if the program has space else false
     */
    public boolean hasCapacity(){
        return enrolledStudents.size() < capacity;
    }
    /**
     * adds the student to a program
     * @param student who wants to join the program
     */
    public void enrollStudent(Student student){
        if(hasCapacity()){
            enrolledStudents.add(student);
        }
    }
    public void setCapacity(int capacity){
        this.capacity = capacity; 
    }
    /**
     * extracts the list of student enrolled in that program
     * @return list of enrolled students
     */
    public List<Student> getEnrolledStudent(){
        return enrolledStudents;
    }
}