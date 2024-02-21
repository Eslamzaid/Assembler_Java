package modle.Helpers;

import java.util.ArrayList;
import java.util.HashMap;

public class Helpers {
    private HashMap<String, String> data;

    public Helpers() {
        data = new HashMap<>();
        initiate();
    }

    // An algo for transforming a number to decimal
    // It will start first by multiplying 1 by 2 and taking the result and multiply it by 2 and so on, until it
    // reaches smaller or equally the number
    public StringBuilder intToBinaryConverter(int number) {
        boolean fl = false;
        int counter = 15;
        StringBuilder result = new StringBuilder();
         while (!fl) {
            int position = generateNumOfN(counter);
            if (position <= number) {
                number -= position;
                result.append('1');
            } else result.append('0');
            counter--;
            if (counter == -1) fl = true;
        }
        return result;
    }


    public String cInstructionDecoder(String ins) {
        StringBuilder result = new StringBuilder("111");
        String[] var = {"", "", ""};
        boolean[] ava = {false, false};
        ArrayList<Character> sym = new ArrayList<>();

        if (ins.contains("=")) {
            var[0] = ins.substring(0, ins.indexOf("="));
            ava[0] = true;
        }
        if (ins.contains(";")) {
            var[1] = ins.substring(ins.indexOf(';') + 1);
            ava[1] = true;
        }
        var[2] = ava[0] || ava[1] ? ins.substring(ava[0] ? ins.indexOf('=') + 1 : 0, ava[1] ? ins.indexOf(';') : ins.length()) : "";
        if (var[2].contains("M")) result.append('1');
        else result.append('0');
        result.append(data.get('c' + var[2]));
        result.append(ava[0] ? data.get(var[0]) : "000");
        result.append(ava[1] ? data.get(var[1]) : "000");
        return result.toString();

    }

    private int generateNumOfN(int num) {
        int sum = 1;
        for (int i = 0; i < num; i++) sum *= 2;
        return sum;
    }

    private void initiate() {
        data.put("c0", "101010");
        data.put("c1", "111111");
        data.put("c-1", "111010");
        data.put("cD", "001100");
        data.put("cA", "110000");
        data.put("c!D", "001101");
        data.put("c!A", "110001");
        data.put("c-D", "001111");
        data.put("c-A", "110011");
        data.put("cD+1", "011111");
        data.put("cA+1", "110111");
        data.put("cD-1", "001110");
        data.put("cA-1", "110010");
        data.put("cD+A", "000010");
        data.put("cD-A", "010011");
        data.put("cA-D", "000111");
        data.put("cD&A", "000000");
        data.put("cD|A", "010101");
        data.put("cM", "110000");
        data.put("c!M", "110001");
        data.put("c-M", "110011");
        data.put("cM+1", "110111");
        data.put("cM-1", "110010");
        data.put("cD+M", "000010");
        data.put("cD-M", "010011");
        data.put("cM-D", "000111");
        data.put("cD&M", "000000");
        data.put("cD|M", "010101");
        // Dest
        data.put("M", "001");
        data.put("D", "010");
        data.put("DM", "011");
        data.put("MD", "011");
        data.put("A", "100");
        data.put("AM", "101");
        data.put("AD", "110");
        data.put("ADM", "111");
        // Jump
        data.put("JGT", "001");
        data.put("JEQ", "010");
        data.put("JGE", "011");
        data.put("JLT", "100");
        data.put("JNE", "101");
        data.put("JLE", "110");
        data.put("JMP", "111");
    }

}
