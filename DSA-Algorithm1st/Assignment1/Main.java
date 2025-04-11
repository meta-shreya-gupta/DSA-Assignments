package Assignment1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of dictionary key-value pair you want to enter");
        int count = sc.nextInt();
        sc.nextLine();

        String[] keys = new String[count];
        String[] values = new String[count];

        for(int index = 0 ; index < count ; index ++){
            System.out.println("Enter key " + (index + 1));
            keys[index] = sc.next();
            sc.nextLine();
            System.out.println("Enter value");
            values[index] = sc.nextLine();
        }

        BSTDictionary<String , String> bst = new BSTDictionary<>(keys, values);

        bst.inorder(bst.getRoot());
        System.out.println("Enter key whose value you want");
        String key = sc.nextLine();
        String value = bst.getValue(key);
        System.out.println("Value = " + value);
        
        System.out.println("Enter key you want to delete ");
        String deleteKey = sc.nextLine();
        bst.delete(deleteKey);
        bst.inorder(bst.getRoot());

        System.out.println("Dictionary in sorted order");
        bst.sortedList();

        System.out.println("Sort through initial key to final key");
        System.out.println("Enter the initial key");
        String key1= sc.nextLine();
        System.out.println("Enter the final key");
        String key2 = sc.nextLine();
        bst.sortedListByKeys(key1, key2);

        sc.close();
    }
}
