package level7.task1712;

public class Cook implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        boolean needToWait;
        while (continueWorking || needToCookOrders()) {
            try {
                synchronized (this) {
                    needToWait = !needToCookOrders();
                    if (!needToWait) {
                        cook();
                    }
                }
                if (continueWorking && needToWait) {
                    System.out.println("Повар отдыхает");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Cook stoppinhg - Dishes queue: " + Manager.getInstance().getDishesQueue().isEmpty());
        System.out.println("Cook stoppinhg - Order queue: " + Manager.getInstance().getOrderQueue().isEmpty());
    }

    private boolean needToCookOrders() {
        return !Manager.getInstance().getOrderQueue().isEmpty();
    }

    private void cook() throws InterruptedException {
        Manager manager = Manager.getInstance();
        Order order = manager.getOrderQueue().poll();      // повар берет заказ из очереди
        System.out.println(String.format("Заказ будет готовиться %d мс для стола №%d", order.getTime(), order.getTableNumber()));
        Thread.sleep(order.getTime());     // готовим блюдо
        Dishes dishes = new Dishes(order.getTableNumber());       //  это готовое блюдо
        manager.getDishesQueue().add(dishes); // этой строки небыло - отправляем готовое(готовый заказ) блюдо в очередь готовых заказов
        System.out.println(String.format("Заказ для стола №%d готов", dishes.getTableNumber()));

    }
}
