package level7.task1721;
/* 
 * Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
Требования:
    •    Класс Solution должен содержать public static поле allLines типа List<String>.
    •    Класс Solution должен содержать public static поле forRemoveLines типа List<String>.
    •    Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
    •    Программа должна считывать c консоли имена двух файлов.
    •    Программа должна считывать построчно данные из первого файла в список allLines.
    •    Программа должна считывать построчно данные из второго файла в список forRemoveLines.
    •    Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
    •    Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
    •    Метод joinData должен вызываться в main.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    static {
        try ( BufferedReader consoleReader = new BufferedReader( 
                                             new InputStreamReader(System.in, "cp866"));
        ){
            System.out.print("Введите имя файла из которого удалить строки: ");
            Path path = Paths.get(consoleReader.readLine());
            allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            System.out.print("Введите второго файла содержащего строки к удалению в первом: ");
            path = Paths.get(consoleReader.readLine());
            forRemoveLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("Задано неправильное имя файла!");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println("Начальное наполнение списков.");
        System.out.println("allLines: ");
        for (String string : allLines) {
            System.out.println(string);            
        }
        System.out.println("forRemoveLines: ");
        for (String string : forRemoveLines) {
            System.out.println(string);            
        }

        try {
            new Solution().joinData();
        }catch (CorruptedDataException e) {
            System.out.println("Данные испорчены. Список allLines очищен.");
        }

        System.out.println("Наполнение списков после удаления.");
        System.out.println("allLines: ");
        for (String string : allLines) {
            System.out.println(string);            
        }
        System.out.println("forRemoveLines: ");
        for (String string : forRemoveLines) {
            System.out.println(string);            
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
