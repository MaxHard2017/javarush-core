package level4.task1410;
/*Давай напишем программу, которая поможет нам определить, какое вино пить по какому случаю.
    Создать абстрактный класс Drink с реализованным методом public void taste(), который выводит в консоль "Вкусно".
    Создать класс Wine, наследуемый от Drink, с реализованным методом public String getHolidayName(), который возвращает строку "День Рождения".
    Создать класс SparklingWine, наследуемый от Wine, с реализованным методом public String getHolidayName(), который возвращает строку "Новый Год".
    Написать реализацию методов getDeliciousDrink, getWine, getSparklingWine.
    Все классы должны находиться в отдельных файлах.
        Требования:
            •  Абстрактный класс Drink должен быть создан в отдельном файле.
            •  В классе Drink должен быть реализован метод public void taste(), который выводит на экран строку - "Вкусно".
            •  Класс Wine должен быть создан в отдельном файле и быть потомком класса Drink.
            •  В классе Wine должен быть реализован метод public String getHolidayName(), который возвращает строку - "День Рождения".
            •  Класс SparklingWine должен быть создан в отдельном файле и быть потомком класса Wine.
            •  В классе SparklingWine должен быть реализован метод public String getHolidayName(), который возвращает строку - "Новый Год".
            •  В классе Solution должен быть реализован метод getDeliciousDrink(), который возвращает объект типа Wine.
            •  В классе Solution должен быть реализован метод getWine(), который возвращает объект типа Wine.
            •  В классе Solution должен быть реализован метод getSparklingWine(), который возвращает объект типа SparklingWine. 
            начальный текст
                public class Solution {
                    public static void main(String[] args) {
                        getDeliciousDrink().taste();
                        System.out.println(getWine().getHolidayName());
                        System.out.println(getSparklingWine().getHolidayName());
                        System.out.println(getWine().getHolidayName());
                    }
                    public static Drink getDeliciousDrink() { }
                    public static Wine getWine() { }
                    public static Wine getSparklingWine() { }
                }

            */

public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getSparklingWine().getHolidayName());
        System.out.println(getWine().getHolidayName());
    }

    public static Drink getDeliciousDrink() {
        Wine vino = new Wine();
        return vino;
    }

    public static Wine getWine() {
        Wine vino = new Wine();
        return vino;

    }

    public static Wine getSparklingWine() {
        Wine vino = new SparklingWine();
        return vino;
    }
}
