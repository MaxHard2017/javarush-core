package level3.task1318;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;


public class Solution {
/*
альтернативный вариант без проерок ввода и работы файла    
    public static void main(String[] args) {
        try(
            BufferedReader br = new BufferedReader(     // оборачиваем в BufferedReader чтобы читать из файла построчно 
                                new FileReader(         // поток чтения из файла
                                new BufferedReader(     // оборачиваем в BufferedReader чтобы читать с консоли построчно 
                                new InputStreamReader(System.in,"cp866")).readLine(), StandardCharsets.UTF_8));
        // поток посимвольного чтения c указанием кодовой страницы cp866 для консоли и чарсета UTF8 для
        // правильного чтения русских букв из файла
        ) {
            while(br.ready()){
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
    static File getFile() throws IOException  {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in, "cp866"));
        String fileName ="";
        File file = null;

        System.out.print("Введите имя файла для отображения в консоли: ");
        do {
            try {
                fileName = consoleReader.readLine();
                file = new File(fileName);
                if (!file.exists()) {
                    System.out.println("Файл не существует. Повторите попытку или нажмите Ctrl+C.");
                } else if (!(Files.isReadable(file.toPath())) == true) {            
                            // file.canRead() не срабатывает на отсутствие разрешения на чтение из файла
                            // так что используем Files.isReadable()
                    System.out.println("Файл не читается. Повторите попытку или нажмите Ctrl+C.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                System.out.println("Неверное имя файла. Повторите попытку или нажмите Ctrl+C.");      
            }
            
        } while((!file.exists()) || !(Files.isReadable(file.toPath())));
        
        if (consoleReader != null) {
            consoleReader.close();          // закрываем ресурсы потока чтения с консoли
        }
        return file;
    }

    public static void main(String[] args) throws IOException {

        File file = getFile();
        BufferedReader fileReader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));       //Создаем filereader и указываем чарсет кодировку, так как по умолчанию она может быть другой
        System.out.print("\033[H\033[2J");              // очищаем консоль
        System.out.println("Cодержимое файла " + file.getName());
        int fileStringCount = 1;
        String fileString = "";
        while ((fileString = fileReader.readLine()) != null) {
            System.out.print("строка " + fileStringCount++ + ": ");
            System.out.println(fileString);        
        }
        
        fileReader.close();                                 // закрываем ресурсы потоков чтения из файла
    }
}