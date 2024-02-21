package modle;

import java.util.LinkedList;

public class SymbolTable {
    private final LinkedList<Symbol> symbolTable;

    public SymbolTable() {
        symbolTable = new LinkedList<>();
    }

    public void addSymbol(Symbol sym) {
        symbolTable.add(sym);
    }

    public void removeSymbol(Symbol sym) {
        symbolTable.remove(sym);
    }

    public Symbol searchSymbol(String sym) throws NullPointerException {
        for(Symbol s : symbolTable) {
            if(s.getName().equals(sym)) return s;
        }
        return null;
    }

    public LinkedList<Symbol> getSymbolTable() {
        return symbolTable;
    }


}
