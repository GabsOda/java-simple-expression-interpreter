package resources;

import entities.ETokenType;
import entities.Token;
import resources.exceptions.SimpleParserException;

public class SimpleParser {
    
    public String output; 
    private SimpleLexer lexer; 
    private Token lookAhead; 

    private SymbolTable symbolTable = new SymbolTable();

    private StringBuilder sb = new StringBuilder();

    public SimpleParser(SimpleLexer lexer) {
        this.lexer = lexer; 
        this.lookAhead = lexer.nextToken(); 
    }

    public String getOutput() {
        buildOutput();

        return output;
    }

    private void match(Token token) {
        System.out.println("|" + " -> token: " +lookAhead.getType() + " - " + lookAhead.getAttribute()); 
        if (lookAhead.getType() == token.getType() && lookAhead.getAttribute() == token.getAttribute()) {
            lookAhead = lexer.nextToken();
        } else {
            throw new SimpleParserException("\n *** Syntax Error! Values do not match. *** \n"); 
        }
    }

    public void run() {
        prog(); 
    }

    private void prog() {
        stmt(); 
        match(lookAhead);//-> EOL
        lines(); 
    }

    private void lines() {
        if (lookAhead.getType() != ETokenType.EOF) {
           prog();  
        }
    }

    private void stmt() {
        if (lookAhead.getType() == ETokenType.VAR) {
            atr();
        } else if (lookAhead.getType() == ETokenType.PRINT) {
            imp(); 
        } else {
            throw new RuntimeException(); 
        }
    }

    private void atr() {
        String name = lookAhead.getAttribute(); 

        match(lookAhead);//-> VAR
        match(lookAhead);//-> EQ

        Double value = expr(); 

        System.out.println("| # var: " + name + " -> " + value);

        symbolTable.addSymbolOnTable(name, value);
    }

    private void imp() {
        match(lookAhead);//-> PRINT
        match(lookAhead);//-> OPEN
        
        String name = lookAhead.getAttribute(); 

        match(lookAhead);//-> VAR
        match(lookAhead);//-> CLOSE

        Double value = symbolTable.getSymbolOnTable(name); 

        sb.append(""+value); 
    }

    private Double expr() {
        double fact = fact(); 

        if (lookAhead.getType().equals(ETokenType.SUM)) {
            match(lookAhead);//-> SUM
            double expr = expr(); 
            return fact + expr;
        } else if (lookAhead.getType().equals(ETokenType.SUB)) {
            match(lookAhead);//-> SUB
            double expr = expr();  
            return fact - expr; 
        } else {
            return fact; 
        }
    }

    private Double fact() {
        double term = term(); 

        if (lookAhead.getType().equals(ETokenType.MULT)) {
            match(lookAhead);//-> MULT
            double fact = fact();
            return term * fact; 
        } else if (lookAhead.getType().equals(ETokenType.DIV)) {
            match(lookAhead);//-> DIV
            double fact = fact(); 
            return term / fact; 
        } else {
            return term; 
        }
    }

    private Double term() {
        if (lookAhead.getType().equals(ETokenType.OPEN)) {
            match(lookAhead);// -> OPEN
            Double expr = expr(); 
            match(lookAhead);// -> CLOSE
            return expr; 
        } else if (lookAhead.getType().equals(ETokenType.NUMBER)) {
            Double value = Double.parseDouble(lookAhead.getAttribute()); 
            match(lookAhead);//-> NUMBER
            return value; 
        } else if (lookAhead.getType().equals(ETokenType.VAR)) {
            String name = lookAhead.getAttribute(); 
            match(lookAhead);//-> VAR
            return symbolTable.getSymbolOnTable(name); 
        } else {
            throw new RuntimeException(); 
        }
    }    

    private void buildOutput() {
        output = sb.toString(); 
    }
}
