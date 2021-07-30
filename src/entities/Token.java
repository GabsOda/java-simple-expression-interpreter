package entities;

public class Token {
    
    private ETokenType type; 
    private String attribute; 

    public Token() {

    }

    public Token(ETokenType type, String attribute) {
        this.type = type; 
        this.attribute = attribute; 
    }

    public ETokenType getType() {
        return type;
    }

    public void setType(ETokenType type) {
        this.type = type;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

}
