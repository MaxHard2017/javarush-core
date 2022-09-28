package level4.task1408;

public class MoldovanHen extends Hen {
    public int getCountOfEggsPerMonth() {
        
        return 300;
    }

    @Override
    public String getDescription() { 
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA 
                                        + ". Я несу " 
                                        + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
