package Assignment3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeList empList = new EmployeeList();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of employees you want to add:");
        int number = sc.nextInt();
        sc.nextLine();

        for (int count = 1; count <= number; count++) {

            System.out.println("Enter the name of the employee:");
            String name = sc.nextLine();

            System.out.println("Enter the age of the employee");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter the salary of the employee");
            double salary = sc.nextDouble();
            sc.nextLine();

            empList.addEmployee(new Employee(name, age, salary)); // ceating object for employee class
        }

        System.out.println("Employee List");
        System.out.println("***************");
        empList.displayList(); // display method call

        System.out.println("Employee list sorted on the basis of salary");
        System.out.println("********************************************");
        empList.sortList(); // sort method call
        empList.displayList(); // display method call

        sc.close();
    }
}