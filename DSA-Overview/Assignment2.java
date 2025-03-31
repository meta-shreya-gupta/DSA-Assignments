import java.util.Scanner;
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class MyLinkedList {   
    Node head;
    public MyLinkedList(){
        this.head = null;
    }
    public MyLinkedList(Node head){
        this.head = head;
    }
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node start = head;
        while (start.next != null) {
            start = start.next;
        }
        start.next = newNode;
    }
    public boolean checkLoop() {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public void createLoopAtPosition(int position) {
        if (position == -1){
            return;
        }
        Node temp = head;
        Node loopNode = null;
        int count = 1;
        while (temp.next != null) {
            if (count == position) {
                loopNode = temp;
            }
            temp = temp.next;
            count++;
        }
        if(loopNode != null){
            temp.next = loopNode;
        }
        return;
    }
}
public class Assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();

        System.out.println("Enter number of elements in the list");
        int numberOfValues = sc.nextInt();
        
        System.out.println("Enter Node values");
        for(int index = 0 ; index < numberOfValues ; index ++){
            list.add(sc.nextInt());
        }
        System.out.println("Enter position to create a loop (-1 for no loop)");
        int position = sc.nextInt();
        list.createLoopAtPosition(position);

        if(list.checkLoop()){
            System.out.println("loop is detected");
        }
        else{
            System.out.println("No loop is detected");
        }
        sc.close();
    }
}
