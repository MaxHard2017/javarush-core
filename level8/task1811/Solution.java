package level8.task1811;
/* 
 * Разберись, что делает программа.
Аналогично классу DecoratorRunnableImpl создай класс DecoratorMyRunnableImpl.
Вывод в консоль должен быть таким:
DecoratorRunnableImpl body
DecoratorMyRunnableImpl body
RunnableImpl body
Требования:
    •    Создай класс DecoratorMyRunnableImpl, аналогичный DecoratorRunnableImpl.
    •    После запуска, каждый класс должен вывести в консоль "<свое имя класса> body", например "DecoratorRunnableImpl body".
    •    Классы RunnableImpl и DecoratorRunnableImpl изменять нельзя.
    •    Метод main изменять нельзя.
 */
public class Solution {

    public static void main(String[] args) {
        new Thread(new DecoratorRunnableImpl(new DecoratorMyRunnableImpl(new RunnableImpl()))).start();
    }

    public static class RunnableImpl implements Runnable {
        @Override
        public void run() {
            System.out.println("RunnableImpl body");
        }
    }

    public static class DecoratorRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorRunnableImpl(Runnable component) {
            this.component = component;
        }

        @Override
        public void run() {
            System.out.println("DecoratorRunnableImpl body");
            component.run();
        }
    }
    
    public static class DecoratorMyRunnableImpl implements Runnable {
        private Runnable component;

        public DecoratorMyRunnableImpl(Runnable component) {
            this.component = component;
        }

        @Override
        public void run() {
            System.out.println("DecoratorMyRunnableImpl body");
            component.run();
        }
    }
}
