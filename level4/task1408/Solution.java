package level4.task1408;

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.MOLDOVA);
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            switch(country) {
                case Country.BELARUS :
                    hen = new BelarusianHen();
                break;
                case Country.UKRAINE :
                    hen = new UkrainianHen();
                break;
                case Country.MOLDOVA :
                    hen = new MoldovanHen();
                break;
                case Country.RUSSIA :
                    hen = new RussianHen();
                break;
                default :
                break;
            }
            //напишите тут ваш код
            return hen;
        }
    }
}
