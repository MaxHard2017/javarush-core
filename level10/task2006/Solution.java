package level10.task2006;
/* 
 * Сделай так, чтобы сериализация класса Human была возможной.
Требования:
•	Класс Human должен существовать внутри класса Solution.
•	Класс Human должен быть статическим.
•	Класс Human должен быть публичным.
•	Класс Human должен поддерживать интерфейс Serializable.
CODE

public class Solution {
    public static class Human {
        public String name;
        public List<String> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, String... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }

    public static void main(String[] args) {

    }
}

 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Как сериализовать?
*/

public class Solution {
    public static class Human implements Serializable {
        public String name;
        public List<String> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, String... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }
    }

    public static void main(String[] args) {
        // TBD
    }
}