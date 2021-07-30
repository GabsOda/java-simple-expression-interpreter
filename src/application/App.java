package application;

import java.util.Scanner;

import services.Interpreter;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);  
        
        System.out.println("------------------------------------------------------------------");
        System.out.println("| code: "); 
        System.out.print("| ");

        String test = sc.nextLine(); 

        long runtime = System.currentTimeMillis(); 
        String result = Interpreter.simpleInterpreter(test);
        runtime = System.currentTimeMillis() - runtime;

        System.out.println(" -----------------------------------------------------------------");
        System.out.println("| => result: ");
        System.out.println("| - " + result); 
        System.out.println("| ~ Runtime: " + runtime + " ms");
        System.out.println("------------------------------------------------------------------");

        sc.close(); 
    }
}


/*
------------------ Infix to Postfix ------------------------------
| -> Input:
| - Infix: 1 + 2 + 3
 -----------------------------------------------------------------
| => Results:
| - Postfix: 1 2 + 3 +
| ~ Runtime: 10 ms
------------------------------------------------------------------
*/ 