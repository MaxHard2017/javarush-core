package level10.task2001;

/* 
 * Часто необходимо сохранять состояние работы программы. До появления сериализации каждый делал это своим способом. В этой задаче нужно сохранить в файл состояние работы программы и вычитать состояние из файла без использования сериализации.
Реализуй логику записи в файл и чтения из файла для класса Human.
Поле name в классе Human не может быть пустым.
Метод main реализован только для тебя и не участвует в тестировании.
Требования:
    •    Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets пустой.
    •    Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не пустые.
    •    Класс Solution.Human не должен поддерживать интерфейс Serializable.
    •    Класс Solution.Human должен быть публичным.
    •    Класс Solution.Human не должен поддерживать интерфейс Externalizable.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
             File your_file_name = File.createTempFile("your_file_name", null);
            //  OutputStream outputStream = new FileOutputStream(your_file_name);
            //  InputStream inputStream = new FileInputStream(your_file_name);
            outputStream = new FileOutputStream("c://test/human.txt");
            inputStream = new FileInputStream("c://test/human.txt");

            Human ivanov = new Human("Petroff123", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        } finally {
            if (inputStream != null) {
                inputStream.close();
                outputStream.close();
                System.out.println("Done!");
            }
        }
    } 

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            OutputStreamWriter sw = new OutputStreamWriter(outputStream);
            sw.write(name + "\n");
            for (Asset asset : assets) {
                sw.write(asset.getName() + "\n");
                sw.write(Double.toString(asset.getPrice())+ "\n");
            }
            sw.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            
            InputStreamReader sr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(sr);
            String inStr = "";
            String inStrDouble = "";
            inStr = br.readLine();
            this.name = inStr;
            
            while (br.ready()) {
                inStr = br.readLine();
                inStrDouble = br.readLine();
                assets.add(new Asset(inStr, Double.parseDouble(inStrDouble)));
            }
        }
    }
}