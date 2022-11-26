package level8.task1817;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* 
 * В метод main первым параметром приходит путь к файлу.
Посчитать количество символов в файле, которые соответствуют буквам английского алфавита.
Вывести на экран число (количество символов).
Закрыть потоки.
Требования:
    •    Считывать с консоли ничего не нужно.
    •    Создай поток чтения из файла, который приходит первым параметром в main.
    •    В файле необходимо посчитать количество символов, которые соответствуют буквам английского алфавита, и вывести это число в консоль.
    •    Нужно учитывать заглавные и строчные буквы.
    •    Поток чтения из файла должен быть закрыт.
 */
public class Solution {
    public static void main(String[] args) {
        File file = new File(args[0]);
        try (FileReader fr = new FileReader(file)
        ){
            int countSpace = 0;
            int countAll = 0;
            int inputChar;

            while (fr.ready()) {
                inputChar = fr.read();
                countAll++;
                if ( inputChar == 32 ){
                    countSpace++;
                }
            }
            System.out.printf("%.2f", ((countSpace * 1.0) / countAll) * 100);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}