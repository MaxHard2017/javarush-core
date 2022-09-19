package level3.task1327;

import java.util.ArrayList;
import java.util.List;

/* 
Давай напишем программу по мотивам сказки "Репка":
    Реализуй интерфейс RepkaItem в классе Person.
    В классе Person реализуй метод pull(Person person), который выводит фразу типа '<name> за <person>'.
        Пример:
        Бабка за Дедку
        Дедка за Репку
        Исправь логическую ошибку цикла в методе tell класса RepkaStory.
        Выполни метод main и наслаждайся сказкой!
    Требования:
    •    Интерфейс RepkaItem должен быть реализован в классе Person.
    •    В классе Person должен быть реализован метод pull() c одним параметром типа Person.
    •    Метод pull в классе Person должен выводить на экран фразу типа '<name> за <person>'. Например: Бабка за Дедку.
    •    В результате выполнения метода main() на экран должен быть выведен краткий вариант сказки про Репку.
*/

public class Solution {
    public static void main(String[] args) {
        List<Person> plot = new ArrayList<Person>();
        plot.add(new Person("Репка", "Репку"));
        plot.add(new Person("Дедка", "Дедку"));
        plot.add(new Person("Бабка", "Бабку"));
        plot.add(new Person("Внучка", "Внучку"));
        RepkaStory.tell(plot);
    }

    public static class RepkaStory {
        public static void tell(List<Person> repkaStoryPlayers) {
            for (int i = repkaStoryPlayers.size() - 1; i > 0; i--) {
                repkaStoryPlayers.get(i).pull(repkaStoryPlayers.get(i - 1));
            }
        }
    }

    interface RepkaItem {
        void pull (Person next);
    }

    static class Person implements RepkaItem {
        public String name;
        public String whomToPull;
        Person(String name, String whomToPull) {
            this.name = name;
            this.whomToPull = whomToPull;
        }

        public void pull(Person nextPerson) { 
            System.out.println(this.name + " за " + nextPerson.whomToPull);
        }
         
    }
}