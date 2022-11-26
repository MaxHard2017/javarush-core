package level8.task1822;

/* 
 * Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.
В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.
Информация по каждому товару хранится в отдельной строке.
    Пример содержимого файла:
    194 хлеб 12.6 25
    195 масло сливочное 52.2 12
    196 молоко 22.9 19
Пример вывода для id = 195:
    195 масло сливочное 52.2 12
Требования:
    •    Программа должна считать имя файла с консоли.
    •    Создай для файла поток для чтения.
    •   Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
    •    Поток для чтения из файла должен быть закрыт.
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "cp866"));
        String fileName = br.readLine();

        String inputId = args[0].trim();
        String line = "";
        String lineId = "";

        try (
                BufferedReader bfr = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
        ){  
            String foundLine = null;
            while (bfr.ready()) {
                line = bfr.readLine();
                lineId = line.substring(0, line.indexOf(" ", 0));        //  берем первое слово - начало строки до первого пробела
                if (lineId.equals(inputId)) {
                    foundLine = line;
                    break;
                }
            }
            if (foundLine == null) {
                foundLine = "ID " + inputId + " not found.";
            }
            System.out.println(foundLine);
        }
    }
}
