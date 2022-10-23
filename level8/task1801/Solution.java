package level8.task1801;
/* 
 * Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.
Требования:
    •    Программа должна считывать имя файла с консоли.
    •    Для чтения из файла используй поток FileInputStream.
    •    В консоль должен выводиться максимальный байт, считанный из файла.
    •    Поток чтения из файла должен быть закрыт.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main( String[] args ) {
        System.out.print( "Введите имя файла: " );
        try (
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
            FileInputStream fis = new FileInputStream( new File(br.readLine()) );
        ) {
            int max = 0;
            int readByte = 0;
            while( !((readByte = fis.read()) == -1) ) {
                if ( (readByte) > max ) {
                    max = readByte;
                };
            }
            System.out.println(max);

        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
