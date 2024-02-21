package modle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class AssemblerFirstBase {
    private final SymbolTable symbolTable;
    private int lineNumber;
    private String nameOfFile;

    public AssemblerFirstBase(SymbolTable symTable, String name) {
        this.symbolTable = symTable;
        this.lineNumber = 0;
        this.nameOfFile = name;
        analyzeScript();
    }


    // REQUIRE: NOF.asm
    // EFFECTS: will analyze the script and will add all the available labels to the symbol table
    private void analyzeScript() {
        try {
            File asmObj = new File(nameOfFile+".asm");
            Scanner myReader = new Scanner(asmObj);
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(!data.trim().startsWith("//") && !data.isEmpty()) {
                    data = data.trim();
                    if(data.startsWith("(")) {
                        String label = "";
                        label += data.substring(1, data.indexOf(')'));
                        symbolTable.addSymbol(new Symbol(label, lineNumber));
                    } else lineNumber++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occuried reading file: "+e);
            e.printStackTrace();
        }
    }
}
