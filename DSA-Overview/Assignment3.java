import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Term{
    int coefficient;
    Map<Character , Integer> variables = new HashMap<>();
    public Term(int coefficient , Map<Character , Integer> variables){
        this.coefficient = coefficient;
        this.variables = variables;
    }
    public int degree(){
        int degree = 0;
        for(int exponent : variables.values()){
            degree += exponent;
        }
        return degree;
    }
}
public class Assignment3 {
    public static int getDegree(List<Term> polynomial){
        int maxDegree = 0;
        for(Term term : polynomial){
            maxDegree = Math.max(maxDegree, term.degree());
        }
        return maxDegree;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of terms");
        List<Term> polynomial = new ArrayList<>();
        int numberOfTerms = sc.nextInt();
        for(int index = 0 ; index < numberOfTerms ; index ++){
            System.out.println("Enter coefficient");
            int coefficient = sc.nextInt();
            Map<Character , Integer> variables = new HashMap<>();
            System.out.println("Enter number of variables");
            int numberOfVariable = sc.nextInt();
            for(int mapIndex = 0 ; mapIndex < numberOfVariable ; mapIndex ++){
                System.out.println("Enter variable");
                char variable = sc.next().charAt(0);
                System.out.println("Enter exponent");
                int exponent = sc.nextInt();
                variables.put(variable , exponent);
            }
            Term term = new Term(coefficient, variables);
            polynomial.add(term);
        }
        System.out.println("Degree of the polynomial = " + getDegree(polynomial));
        sc.close();
    }
}
