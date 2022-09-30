package level4.task1414;
/*
 * 
 * началььный код
 *  import java.io.BufferedReader;
    import java.io.InputStreamReader;
    public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
            8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
            8.2 вывести на экран movie.getClass().getSimpleName()
    }
    static class MovieFactory {
        static Movie getMovie(String key) {
            Movie movie = null;
            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            //напишите тут ваш код, пункты 5,6
            return movie;
        }
    }
    static abstract class Movie {    }
    static class SoapOpera extends Movie {     }
    //Напишите тут ваши классы, пункт 3
}

 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String keyForMakeMovie = null;
        Movie movie = null;
        while (true)  {
            keyForMakeMovie = r.readLine();
            movie = MovieFactory.getMovie(keyForMakeMovie);
            if (movie == null) {
                break;
            }
            System.out.println(movie.getClass().getSimpleName());
        }

        //ввести с консоли несколько ключей (строк), пункт 7

        /*
            8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
            8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
            8.2 вывести на экран movie.getClass().getSimpleName()
                    */

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            //напишите тут ваш код, пункты 5,6
            }else if (key.equals("cartoon")) {
                movie = new Cartoon ();
            }
            else if (key.equals("thriller")) {
                movie = new Thriller ();
            } 

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }
    static class Cartoon extends Movie {
    }
    static class Thriller  extends Movie {
    }
}