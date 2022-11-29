package level10.task2003;
/* 
 * В методе main() происходит считывание пути к файлу с консоли и заполнение runtimeStorage данными из файла.
Тебе необходимо в методе save() реализовать логику записи в файл для карты runtimeStorage, а в методе load() - логику чтения из файла для runtimeStorage.
Файл должен быть в формате .properties. Комментарии в файле игнорируй.
Про .properties прочитай в вики.
Подсказка: используй объект класса Properties.
Требования:
•	Метод save() должен сохранять карту runtimeStorage в параметр outputStream.
•	Метод load() должен восстанавливать состояние карты runtimeStorage из параметра inputStream.
 */
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        PrintWriter pr = new PrintWriter(outputStream);
        Properties properties = new Properties();
        properties.putAll(runtimeStorage);
        properties.list(pr);
    }

    public static void load(InputStream inputStream) throws IOException {
        InputStreamReader isr = new InputStreamReader(inputStream);
        Properties properties = new Properties();
        properties.load(isr);
        String[] valueStr;
        for (Entry entry : properties.entrySet()) {
            valueStr = ((String) entry.getValue()).split("( *#| *!)", 0);
            runtimeStorage.put((String) entry.getKey(), valueStr[0] );
        }

        //напишите тут ваш код
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
