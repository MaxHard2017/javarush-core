package level9.task1925;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* 
 * В метод main первым параметром приходит путь к файлу1, вторым - путь к файлу2.
Файл1 содержит слова, разделенные пробелом или переводом строки (в файле может быть несколько строк).
Все, что не относится к пробелу или переводу строки, разделителем не считать.
Записать в одну строку через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.
    Пример выходных данных в файл2:
        длинное,короткое,аббревиатура
Требования:
    •    Программа НЕ должна считывать данные с консоли.
    •    Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
    •    Поток чтения из файла (FileReader) должен быть закрыт.
    •   Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
    •    Поток записи в файл (FileWriter) должен быть закрыт.
 */

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (
            BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
            FileWriter fw = new FileWriter(args[1]);
        ){
            String[] lineWords;
            boolean first = true;
            while (bfr.ready()) {
                lineWords = bfr.readLine().split("\\s");
                
                for (int i = 0; i < lineWords.length; i++) {
                    if (lineWords[i].length() > 6) {
                        if (first) {                 // первый записывается без лидирующей запятой
                            fw.append(lineWords[i]);
                            first = false;  
                        } else {                    // не первые записываются с лидирующей запятой
                            fw.append(",");
                            fw.append(lineWords[i]);
                        }
                    }
                }
            }
            fw.flush();
        }
    }
}