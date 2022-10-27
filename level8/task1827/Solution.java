package level8.task1827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/* 
 * CRUD для таблицы внутри файла.
Напиши программу, которая считывает с консоли путь к файлу для операций CRUD и при запуске со следующим набором параметров:
        -c productName price quantity
добавляет товар с заданными параметрами с новой строки в конец файла, генерируя id (8 символов) самостоятельно путем инкремента максимального id, найденного в файле.
    Значения параметров:
        -c - флаг, который означает добавления товара.
productName - название товара, 30 символов.
    price - цена, 8 символов.
    quantity - количество, 4 символа.
В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины.
Для чтения и записи файла нужно использовать FileReader и FileWriter соответственно.
    Пример содержимого файла:
        19846   Шорты пляжные синие           159.00  12  
        198478  Шорты пляжные черные с рисунко173.00  17  
        19847983Куртка для сноубордистов, разм10173.991234
Требования:
    •    Программа должна считать имя файла для операций CRUD с консоли.
    •    В классе Solution не должны быть использованы статические переменные.
    •    При запуске программы без параметров список товаров должен остаться неизменным.
    •    При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
    •    Товар должен иметь следующий id, после максимального, найденного в файле.
    •    Форматирование новой строки товара должно четко совпадать с указанным в задании.
    •    Созданные для файлов потоки должны быть закрыты.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        
        // // параметры командной строки
        // String[] inputArgs = {"-c","ов, очень большого размера10", "  9999.9900000   ", "1234 "};        
        // args = inputArgs;
        
        //поля файла
        String productName = "";     //30 знаков
        String quantity = "";        // 4 знака
        String price = "";          // 8 знаков 
      
        if ( (args.length < 2) ) {
            System.out.println("Wrong arguments!");
            return;
        }
        // проверка аргументов
        switch (args[0]) {
                case "-c" :
                    if ( (args.length < 4) ) {
                        System.out.println("Wrong arguments for creating record!");
                        return;
                    }
                    
                    // формируем поля из переданых параметров
                    // собираем название товара из возможно нескольких слов
                    for (int i = 1; i < args.length - 2; i++) {
                        productName += (i < args.length - 3) ? args[i] + " " : args[i]; // последнее значение args.length - 2 добавлям без пробела
                    }

                    // обработка параметра quantity
                    quantity = args[args.length - 1];              // последний параметр командной строки
                    quantity = quantity.trim();                 // удаляем пробелы
                    int iQuantity = Integer.parseInt(quantity); 
                    if (iQuantity > 9999 ) {
                        System.out.println("Wrong quantity (mote than 9999)!");
                        return;
                    }         

                    // приводим price к виду 5.2 и проверяем на максимально хранимое значение
                    price = args[args.length - 2];           // пердпаследний параметр командной строки
                    price = price.trim();
                    Double dPrise = Double.parseDouble(price);
                    
                    if ( dPrise > 99999.99 ) {
                        System.out.println("Wrong argument for price (more than 99999.990)!");
                        return;
                    }

                    CreateRecord(productName, dPrise, iQuantity);
                    
            //     break
            //     default :
            //     break;
        }
    }


    public static void CreateRecord(String productName, double dPrise, int iQuantity) throws IOException {
        String id = "";         // 8 знаков
        String FileString = ""; // строка для чтения или записи в файл

        /* // для тестирования вводим имя файла не с клавиатуры а строкой
        String inputFileName = "c://test/ttt.txt";
        byte[] inputBytes = inputFileName.getBytes(StandardCharsets.UTF_8); // в принципе кодировкак тут не нужна
        InputStream is = new ByteArrayInputStream(inputBytes);
        System.setIn(is); // меняем систем ин на нашу строчку
         */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String FileName = br.readLine();
        try (
            FileReader fr = new FileReader(FileName);
            BufferedReader bfr = new BufferedReader(fr);        // bfr - для чтения файла пеострочно

            FileOutputStream fos = new FileOutputStream(FileName, true);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            BufferedWriter bwr = new BufferedWriter(osw);        // bwr - для записи в фал построчно
        ){
            while (bfr.ready()) {
                FileString = bfr.readLine();
            }
            // читаем  id, переводим в int инерементируем и записываем обратно как стрингу
            id = (FileString.substring(0, 8));
            id = id.trim();
            int iId = Integer.parseInt(id) + 1;          // удвляем пробелы
            // id = String.valueOf(Integer.parseInt(id) + 1);
            
            // строка для записи в файл: % - начало параметра
            // + или - выравнивание, 
            // x.y где х - ширина поля a .y - прарметр обрезания для строки или точность до знака y для нецелых
            // для строки разность x-y заполняется пробелами справа или слева в зависимости от знака - привязки
            // s - для вывода строковой переменной
            // например %-30.20s - строковая переменная выводится обрезанной до 20 символов в поле 30 символов с левой привязкой
            // т.е. недостающие 10 символов замещаются пробелами и  помещаются после 20 выводимых смиволов переменной 
            // System.out.println(productName);
             
            FileString = String.format(Locale.ENGLISH,"\n%-8d%-30s%-8.2f%-4d", iId, productName, dPrise, iQuantity);
            bwr.write(FileString);
    
        }catch ( IOException e) {
            e.printStackTrace();
        }
        br.close();
    }
}