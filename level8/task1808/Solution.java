package level8.task1808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.
Требования:
    •    Программа должна три раза считать имена файлов с консоли.
    •    Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
    •    Первую половину байт из первого файла нужно записать во второй файл.
    •    Вторую половину байт из первого файла нужно записать в третий файл.
    •    Потоки FileInputStream и FileOutputStream должны быть закрыты.
 */
public class Solution {
    
    public static void main(String[] args) {
        try ( 
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"cp866"));
            FileInputStream fis = new FileInputStream(br.readLine());
            FileOutputStream fos1 = new FileOutputStream(br.readLine());
            FileOutputStream fos2 = new FileOutputStream(br.readLine());
        ){
            int firstHalf = (fis.available() / 2) + (fis.available() % 2);
            byte[] buffer = new byte[firstHalf];
            // если в исходном файле нечетное кол-во байт, то большее кол- во (+1 байт) пойдет первую часть - файл file2
            fos1.write(buffer, 0, fis.read(buffer));
            fos2.write(buffer, 0, fis.read(buffer));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}