import modle.*;
import modle.Helpers.Helpers;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();
        Initiater init = new Initiater(symbolTable);
        AssemblerFirstBase firstBase = new AssemblerFirstBase(symbolTable, "D:\\temp\\nand2tetris\\projects\\06\\pong\\Pong");
        AssemblerSecondBase secondBase = new AssemblerSecondBase(symbolTable, "D:\\temp\\nand2tetris\\projects\\06\\pong\\Pong");
    }
}