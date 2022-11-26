package level9.task1906;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* 
 * Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).
    Пример первого файла:
        text in file
        Вывод во втором файле:
        eti ie
Закрыть потоки ввода-вывод
Требования:
    •    Программа должна считывать имена файлов с консоли (используй BufferedReader).
    •    BufferedReader для считывания данных с консоли должен быть закрыт.
    •    Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
    •    Поток чтения из файла (FileReader) должен быть закрыт.
    •    Программа должна записывать во второй файл все символы из первого файла с четным порядковым номером (используй FileWriter).
    •    Поток записи в файл (FileWriter) должен быть закрыт.
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                FileReader fr = new FileReader(new File(br.readLine()));
                FileWriter fw = new FileWriter(new File(br.readLine()));
        ){
            int i = 1;

            while (fr.ready()) {
                if (i % 2 == 0) {
                    fw.write(fr.read());
                } else {
                    fr.read();
                }
                i++;
            }
        }
    }
}
