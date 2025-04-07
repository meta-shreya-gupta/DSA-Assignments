package Assignment1;

import java.util.Scanner;

public class EvaluateInfix {
    /**
     * checks for the arithmetic operator
     * @param op token as an arithmetic operator
     * @return true if the token is arithmetic else false
     */
    public static boolean checkArithmetic(String op){
        switch(op){
            case "+" : return true; 
            case "-" : return true;
            case "*" : return true;
            case "/" : return true;
            default : return false;
        }
    }
    /**
     * checks for the relational operator
     * @param op token as relational operator
     * @return true if the operator is relational else false
     */
    public static boolean checkRelational(String op){
        switch(op){
            case "<" : return true;
            case ">" : return true;
            case "<=" : return true;
            case ">=" : return true;
            case "==" : return true;
            case "!=" : return true;
            default : return false;
        }
    }
    /**
     * checks for the boolean operator
     * @param op token as boolean operator
     * @return true if the token is boolean else false
     */
    public static boolean checkBoolean(String op){
        switch(op){
            case "!" : return true;
            case "&&" : return true;
            case "||" : return true;
            default : return false;
        }
    }
    /**
     * chwcks if arithmetic , relational or logical
     * @param token token is arithmetic , relational or logical
     * @return true if there is any type of operator else false
     */
    public static boolean isOperator(String token){
        return checkArithmetic(token) || checkBoolean(token) || checkRelational(token);
    }
    /**
     * higher int value means higher precedence
     * @param operator whose precedence is to be set
     * @return higher value for higher precedence operator
     */
    public static int getPrecedence(String operator){
        switch(operator){
            case "!" : return 6;
            case "*" : case "/" : return 5;
            case "+" : case "-" : return 4;
            case "<" : case ">" : case "<=" : case ">=" : return 3;
            case "!=" : case "==" : return 2;
            case "&&" : case "||" : return 1;
            default : return 0;
        }
    }
    /**
     * executes the operation according to the operator
     * @param operand1 whose operation is to be performed
     * @param operand2 with whom the operation is to be performed
     * @param operator type of operation need to be perfromed
     * @return output after the operation is performed
     */
    public static int executeOperation(int operand1 , int operand2 , String operator){
        switch(operator){
            case "+" : return operand1 + operand2;
            case "-" : return operand1 - operand2;
            case "*" : return operand1 * operand2;
            case "/" :
                if(operand2 == 0){
                    throw new ArithmeticException("Divion by 0 not possible");
                }
                return operand1 / operand2;
            case "<" : return operand1 < operand2 ? 1 : 0;
            case ">" : return operand1 > operand2 ? 1 : 0;
            case "<=" : return operand1 <= operand2 ? 1 : 0;
            case ">=" : return operand1 >= operand2 ? 1 : 0;
            case "==" : return operand1 == operand2 ? 1 : 0;
            case "!=" : return operand1 != operand2 ? 1 : 0;
            case "&&" : return (operand1 != 0 && operand2 != 0) ? 1 : 0;
            case "||" : return (operand1 != 0 || operand2 != 0) ? 1 : 0;
            default : throw new IllegalArgumentException("Unknown Operator");
        }
    }
    /**
     * converts infix string to the postfix string
     * @param infix string expression that needs to be converted to postfix
     * @return postfix expression as a string
     */
    public static String infixToPostfix(String infix){
        StringBuilder postfix = new StringBuilder();
        MyStack<String> operatorStack = new ArrayStack<>(infix.length());
        String[] tokens = infix.split(" ");
        for(String token : tokens){
            if(token.matches("\\d+")){
                postfix.append(token).append(" ");
            }
            else if(token.equals("(")){
                operatorStack.push(token);
            }
            else if(token.equals(")")){
                while(!operatorStack.isEmpty() && !operatorStack.peek().equals("(")){
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop();
            }
            else if(isOperator(token)){
                while(!operatorStack.isEmpty() && !operatorStack.peek().equals("(") && getPrecedence(operatorStack.peek()) >= getPrecedence(token)){
                    postfix.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(token);
            }
        }
        while(!operatorStack.isEmpty()){
            postfix.append(operatorStack.pop()).append(" ");
        }
        return postfix.toString().trim();
    }
    /**
     * evaluate the postfix operation
     * @param postfix expression which needs to be evaluated
     * @return value after evaluating the whole expression
     */
    public static int evaluatePostfix(String postfix){
        String[] tokens = postfix.split(" ");
        MyStack<Integer> evaluate = new ArrayStack<>(tokens.length);
        for(String token : tokens){
            if(token.matches("\\d+")){
                evaluate.push(Integer.parseInt(token));
            }
            else if(token.equals("!")){
                int operand = evaluate.pop();
                if(operand == 0){
                    evaluate.push(1);
                }
                else{
                    evaluate.push(0);
                }
            }
            else if(isOperator(token)){
                int operand2 = evaluate.pop();
                int operand1 = evaluate.pop();
                evaluate.push(executeOperation(operand1, operand2, token));
            }
        }
        if(evaluate.size() != 1){
            throw new IllegalArgumentException("Invalid expression");
        }
        return evaluate.pop();
    }
    /**
     * whole process for infix expression evaluation
     * @param infix expression that needs to be evaluated
     * @return value obtained after whole evaluation
     */
    public static int evaluateInfixViaPostfix(String infix){
        String postfix = infixToPostfix(infix);
        return evaluatePostfix(postfix);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the infix expression containing digits and + , - , * , / , < , <= , > , >= , == , != , ! , && , || each separated by a whitespace");
        String infix = sc.nextLine();
        System.out.print("Result = " + evaluateInfixViaPostfix(infix));
        sc.close();
    }
}
