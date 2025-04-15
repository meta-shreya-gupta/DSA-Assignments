package Assignment3;

public class EmployeeList {
    Node head;
    Node left;
    Node right;

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
    public void sortList(){
        head = quickSort(head);
    }
    public Node quickSort(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        left = null;
        right = null;
        partition(head);
        Node Sortedleft = quickSort(left);
        Node Sortedright = quickSort(right);
        head.next = Sortedright;

        if( Sortedleft == null) {
            return head;
        }
        Node temp = Sortedleft;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        return Sortedleft;

    }

    private void partition(Node pivot) {
        Node temp = pivot.next;
        pivot.next = null;
        while (temp != null) {
            Node nxt = temp.next;
            if (comparison(temp.emp, pivot.emp)) {
                temp.next = left;
                left = temp;
            } else {
                temp.next = right;
                right = temp;
            }
            temp = nxt;
        }
    }
    public boolean comparison(Employee emp1 , Employee emp2){
        if(emp1.getSalary() > emp2.getSalary()){
            return true;
        }
        else if(emp1.getSalary() == emp2.getSalary() && emp1.getAge() < emp2.getAge()){
            return true;
        }
        return false;
    }


}
