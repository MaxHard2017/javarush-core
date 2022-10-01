package level4.task1421;

public final class Singleton {
    private static final Singleton INSTANCE = new Singleton();
    private Singleton() {}
    public void act(){
        System.out.println("Работаю!");
    }

    public static Singleton getInstance() {
        
        return INSTANCE;
    }
}
