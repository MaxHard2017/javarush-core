package level9.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
 * Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.
Требования:
    •    Программа должна считывать имя файла с консоли (используй BufferedReader).
    •    BufferedReader для считывания данных с консоли должен быть закрыт.
    •    Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
    •    Поток чтения из файла (FileReader) должен быть закрыт.
    •    Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
 */
public class Solution {
    
    public static void main(String[] args) {
        try ( 
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                FileReader fr = new FileReader(br.readLine());
                BufferedReader bfr = new BufferedReader(fr);
        ) {
            int wordCount = 0;
            String[] words;
            while (bfr.ready()) {
                words = bfr.readLine().split("[\\p{Punct}\\s]");
                for (String word : words) {
                    if (word.matches("world")) {
                        wordCount++;
                    }
                }
            }
            System.out.println(wordCount);

        }catch(IOException e){
            e.printStackTrace();
        } 
    }
}
