package level10.task2022;

/* 
 * Сериализация/десериализация Solution не работает.
Исправь ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные - writeObject
3) сериализовать класс Solution - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
Требования:
    •    Поле stream должно быть объявлено с модификатором transient.
    •    В методе writeObject(ObjectOutputStream out) не должен быть вызван метод close у потока полученного в качестве параметра.
    •    В методе readObject(ObjectInputStream in) не должен быть вызван метод close у потока полученного в качестве параметра.
    •    В методе readObject(ObjectInputStream in) поле stream должно быть инициализировано новым объектом типа FileOutputStream с параметрами(fileName, true).
    •    В конструкторе класса Solution поле stream должно быть инициализировано новым объектом типа FileOutputStream с параметром(fileName).
 CODE
public class Solution implements Serializable, AutoCloseable {
    private FileOutputStream stream;
    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);    }
    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();    }
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.close();    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        in.close();    }
    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();    }
    public static void main(String[] args) {   }
}
*/

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream("c://test//t2.txt", true);
        // in.close();

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        Solution solution = new Solution("c://test//t1.txt");
        solution.writeObject("I am");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(solution);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        Solution solution1 = new Solution("c://test//t2.txt");
        ObjectInputStream in = new ObjectInputStream(bis);
        solution1 = (Solution) in.readObject();
    }
}