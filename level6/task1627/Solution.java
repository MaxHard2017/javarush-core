package level6.task1627;
/*
 * Три человека играют в игру. Каждый игрок(Gamer) характеризуется двумя параметрами: фамилией(name) и количеством действий в секунду (rating).
Нужно вывести в консоль ход игры и определить победителя и проигравших.
Итак...
1. Разберись, что делает программа.
1.1. List<String> steps хранит последовательность действий, которое каждый игрок выполняет от 0 до последнего.
1.2. isWinnerFound показывает, найден победитель или нет.
1.3. Метод sleep выбрасывает InterruptedException и принимает параметр типа long.
1.4. Игроки играют независимо друг от друга.
2. Реализуй логику метода run так, чтобы для каждого игрока:
2.1. Через равные интервалы времени (1000ms / rating) выводились в консоль действия, описанные в steps.
2.2. Любой текст должен начинаться с фамилии игрока (метод getName()), потом следовать двоеточие, а затем сам текст.
        Пример:
        Ivanov:Начало игры
2.3. Когда игрок выполнит все действия из steps, то он считается победителем. Выведи getName() + ":победитель!"
2.4. Когда найден победитель, то игра останавливается, и остальные игроки считаются побежденными. Выведи для них getName() + ":проиграл"
Требования:
    •    Метод run класса Gamer через равные интервалы времени (1000ms / rating) должен выводить в консоль фамилию игрока (метод getName()), потом двоеточие, а затем текст из OnlineGame.steps. Пример: Ivanov:Начало игры
    •    Когда все игровые шаги будут выполнены, а победитель еще не найден, метод run должен установить флаг OnlineGame.isWinnerFound в true (сообщить остальным, что он победитель).
    •    Если игрок стал победителем, его метод run должен вывести надпись getName() + ":победитель!". Например: Sidorov:победитель!
    •    Методы run всех игроков которые не стали победителями (были прерваны), должны вывести надписи getName() + ":проиграл". Например: Petrov:проиграл
    •    Метод run не должен кидать исключение при прерывании.

 */

import java.util.ArrayList;
import java.util.List;


public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add( "Начало игры" );
            steps.add( "Сбор ресурсов" );
            steps.add( "Рост экономики" );
            steps.add( "Убийство врагов" );
        }

        protected Gamer gamer1 = new Gamer( "Ivanov", 3 );
        protected Gamer gamer2 = new Gamer( "Petrov", 1 );
        protected Gamer gamer3 = new Gamer( "Sidorov", 5 );

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while ( !isWinnerFound ) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }

        /**
         * tryToWin() - синхронизированный статичесткй метод класса OnlineGame
         * захватывает изменение флага isWinnerFound чтобы тоько одна нить могла его изменить
         * 
         * @return - при удачной установке флага isWinnerFound возвращает true. Считается, что 
         * выигрыш успешно засчитан. При false выигрыш не должен засчитываться.
         */
        public static synchronized boolean tryToWin() {
            if ( !isWinnerFound ) {
                isWinnerFound = true;
                return true;
            } else return false;
        }

    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super( name );
            this.rating = rating;
        }

        @Override
        public void run() {
            Thread current = Thread.currentThread();
            while (!OnlineGame.isWinnerFound) {
                try {
                    for (String element : OnlineGame.steps) {
                        System.out.println( current.getName() + ":" + element );
                        Thread.sleep( 1000 / rating );
                    }
                    if (!OnlineGame.isWinnerFound) {
                        if ( OnlineGame.tryToWin() == true ) {
                            System.out.println( current.getName() + ":победитель!" );
                        }
                    }

                }catch (InterruptedException e) {
                    System.out.println( current.getName() + ":проиграл" );
                }
            }
            //Add your code here - добавь код тут
        }
    }
}