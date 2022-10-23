package level8.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.
    Подсказка:
        нужно сравнивать с ascii-кодом символа ','.
Требования:
    •    Программа должна считывать имя файла с консоли.
    •    Для чтения из файла используй поток FileInputStream.
    •    В консоль должно выводится число запятых в считанном файле.
    •    Поток чтения из файла должен быть закрыт.
 */
public class Solution {
    public static byte[] inputBytes;
    public static void main(String[] args) {
        
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "cp866"));
                FileInputStream fis = new FileInputStream(br.readLine());
        ) {
            inputBytes = new byte[fis.available()];  // make int array size = number bytes in file
            ;
            if (fis.available() == fis.read(inputBytes)) {
                System.out.println("Прочитаны все байты.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        int countCommas = 0;
        for (byte item : inputBytes) {
            if (item ==  44) {
                countCommas++;
            }
        }
        System.out.println(countCommas);

    }
}
