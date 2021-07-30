package resources;

import entities.ETokenType;
import entities.Token;

public class SimpleLexer {
    
    private Character space[] = {' ', '\n', '\t'};
    
    public int position; 

    public String input; 

    public SimpleLexer(String input) {
        this.input = input; 
        position = 0; 
    }

    private char nextChar() {
        if (position == input.length()) {
            return '\0'; 
        }

        return input.charAt(position++);
    }

    public Token nextToken() {
        char peek; 

        do {
            peek = nextChar(); 
        } while(peek == space[0] || peek == space[1] || peek == space[2]); 

        if(Character.isDigit(peek)) {
            String value = ""; 

            do{
                value += peek; 
                peek = nextChar(); 

            } while(Character.isDigit(peek) || peek == '.');

            if (peek != Character.MIN_VALUE) {
                position--; 
            }

            return new Token(ETokenType.NUMBER, value);
        }

        switch (peek) { 
            case '$': 
                String varName = ""; 
                
                do {
                    varName += peek; 
                    peek = nextChar();
                } while (Character.isLetter(peek));

                if (peek != Character.MIN_VALUE) {
                    position--; 
                }
                
                return new Token(ETokenType.VAR, varName); 

            case '=': 
                return new Token(ETokenType.EQ, null); 

            case '+': 
                return new Token(ETokenType.SUM, null);

            case '-': 
                return new Token(ETokenType.SUB, null); 

            case '*': 
                return new Token(ETokenType.MULT, null);

            case '/': 
                return new Token(ETokenType.DIV, null);

            case '(': 
                return new Token(ETokenType.OPEN, null); 

            case ')': 
                return new Token(ETokenType.CLOSE, null); 

            case 'p': 
                do {
                    peek = nextChar();
                } while (peek != 't');

                return new Token(ETokenType.PRINT, null); 

            case ';': 
                return new Token(ETokenType.EOL, null); 

            default: 
                return new Token(ETokenType.EOF, null); 
        }
    }

}
