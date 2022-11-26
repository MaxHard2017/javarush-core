package level8.task1823;

/* 
 * Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.
Требования:
    •    Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
    •    Для каждого файла создай нить ReadThread и запусти ее.
    •    После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
    •    Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
    •    Поток для чтения из файла в каждой нити должен быть закрыт.
Начальный код:
        import java.io.BufferedReader;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.HashMap;
        import java.util.Map;

        public class Solution {
            public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

            public static void main(String[] args) {

            }

            public static class ReadThread extends Thread {
                public ReadThread(String fileName) {
                    //implement constructor body
                }
                // implement file reading here - реализуйте чтение из файла тут
            }
        }
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
        String fileName = "";
        while (true) {
            fileName = br.readLine();
            if (fileName.equals("exit")) {
                break;
            }
            new ReadThread( fileName ).start();
        } 
    }

    public static class ReadThread extends Thread {
        String fileName = "";

        public ReadThread( String fileName ) {
            //implement constructor body
            this.fileName = fileName;
        }
        @Override
        public void run() {

            try ( 
                FileInputStream fis = new FileInputStream(this.fileName);
            ){
                
                int[] bytesInFile = new int[256];       // массив инт соответствует возможгным байтам 0 - 256
                                                        // значение элемента - кол-во раз повторения этого байта в файле
                                                        // наприсмер: bytesInFile[1] = 3 - байт со значением инт 1 встречается 3 раза
                while (fis.available() > 0) {
                    bytesInFile[fis.read()]++;      // увеличиваем элемент, соответствующий прочитанному байту
                }
                int maxByte = -1;
                int maxBytecount = -1;
                for (int i = 0; i < bytesInFile.length; i++ ) {
                    if (bytesInFile[i] > maxBytecount) {
                        maxBytecount = bytesInFile[i];
                        maxByte = i;
                    }
                }
                System.out.println( fileName + " - " + maxByte );
                resultMap.put( fileName,bytesInFile[maxByte] );
                
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}