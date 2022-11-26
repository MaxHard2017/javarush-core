package level8.task1816;

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
            int countLanit = 0;
            int inputChar;
            while (fr.ready()) {
                inputChar = fr.read();
                if  ( (( inputChar >= 65 ) && ( inputChar <= 90 ))
                    ||(( inputChar >= 97 ) && ( inputChar <= 122 )) ){
                
                    countLanit++;
                }
            }
            System.out.println(countLanit);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}