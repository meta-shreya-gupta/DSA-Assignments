package Assignment2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static int uniqueCharacter(String input){
        Map<String , Integer> map = new HashMap<>();            //to store already encountered string
        if(map.containsKey(input)){
            return map.get(input);
        }
        Set<Character> set = new HashSet<>();                   //to store unique character of the string
        char[] inputArr = input.toCharArray();
        for(Character ch : inputArr){
            set.add(ch);
        }
        map.put(input , set.size());
        return set.size();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter string or exit to exit the program");
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("exit")){
                System.exit(0);
                sc.close();
            }
            System.out.println("Unique character = " + uniqueCharacter(input));
        }
    }
    
}
