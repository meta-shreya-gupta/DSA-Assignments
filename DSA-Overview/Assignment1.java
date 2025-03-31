import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class LinkedList{
    Node head;
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return ;
        }
        Node start = head;
        while(start.next != null){
            start = start.next;
        }
        start.next = newNode;
    }
    public void rotateSubList(int L , int R , int N ){
        Node start = head;
        for(int index = 1 ; index < L ; index ++){
            start = start.next;
        }
        Node end = start;
        for(int index = L ; index < R ; index ++){
            end = end.next;
        }
        Node previous = end.next;
        end.next = null;
        List<Integer> subList = new ArrayList<>();
        Node temp = start;
        while(temp != null){
            subList.add(temp.data);
            temp = temp.next;
        }
        Collections.rotate(subList , N);
        temp = start;
        for(int element : subList){
            temp.data = element;
            temp = temp.next;
        }
        end.next = previous;
    }
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
public class Assignment1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int size = sc.nextInt();
        System.out.println("Enter elements one by one");
        LinkedList list = new LinkedList();
        for(int index = 0 ; index < size ; index++){
            int data = sc.nextInt();
            list.add(data);
        }
        list.printList();
        System.out.println("Enter left index");
        int L = sc.nextInt();
        System.out.println("Enter right index");
        int R = sc.nextInt();
        System.out.println("Enter number of steps of rotation");
        int N = sc.nextInt();
        list.rotateSubList(L, R, N);
        list.printList();
        sc.close();
    }
}