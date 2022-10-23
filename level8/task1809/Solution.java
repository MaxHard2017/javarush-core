package level8.task1809;
/* 
 * Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.
Требования:
    •    Программа должна два раза считать имена файлов с консоли.
    •    Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
    •    Во второй файл нужно записать все байты из первого в обратном порядке.
    •    Потоки FileInputStream и FileOutputStream должны быть закрыты.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                FileInputStream fis = new FileInputStream(br.readLine());
                FileOutputStream fos = new FileOutputStream(br.readLine());
        ){
            byte[] inputFileByte = new byte[fis.available()];
            fis.read(inputFileByte);
            for (int i = inputFileByte.length - 1; i >= 0 ; i--) {
                fos.write(inputFileByte[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}