package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import utils.exceptions.FileInputTypeException;

public class InputType {
    
    public static String choise(Integer type) {
        switch (type) {
            case 1:    
                return fileInputType(); 
            case 2:
                return typedInputType(); 
            default:
                return "Nothing Here";
        }
    }

    private static String typedInputType() {
        Scanner sc = new Scanner(System.in); 
        String input = new String(); 

        System.out.println("| code: ");
        System.out.print("| "); 

        input += sc.nextLine(); 

        sc.close(); 
        return input; 
    }

    private static String fileInputType() {
        Scanner sc = new Scanner(System.in); 
        String path; 
        String input = new String();

        System.out.print("| file path: "); 
        path = sc.nextLine(); 

        sc.close(); 

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); 
            while (line != null) {
                input += line; 

                line = br.readLine(); 
            }
        } catch(IOException io) {
            throw new FileInputTypeException("\n *** Some error has occurred. Unable to read file!  *** \n"); 
        }

        return input; 
    }
}
