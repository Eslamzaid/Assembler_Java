package modle;

import java.util.LinkedList;

public class Initiater {
    private SymbolTable symbolTable;

    public Initiater(SymbolTable symTable) {
        this.symbolTable = symTable;
        initate();
    }

    private Symbol R0 = new Symbol("R0", 0);
    private Symbol R1 = new Symbol("R1", 1);
    private Symbol R2 = new Symbol("R2", 2);
    private Symbol R3 = new Symbol("R3", 3);
    private Symbol R4 = new Symbol("R4", 4);
    private Symbol R5 = new Symbol("R5", 5);
    private Symbol R6 = new Symbol("R6", 6);
    private Symbol R7 = new Symbol("R7", 7);
    private Symbol R8 = new Symbol("R8", 8);
    private Symbol R9 = new Symbol("R9", 9);
    private Symbol R10 = new Symbol("R10", 10);
    private Symbol R11 = new Symbol("R11", 11);
    private Symbol R12 = new Symbol("R12", 12);
    private Symbol R13 = new Symbol("R13", 13);
    private Symbol R14 = new Symbol("R14", 14);
    private Symbol R15 = new Symbol("R15", 15);

    private Symbol SP = new Symbol("SP", 0);
    private Symbol LCL = new Symbol("LCL", 1);
    private Symbol ARG = new Symbol("ARG", 2);
    private Symbol THIS = new Symbol("THIS", 3);
    private Symbol THA = new Symbol("THAT", 4);

    // SCREEN and KBD stand for 16384 and 24576
    private Symbol SCREEN = new Symbol("SCREEN", 16384);
    private Symbol KBD = new Symbol("KBD", 24576);

    private void initate() {
        symbolTable.addSymbol(R0);
        symbolTable.addSymbol(R1);
        symbolTable.addSymbol(R2);
        symbolTable.addSymbol(R3);
        symbolTable.addSymbol(R4);
        symbolTable.addSymbol(R5);
        symbolTable.addSymbol(R6);
        symbolTable.addSymbol(R7);
        symbolTable.addSymbol(R8);
        symbolTable.addSymbol(R9);
        symbolTable.addSymbol(R10);
        symbolTable.addSymbol(R11);
        symbolTable.addSymbol(R12);
        symbolTable.addSymbol(R13);
        symbolTable.addSymbol(R14);
        symbolTable.addSymbol(R15);
        symbolTable.addSymbol(SP);
        symbolTable.addSymbol(LCL);
        symbolTable.addSymbol(ARG);
        symbolTable.addSymbol(THIS);
        symbolTable.addSymbol(THA);
        symbolTable.addSymbol(SCREEN);
        symbolTable.addSymbol(KBD);
    }
}
