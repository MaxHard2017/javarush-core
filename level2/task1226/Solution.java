package level2.task1226;
/*
 * Вот что тебе нужно сделать в этой задаче:
    Внутри класса Solution создай интерфейс public interface CanFly (летать) с методом void fly().
    Внутри класса Solution создай интерфейс public interface CanClimb (лазить по деревьям) с методом void climb().
    Внутри класса Solution создай интерфейс public interface CanRun (бегать) с методом void run().
    Подумай логически, какие именно интерфейсы нужно добавить для каждого класса.
    Добавь интерфейсы классам Cat (кот), Dog (собака), Tiger (тигр), Duck (Утка).
        Требования:
            •    Класс Solution должен содержать интерфейс CanFly с методом void fly().
            •    Класс Solution должен содержать интерфейс CanClimb с методом void climb().
            •    Класс Solution должен содержать интерфейс CanRun с методом void run().
            •    Объект класса Cat должен уметь бегать (поддерживать интерфейс CanRun) и лазить по деревьям (поддерживать интерфейс CanClimb).
            •    Объект класса Dog должен уметь бегать (поддерживать интерфейс CanRun).
            •    Класс Tiger должен быть котом.
            •    Объект класса Duck должен уметь бегать (поддерживать интерфейс CanRun) и летать (поддерживать интерфейс CanFly).
 */
public class Solution {

    public static void main(String[] args) {

    }
    
    public interface CanFly {
        default void fly(){}
    }
    
    public interface CanClimb {
        default void climb(){}
    }
    
    public interface CanRun {
        default void run(){}
    }

    public class Cat implements CanClimb, CanRun {
    }

    public class Dog implements CanRun {
    }

    public class Tiger extends Cat {
    }

    public class Duck implements CanFly, CanRun {
    }
}
