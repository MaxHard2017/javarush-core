package level2.task1215;
/*
 * Унаследуй классы Cat и Dog от Pet.
    Реализуй недостающие методы. Классы Cat и Dog не должны быть абстрактными.
    Требования:
        Класс Pet должен быть абстрактным.
        Класс Dog не должен быть абстрактным.
        Класс Cat не должен быть абстрактным.
        Класс Dog должен наследоваться от класса Pet и реализовывать его абстрактные методы.
        Класс Cat должен наследоваться от класса Pet и реализовывать его абстрактные методы.
 */
public class Solution {
    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet {
        public String getName(){return "";}
        public Pet getChild() {return null;}
    }

    public static class Dog extends Pet{
        public String getName(){return "";}
        public Pet getChild() {return null;}
    }
}