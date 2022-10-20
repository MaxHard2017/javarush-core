package level7.task1712;

import java.util.ArrayList;
import java.util.List;

/* 
Ресторан
*/

public class Restaurant {
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Waiter waiterTarget = new Waiter();
        Thread waiter = new Thread(waiterTarget);
        threads.add(waiter);

        Cook cookTarget = new Cook();
        Thread cook = new Thread(cookTarget);
        threads.add(cook);

        waiter.start();
        cook.start();

        Thread.sleep(2000);

        
        
        waiterTarget.continueWorking = false;
        Thread.sleep(500);
        cookTarget.continueWorking = false;

        System.out.println("Cook - STOP!");
        System.out.println("Weiter - STOP!");

    }
}