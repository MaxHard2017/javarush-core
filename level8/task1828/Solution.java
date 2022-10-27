package level8.task1828;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Solution {

    static class Product {
        private int id;
        private String productName = "";     //30 знаков
        private String quantity = "";        // 4 знака
        private String price = "";

        public Product(Integer id, String productName, String price, String quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }
        public int getId() {
            return id;
        }
        public String getProductName() {
            return productName;
        }
        public String getQuantity() {
            return quantity;
        }
        public String getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return String.format(Locale.ENGLISH, "%-8d%-30s%-8s%-4s",id, productName, price, quantity);
        }

    }

    static class PriceList {
        private Path path;
        private List<Product> proguctList = new ArrayList<Product>();

        public PriceList(Path path) {
            this.path = path;
            List<String> products = readAllPrices();
            for (String item : products) {
                this.proguctList.add(ReadProduct(item));
            }
        }
        /**
         * @return - возвращает правйс-лист как список объектов (Product)
         */
        public List<Product> getProductsPriceList() {
            return this.proguctList;
        }
        /**
         * @return - возвращает правйс-лист как список строк
         */
        public List<String> getPricesAsList() {
            List<String> result = new ArrayList<String>();
         
            for (Product product : proguctList) {
                result.add(product.toString());
            }
            return result;
        }
        
        // public void updateProductPrice(Product product) {
        //     int index = proguctList.indexOf(product);
        //     proguctList.remove(product);
        //     proguctList.add(index, product);
        // }
        public void updateProductPrice(int id, Product product) {
            int index = getIndexById(id);
            proguctList.remove(index);
            proguctList.add(index, product);
        }

        /**
         * @param id
         * @return - если proguctList.remove находит и удаляет запись то он возвращает удаленнывй объект
         * мы проверяем и возвращаем true или false
         */
        public boolean deleteProduct(int id) {
            return ((proguctList.remove(getIndexById (id))) == null) ? false : true; // а remove надо передать int а то он думает что передают Object
        }
        
        public boolean deleteProduct(Product product) {
            return proguctList.remove(product);
        }

        public boolean saveAllPrices() {
            try {
                // записываем в файл содержимое стрингового списка - прайслиста 
                Files.write(this.path, this.getPricesAsList(), StandardCharsets.UTF_8);
                return true;
              
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        private int getIndexById (int id){
            for (int i = 0; i < this.proguctList.size(); i++) { 
                if( (this.proguctList.get(i).id) == id ) {
                    return i;
                }
            }
            return -1;
        }

        private  List<String> readAllPrices() {
            try {
                return Files.readAllLines(this.path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private Product ReadProduct(String string) {
            String id = string.substring(0, 8).trim();
            String name = string.substring(8, 38).trim();
            String price = string.substring(38, 46).trim();
            String quantity = string.substring(46, 50).trim();
            return new Product(Integer.parseInt(id), name, price, quantity);
        }
    }


    public static void main(String[] args) throws IOException {
        
        // для тестирования вводим имя файла не с клавиатуры а строкой
        String inputFileName = "c://test/tt.txt";
        byte[] inputBytes = inputFileName.getBytes(StandardCharsets.UTF_8); // в принципе кодировкак тут не нужна
        InputStream is = new ByteArrayInputStream(inputBytes);
        System.setIn(is); // менявод иени файла прайснашу строчку 
       
        
        //Ввод иени файла прайса с клавиатуры
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String fileName = "";
        try {
            fileName = br.readLine();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        br.close();
        //Получили имя файла как Path
        Path path = Paths.get(fileName);
        
        // параметры командной строки
        String[] inputArgs = {"-u","19847986 ","Шорты хипстера цук","345.345", "345"};        
        args = inputArgs;
        
        
        // первичная проверка валидности параметров
        if ( (args.length < 2) ) {
            System.out.println("Wrong arguments!");
            return;
        }

        //Переменные для аргумантов из параметров запуска для изменения полей файла прайса
        String id = "";             // 8 знаков
        Integer iId = 0;
        String productName = "";    //30 знаков
        String quantity = "";       // 4 знака
        Integer iQuantity = 0;
        String price = "";          // 8 знаков
        PriceList priceList;
        
        // проверка аргументов
        switch (args[0]) {
                case "-u" :
                    if ( (args.length < 5) ) {
                        System.out.println("Wrong arguments for update record!");
                        return;
                    }

                    // формируем поля из переданых параметров
                    id = args[1].trim();              // последний параметр командной строки
                    iId = Integer.parseInt(id); 
                    if (iId > 99999999 ) {
                        System.out.println("Wrong ID (more than 99999999)!");
                        return;
                    }
                    id = iId.toString();  

                    // собираем название товара из возможно нескольких слов
                    for (int i = 2; i < args.length - 2; i++) {
                        productName += (i < args.length - 3) ? args[i].trim() + " " : args[i]; // последнее значение args.length - 2 добавлям без пробела
                    }
                    if (productName.length() > 30 ) {
                        productName = productName.substring(0, 30);
                    } 

                    // обработка параметра quantity
                    quantity = args[args.length - 1].trim();              // последний параметр командной строки
                    iQuantity = Integer.parseInt(quantity); 
                    if (iQuantity > 9999 ) {
                        System.out.println("Wrong quantity (more than 9999)!");
                        return;
                    }
                    quantity = iQuantity.toString();  

                    // приводим price к виду 5.2 и проверяем на максимально хранимое значение
                    price = args[args.length - 2];           // пердпаследний параметр командной строки
                    price = price.trim();
                    Double dPrise = Double.parseDouble(price);
                    
                    if ( dPrise > 99999.99 ) {
                        System.out.println("Wrong argument for price (more than 99999.990)!");
                        return;
                    }
                    price = String.format(Locale.ENGLISH,"%.2f", dPrise);

                    priceList = new PriceList(path);
                    Product updatedProduct = new Product(iId, productName, price, quantity);
                    priceList.updateProductPrice(iId, updatedProduct);
                    priceList.saveAllPrices();
                    
                break;

                case "-d" : 
                    if ( (args.length < 2) ) {
                        System.out.println("Wrong arguments for delete record!");
                        return;
                    }

                    // формируем поля из переданых параметров
                    id = args[1].trim();              // последний параметр командной строки
                    iId = Integer.parseInt(id); 
                    if (iId > 99999999 ) {
                        System.out.println("Wrong ID (more than 99999999)!");
                        return;
                    }
                
                    priceList = new PriceList(path);
                    priceList.deleteProduct(iId);
                    priceList.saveAllPrices();
                
                break;
            //     default :
            //     break;
        }
   
    }

    public static void UpdateRecord(Integer id, String productName, String price,String quantity) {

    }

}