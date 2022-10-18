package level6.task1630;
/*1. Разберись, что делает программа.
2. В статическом блоке считай 2 имени файла firstFileName и secondFileName.
3. Внутри класса Solution создай нить public static ReadFileThread, которая реализует
интерфейс ReadFileInterface (Подумай, что больше подходит - Thread или Runnable).
3.1. Метод setFileName должен устанавливать имя файла, из которого будет читаться содержимое.
3.2. Метод getFileContent должен возвращать содержимое файла.
3.3. В методе run считай содержимое файла, закрой поток. Раздели пробелом строки файла.
4. Подумай, в каком месте нужно подождать окончания работы нити, чтобы обеспечить последовательный вывод файлов.
4.1. Для этого добавь вызов соответствующего метода.
    Ожидаемый вывод:
        [все тело первого файла]
        [все тело второго файла]
        (квадратные скобки выводить не нужно)
    Требования:
    •    Статический блок класса Solution должен считывать с консоли имена двух файлов и сохранять их в переменные firstFileName и secondFileName.
    •    Объяви в классе Solution public static класс ReadFileThread.
    •    Класс ReadFileThread должен реализовывать интерфейс ReadFileInterface.
    •    Класс ReadFileThread должен быть унаследован от подходящего класса.
    •    Метод run класса ReadFileThread должен считывать строки из файла, установленного методом setFileName. А метод getFileContent, этого же класса, должен возвращать вычитанный контент. Возвращаемое значение - это одна строка, состоящая из строк файла, разделенных пробелами.
    •    Метод systemOutPrintln должен вызывать метод join у созданного объекта f.
    •    Вывод программы должен состоять из 2х строк. Каждая строка - содержимое одного файла.
Начальный код
    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    public class Solution {
        public static String firstFileName;
        public static String secondFileName;
        //напишите тут ваш код
        public static void main(String[] args) throws InterruptedException {
            systemOutPrintln(firstFileName);
            systemOutPrintln(secondFileName);
        }
        public static void systemOutPrintln(String fileName) throws InterruptedException {
            ReadFileInterface f = new ReadFileThread();
            f.setFileName(fileName);
            f.start();
            System.out.println(f.getFileContent());
        }

        public interface ReadFileInterface {
            void setFileName(String fullFileName);
            String getFileContent();
            void join() throws InterruptedException;
            void start();
        }
        //напишите тут ваш код
    }
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        
        try ( BufferedReader br = new BufferedReader(
                                    new InputStreamReader( System.in,  "cp866"))
        ) {
            
            System.out.print("введите имя файла 1: ");
            firstFileName = br.readLine();
            System.out.print("введите имя файла 2: ");
            secondFileName = br.readLine();
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }
    //напишите тут ваш код

    public static void main( String[] args ) throws InterruptedException {
        systemOutPrintln( firstFileName );
        systemOutPrintln( secondFileName );
    }

    public static void systemOutPrintln( String fileName ) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName( fileName );
        f.start();
        // f.join();
        // System.out.println( f.getFileContent() );
    }

    public interface ReadFileInterface {

        void setFileName( String fullFileName );

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread
                                     implements ReadFileInterface {
        private String fileName = "";
        private String fileContent = "";

        @Override
        public void run() {
            String result = "";

            try ( BufferedReader fileRead = new BufferedReader(
                                     new FileReader( this.fileName,
                                                         StandardCharsets.UTF_8 ) )
            ){
                while (fileRead.ready()) {
                    result += fileRead.readLine() + " ";
                }
                this.fileContent = result;
                
            }catch (IOException e) {
                e.printStackTrace();
            }
// вывод содержимого перенес сюда из systemOutPrintln(), чтобы
// запустить две нити читать парралельно без join
            System.out.println( getFileContent() );     
        }

        @Override
        public void setFileName( String fullFileName) {
            this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }
    }
    //напишите тут ваш код
}