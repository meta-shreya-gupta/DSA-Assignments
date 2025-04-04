package Assignment1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        VirtualCommandPrompt test = new VirtualCommandPrompt();
        while(true){
            System.out.print(test.findPath(test.getCurrent()));
            String input = sc.nextLine();
            String[] parts = input.split("\\s+");
            String command = parts[0];
            switch(command){
                case "mkdir" :
                    if(parts.length > 1){
                        test.mkdir(parts[1]);
                    }
                    else{
                        System.out.println("Directory name required");
                    }
                    break;
                case "cd" :
                    if(parts.length > 1){
                        test.cd(parts[1]);
                    }
                    else{
                        System.out.println("Directory name required");
                    }
                    break;
                case "bk" :
                    test.bk();
                    break;
                case "ls" :
                    test.ls();
                    break;
                case "find" :
                    test.find(test.getCurrent() , parts[1]);
                    break;
                case "exit" :
                    test.exit();
                    sc.close();
                    break;
                default : 
                    System.out.println("Enter valid command");
            }
        }
    }
}
