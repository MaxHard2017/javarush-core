package level4.task1408;

public class BelarusianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 400;
    }
    @Override
    public String getDescription() { 
        return super.getDescription() + " Моя страна - " + Country.BELARUS 
                                        + ". Я несу " 
                                        + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
