package resources;

import java.util.HashMap;

public class SymbolTable {
    
    private HashMap<String, Double> symbolTable; 

    public SymbolTable(){
        this.symbolTable = new HashMap<>(); 
    }

    public void addSymbolOnTable(String name, Double value) {
        symbolTable.put(name, value); 
    }

    public Double getSymbolOnTable(String name) {
        return symbolTable.get(name); 
    }
}
