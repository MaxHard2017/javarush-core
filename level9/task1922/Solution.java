package level9.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
 * Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.
    Пример:
        words содержит слова А, Б, В (количество слов в списке words может быть любым).
    Строки:
        В Б А Д //3 слова из words, не подходит
        А Б А Д //3 слова из words, не подходит
        Д А Д //1 слово из words, не подходит
        Д А Б Д //2 слова - подходит, выводим
        Д А А Д //2 слова - подходит, выводим
Требования:
    •    Класс Solution должен содержать публичное статическое поле words типа List<String>, которое должно быть сразу проинициализировано.
    •    Класс Solution должен содержать статический блок, в котором добавляются три или больше слов в список words.
    •    Пограмма должна считывать имя файла с консоли (используй BufferedReader).
    •    BufferedReader для считывания данных с консоли должен быть закрыт.
    •    Программа должна считывать содержимое файла (используй FileReader).
    •    Поток чтения из файла (FileReader) должен быть закрыт.
    •    Программа должна выводить в консоль все строки из файла, которые содержат всего 2 слова из списка words.
CODE
    public class Solution {
    public static List<String> words = new ArrayList<String>();
    static {
        words.add("файл");
        words.add("вид");
        words.add("В");    }
    public static void main(String[] args) {    }
}

 */
public class Solution {
    public static List<String> words = new ArrayList<String>(); // массив искомых слов

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        List<String> fileContent = new ArrayList<String>();                                                             
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader bfr = new BufferedReader(new FileReader(br.readLine(), StandardCharsets.UTF_8));
        ) {
            while (bfr.ready()) {
                fileContent.add(bfr.readLine());   // читаем содержимое файла в массив строк
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int countMatched = 0;                       // счетчик совпавших слов из строки и списка искомых
        String[] inputWords;                        // массив слов выбранной строки из входного файла
        
        for (String fileLine : fileContent) {       // для каждой входной строки 
            int[] wordsCount = new int[words.size()];
            countMatched = 0;
            inputWords = fileLine.split(" "); // разбиваем входную стоку на слова

            for (String inputWord : inputWords) {   // для каждого слова входной строки
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).equals(inputWord)) { // ищем совпадение с каким-либо словом в искомом массиве слов words
                        wordsCount[i]++;            //инкремемнтируем соответствующий элемент массива счетчиков 
                    }
                }
            }

            for (int count : wordsCount) {          // считаем когличество совпавших слов в строке
                if (count > 0) {
                    countMatched++;
                }
            }

            if (countMatched == 2) {                // выводим строку если совпало 2
                System.out.println(fileLine);
            }
        }
    }
}