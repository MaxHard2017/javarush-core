package level2.task1217;
/*
 * Напиши public интерфейсы CanFly(летать), CanRun(бежать/ездить), CanSwim(плавать).
Добавить в каждый интерфейс по одному методу.
Требования:
    Класс Solution должен содержать интерфейс CanFly.
    Класс Solution должен содержать интерфейс CanRun.
    Класс Solution должен содержать интерфейс CanSwim.
    Интерфейс CanFly должен содержать один метод.
    Интерфейс CanRun должен содержать один метод.
    Интерфейс CanSwim должен содержать один метод.
 */
public class Solution {
    
    interface CanFly{
        void fly();
    }

    interface CanRun {
        void run();

    }

    interface CanSwim {
        void swim();
    }
}