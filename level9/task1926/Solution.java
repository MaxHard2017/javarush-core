package level9.task1926;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* 
 * 1. Считать с консоли имя файла. Считать содержимое файла.
2. Для каждой строки в файле:
2.1. переставить все символы в обратном порядке.
2.2. вывести на экран.
3. Закрыть потоки.
    Пример тела входного файла:
        я - программист.
        Амиго
    Пример результата:
        .тсиммаргорп - я
        огимА
Требования:
    •    Программа должна считывать имя файла с консоли (используй BufferedReader).
    •    BufferedReader для считывания данных с консоли должен быть закрыт.
    •   Программа должна считывать содержимое файла (используй FileReader).
    •    Поток чтения из файла (FileReader) должен быть закрыт.
    •    Программа должна выводить в консоль все символы из файла в обратном порядке.
 */

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            BufferedReader fr = new BufferedReader(new FileReader(br.readLine(), StandardCharsets.UTF_8));
        ){
            while (fr.ready()) {
                StringBuilder sb = new StringBuilder();
                sb.append(fr.readLine());
                System.out.println(sb.reverse());
            }
        }
    }
}