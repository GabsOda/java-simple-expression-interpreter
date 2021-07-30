package entities;

public enum ETokenType {
    
    NUMBER(0),  // <NUM>    ::= 1 | 2 | 3 | 4 | 5 | ...
    VAR(1),     // <VAR>    ::= $<variableName> 
    EQ(2),      // <EQ>     ::= =
    SUM(3),     // <SUM>    ::= + 
    SUB(4),     // <SUB>    ::= - 
    MULT(5),    // <MULT>   ::= *
    DIV(6),     // <DIV>    ::= /
    OPEN(7),    // <OPEN>   ::= (
    CLOSE(8),   // <CLOSE>  ::= )
    PRINT(9),   // <PRINT>  ::= print | PRINT
    EOL(99),    // <EOL>    ::= ; 
    EOF(-1); 

    private int code; 

    private ETokenType(int code) {
        this.code = code; 
    }

    public int getCode() {
        return code; 
    }
}
