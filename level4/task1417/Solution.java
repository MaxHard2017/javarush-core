package level4.task1417;

/*
 * Расширь функциональность программы, которая позволит производить манипуляции с валютами.
    В существующем абстрактном классе Money создай приватное поле amount типа double.
    Создай публичный геттер для поля amount(public double getAmount()), чтобы к этому полю можно было получить доступ извне класса Money.
    В отдельных файлах создай классы Hryvnia, Ruble и USD, которые будут являться потомками класса Money.
    В классах Hryvnia, Ruble и USD реализуй метод getCurrencyName() который будет возвращать название соответствующей валюты (строку) в виде аббревиатуры (USD, UAH, RUB).
    В классах Hryvnia, Ruble и USD реализуй публичный (public) конструктор, который принимает один параметр и вызывает конструктор базового класса (super) с этим параметром.
    Заполни список allMoney объектами всех возможных в рамках условия задачи и функциональности программы валют.
        Требования:
            •  В классе Money должно содержаться приватное поле amount типа double.
            •  В классе Money должен быть реализован публичный конструктор с одним параметром типа double, который устанавливает значение переменной amount согласно переданному параметру.
            •  В классе Money должен быть реализован публичный метод getAmount(), который будет возвращать значение поля amount.
            •  Классы Hryvnia, Ruble и USD должны быть потомками класса Money и существовать в отдельных файлах.
            •  В классах Hryvnia, Ruble и USD должен быть реализован метод getCurrencyName().
            •  Метод getCurrencyName() должен возвращать название соответствующей валюты (строку) в виде аббревиатуры (USD, UAH, RUB).
            •  В классах Hryvnia, Ruble и USD должен быть реализован публичный конструктор с одним параметром типа double, который устанавливает значение поля amount класса Money путем вызова конструктора класса родителя c тем же параметром.
    Начальный код
        import java.util.ArrayList;
        import java.util.List;
        public class Solution {
            public static void main(String[] args) {
                Person ivan = new Person("Иван");
                for (Money money : ivan.getAllMoney()) {
                    System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
                }
            }
            static class Person {
                public String name;
                Person(String name) {
                    this.name = name;
                    this.allMoney = new ArrayList<Money>();
                    //напишите тут ваш код
                }
                private List<Money> allMoney;
                public List<Money> getAllMoney() {
                    return allMoney;
                }
            }
        }
    */

    import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;
        private List<Money> allMoney;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();

            allMoney.add(new Ruble(200));
            allMoney.add(new Hryvnia(100));
            allMoney.add(new USD(300));
        }

        public List<Money> getAllMoney() {
            return allMoney;
        }

    }
}