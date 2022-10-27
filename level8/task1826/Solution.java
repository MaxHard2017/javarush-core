package level8.task1826;
/* 
 * Придумать механизм шифровки/дешифровки.
Программа запускается с одним из следующих наборов параметров:
    -e fileName fileOutputName
    -d fileName fileOutputName
    где:
        fileName - имя файла, который необходимо зашифровать/расшифровать.
        fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
        -e - ключ указывает, что необходимо зашифровать данные.
        -d - ключ указывает, что необходимо расшифровать данные.
Требования:
    •    Считывать с консоли ничего не нужно.
    •    Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
    •   Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
    •    В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
    •    В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
    •    Созданные для файлов потоки должны быть закрыты.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    
    public static void main(String[] args) {
    
        //  String[] inputArgs = {"-e","c://test//ttt.txt", "c://test//tttprocessed.txt"};        
        // String[] inputArgs = {"-d","c://test//tttprocessed.txt", "c://test//ttt2.txt"};        
        // args = inputArgs;
        // switch (args[0]) {
        //     case "-e" :
        //         crypto(args);
        //     break;

        //     case "-d" :
        //         crypto(args);
        //     break;

        //     default :
        //     break;
        // }
        crypto(args);
    }

    static void crypto(String[] args) {
        try (FileInputStream fis = new FileInputStream(args[1]);
            FileOutputStream fos = new FileOutputStream(args[2]);
        ){
            while(fis.available() > 0) {
                fos.write((fis.read()^103));
            }
        }catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
