package level9.task1904;

import java.io.File;
import java.io.FileNotFoundException;

/* 
 * Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с одним аргументом типа Scanner.
    Данные в файле хранятся в следующем виде:
    Иванов Иван Иванович 31 12 1950
    Петров Петр Петрович 31 12 1957
В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные только одного человека.
Требования:
    •    PersonScanner должен быть интерфейсом.
    •    Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
    •    Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
    •    Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
    •    Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
    •    Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её, и возвращать данные только одного человека, в виде объекта класса Person.
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
   
        // Проверка:
        // Scanner sc = new Scanner(new File("c://test//person.txt"), StandardCharsets.UTF_8);
        // файл person.txt: "Иванов Иван Иванович 31 12 1950"
        // PersonScannerAdapter ps = new PersonScannerAdapter(sc);
        // System.out.println(ps.read().toString());
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner filScanner) {
            this.fileScanner = filScanner;
        }

        @Override
        public Person read() throws IOException {
            //Сканером последовательно читаем поля стринги и инты

            String lastName = fileScanner.next();
            String name = fileScanner.next();
            String midName = fileScanner.next();
            int day = fileScanner.nextInt();
            int month = fileScanner.nextInt() - 1; // В календаре месяцы считаюьтся от нуля!
            int year = fileScanner.nextInt();

            Calendar calendarBirth = new GregorianCalendar(year, month, day); // Создаем календарь
            Date dateBirth = calendarBirth.getTime();                         // через календарь .getTime расчитывается значение Date

            return new Person(name, midName, lastName, dateBirth);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}