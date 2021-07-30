package services;

import resources.SimpleLexer;
import resources.SimpleParser;

public class Interpreter {
    
    public static String simpleInterpreter(String entry) {
        SimpleParser parser = new SimpleParser(new SimpleLexer(entry)); 
        
        parser.run();

        return parser.getOutput(); 
    }
}
