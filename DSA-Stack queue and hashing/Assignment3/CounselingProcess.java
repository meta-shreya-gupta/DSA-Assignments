package Assignment3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Assignment2.ArrayQueue;

public class CounselingProcess {
    ArrayQueue<Student> studentQueue ;
    Map<String , Program> programs;
    public CounselingProcess(int queueCapacity){
        this.studentQueue = new ArrayQueue<>(queueCapacity);
        this.programs = new HashMap<>();
    }
    /**
     * adds a program to the college counseling
     * @param name of the program that is added
     * @param capacity number of students to whom this program can be allocated
     */
    public void addProgram(String name , int capacity){
        programs.put(name , new Program(name, capacity));
    }
    /**
     * adds a student to the counseling process queue
     * @param student added in the queue of counsling process
     */
    public void addStudent(Student student){
        studentQueue.add(student);
    }
    /**
     * allocates a program to the student if that program has capacity
     * @param student whome program is allocated
     */
    public void allocateProgram(Student student){
        for(String preference : student.getPreferredPrograms()){
            Program program = programs.get(preference);
            if(program != null && program.hasCapacity()){
                program.enrollStudent(student);
                student.setAllocatedProgram(preference);
                break;
            }
        }
    }
    /**
     * traverses each student which are in the queue for the counseling process
     */
    public void allocationProcess(){
        while(!studentQueue.isEmpty()){
            Student student = studentQueue.remove();
            allocateProgram(student);
        }
    }
    /**
     * prints the allocation for each student and the program which are allocated to them
     */
    public void printAllocations(){
        System.out.println("Student Allocations");
        for(Program program : programs.values()){
            System.out.println("Program : " + program.getProgramName());
            for(Student student : program.getEnrolledStudent()){
                System.out.println(student.getStudentName());
            }
        }
        System.out.println("Students without allocations");
        for(Program program : programs.values()){
            for(Student student : program.getEnrolledStudent()){
                if(student.getAllocatedProgram() == null){
                    System.out.println(student.getStudentName());
                }
            }
        }
    }
    public static void main(String[] args){
        CounselingProcess counseling = new CounselingProcess(100);
        counseling.addProgram("cs", 1);
        counseling.addProgram("ece", 1);
        counseling.addProgram("it", 1);
        counseling.addProgram("aiml", 1);
        counseling.addProgram("mech", 0);

        counseling.addStudent(new Student("Ram" , Arrays.asList("cs" , "ece" , "it" , "aiml" , "mech")));
        counseling.addStudent(new Student("Shyam" , Arrays.asList("ece" , "it" , "mech" , "cs" , "aiml")));
        counseling.addStudent(new Student("Sita" , Arrays.asList("mech" , "cs" , "aiml" , "ece" , "it")));
        counseling.addStudent(new Student("Gita" , Arrays.asList("aiml" , "cs" , "mech" , "ece" , "it")));
        counseling.addStudent(new Student("Rohan" , Arrays.asList("cs" , "ece" , "aiml" , "it" , "mech")));

        counseling.allocationProcess();

        counseling.printAllocations();
    }
}