package Assignment2;

public class Employee{
    String name;
    int age;
    double salary;
    public Employee(String name , int age , double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    /**
     * extracts name of employee
     * @return name of the employee
     */
    public String getName(){
        return name;
    }
    /**
     * extracts age of the employee
     * @return age of the employee
     */
    public int getAge(){
        return age;
    }
    /**
     * extracts salary of the employee
     * @return salary of the employee
     */
    public double getSalary(){
        return salary;
    }
    /**
     * sets name of the employee
     * @param name which we want to set
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * sets age of the employee
     * @param age which we want to set
     */
    public void setAge(int age){
        this.age = age;
    }
    /**
     * set the salary of the employee
     * @param salary which we want to set
     */
    public void setSalary(double salary){
        this.salary = salary;
    }
    /**
     * shortens to print method to print the object
     */
    @Override
    public String toString(){
        return name + " " + age + " " + salary + " ";
    }
}