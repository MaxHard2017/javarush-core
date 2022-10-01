package level4.task1420;
/*
 * НОД
 * Давай найдем наибольший общий делитель (НОД). Для этого:
    Введи с клавиатуры 2 целых положительных числа.
    Выведи в консоли наибольший общий делитель.
Требования:
    •    Программа должна считывать с клавиатуры 2 строки.
    •    Программа должна выводить данные на экран.
    •    Программа должна выводить на экран наибольший общий делитель (НОД) чисел, считанных с клавиатуры, и успешно завершаться.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int a,b; // числа у которых надо найти НОД
        a = inputInteger();
        b = inputInteger();
        System.out.println("(" + a + "," + b + ") = " + gcd(a, b)); 

    }

    /**
     * gcd(int a, int b) - вычисляет НОД
     * @param a первое чило для вычисленгия НОД
     * @param b второе число лдя вычисления НОД
     * @return НОД для рекурсивного вычисления. Для a == 0 и b == 0 выдает -1 (ошибка).
     */
    public static int gcd(int a, int b) {
        if ( a == b ) {
            return a;
        }
        if ( a == 0 && b == 0 ) {
            return -1; // ошибка
        }
        if ((a == 0) && !(b == 0)) {
            return b;
        }
        if ((b == 0) && !(a == 0)) {
            return a;
        }
        if ((( a % 2) == 0) && ((b % 2) == 0)) {
            return 2 * (gcd(a / 2, b /2)); 
        }
        if ((( a % 2) == 0) && !((b % 2) == 0)) {
            return (gcd(a / 2, b)); 
        }
        if (!(( a % 2) == 0) && ((b % 2) == 0)) {
            return (gcd(a, b /2)); 
        }
        if (!(( a % 2) == 0) && !((b % 2) == 0) && (a > b)){
            return (gcd((a - b) / 2, b)); 
        } 
        if (!(( a % 2) == 0) && !((b % 2) == 0) && (a < b)) {
            return (gcd((b - a) / 2, a)); 
        }

        return -1;
    }

    public static int inputInteger () throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in, "cp866"));
        boolean isInteger = false; // опредяет введено целое цисло или нет
        int inputIntNumber = 0;    // переменная для ввода целого числа
        while (!isInteger) {
            try {
                inputIntNumber = Integer.parseInt(read.readLine());
                isInteger = true;
            } catch (NumberFormatException e) {
                System.out.println("Введено не целое число. Повтори ввод.");
            }
        }
        return inputIntNumber;
    }
}