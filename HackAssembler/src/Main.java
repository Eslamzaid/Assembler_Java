import modle.*;
import modle.Helpers.Helpers;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();
        Initiater init = new Initiater(symbolTable);
        AssemblerFirstBase firstBase = new AssemblerFirstBase(symbolTable, "address of file"); // for future updates, just put the name of the file as an argument when running the file
        AssemblerSecondBase secondBase = new AssemblerSecondBase(symbolTable, "address of file");
    }
}
