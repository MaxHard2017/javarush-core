package level10.task2002;
/* 
 * Реализуй логику записи в файл и чтения из файла для класса JavaRush.
Пустых полей у объекта User быть не может. Дату в файле удобно хранить в формате long.
Метод main реализован только для тебя и не участвует в тестировании.
Требования:
    •    Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
    •    Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
    •    Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
    •    Класс Solution.JavaRush должен быть публичным.
    •    Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            // File yourFile = File.createTempFile("your_file_name", null);
            File yourFile = new File("c://test/u1.txt");
            
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            User amigo = new User();
            amigo.setFirstName("Амиго");
            amigo.setLastName("Роботофф");
            GregorianCalendar birth = new GregorianCalendar(1999, 10, 5);
            amigo.setBirthDate(birth.getTime());
            amigo.setMale(true);
            amigo.setCountry(User.Country.OTHER);

            javaRush.users.add(amigo);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        /**
         *
         */
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            
            OutputStreamWriter sw = new OutputStreamWriter(outputStream);
            for (User user : this.users) {
                if (!(user == null)) {
                    sw.write(user.getFirstName() + "\n");
                    sw.write(user.getLastName() + "\n");
                    sw.write(Long.toString(user.getBirthDate().getTime()) + "\n");
                    sw.write(Boolean.toString(user.isMale()) + "\n");
                    sw.write(user.getCountry().getDisplayName() + "\n");
                } else {
                    System.out.println("Can not save User " + this.users.lastIndexOf(user)
                            + " user-record is empty (nullpionter in user list)");
                }
            }
            sw.flush();
            sw.close();
        }

        public void load(InputStream inputStream) throws Exception {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String inString = "";
            while (br.ready()) {
                inString = br.readLine();
                if (!(inString.equals(""))) {
                    User user = new User();
                    user.setFirstName(inString);
                    inString = br.readLine();
                    user.setLastName(inString);
                    inString = br.readLine();
                    user.setBirthDate(new Date(Long.parseLong(inString)));
                    inString = br.readLine();
                    user.setMale(Boolean.parseBoolean(inString));
                    inString = br.readLine();

                    switch (inString) {
                        case "UKRAINE":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        case "RUSSIA":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        default:
                            user.setCountry(User.Country.OTHER);
                            break;
                    }
                    this.users.add(user);
                }
                
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;
        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}