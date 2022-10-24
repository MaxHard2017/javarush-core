package level8.task1814;

import java.io.FileInputStream;
import java.io.IOException;

import level1.task1101.Solution;

/* 
Измени класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt).
Например, first.txt или name.1.part3.txt.
Если передан не txt-файл, например, file.txt.exe, то конструктор должен выбрасывать исключение UnsupportedFileNameException.
Подумай, что еще нужно сделать, в случае выброшенного исключения.
Требования:
    •    Класс TxtInputStream должен наследоваться от класса FileInputStream.
    •    Если в конструктор передан txt-файл, TxtInputStream должен вести себя, как обычный FileInputStream.
    •    Если в конструктор передан не txt-файл, должно быть выброшено исключение UnsupportedFileNameException.
    •    В случае выброшенного исключения, так же должен быть вызван super.close().
*/

public class TxtInputStream extends FileInputStream {
    FileInputStream original;

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);

        // int dotIndex = fileName.lastIndexOf(".");
        // if ( fileName.length() - dotIndex > 3
        //     !(fileName.substring(dotIndex + 1, dotIndex + 4)).equals("txt") ) {
        //     super.close();
        //     throw new UnsupportedFileNameException();
        // } 
    }

    public static void main(String[] args) throws UnsupportedFileNameException{
        String fileName = "c:/test/.fdsasd.tt";
        int dotIndex = fileName.lastIndexOf(".");

        if ( ( fileName.length() - dotIndex < 4) 
                || !(fileName.substring(dotIndex + 1, dotIndex + 4)).equals("txt") ) {
            throw new UnsupportedFileNameException();
        } 

        System.out.println(fileName.substring(dotIndex + 1, dotIndex + 4));
        System.out.println(fileName.length() - dotIndex );
        System.out.println("txt".length());
    }
}

