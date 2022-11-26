package level9.task1920;

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
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.
    Пример входного файла:
        Петров 0.501
        Иванов 1.35
        Петров 0.85
    Пример вывода:
        Петров
Требования:
    •    Программа НЕ должна считывать данные с консоли.
    •    Программа должна считывать содержимое файла (используй FileReader).
    •    Поток чтения из файла (FileReader) должен быть закрыт.
    •    Программа должна выводить в консоль имена, у которых максимальная сумма.
 */
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Solution {
    public static void main(String[] args) {
        TreeMap<String, Double> list = new TreeMap<String, Double>();
        TreeSet<String> topList = new TreeSet<String>();
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

            Double maxValue = value;
            
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
                if (value > maxValue) {
                    maxValue = value;
                }
            }
            
            for (Entry<String,Double> entry : list.entrySet()) {
                if (entry.getValue().compareTo(maxValue) == 0) {
                    topList.add(entry.getKey());
                }
            }
            
            for (String entry : topList) {
                System.out.println(entry);
            }
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}