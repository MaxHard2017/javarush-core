package level9.task1908;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * Считать с консоли 2 пути к файлам.
Вывести во второй файл все целые числа, которые есть в первом файле (54у не является числом).
Числа выводить через пробел.
Закрыть потоки. 
    Пример тела файла:
        12 text var2 14 8ю 1
    Результат:
        12 14 1
Требования:
    •    Программа должна считывать пути к файлам с консоли (используй BufferedReader).
    •    BufferedReader для считывания данных с консоли должен быть закрыт.
    •    Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
    •    Поток чтения из файла (BufferedReader) должен быть закрыт.
    •    Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
    •    Поток записи в файл (BufferedWriter) должен быть закрыт.
 */
public class Solution {
    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileOut = "";
        String fileIn  = "";
        
        try {
            fileIn  = br.readLine();
            fileOut = br.readLine();
            br.close();
        } catch (IOException e) {
            System.out.println("Can not read name!");
            e.printStackTrace();
        }
        

        try (
                FileWriter fw = new FileWriter(new File(fileOut));
                FileReader fr = new FileReader(new File(fileIn));
                BufferedReader bfr = new BufferedReader(fr);
                BufferedWriter bfw = new BufferedWriter(fw)
        ) {
            String[] inputFileString;
            while (bfr.ready()) {
                inputFileString = bfr.readLine().split("[\\s]");
                for (String word : inputFileString) {
                    if(word.matches("\\d+")) {
                        bfw.write(word + " ");
                    }
                }
            }
                
        } catch (IOException e) {
            System.out.println("Can not open file!");
            e.printStackTrace();
        }
    }
}