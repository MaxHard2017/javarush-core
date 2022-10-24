package level8.task1813;

/*
1 Измени класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используй наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 Вызвать метод flush().
2.2 Записать в конец файла фразу "JavaRush © All rights reserved.", используй метод getBytes().
2.3 Закрыть поток методом close().
    Требования:
        •    Метод main изменять нельзя.
        •    Класс AmigoOutputStream должен наследоваться от класса FileOutputStream.
        •    Класс AmigoOutputStream должен принимать в конструкторе объект типа FileOutputStream.
        •    Все методы write(), flush(), close() в классе AmigoOutputStream должны делегировать свое выполнение объекту FileOutputStream.
        •    Метод close() должен сначала вызвать метод flush(), затем записать в конец файла текст, затем закрыть поток.
Начальный код
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class AmigoOutputStream {
    public static String fileName = "C:/tmp/result.txt";

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
}
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {

    public static String fileName = "C:/temp/result.txt";
    private FileOutputStream originalFos;

    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
        super(fileName, true);
        this.originalFos = fos;
    }    

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }


    @Override 
    public void flush() throws IOException {
        originalFos.flush();
    }

    @Override
    public void write(byte[] b) throws IOException {
        originalFos.write(b);
    }
    
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        originalFos.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        originalFos.write(b);
    }

    @Override 
    public void close() throws IOException {
        byte[] byteStribg = "JavaRush © All rights reserved.".getBytes();
        flush();

        write(byteStribg);
        originalFos.close();
    }
}