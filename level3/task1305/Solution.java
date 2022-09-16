package level3.task1305;
/*
 * Исправь 4 ошибки в программе, чтобы она компилировалась.
    Требования:
        •        У переменных, объявленных в интерфейсе, может быть только самый широкий уровень доступа (public).
        •        Унаследоваться (extends) можно только от класса: для реализации интерфейсов используется ключевое слово implements.
        •        Класс Hobby должен быть объявлен с модификатором доступа static.
        •        Для доступа к переменной HOBBY не нужно создавать объект Dream.
        •        Объявления интерфейсов не изменяй.
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(Dream.HOBBY.toString());
        System.out.println(new Hobby("hobby 2").toString());

    }

    interface Desire {
    }

    interface Dream {
        public static Hobby HOBBY = new Hobby("hobby 1");
    }

    static class Hobby  implements Dream, Desire {
        int index = 1;
        String name;
        
        public Hobby(String str) {
            this.name = str;
        }
    

        @Override
        public String toString() {
            index++;
            return "index: " + index + " name: " + name;
        }
    }

}
