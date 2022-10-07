package level5.task1530;

public abstract class DrinkMaker {
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();
    
    public void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}