package level8.task1819;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.
Требования:
    •    Программа должна два раза считать имена файлов с консоли.
    •    Не используй в программе статические переменные.
    •    Для первого файла создай поток для чтения и считай его содержимое.
    •    Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
    •    Содержимое первого и второго файла нужно объединить в первом файле.
    •    Сначала должно идти содержимое второго файла, затем содержимое первого.
    •    Созданные для файлов потоки должны быть закрыты.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"cp866"));
        File fileInput1 = new File(br.readLine());
        File fileInput2 = new File(br.readLine());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try (
             FileInputStream fis1 = new FileInputStream(fileInput1);
             FileInputStream fis2 = new FileInputStream(fileInput2);
        ){
            while(fis2.available() > 0) {
                bos.write(fis2.read());
            }
            bos.write(System.lineSeparator().getBytes());
            while(fis1.available() > 0) {
                bos.write(fis1.read());
            }
        }catch (IOException e) {
                e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream(fileInput1);){
                bos.writeTo(fos);
                
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}