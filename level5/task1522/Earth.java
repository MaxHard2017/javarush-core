package level5.task1522;

public class Earth implements Planet {
    private static Earth instance;
    private Earth() {}
    public static Planet getInstance() {
        if (instance == null) {
            instance = new Earth();
        }
        return instance;
    }
}