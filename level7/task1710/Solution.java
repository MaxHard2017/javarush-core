package level7.task1710;

/*
 * CRUD - Create, Read, Update, Delete.
Программа запускается с одним из следующих наборов параметров:
    -c name sex bd
    -r id
    -u id name sex bd
    -d id
Значения параметров:
    name - имя, String
    sex - пол, "м" или "ж", одна буква
    bd - дата рождения в следующем формате 15/04/1990
    -c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
    -r - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
    -u - обновляет данные человека с данным id
    -d - производит логическое удаление человека с id, заменяет все его данные на null
id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.
    Пример параметров:
        -c Миронов м 15/04/1990
    Пример вывода для параметра -r:
        Миронов м 15-Apr-1990
Если программа запущена с параметрами, то они попадают в массив args (аргумент метода main - String[] args).
    Например, при запуске программы c параметрами:
        -c name sex bd
    получим в методе main
        args[0] = "-c"
        args[1] = "name"
        args[2] = "sex"
        args[3] = "bd"
Для запуска кода с параметрами в IDE IntellijIDEA нужно их прописать в поле Program arguments в меню Run -> Edit Configurations.
Требования:
    •    Класс Solution должен содержать public static поле allPeople типа List<Person>.
    •    Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.    •    При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
    •    При запуске программы с параметром -r программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.
    •    При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
    •    При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
Начальный код:
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) {
        //напишите тут ваш код
    }
    public class Person {...
    public enum Sex {...
}

 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
     

    static int personCreate( String name, String sexStr, Date birthbay ) {
        if (sexStr.equals( "м" )) {
            Person person = Person.createMale( name, birthbay );
            allPeople.add( person );
            return allPeople.indexOf( person );
        }
        if ( sexStr.equals(  "ж" ) ) {
            Person person = Person.createFemale( name, birthbay );
            allPeople.add( person );
            return allPeople.indexOf( person );
        }
        return -1;
    }
    
    static boolean personUpdate( Integer id, String name, String sexStr, Date birthbay ) {
        try {
            Person person = allPeople.get(id);
            person.setName(name);
            if ( sexStr.equals("м" ) ) {
                person.setSex(Sex.MALE);
            } else if ( sexStr.equals("ж") ){
                person.setSex(Sex.FEMALE);
            }
            person.setBirthDate(birthbay);
            return true;
        }catch ( IndexOutOfBoundsException e ) {
            e.printStackTrace();
            System.out.println("ID " + id + " not found!");
            return false;
        }  
    }

    static String personRead(Integer id) {
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH);
        try {
            Person person = allPeople.get(id);
            String result = person.getName();
            result += person.getSex() == Sex.MALE ? " м " : " ж ";    // добавляем в result м или ж в зависимости от пола
            result += outputFormat.format(person.getBirthDate());
            return result;
        }catch ( IndexOutOfBoundsException e ) {
            e.printStackTrace();
            System.out.println("ID " + id + " not found!!");
            return "";
        }  
    }
    
    static boolean personDelete(Integer id) {
        try {
            Person person = allPeople.get(id);
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
            allPeople.set(id, null);
            return true;
        }catch ( IndexOutOfBoundsException e ) {
            e.printStackTrace();
            System.out.println("ID " + id + " not found!!!");
            return false;
        }  
    }
    
    static void errorFormat() {
        System.out.println("No paramerers, or they are wrong.");
        System.out.println("Use -c <name> <sex> <bd> - to create person.");
        System.out.println("Use -r <id> - to read person information.");
        System.out.println("Use -u <id> <name> <sex> <bd> - to update person.");
        System.out.println("Use -d <id> - to delete person.");
        System.out.println("id - integer value of existing person ID");
        System.out.println("name - string");
        System.out.println("sex - 'м' or 'ж' one letter");
        System.out.println("bd  - birth date in format: day number/month number/year ");
    }

    static boolean sexFormatOk(String sexStr) {
        if ( (sexStr.equals("м")) || (sexStr.equals("ж")) ) {
            return true;
        }
        return false;
    }

    static Date giveBirthDate(String birthStr) {
        SimpleDateFormat inputDateformat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return  inputDateformat.parse(birthStr);
        } catch (ParseException e) {
            e.printStackTrace();
            errorFormat();
            return null;
        }
    }

    static Integer givePersonID( String idStr ) {
        try {
            return Integer.valueOf(idStr);
        }catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Wrong ID format. " + idStr + " - must be integer!");
            return null;
        }
    }

    /**
     * @param args - параметры должны вводится через командную строку но для тестирования
     * вводим их в блоке инициализации
     */
    public static void main(String[] args ) {
        {   
            // args = new String[2];
            // args[0] = "-r";
            // args[1] = "1";
            // args[2] = "MacЯ"; 
            // args[3] = "ж";
            // args[4] = "01/02/2003";
        }

        Date birth;
        Integer id = -1;
        
        switch (args[0]) {
            
            case "-c" :
                if ( (args.length == 4) &  (sexFormatOk(args[2])) 
                                        & !((birth = giveBirthDate(args[3])) == null) ) {

                    id = personCreate(args[1], args[2], birth);
                    if ( !(id == -1) ) {
                        System.out.println(id);
                    }    
                } else {
                    System.out.println("Person " + id + " is not created.");
                }
            break;

            case "-r" : 
                if ( (args.length == 2) & !((id = givePersonID(args[1])) == null) ) {
                    System.out.println(personRead( id ));
                }
            break;

            case "-u" :
                if ( (args.length == 5) &  (sexFormatOk(args[3]))
                                        & !((birth = giveBirthDate(args[4])) == null)
                                        & !((id = givePersonID(args[1])) == null) ) {

                    personUpdate( id, args[2], args[3], birth );
                }    
            break;

            case "-d" :
                if ( (args.length == 2) & !((id = givePersonID(args[1])) == null) ) {
                    personDelete( id );
                } else {
                    System.out.println("Person " + id + " is not deleted.");
                }

            break;

            default :
                errorFormat();
            break;
        }
        System.out.println(personRead( 0 ));
        System.out.println(personRead( 1 ));
        //напишите тут ваш код
    }
}