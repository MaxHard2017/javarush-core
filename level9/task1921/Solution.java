package level9.task1921;


import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/* 
 * В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.
Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.
    Пример входного файла:
        Иванов Иван Иванович 31 12 1987
        Вася 15 5 2013
Требования:
    •    Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
    •    Программа НЕ должна считывать данные с консоли.
    •    Программа должна считывать содержимое файла (используй FileReader).
    •    Поток чтения из файла (FileReader) должен быть закрыт.
    •    Программа должна заполнить список PEOPLE данными из файла.
    •    Программа должна правильно работать с двойными именами, например Анна-Надежда.
 */

public class Solution {

    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        GregorianCalendar birth = new GregorianCalendar();
        try (Scanner fsc = new Scanner(new FileReader(args[0], StandardCharsets.UTF_8));
        ) {
            String inputName = "";
            int year = 0;
            int month = 0;
            int day = 0;
            
            while (fsc.hasNext()) {
                inputName = "";
                
                while (fsc.hasNext("[^\\p{javaDigit}]+?")) { // (?u)[А-я]+ \\D+? берем все что не цифра до пробела не жадным способом    
                    inputName = inputName + " " + fsc.next(); // склеиваем слова в полное имя
                }
                inputName.trim();       // удяляем лишние (лидирующий) пробелы

                day = fsc.nextInt();                // читаем даты
                month = fsc.nextInt();
                year = fsc.nextInt();
                
                birth.clear();
                birth.set(year, month - 1, day); // инициируем календарь чтобы не считать date 
                // счет месяцев в календаре от 0, не забывать!
                Person person = new Person(inputName, birth.getTime());     //получаем date из birth
                PEOPLE.add(person);
            }
        }
    }
}