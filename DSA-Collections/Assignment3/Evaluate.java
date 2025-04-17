package Assignment3;

import java.util.Scanner;
import java.util.Stack;

public class Evaluate {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter chemical formula");
        String chemicalFormula = sc.nextLine();
        System.out.println("Molecular mass = " + evaluateMass(chemicalFormula));
        sc.close();
    }

    private static int evaluateMass(String chemicalFormula) {
        Stack<Integer> stack = new Stack<>();
        char[] array = chemicalFormula.toCharArray();
        for(char ch : array){
            switch(ch){
                case 'C' :                          //mass of C = 12
                    stack.push(12);
                    break;
                case 'H' :                          //mass of H = 1
                    stack.push(1);
                    break;
                case 'O' :                          //mass of O = 16
                    stack.push(16);
                    break;
                case '(' :                          //addition of 0 do not affect the mass
                    stack.push(0);
                    break;
                case ')' :                          //adding till we get (
                    int temp = 0;
                    while(stack.peek() != 0  && !stack.isEmpty()){
                        temp += stack.pop();
                    }
                    stack.push(temp);
                    break;
                default :                           //care is taken if a number appears to multiply
                    if(ch >= '1' && ch <= '9'){
                        int temp1 = ch - '0';
                        stack.push(stack.pop() * temp1);
                    }
            }
        }
        int finalResult = 0;                        //adding all the results of the stack
        while(!stack.isEmpty()){
            finalResult += stack.pop();
        }
        return finalResult;
    }
}
