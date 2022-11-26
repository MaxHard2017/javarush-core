package level9.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {



    public static void main(String[] args) throws IOException {

        
        String fileName = null;
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = consoleReader.readLine();
        } catch (IOException ignore) {
        }

        StringBuilder readFileContent = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                readFileContent.append(fileReader.readLine());
            }
        } catch (IOException ignore) {
        }

        String fileStr = readFileContent.toString().replaceAll("[\\r\\n]+", "");
        
        
        // String fileStr = Files.readString(Paths.get("c://test//d1.html"));

        Pattern tegPattern = Pattern.compile("(?m)(<\\/|<)(" + args[0] + "[^>\\/]*\\/?>[^<\\/\\n]*)");

        List<String> resultStr = new ArrayList<String>();
        Matcher match = tegPattern.matcher("");
        match.reset(fileStr);

        while (match.find()) {
            System.out.print(match.group(1) + match.group(2));
        }
    }
}