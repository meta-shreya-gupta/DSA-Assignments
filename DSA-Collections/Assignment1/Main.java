package Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of employees you want to add (add 5)");
        int count = sc.nextInt();
        Set<Employee> empSet = new HashSet<>();
        while(count > 0){
            System.out.println("Enter employee id");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter name");
            String name = sc.nextLine();
            System.out.println("Enter address");
            String address = sc.nextLine();
            empSet.add(new Employee(id, name, address));
            count --;
        }
        System.out.println("Data entered");
        for(Employee emp : empSet){
            System.out.println(emp);
        }
        List<Employee> empList = new ArrayList<>(empSet);
        Collections.sort(empList);
        System.out.println("Natural Sort");
        for(Employee emp : empList){
            System.out.println(emp);
        }
        System.out.println("Sort by name");
        Collections.sort(empList , new NameSort());
        for(Employee emp : empList){
            System.out.println(emp);
        }
        sc.close();
    }
}
