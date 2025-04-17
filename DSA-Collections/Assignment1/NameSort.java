package Assignment1;

import java.util.Comparator;
/**
 * implements the comparator->third object compares the two object
 */
public class NameSort implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1 , Employee emp2){
        return emp1.getName().compareToIgnoreCase(emp2.getName());
    }
}
