package level9.task1923;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/* 
 * В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1, abc3d или 564.
Закрыть потоки.
Требования:
    •    Программа НЕ должна считывать данные с консоли.
    •    Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
    •    Поток чтения из файла (FileReader) должен быть закрыт.
    •    Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
    •    Поток записи в файл (FileWriter) должен быть закрыт.
 */
public class Solution {
    public static void main(String[] args) {
    
        try (
                Scanner fsc = new Scanner(new File(args[0]), StandardCharsets.UTF_8);
                FileWriter fw = new FileWriter(args[1]);
        ) {
            StringBuffer dword = new StringBuffer();
            while (fsc.hasNext()) {
                if (fsc.hasNext("[^ ]*\\d[^ ]*")) {
                    dword.append(fsc.next());
                    dword.append(" ");
                } else {
                    fsc.next();
                }
            }
            fw.write(dword.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}