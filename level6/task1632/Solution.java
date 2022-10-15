package level6.task1632;

/*
 * 1. Создай 5 различных своих нитей (наследников класса Thread):
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить "Ура";
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
        Подсказка:
        Нить 4 можно проверить методом isAlive()
Требования:

    •    Статический блок класса Solution должен создавать и добавлять 5 нитей в список threads.
    •    Нити из списка threads не должны стартовать автоматически.
    •    Нить 1 из списка threads должна бесконечно выполняться.
    •    Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения InterruptedException.
    •    Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
    •    Нить 4 из списка threads должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться.
    •    Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        // threads.get(0).start();
        threads.add(new ThreadTwo());
        //threads.get(1).start();
        threads.add(new ThreadThree());
        // threads.get(2).start();
        threads.add(new ThreadFor());
        // threads.get(3).start();
        threads.add(new ThreadFive());
        // threads.get(4).start();
    }

    public static void main(String[] args) throws InterruptedException {
        
        for (Thread thread : threads) {
            if(!thread.isAlive()) {
                thread.start();
            }
        }
 
        try {
            Thread.sleep(1000);
            threads.get(4).join();
            
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ((ThreadFor) threads.get(3)).showWarning();
        Thread.sleep(5000);
        
        for (Thread thread : threads) {
            if(thread.isAlive()) {
                System.out.println("try to stop " + thread.getName());
                thread.interrupt();
                Thread.sleep(5000);
            }
        }

    }

    public static class ThreadOne extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                     sleep(100);
                }
            }catch (InterruptedException e) { } // бесконечный цикл
            System.out.println(Thread.currentThread().getName() + " is stopping...");
        }
    }

    public static class ThreadTwo extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                     sleep(100);
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is stopping...");
        }
    }

    public static class ThreadThree extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    sleep(1000);
                }
            }catch (InterruptedException e) { }
            System.out.println(Thread.currentThread().getName() + " is stopping...");

        }
    }

    public static class ThreadFor extends Thread 
                                    implements Message {
        private Thread threadFor;       // ссылка на поток 4
        public ThreadFor() {
            super();
            threadFor = this;
        }

        @Override
        public void run() {
            while (!threadFor.isInterrupted()) {
            }
            System.out.println(Thread.currentThread().getName() + " is stopping...");
        }
        

        public void showWarning() {
            if (threadFor.isAlive()) {
                System.out.println("Message to stop "  + threadFor.getName());
                threadFor.interrupt();
            }
        }
    }    

    public static class ThreadFive extends Thread {
        @Override
        public void run() {
            try (
                BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
            ) {
                String inputString = "";
                int summ = 0;
                while ( !(inputString = br.readLine()).equals("N") ) {
                    System.out.println(inputString); 
                    if ( !(inputString == "N") ) {
                        summ += Integer.parseInt(inputString);
                    } 
                }
                System.out.println(summ);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is stopping...");

        }
    }
}