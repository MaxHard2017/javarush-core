package level4.task1419;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Заполни список exceptions десятью различными исключениями.
Первое исключение уже реализовано в методе initExceptions.
Требования:
    •    Список exceptions должен содержать 10 элементов.
    •    Все элементы списка exceptions должны быть исключениями (потомками класса Throwable).
    •    Все элементы списка exceptions должны быть уникальны.
    •    Метод initExceptions должен быть статическим.
Начальый текст
public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();
    public static void main(String[] args) {
        initExceptions();
        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }
    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        //напишите тут ваш код
    }
}
 */
public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        
        try {
            throw new IOException();
        } catch (IOException e) {
            exceptions.add(e);
        }

        try {
            throw new ClassCastException();
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }

        try {
            throw new NullPointerException ();
        } catch (NullPointerException  e) {
            exceptions.add(e);
        }

        try {
            throw new SecurityException  ();
        } catch (SecurityException e) {
            exceptions.add(e);
        }

        try {
            throw new NumberFormatException  ();
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalMonitorStateException ();
        } catch (IllegalMonitorStateException e) {
            exceptions.add(e);
        }
        try {
            throw new IndexOutOfBoundsException ();
        } catch ( IndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            throw new ClassNotFoundException ();
        } catch (ClassNotFoundException  e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}