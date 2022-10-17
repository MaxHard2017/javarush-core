package level6.task1623;
/*
 * 1. Измени класс GenerateThread так, чтобы он стал нитью.
2. Создай конструктор GenerateThread, который должен:
2.1. Вызвать конструктор суперкласса с параметром String - номером созданной нити. Используй createdThreadCount.
2.2. Запустить текущую нить.
2.3. Номер первой нити должен начинается с 1.
3. Переопредели метод toString, для этого внутри GenerateThread нажми Alt+Insert -> Override Methods. Начни печатать toString.
3.1. Метод toString должен возвращать № текущей нити и слово " created". Используй getName().
        Пример:
        8 created
4. Пока количество созданных нитей меньше Solution.count метод run должен:
4.1. Создать новую нить типа GenerateThread.
4.2. Вывести в консоль созданную в пункте 4.1 нить.
5. В итоге должно быть выведено в консоль 15 строк.
Требования:
    •    Класс GenerateThread должен быть унаследован от Thread.
    •    В классе GenerateThread должен быть открытый конструктор без параметров.
    •    Конструктор класса GenerateThread должен увеличивать значение createdThreadCount и передавать его в виде строки в конструктор суперкласса.
    •    Конструктор класса GenerateThread должен запускать нить.
    •    Метод toString класса GenerateThread должен возвращать имя нити и слово " created". Пример: "8 created".
    •    Если количество созданных нитей меньше Solution.count, метод run должен создать новую нить типа GenerateThread.
    •    Если количество созданных нитей меньше Solution.count, метод run должен вывести созданную нить в консоль.
    •    Вывод программы должен соответствовать заданию, показывать, что все 15 нитей были созданы.
Начальный код:
public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;
    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }
    public static class GenerateThread {    }
}
 */


public class Solution {
    static final int COUNT = 15;
    static volatile int createdThreadCount = 0;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {
        public GenerateThread () {
                super(String.valueOf(getNextCreatedThreadCount()));
                this.start();
        }
        public GenerateThread (String name) {
            super(name);
            this.start();
        }
        // каждая нить создает новую нить если акунтер не превышен
        // затем нить  потухает и продлжает новая
        @Override
        public void run() {     
                                
            /* Это лучший на мой взгляд вариант чрез альтернативный конструктор 
             * принимающий String
             *            
             * int availableNumber = getNextCreatedThreadCount();
             * if (availableNumber < Solution.COUNT){
             *     System.out.println(new GenerateThread(String.valueOf(availableNumber)));
             * }  
            */           
            if (Solution.createdThreadCount < Solution.COUNT) {
                System.out.println(new GenerateThread());
            }
        }
    
        @Override
        public String toString() {
            return  this.getName() + " created";
        }
    }
    // другой алгоримт: каждая нить крутится и создает другие нити пока не первышен каунтер
    // создание вынесено в статический синхронизованный метод чтобы несколько нитей не создали болше 
    // чем надо. На  самом деле это тоже не айс и лучше делать через проверку и передачу в конструктор 
    // доступного номера нити. (см. альтернативно в методе run),но конструктор
    // было запрещено менять по условию((:
    //
    // public static synchronized boolean canMakeThread() {
    //     if ((Solution.createdThreadCount < Solution.count)) {
    //         System.out.println(new GenerateThread());
    //         return true;
    //     }else {
    //         return false;
    //     }
    // }

    public static synchronized int getNextCreatedThreadCount () {
        return ++createdThreadCount;
    }
}