package level9.task1902;

import java.io.FileOutputStream;
import java.io.IOException;

/* 
 * Используй класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter.
Требования:
    •    AmigoStringWriter должен быть интерфейсом.
    •    Класс AdapterFileOutputStream должен реализовывать интерфейс AmigoStringWriter.
    •    Класс AdapterFileOutputStream должен содержать приватное поле fileOutputStream типа FileOutputStream.
    •    Класс AdapterFileOutputStream должен содержать конструктор с параметром FileOutputStream.
    •    Метод flush() класса AdapterFileOutputStream должен делегировать полномочие соответствующему методу fileOutputStream.
    •    Метод writeString(String s) класса AdapterFileOutputStream должен делегировать полномочие соответствующему методу write() объекта fileOutputStream.
    •    Метод close() класса AdapterFileOutputStream должен делегировать полномочие соответствующему методу fileOutputStream.
 */
public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    public void writeString(String s) throws IOException {
        fileOutputStream.write(s.getBytes());
    }
       
    public void close() throws IOException {
        fileOutputStream.close();
    }


    public static void main(String[] args) {
    }

}

interface AmigoStringWriter {

    public void flush() throws IOException;

    public void writeString(String s) throws IOException;

    public void close() throws IOException;

}