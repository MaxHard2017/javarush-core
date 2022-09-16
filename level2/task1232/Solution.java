package level2.task1232;
/*
 * Сделать класс Pegasus (пегас) на основе класса Horse (лошадь) и интерфейса CanFly (летать).
    Требования:
        •        Класс Solution должен содержать интерфейс CanFly с методом fly().
        •        Класс Solution должен содержать класс Horse с методом run().
        •        Класс Solution должен содержать класс Pegasus.
        •        Класс Pegasus должен наследоваться от класса Horse.
        •        Класс Pegasus должен реализовывать интерфейс CanFly.
 */
public class Solution {
    public static void main(String[] args) {
        // Pegasus horse = new Pegasus();
    }

    public static interface CanFly {
        public void fly();
    }

    public static class Horse {
        public void run() {

        }
    }

    public static class Pegasus extends Horse implements CanFly {
        public void fly(){}
    }
}
