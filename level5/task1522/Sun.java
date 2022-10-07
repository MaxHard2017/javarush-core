package level5.task1522;

public class Sun implements Planet {
    private static Sun instance;
    private Sun() {}
    public static Planet getInstance() {
        if (instance == null) {
            instance = new Sun();
        }
        return instance;
    }
}