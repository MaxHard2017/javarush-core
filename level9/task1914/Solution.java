package level9.task1914;
/*
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
Возможные операции: + - *
    Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.
    Пример вывода:
        3 + 6 = 9
Требования:
    •    Класс Solution должен содержать класс TestString.
    •    Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
    •    Класс TestString должен содержать публичный void метод printSomething().
    •    Метод printSomething() класса TestString должен выводить на экран строку "3 + 6 = ".
    •   Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c параметром конструктора ByteArrayOutputStream).
    •    Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
    •    Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
    •    Метод main(String[] args) класса Solution должен модифицировать строку выведенную методом printSomething() согласно заданию, и выводить её в консоль.
CODE
public class Solution {
    public static TestString testString = new TestString();
    public static void main(String[] args) {
    }
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        final PrintStream OLD_CONSOLE = System.out;
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream newPs = new PrintStream(outBytes);

        System.setOut(newPs);
        testString.printSomething();
        System.setOut(OLD_CONSOLE);

        String exspressionStr = outBytes.toString().replaceAll("\\r?\\n", "");  // удаляем переход на новую строку приходящий из println (75:)
        String[] digitsStr = exspressionStr.split("[\\s=]");
        // for (String string : digitsStr) {
        //     System.out.println(string);
        // }
        int operandA = Integer.parseInt(digitsStr[0]);
        int operandB = Integer.parseInt(digitsStr[2]);
        int result = 0;

        switch (digitsStr[1]) {
            case "+" :
                result = operandA + operandB;
                break;
            case "-" :
                result = operandA - operandB;
                break;
            case "*" :
                result = operandA * operandB;
                break;
        }
        System.out.printf("%s%d", exspressionStr, result );
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}
