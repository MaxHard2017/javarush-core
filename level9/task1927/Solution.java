package level9.task1927;

import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/* 
 * В методе main подмени объект System.out написанной тобой ридер-оберткой.
Твоя ридер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
    Рекламный текст: "JavaRush - курсы Java онлайн"
        Пример вывода:
            first
            second
            JavaRush - курсы Java онлайн
            third
            fourth
            JavaRush - курсы Java онлайн
            fifth
Требования:

    •    Класс Solution должен содержать класс TestString.
    •    Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
    •    Класс TestString должен содержать публичный void метод printSomething().
    •    Метод printSomething() класса TestString должен выводить на экран строки: "first","second","third","fourth","fifth".
    •    Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c конструктором принимающим ByteArrayOutputStream).
    •    Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
    •    Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
    •    Метод main(String[] args) класса Solution должен модифицировать строки(вставлять контекстную рекламу) выведенные методом printSomething() согласно заданию, и выводить её в консоль.
 CODE
 public class Solution {
    public static TestString testString = new TestString();
    public static void main(String[] args) {    }
    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
*/
public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        System.setOut(new outWrapper(System.out));
        new TestString().printSomething();
        System.setOut(console);
    }

    public static class outWrapper extends PrintStream {
        static int printCounts = 0;

        public outWrapper(OutputStream out) {
            super(out);
        }

        @Override
        public void println(String x ) {
            super.println(x);
            printCounts++;
            if (printCounts % 2 == 0) {
                
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("Второй");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}