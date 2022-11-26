package level8.task1820;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"cp866"));
        String fileIn = br.readLine();
        String fileOut = br.readLine();

        try (
                BufferedReader bufIn = new BufferedReader(new FileReader(fileIn));
                FileWriter fw = new FileWriter(fileOut);
        ){
            String inputString;
            String[] inpuStringWords;
            String newDouble;
            while (bufIn.ready()) {
                inputString = bufIn.readLine();
                inpuStringWords = inputString.split(" ", 0);
                for (String word : inpuStringWords) {
                    newDouble = round(word, 0) + " ";
                    fw.write(newDouble);
                }
            }
        }
    }

    public static String round (String doubleValue, int scale) {
        if (scale < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(doubleValue);
        bd = bd.setScale(scale, RoundingMode.UP);
        return bd.toString();
    }
}
