package level9.task1910;

/* 
 * Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.
Результат вывести во второй файл.
Закрыть потоки.
Требования:
    •    Программа должна считывать имена файлов с консоли (используй BufferedReader).
    •    BufferedReader для считывания данных с консоли должен быть закрыт.
    •    Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
    •    Поток чтения из файла (BufferedReader) должен быть закрыт.
    •    Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации, включая символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
    •    Поток записи в файл (BufferedWriter) должен быть закрыт.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String fileIn = "";
        String FileOut = "";
        ArrayList<String> fileStrings = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        ) {
            fileIn  = br.readLine();
            FileOut = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                BufferedReader bfr = new BufferedReader(new FileReader( fileIn,StandardCharsets.UTF_8));
                BufferedWriter bfw = new BufferedWriter(new FileWriter(FileOut,StandardCharsets.UTF_8));
        ) {
            while (bfr.ready()) {
                fileStrings.add(bfr.readLine());
            }

            for (String string : fileStrings) {
                string = string.replaceAll("[\\p{P}\\n]", "");
                bfw.write(string);
            }
            
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}