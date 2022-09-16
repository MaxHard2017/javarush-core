package level2.task1220;
/*
 * Напиши public класс Human (человек) и public интерфейсы CanRun (бежать/ездить), CanSwim(плавать).
    Добавь в каждый интерфейс по oдному методу.
    Добавь эти интерфейсы классу Human, но не реализуй методы.
    Объяви класс Human абстрактным.
    Требования:
        Класс Solution должен содержать интерфейс CanRun с одним методом.
        Класс Solution должен содержать интерфейс CanSwim с одним методом.
        Класс Solution должен содержать класс Human.
        Класс Human должен реализовывать интерфейсы CanRun и CanSwim.
        Класс Human должен быть абстрактным.
        У класса Human не должно быть методов.
 */
public class Solution {
    public static void main(String[] args) {
        
    }
    interface CanRun {
        public void run();
    }
    interface CanSwim {
        public void swim();
    }

    public abstract class Human implements CanRun, CanSwim {
    }
}