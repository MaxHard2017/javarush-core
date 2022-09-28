package level4.task1408;

public class UkrainianHen extends Hen {
    public int getCountOfEggsPerMonth() {
        return 200;
    }

    @Override
    public String getDescription() { 
        return super.getDescription() + " Моя страна - " + Country.UKRAINE 
                                        + ". Я несу " 
                                        + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
