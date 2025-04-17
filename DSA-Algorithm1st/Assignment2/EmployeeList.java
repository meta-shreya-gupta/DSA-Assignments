package Assignment2;

public class EmployeeList {
    Node head;

    /**
     * adds a new employee in the linked list
     * @param emp employee which we want to add in the linked list
     */
    public void addEmployee(Employee emp) {
        Node newNode = new Node(emp);
        if(head == null){                       //if initially list is empty then there will be only one employee in the linked list
            head = newNode;
            return ;
        }
        Node temp = head;                       //use temp so that we don't lose head of the linked list
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    /**
     * prints the details of each employee present in the linked list
     */
    public void displayList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.emp);
            temp = temp.next;
        }
    }
    /**
     * sorts the list according to salary(desc) if sal1 = sal2 then sort according to age
     */
    public void sortList(){
        Node sorted = null;
        Node current = head;                //considering the first employee to have max salary
        while(current != null){
            Node next = current.next;
            sorted = sorting(current , sorted);         //sorts the employees and add to next of the first employee
            current = next;
        }
        head = sorted;
    }
    /**
     * helper function to sort the linked list
     * @param current node which are currently on
     * @param sorted linked list which we are building by sorting
     * @return head of the sorted list
     */
    private Node sorting(Node current , Node sorted){
        if(sorted == null || compare(current.emp , sorted.emp)){
            current.next = sorted;
            return current;
        }
        Node temp = sorted;
        while(temp.next != null && !compare(current.emp , temp.next.emp)){
            temp = temp.next;
        }
        current.next = temp.next;
        temp.next = current;
        return sorted;

    }
    /**
     * helper function to determine if the employee salary or age is greater or smaller
     * @param emp1 first employee
     * @param emp2 second employee
     * @return true if first employee has greater salary (lesser age in case of equal salary)
     */
    private boolean compare(Employee emp1 , Employee emp2){
        if(emp1.getSalary() > emp2.getSalary()){
            return true;
        }
        else if(emp1.getSalary() == emp2.getSalary() && emp1.getAge() < emp2.getAge()){
            return true;
        }
        return false;
    }
}
