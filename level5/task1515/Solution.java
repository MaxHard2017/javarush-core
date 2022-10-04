package level5.task1515;

/*
    В статическом блоке считать с консоли А и В — две переменные с типом int.
    Обработать IOException в блоке catch.
    Закрыть поток ввода методом close().
Требования:
    •    Поле A должно быть публичным и статическим.
    •    Поле B должно быть публичным и статическим.
    •    Программа должна считывать данные с клавиатуры в статическом блоке.
    •    Программа должна инициализировать поля A и B в статическом блоке согласно введенным с клавиатуры значениям.
    •    Программа должна выводить в консоль минимальное из введенных с клавиатуры значений.
 * начальный код
        * import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        public class Solution {
        public static int A;
        public static int B;
    public static final int MIN = min(A, B);
        public static void main(String[] args) {
            System.out.println(MIN);
        }
        public static int min(int a, int b) {
            return a < b ? a : b;
        }
    }
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static int A;
    public static int B;

    static {
        BufferedReader br;
        try {
            br = new BufferedReader (new InputStreamReader(System.in, "cp866"));
            A = Integer.parseInt(br.readLine());
            B = Integer.parseInt(br.readLine());
        } catch (IOException e1) {
            System.out.println("Error: entered value us not integer!");
            e1.printStackTrace();
        }
    }

    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}