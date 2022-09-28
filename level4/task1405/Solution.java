package level4.task1405;
/*
 *  Реализовать интерфейс Selectable в классе Food.
    Метод onSelect() должен выводить на экран фразу "The food was selected".
    Подумай, какие методы можно вызвать для переменной food, а какие для — selectable.
    В методе callFoodMethods вызови методы onSelect, onEat, если это возможно.
    В методе callSelectableMethods вызови методы onSelect, onEat, если это возможно.
    Не используй явное приведение типов.
        Требования:
            •   Интерфейс Selectable должен быть реализован в классе Food.
            •   Метод onSelect() в классе Food должен выводить на экран фразу "The food was selected".
            •   В методе callFoodMethods должны вызываться методы объекта типа Food.
            •   В методе callSelectableMethods должны вызываться методы доступные у любого объекта реализующего интерфейс Selectable.
 */
public class Solution {
    public static void main(String[] args) {
        Food food = new Food();
        Selectable selectable = new Food();

        callFoodMethods(food);
        callSelectableMethods(selectable);
    }

    public static void callFoodMethods(Food food) {
        food.onSelect();
        food.onEat();
        //тут добавьте вызов методов для переменной food
    }

    public static void callSelectableMethods(Selectable selectable) {
        if (selectable instanceof Food) {
           selectable.onSelect();
        }

        selectable.onSelect();
        //тут добавьте вызов методов для переменной selectable
    }

    interface Selectable {
        void onSelect();
    }

    static class Food implements Selectable {
        public void onEat() {
            System.out.println("The food was eaten");
        }
        public void onSelect() {
            System.out.println("The food was selected");
        }
    }
}

