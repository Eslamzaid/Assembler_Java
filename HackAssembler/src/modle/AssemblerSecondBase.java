package modle;

import modle.Helpers.Helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AssemblerSecondBase {
    private SymbolTable symbolTable;
    private int lineNumber;
    private String nameOfFile;
    private StringBuilder outputFile;
    private Helpers helperFun;
    private int variableNumber;


    public AssemblerSecondBase(SymbolTable symTable, String name) {
        this.symbolTable = symTable;
        this.lineNumber = 0;
        this.nameOfFile = name;
        outputFile = new StringBuilder();
        helperFun = new Helpers();
        this.variableNumber = 16;
        analyzeScript();
    }

    private void analyzeScript() {
        try {
            File asmObj = new File(nameOfFile + ".asm");
            File outputFile = new File(nameOfFile + ".hack");
            FileWriter outputFileWriter = new FileWriter(nameOfFile + ".hack");
            Scanner myReader = new Scanner(asmObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String address = "";
                if (!data.trim().startsWith("//") && !data.isEmpty() && !data.startsWith("(")) {
                    data = data.trim();
                    if (data.startsWith("@")) {
                        Symbol aInstruct = symbolTable.searchSymbol(data.substring(1));
                        try {
                            String var = data.substring(1);
                            if (aInstruct != null) {
                                address = helperFun.intToBinaryConverter(aInstruct.getAddress()).toString();
                            } else if (!isNumber(var)) {
                                symbolTable.addSymbol(new Symbol(var, variableNumber));
                                variableNumber++;
                                Symbol varInstruct = symbolTable.searchSymbol(data.substring(1));
                                address = helperFun.intToBinaryConverter(varInstruct.getAddress()).toString();
                            } else {
                                int add = Integer.parseInt(var);
                                address = helperFun.intToBinaryConverter(add).toString();
                            }
                            outputFileWriter.write(address + "\n");
                        } catch (NullPointerException e) {
                            System.out.println("Couldn't parse the string");
                        }
                    } else {
                        outputFileWriter.write(helperFun.cInstructionDecoder(data) + "\n");
                    }
                }
            }
            myReader.close();
            outputFileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occuried reading file: " + e);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error occurred reading the file");
            throw new RuntimeException(e);
        }

        System.out.println(outputFile);
    }

    private boolean isNumber(String test) {
        try {
            Integer.parseInt(test);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
