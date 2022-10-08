package level5.task1527;
/*
 *  Считать с консоли URL-ссылку.
    Вывести на экран список всех параметров через пробел (Параметры идут после ? и разделяются &, например, lvl=15).
    URL содержит минимум 1 параметр.
    Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
    Если присутствует параметр obj, то передать его значение в нужный метод alert():
        alert(double value) - для чисел (не забывай о том, что число может быть дробным);
        alert(String value) - для строк.
    Обрати внимание на то, что метод alert() необходимо вызывать после вывода списка всех параметров на экран.
        Пример 1
            Ввод:
                http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
            Вывод:
        l       vl view name
        Пример 2
            Ввод:
                http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
            Вывод:
                obj name
                double: 3.14
        Требования:
            •    Программа должна считывать с клавиатуры только одну строку.
            •    Класс Solution не должен содержать статические поля.
            •    Программа должна выводить данные на экран в соответствии с условием.
            •    Программа должна вызывать метод alert() с параметром double, если значение параметра obj можно корректно преобразовать в число типа double.
            •    Программа должна вызывать метод alert() с параметром String, если значение параметра obj нельзя корректно преобразовать в число типа double.
начальный код
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
    }
    public static void alert(double value) {
        System.out.println("double: " + value);
    }
    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();                               // Savig URL, for some future needs
        List<String> paramList = getParameterList( url );             // read URL string from console and get list of parameters
    /*
    for test
        System.out.println("URL: " + url);
        System.out.println();
        System.out.println("Parameters");
        printUrlParams(paramList);
    */

        for ( String item : paramList ) {
            System.out.print(paramName(item) + " ");
        }
        System.out.println();

        for ( String item : paramList ) {
            if ( paramName(item).equals("obj") ) {
                try {
                    Double doubleValue = Double.parseDouble( paramValue(item) );    // trying to parse parametrer as number - double
                    alert( doubleValue );                                           // alert as a double
                }catch ( NumberFormatException e ){                                 // if not number - alert as a string
                    alert( paramValue(item) );
                }
            }
        }    
    }

               
        //напишите тут ваш код


    /**
     * printUrlParams() - prints parameter string - expected in a key-value format,
     *  name and value of each key-value parameter
     * @param paramList - list of strings each as a key-value parametr
     */
    static void printUrlParams( List<String> paramList ) {
        for (String item : paramList) {
            System.out.println( "Parameter string: " + item );
            System.out.println( "Name: " + paramName(item) );
            System.out.println( "Value: " + paramValue(item) );
        }
    }

    /** getParameterList() - returns list of strings which are parameters from URL
     * "?" delimeter  determins the start of URL parameters
     * Each parameter started "&" delimeter is saved as a separete list item
     * @param urlString - URL string
     * @return returns List<String> of URL parameters
     */
    static List<String> getParameterList(String urlString) {
        List<String> strlList = new ArrayList<String>();
        String urlParamString = urlString.substring(urlString.indexOf("?") + 1);  // Get substring of parameters fron URL - delimeter '?'
        String urlParameters[] = urlParamString.split("&");                     // Split substring by '&' geting several key-value params
        strlList = Arrays.asList(urlParameters);
        return strlList;
    }

    /**
     * paramName() - rerturns name of parameter from 
     * key-vajue string "name=value"
     * @param paramLine - key-vajue string in "name=value" format
     * @return substring before first "=" as delimeter
     */
    static String paramName( String paramLine ) {
        int delimeterIndex = paramLine.indexOf( "=" );
        switch ( delimeterIndex ) {
            case -1 :
                return paramLine;
            case 0:
                return "";
        }
        return paramLine.substring( 0, paramLine.indexOf("=") ); //get substring from the start to the "=" char
    }

    /**
     paramValue() - rerturns value of parameter from 
     * key-vajue string "name=value"
     * @param paramLine - key-vajue string in "name=value" format
     * @return substring after first "=" as delimeter
     */
    static String paramValue( String paramLine ) {

        int delimeterIndex = paramLine.indexOf( "=" );
        if ( (delimeterIndex == -1)                                     // if there is no "delimeter" orit is the last one
                    || ((paramLine.length() - delimeterIndex) <= 1) )
        {
            return "";
        }
        return paramLine.substring( paramLine.indexOf("=") + 1 );     //get substring from the "delimeter" to the end
    }



    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}