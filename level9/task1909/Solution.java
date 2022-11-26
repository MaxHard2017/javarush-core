package level9.task1909;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки "." на знак "!".
Результат вывести во второй файл.
Закрыть потоки.
Требования:
    •    Программа должна считывать имена файлов с консоли (используй BufferedReader).
    •    BufferedReader для считывания данных с консоли должен быть закрыт.
    •    Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
    •    Поток чтения из файла (BufferedReader) должен быть закрыт.
    •    Программа должна записывать во второй файл содержимое первого файла, где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
    •    Поток записи в файл (BufferedWriter) должен быть закрыт.
 */

public class Solution {
    public static void main(String[] args) {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bfr = new BufferedReader(new FileReader(new File(br.readLine())));
            BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(br.readLine())));
        ) {
            int character = -1;
            while (bfr.ready()) {
                character = bfr.read();
                if (character == 46) {
                    character = 33;
                }
                bfw.write(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
