package Assignment3;

import java.util.List;

public class Student {
    String name;
    List<String> preferences;
    String allocatedProgram;
    public Student(String name , List<String> preferences){
        this.name = name;
        this.preferences = preferences;
    }
    /**
     * extracts the name of the student
     * @return name of the student
     */
    public String getStudentName(){
        return name;
    }
    /**
     * extracts the list of programs preffered by the student
     * @return list of preferred programs
     */
    public List<String> getPreferredPrograms(){
        return preferences;
    }
    /**
     * extracts the program that is allocated to the student
     * @return program which is allocated to the student
     */
    public String getAllocatedProgram(){
        return allocatedProgram;
    }
    /**
     * it sets the allocated program for a student
     * @param program which is to be allocated to the student
     */
    public void setAllocatedProgram(String program){
        this.allocatedProgram = program;
    }
}