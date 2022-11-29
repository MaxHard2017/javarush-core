package level10.task2014;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* 
 * Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором 
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.
Требования:
•	Поле pattern должно быть отмечено модификатором 
•	Поле currentDate должно быть отмечено модификатором 
•	Поле temperature должно быть отмечено модификатором 
•	Поле string НЕ должно быть отмечено модификатором 
CODE
            public class Solution implements Serializable {
            public static void main(String[] args) {
                System.out.println(new Solution(4));    }
            private final String pattern = "dd MMMM yyyy, EEEE";
            private Date currentDate;
            private int temperature;
            String string;
            public Solution(int temperature) {
                this.currentDate = new Date();
                this.temperature = temperature;
                string = "Today is %s, and the current temperature is %s C";
                SimpleDateFormat format = new SimpleDateFormat(pattern);
                this.string = String.format(string, format.format(currentDate), temperature);    }
            @Override
            public String toString() {
                return this.string;    }}
*/
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {
    public static void main(String[] args) {
        Solution savedObject  = new Solution(-4);
        Solution loadedObject = null;
        System.out.println(savedObject);
        try (
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c://test//o.ser"));
            ObjectInputStream obs  = new ObjectInputStream(new FileInputStream("c://test//o.ser"));
        ){
            //Serialize
            oos.writeObject(savedObject);
            //Deserialization
            loadedObject = (Solution) obs.readObject();

        } catch (IOException |  ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(loadedObject);
        System.out.println(loadedObject.temperature);
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private Date currentDate;
    private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature; 

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}