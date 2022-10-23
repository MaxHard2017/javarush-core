package level8.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

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
        
        System.out.print(inputByteArray.get(0));
        int printed = inputByteArray.get(0);
        
        for (int i = 1; i < inputByteArray.size(); i++) {
            if ( !(inputByteArray.get(i) == printed) ) {
                System.out.print(" " + inputByteArray.get(i));
                printed = inputByteArray.get(i);
            }
            
        }
    }
}
