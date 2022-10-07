package level5.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считывать с консоли данные, пока не будет введено слово "exit".
Для каждого значения, кроме "exit", вызвать метод print(). Если значение:
    содержит точку '.', вызвать метод print() для Double;
    больше нуля, но меньше 128, вызвать метод print() для short;
    меньше либо равно нулю или больше либо равно 128, вызвать метод print() для Integer;
    иначе — вызвать метод print() для String.
        Требования:
            •    Программа должна считывать данные с клавиатуры.
            •    Программа должна прекращать считывать данные с клавиатуры после того, как введена строка "exit".
            •    Если введенная строка содержит точку("."), и ее можно корректно преобразовать в число типа Double - должен быть вызван метод print(Double value).
            •    Если введенная строка может быть корректно преобразована в число типа short и полученное число больше 0, но меньше 128 - должен быть вызван метод print(short value).
            •    Если введенная строка может быть корректно преобразована в число типа Integer и полученное число меньше или равно 0 или больше или равно 128 - должен быть вызван метод print(Integer value).
            •    Во всех остальных случаях должен быть вызван метод print(String value).
    начальный код    
        public class Solution {
            public static void main(String[] args) throws IOException {//напиште тут ваш код}

            public static void print(Double value) {
                System.out.println("Это тип Double, значение " + value);
            }
            public static void print(String value) {
                System.out.println("Это тип String, значение " + value);
            }
            public static void print(short value) {
                System.out.println("Это тип short, значение " + value);
            }
            public static void print(Integer value) {
                System.out.println("Это тип Integer, значение " + value);
            }
        }
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        
        String inpuString;
        try(
        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(System.in, "cp866"));
        ){
            while (!(inpuString = reader.readLine()).equals("exit")) {
                try{
                    short shortValue = Short.parseShort(inpuString);
                    if (shortValue > 0 && shortValue < 128) {
                        print(Short.parseShort(inpuString));
                    } else {
                        print(Integer.parseInt(inpuString));
                    }
                    continue; 
                }catch (NumberFormatException e) {
                }

                try{
                    print(Double.parseDouble(inpuString));
                    continue;
                }catch (NumberFormatException e) {
                }
                
                print(inpuString);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}