package level5.task1514;
/*
 * В статическом блоке инициализируй labels пятью различными парами ключ-значение.
Требования:
    •    В классе Solution должен быть только один метод — main().
    •    В классе Solution должно быть объявлено статическое поле labels типа Map.
    •    Поле labels должно быть заполнено 5 различными парами ключ-значение в статическом блоке.
    •    Метод main должен выводить содержимое labels на экран.
            начальный код
            import java.util.HashMap;
            import java.util.Map;

            public class Solution {
                public static Map<Double, String> labels = new HashMap<Double, String>();
                public static void main(String[] args) {
                    System.out.println(labels);
                }
            }
 */
import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    public static void main(String[] args) {
        System.out.println(labels);
    }
    
    static {
        labels.put(0.1, "A");
        labels.put(0.2, "B");
        labels.put(0.3, "S");
        labels.put(1.1, "C");
        labels.put(2.1, "D");
    }
}