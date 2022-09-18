package level3.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static File outFile() throws IOException {
        String fileName = "";
        System.out.print("Введите имя файла для записи: ");

        try(BufferedReader bufreader = new BufferedReader(
                                        new InputStreamReader(System.in, "cp866"));
        ) {
            fileName = bufreader.readLine();
        }                             
        return new File(fileName);
    }
   
    public static List<String> consoleTextToList() throws IOException {
        List<String> list = new ArrayList<String>();
        String inputString = "";
        System.out.println("Введите текст для записи в файл или \"exit\" - для выхода");
        
        try (BufferedReader bufreader = new BufferedReader(
                                    new InputStreamReader(System.in, "cp866"));
        ) {
            do {
                inputString = bufreader.readLine();
                list.add(inputString);
            } while (!inputString.equals("exit"));
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        File file = outFile();
        try (BufferedWriter bufWriter = new BufferedWriter(
                                 new FileWriter(file, StandardCharsets.UTF_8));
        )
        {
            String result = "";
            List<String> list = consoleTextToList();
            for (String item : list) {
                if (!item.equals("exit")) {
                    result = item + "\n";
                } else {
                    result = item;
                }
                bufWriter.write(result);
            }
        }
    }
}