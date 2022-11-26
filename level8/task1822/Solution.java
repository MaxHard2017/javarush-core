package level8.task1822;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "cp866"));
        String fileName = br.readLine();

        String inputId = args[0].trim();
        String line = "";
        String lineId = "";

        try (
                BufferedReader bfr = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
        ){  
            String foundLine = null;
            while (bfr.ready()) {
                line = bfr.readLine();
                lineId = line.substring(0, line.indexOf(" ", 0));        //  берем первое слово - начало строки до первого пробела
                if (lineId.equals(inputId)) {
                    foundLine = line;
                    break;
                }
            }
            if (foundLine == null) {
                foundLine = "ID " + inputId + " not found.";
            }
            System.out.println(foundLine);
        }
    }
}
