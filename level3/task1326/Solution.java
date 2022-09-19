package level3.task1326;
/*
 *  Ввести имя файла с консоли.
    Прочитать из него набор чисел.
    Вывести в консоли только четные, отсортированные по возрастанию.
        Пример ввода:
            5
            8
            -2
            11
            3
            -5
            2
            10

        Пример вывода:
            -2
            2
            8
            10
        Требования:
        •    Программа должна считывать данные с консоли.
        •    Программа должна создавать FileInputStream для введенной с консоли строки.
        •    Программа должна выводить данные на экран.
        •    Программа должна вывести на экран все четные числа, считанные из файла, отсортированные по возрастанию.
        •    Программа должна закрывать поток чтения из файла — FileInputStream.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readString = new BufferedReader(new InputStreamReader(System.in, "cp866"));
        
        String fileName;
        File inputDataFile;
        do {
            System.out.print("Введите имя файла данных: ");
            fileName = readString.readLine();
            inputDataFile = new File(fileName);
        } while (!inputDataFile.exists() || !inputDataFile.isFile());
        
        List<Integer> intList = new ArrayList<Integer>();

        try ( InputStream inputStream = new FileInputStream(inputDataFile);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        ) {
            String line = "";
            while ((line = br.readLine()) != null) {
                intList.add(Integer.parseInt(line));
            }
        }
        intList.sort(null);
        for (Integer item : intList) {
            if ((item % 2)  == 0) {
                System.out.println(item);
            }
        }
    }
}