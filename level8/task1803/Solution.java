package level8.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
 *  Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
Требования:
    •    Программа должна считывать имя файла с консоли.
    •    Для чтения из файла используй поток FileInputStream.
    •    В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
    •    Данные в консоль должны выводится в одну строку.
    •    Поток чтения из файла должен быть закрыт.
 */
public class Solution {
    public static ArrayList<Integer> inputByteArray = new ArrayList<Integer>(); //массив (список) в который читаем входной файл побайтно
    public static ArrayList<Integer> maxByteInFIle = new ArrayList<Integer>(); // maxByteInFIle хранит значение байта с максимальным повторением в файле

    static {
        try (
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
            FileInputStream fis = new FileInputStream(br.readLine());
        ){
            while ( fis.available() > 0) {
                inputByteArray.add(fis.read());
            }
            Collections.sort(inputByteArray);   // сортируем список чтобы с ним было легче работать
            System.out.println(inputByteArray);

        }catch ( Exception e) {}

    }
    public static void main(String[] args) {

        if (inputByteArray.size() == 0) {
            System.out.println("");
            return;
        }

        if (inputByteArray.size() == 1) {
            System.out.println(inputByteArray.get(0));
            return;
        }
        
        // maxByteInFIle хранит значение байта с максимальным повторением в файле или нескольких байтов,
        // если их кол-во повторений равно максимальному
        maxByteInFIle.add(inputByteArray.get(0)) ; // будем считать что первый байт - искомый
                                                              // пока не найдем более подходящий вариант

        int  maxByteCount = 1; // счетчик максимальных повторений
        int  nextByteEqualsCount = 1; // чсетчик текущих повторений

        for (int i = 1; i < inputByteArray.size(); i++) {
        /* inputByteArray отсортирован по возрастанию, все одинаковые байты идут 
        друг за другом в порядке возрастания значений */
           
            if ( inputByteArray.get(i - 1).equals(inputByteArray.get(i)) ) {
                nextByteEqualsCount++; // считаем все одинаковые
            } 

            if (    ((i == inputByteArray.size() - 1) && (inputByteArray.get(i - 1).equals(inputByteArray.get(i))))
                || !(inputByteArray.get(i - 1).equals(inputByteArray.get(i)))) {
            /* условие проверки и сохранения нового возможного значения максимального 
            байта/байтов и колличества его повторений - достигнут конец последовательности или следующее значение
            не равно предыдущему (в этом случае надо проверить набор предыдущих одинаковых значений на максимальность) */

                if (nextByteEqualsCount == maxByteCount) {
                    maxByteInFIle.add(inputByteArray.get(i - 1));
                }
                if ( nextByteEqualsCount > maxByteCount ) {
                    maxByteInFIle.clear();
                    maxByteInFIle.add(inputByteArray.get(i - 1));
                    maxByteCount = nextByteEqualsCount;
                }
                nextByteEqualsCount = 1;
                /* сбрасываем счетчик при появлении неравного значения
                так как начался цикл по новому значению */
            } 
        }
          
        for (int i = 0; i < maxByteInFIle.size(); i++) {
            System.out.print(maxByteInFIle.get(i) + " ");
        }
    }
}
