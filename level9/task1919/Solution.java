package level9.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* 
 * В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.
Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.
    Пример входного файла:
        Петров 2
        Сидоров 6
        Иванов 1.35
        Петров 3.1
    Пример вывода:
        Иванов 1.35
        Петров 5.1
        Сидоров 6.0
        Требования:
    •    Программа НЕ должна считывать данные с консоли.
    •    Программа должна считывать содержимое файла (используй FileReader).
    •    Поток чтения из файла (FileReader) должен быть закрыт.
    •    Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени.
 */

import java.util.TreeMap;
import java.util.Map.Entry;

public class Solution {
    public static void main(String[] args) {
        TreeMap<String, Double> list = new TreeMap<String, Double>();
        try (
                BufferedReader bfr = new BufferedReader(new FileReader(args[0], StandardCharsets.UTF_8));
        ) {
            
            String[] nameValue = new String[2];
            String name;
            Double value;
            nameValue = bfr.readLine().split(" ");
            name  = nameValue[0];
            value = Double.parseDouble(nameValue[1]);
            list.put(name, value);
            
            while (bfr.ready()) {
                nameValue = bfr.readLine().split(" ");
                name = nameValue[0];
                value = Double.parseDouble(nameValue[1]);

                if (list.containsKey(name)) {
                    for (Entry<String, Double> entry : list.entrySet()) {
                        if (entry.getKey().equals(name)) {
                            value = value + entry.getValue();
                            entry.setValue(value);
                            break;
                        }
                    }
                } else {
                    list.put(name, value);
                }
            }
            
            for (Entry<String, Double> entry : list.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}