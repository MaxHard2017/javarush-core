package level9.task1918;

/* 
 * Считай с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>
Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>
text1, text2 могут быть пустыми
Требования:
    •    Программа должна считывать имя файла с консоли (используй BufferedReader).
    •    BufferedReader для считывания данных с консоли должен быть закрыт.
    •    Программа должна считывать содержимое файла (используй FileReader).
    •    Поток чтения из файла (FileReader) должен быть закрыт.
    •    Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {



    public static void main(String[] args) throws IOException {

        
        String fileName = null;
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = consoleReader.readLine();
        } catch (IOException ignore) {
        }

        StringBuilder readFileContent = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                readFileContent.append(fileReader.readLine());
            }
        } catch (IOException ignore) {
        }

        String fileStr = readFileContent.toString().replaceAll("[\\r\\n]+", "");
        
        
        // String fileStr = Files.readString(Paths.get("c://test//d1.html"));

        Pattern tegPattern = Pattern.compile("(?m)(<\\/|<)(" + args[0] + "[^>\\/]*\\/?>[^<\\/\\n]*)");

        List<String> resultStr = new ArrayList<String>();
        Matcher match = tegPattern.matcher("");
        match.reset(fileStr);

        while (match.find()) {
            System.out.print(match.group(1) + match.group(2));
        }
    }
}