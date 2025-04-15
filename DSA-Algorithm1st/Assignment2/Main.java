package Assignment2;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        EmployeeList empList = new EmployeeList();
        System.out.println("Enter the number of employees you want to add");
        int count = sc.nextInt();
        sc.nextLine();
        while(count > 0){
            System.out.println("Enter name ");
            String name = sc.nextLine();
            System.out.println("Enter age ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter salary ");
            double salary = sc.nextDouble();
            sc.nextLine();
            count--;
            empList.addEmployee(new Employee(name, age, salary));
        }
        empList.displayList();
        System.out.println("Sorted list");
        empList.sortList();
        empList.displayList();
        sc.close();
    }
}
