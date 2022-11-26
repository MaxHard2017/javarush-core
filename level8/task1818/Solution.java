package level8.task1818;
/* 
 * Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.
Требования:
    •    Программа должна три раза считать имена файлов с консоли.
    •    Для первого файла создай поток для записи. Для двух других - потоки для чтения.
    •    Содержимое второго файла нужно переписать в первый файл.
    •    Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
    •    Сoзданные для файлов потоки должны быть закрыты.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"cp866"));
        File fileInput1 = new File(br.readLine());
        File fileInput2 = new File(br.readLine());
        File fileOutput = new File(br.readLine());

        try (
             FileInputStream fis1 = new FileInputStream(fileInput1);
             FileInputStream fis2 = new FileInputStream(fileInput2);
             FileOutputStream fos = new FileOutputStream(fileOutput, false);
             FileOutputStream fosAppend = new FileOutputStream(fileOutput, true);
        ){
            while(fis1.available() > 0) {
                fos.write(fis1.read());
            }
            fos.write(System.lineSeparator().getBytes());
            while(fis2.available() > 0) {
                fosAppend.write(fis2.read());
            }
            
        }catch (IOException e) {
                e.printStackTrace();
        }
    }
}