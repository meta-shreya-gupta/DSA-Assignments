package Assignment1;

public class Employee implements Comparable<Employee>{
    int empId;          //should be unique
    String name;
    String address;
    public Employee(int empId , String name , String address){
        this.empId = empId;
        this.name = name;
        this.address = address;
    }
    /**
     * extracts name of the employee
     * @return name of the employee
     */
    public String getName(){
        return name;
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof Employee)){
            return false;
        }
        Employee emp = (Employee)o;
        return this.empId == emp.empId;
    }
    @Override
    public int hashCode(){
        return Integer.hashCode(empId);
    }
    @Override
    public String toString(){
        return empId + " " + name + " " + address;
    }
    /**
     * implements comparable->two objects are compared to each other
     */
    @Override
    public int compareTo(Employee emp){
        return this.empId - emp.empId;
    }
}