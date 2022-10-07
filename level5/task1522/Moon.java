package level5.task1522;

public class Moon implements Planet {
    private static Moon instance;
    private Moon() {}
    public static Planet getInstance() {
        if (instance == null) {
            instance = new Moon();
        }
        return instance;
    }
}