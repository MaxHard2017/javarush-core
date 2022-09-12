package level2.task1204;

/*
 * Напиши метод, который определяет, объект какого класса ему передали, и выводит на экран одну из надписей: Кошка, Собака, Птица, Лампа.
Требования:
    •    Программа должна выводить текст на экран.
    •    Класс Cat менять нельзя.
    •    Класс Dog менять нельзя.
    •    Класс Bird менять нельзя.
    •    Класс Lamp менять нельзя.
    •    Метод printObjectType() должен выводить на экран одну из надписей, в зависимости от переданного объекта. Например "Лампа" для объектов типа Solution.Lamp.
 */
public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        //Напишите тут ваше решение
        if (o instanceof Dog) {
            System.out.println("Собака");
        }
        if (o instanceof Cat) {
            System.out.println("Кошка");
        }
        if (o instanceof Bird) {
            System.out.println("Птица");
        }
        if (o instanceof Lamp) {
            System.out.println("Лампа");
        }


    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}