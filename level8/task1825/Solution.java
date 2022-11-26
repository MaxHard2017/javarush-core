package level8.task1825;

/* 
 * Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.
    Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].
    Например, Lion.avi.
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.
Требования:
    •    Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
    •    Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
    •    В новый файл перепиши все байты из файлов-частей *.partN.
    •    Чтение и запись должны происходить с использованием буфера.
    •    Созданные для файлов потоки должны быть закрыты.
    •    Не используй статические переменные.
 */
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.TreeSet;

import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.tools.FileObject;

public class Solution {
    public static void main(String[] args) throws IOException {

        // для тестирования вводим имя файла не с клавиатуры а строкой
        String inStr = "c:/test/c1.part1\nc:/test/c1.part5\nc:/test/c1.part3\nc:/test/c1.part2\nend\n";
        byte[] inputBytes = inStr.getBytes(StandardCharsets.UTF_8); // в принципе кодировкак тут не нужна
        InputStream is = new ByteArrayInputStream(inputBytes);
        System.setIn(is); // менявод иени файла прайснашу строчку



        TreeSet<joinFile> files = new TreeSet<>(new partNameComparator());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in,"cp866"));
        String inputFileName  = "";
        while(true) {
            inputFileName = br.readLine();
            if (inputFileName.equals("end")) {
                break;
            }
            int dotIndex = inputFileName.lastIndexOf(".");      // находим расположение последней точки в имени файла
            //считаем, что после последней точки распологается название части.

            Integer order;
            if ( inputFileName.length() - dotIndex > 1) {
                order = Integer.parseInt(inputFileName.substring(dotIndex + 5, inputFileName.length()));
                files.add(new joinFile(inputFileName, order));
                //сохраняем название части как отдельное поле partName по которому будет сортироваться TreeSet
            }
        }
        String newFileName = Paths.get(files.first().name).getFileName().toString();
        String newFileNameWithoutExtension = newFileName.substring(0, newFileName.lastIndexOf("."));

        String newFilePath = Paths.get(files.first().name).getParent().toString() + "\\"
                             + newFileNameWithoutExtension;

        FileOutputStream fos = new FileOutputStream(newFilePath, true);
        for (joinFile item : files) {
            FileInputStream fis = new FileInputStream(item.name);
            while(fis.available() > 0) {
                fos.write(fis.read());
            }
            fis.close();
        }
        fos.close();

        for (joinFile joinFile : files) {
            System.out.print(joinFile + " - ");

        }
    }
}

class joinFile {
    String name;
    Integer partName;

    public joinFile (String name, Integer partName) {
        this.name = name;
        this.partName = partName;
    }
    @Override
    public String toString(){
        return this.name;
    }
}

class partNameComparator implements Comparator<joinFile>{
    @Override
    public int compare(joinFile o1, joinFile o2) {
        return (o1.partName).compareTo(o2.partName);
    }
}