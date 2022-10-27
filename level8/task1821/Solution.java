package level8.task1821;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/* 
 * Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).
    Пример:
        ','=44, 's'=115, 't'=116.

    Вывести на консоль отсортированный результат:
        [символ1] частота1
        [символ2] частота2
Закрыть потоки.
    Пример вывода:
        , 19
        - 7
        f 361
Требования:
    •    Считывать с консоли ничего не нужно.
    •    Создай поток для чтения из файла, который приходит первым параметром в main.
    •    В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
    •    Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
    •    Поток для чтения из файла должен быть закрыт.
 */
public class Solution {
    public static void main(String[] args) {
        /* 
        String[] s = {"c://test//t1.txt"};
        args = s;
 */
        int[] asciiCodes = new int[256];

        try (FileReader fr = new FileReader(args[0])
        ){
            int index;
            while(fr.ready()) {
                index = fr.read();
                if (index <= 265) {
                    asciiCodes[index]++;        // увеличиваем элемент массива asciiCodes с индексом соответствующим прочитанному коду
                }           
            }

            for (int i = 0; i < asciiCodes.length; i++) {
                if (asciiCodes[i] > 0) {
                    System.out.println( (char)i + " " + asciiCodes[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
