package application;

import java.util.Scanner;

import services.Interpreter;
import utils.InputType;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);  
        String input = new String(); 
        
        System.out.println("------------------------------------------------------------------");
        System.out.println(">> SIMPLE EXPRESSION INTERPRETER                                <<"); 
        System.out.println("------------------------------------------------------------------"); 
        System.out.println("|> Input Type:");
        System.out.println("| (1) file .txt"); 
        System.out.println("| (2) typed ");
        System.out.println("| ----------------------------------------------------------------"); 
        System.out.print("| - choise: ");

        Integer type = sc.nextInt(); 

        System.out.println("|-----------------------------------------------------------------");

        input = InputType.choise(type); 

        System.out.println("|-----------------------------------------------------------------");
        System.out.println("|> Tokens and Variables: ");

        long runtime = System.currentTimeMillis(); 
        String result = Interpreter.simpleInterpreter(input);
        runtime = System.currentTimeMillis() - runtime;

        System.out.println("|-----------------------------------------------------------------");
        System.out.println("|> Result: ");
        System.out.println("| " + result); 
        System.out.println("| ~ Runtime: " + runtime + " ms");
        System.out.println("------------------------------------------------------------------");

        sc.close(); 
    }
}
