package level9.task1916;
/* 
Считать с консоли 2 пути к файлам - file, cangedFile.
Файлы содержат строки. Так как cangedFile является обновленной версией file, то часть строк совпадает.
Нужно создать объединенную версию строк из обоих файлов и записать эти строки в список lines.
Правила объединения:
    Если строка в обоих файлах совпадает, то в результат она попадает с операцией (приставкой) SAME.
    Например, SAME строка1.
    Если строка есть в file, но ее нет в cangedFile, то считаем, что строку удалили и в результат она попадает с операцией (приставкой) REMOVED.
    Например, REMOVED строка2.
    Если строки нет в file, но она есть в cangedFile, то считаем, что строку добавили и в результат она попадает с операцией (приставкой) ADDED.
    Например, ADDED строка0.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности и означают, что этой строки нет в определенном файле.
В оригинальном и редактируемом файлах пустых строк нет!
    Пример 1:
    содержимое оригинального файл (file):
        строка1
        строка2
        строка3
        строка4
        строка5
        строка1
        строка2
        строка3
        строка5
        строка0
    содержимое "редактированного" файла (cangedFile):
        строка1
        строка3
        строка5
        строка0
        строка1
        строка3
        строка4
        строка5
    результат объединения:
        оригинальный    редактированный    общий
        file:          cangedFile:             результат:(lines)
        
        строка1         строка1            SAME строка1
        строка2                            REMOVED строка2
        строка3         строка3            SAME строка3
        строка4                            REMOVED строка4
        строка5         строка5            SAME строка5
                        строка0            ADDED строка0
        строка1         строка1            SAME строка1
        строка2                            REMOVED строка2
        строка3         строка3            SAME строка3
                        строка4            ADDED строка4
        строка5         строка5            SAME строка5
        строка0                            REMOVED строка0
    Пример 2:
    содержимое оригинального файла (file):
        строка1
    содержимое "редактированного" файла (cangedFile):
        строка1
        строка0
    результат объединения:
        оригинальный    редактированный    общий
        file:          cangedFile:             результат:(lines)
        
        строка1         строка1            SAME строка1
                        строка0            ADDED строка0
Требования:
    •    Класс Solution должен содержать класс LineItem.
    •    Класс Solution должен содержать enum Type.
    •    Класс Solution должен содержать публичное статическое поле lines типа List<LineItem>, которое сразу проинициализировано.
    •    В методе main(String[] args) программа должна считывать пути к файлам с консоли (используй BufferedReader).
    •    В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
    •    Программа должна считывать содержимое первого и второго файла (используй FileReader).
    •    Потоки чтения из файлов (FileReader) должны быть закрыты.
    •    Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.
CODE    
            public class Solution {
                public static List<LineItem> lines = new ArrayList<LineItem>();
                public static void main(String[] args) {                }
                public static enum Type {
                    ADDED,        //добавлена новая строка
                    REMOVED,      //удалена строка
                    SAME          //без изменений
                }
                public static class LineItem {
                    public Type type;
                    public String line;
                    public LineItem(Type type, String line) {
                        this.type = type;
                        this.line = line;
                    }
                }
            }
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        String file = "";
        String cangedFile = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "cp866"));
            file = br.readLine();
            cangedFile = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<String> fileList = new ArrayList<>();
        List<String> cangedfileList = new ArrayList<>();
        try (   
                BufferedReader  fr = new BufferedReader(new FileReader(new File(file), StandardCharsets.UTF_8));
                BufferedReader  cfr = new BufferedReader(new FileReader(new File(cangedFile), StandardCharsets.UTF_8));
        ) {
            while (fr.ready() || cfr.ready()) {
                if (fr.ready()){
                    fileList.add(fr.readLine());
                }
                if (cfr.ready()) {
                    cangedfileList.add(cfr.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int fileCount = 0;
        int changedCount = 0;

        while ((fileCount < fileList.size()) || (changedCount < cangedfileList.size())) {   // делаем пока хотя бы один не пустой

            if ((fileCount < fileList.size()) && (changedCount < cangedfileList.size())) {  // если оба не пустые то 

                if ((fileList.get(fileCount).equals(cangedfileList.get(changedCount)))) { //  не пустые - строки равны
                    lines.add(new LineItem(Type.SAME, fileList.get(fileCount)));
                    fileCount++;
                    changedCount++;
                }else if (  !(fileList.get(fileCount).equals(cangedfileList.get(changedCount)))
                        && (fileList.get(fileCount + 1).equals(cangedfileList.get(changedCount)))) {

                    lines.add(new LineItem(Type.REMOVED, fileList.get(fileCount)));
                    fileCount++;
                } else { 
                // if (  !(fileList.get(fileCount).equals(cangedfileList.get(changedCount)))
                //         && (fileList.get(fileCount).equals(cangedfileList.get(changedCount + 1)))) {

                    lines.add(new LineItem(Type.ADDED, cangedfileList.get(changedCount)));
                    changedCount++;
                }

            } else if ((fileCount < fileList.size())) {                                     
                lines.add(new LineItem(Type.REMOVED, fileList.get(fileCount)));
                fileCount++;                
            } else {
                lines.add(new LineItem(Type.ADDED, cangedfileList.get(changedCount)));
                changedCount++;
            }
            
        }

        for (LineItem line : lines) {
            System.out.println(line);
        }

        // while ((fileCount < fileList.size()) || (changedCount < cangedfileList.size())) {

        //     if ((fileCount < fileList.size()) && (changedCount < cangedfileList.size())) {
        //         while ( (fileList.get(fileCount).equals(cangedfileList.get(changedCount))) ) {
        //             lines.add(new LineItem(Type.SAME, fileList.get(fileCount)));
        //             fileCount++;
        //             changedCount++;
        //         }
        //     }
                        
        //     if (  !(fileList.get(fileCount).equals(cangedfileList.get(changedCount)))
        //             && (fileList.get(fileCount + 1).equals(cangedfileList.get(changedCount)))) {

        //         lines.add(new LineItem(Type.REMOVED, fileList.get(fileCount)));
        //         fileCount++;
        //     }
            
        //     if (  !(fileList.get(fileCount).equals(cangedfileList.get(changedCount)))
        //             && (fileList.get(fileCount).equals(cangedfileList.get(changedCount + 1)))) {

        //         lines.add(new LineItem(Type.ADDED, cangedfileList.get(changedCount)));
        //         changedCount++;
        //     }

        //     if ( (fileCount > fileList.size()) && (changedCount < cangedfileList.size()) ) {
        //         lines.add(new LineItem(Type.ADDED, cangedfileList.get(changedCount)));
        //         changedCount++;
        //     }
        //     if ( (fileCount < fileList.size()) && (changedCount > cangedfileList.size()) ) {
        //         lines.add(new LineItem(Type.REMOVED, cangedfileList.get(changedCount)));
        //         fileCount++;
        //     }
        // }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
        @Override
        public String toString() {
            return this.type + " " + this.line;
        }
    }
    
}
