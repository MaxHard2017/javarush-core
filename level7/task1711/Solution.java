package level7.task1711;
/*
 * CrUD Batch - multiple Creation, Updates, Deletion.
Программа запускается с одним из следующих наборов параметров:
    -c name1 sex1 bd1 name2 sex2 bd2 ...
    -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
    -d id1 id2 id3 id4 ...
    -i id1 id2 id3 id4 ...
Значения параметров:
    name - имя, String
    sex - пол, "м" или "ж", одна буква
    bd - дата рождения в следующем формате 15/04/1990
    -с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
    -u - обновляет соответствующие данные людей с заданными id
    -d - производит логическое удаление человека с id, заменяет все его данные на null
    -i - выводит на экран информацию о всех людях с заданными id: name sex bd
id соответствует индексу в списке.
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople.
Порядок вывода данных соответствует вводу данных.
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных).
Используй Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.
    Пример вывода для параметра -і с двумя id:
        Миронов м 15-Apr-1990
        Миронова ж 25-Apr-1997
Требования:
    •    Класс Solution должен содержать public static volatile поле allPeople типа List<Person>.
    •    Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
    •    При параметре -с программа должна добавлять всех людей с заданными параметрами в конец списка allPeople, и выводить id каждого (index) на экран.
    •    При параметре -u программа должна обновлять данные людей с заданными id в списке allPeople.
    •    При параметре -d программа должна логически удалять людей с заданными id в списке allPeople.
    •    При параметре -i программа должна выводить на экран данные о всех людях с заданными id по формату указанному в задании.
    •    Метод main класса Solution должен содержать оператор switch по значению args[0].
    •    Каждый case оператора switch должен иметь блок синхронизации по allPeople.
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
    public static volatile List<Person> allPeople = new ArrayList<Person>();

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
            //allPeople.set(id, null);
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
            // args[0] = "-i";
            // args[1] = "0";
            // args[2] = "1"; 
            
        }

        switch (args[0]) {
            
            case "-c" : 
            synchronized (allPeople) {
                Date birth;
                Integer id = -1;
                    for (int i = 1; i < args.length; i += 3) {
                        if ( (sexFormatOk(args[ i + 1 ])) 
                                                & !((birth = giveBirthDate(args[ i+2 ])) == null) ){
                            System.out.println(personCreate(args[i], args[ i+1 ], birth));      
                        }else {
                            System.out.println("Person " + id + " is not created.");
                        }
                    }
            }    
            break;

            case "-u" : 
            synchronized (allPeople) {
                Date birth;
                Integer id = -1;
                    for (int i = 1; i < args.length; i += 4) {
                        if ( (sexFormatOk(args[ i+2 ])) 
                                                & !((birth = giveBirthDate(args[ i+3 ])) == null)
                                                        & !((id = givePersonID(args[i])) == null) ) {
                            
                            personUpdate( id, args[ i+1 ], args[ i+2 ], birth );      
                        }else {
                            System.out.println("Person " + id + " is not created.");
                        }
                    }
            }    
            break;

            case "-i" : 
            synchronized (allPeople) {
                Integer id = -1;
                    for (int i = 1; i < args.length; i ++) {
                        if (  !((id = givePersonID(args[i])) == null) ) {
                           System.out.println(personRead( id ));      
                        }else {
                            System.out.println("Person " + id + " can not be read.");
                        }
                    }
            }    
            break;


            case "-d" : 
            synchronized (allPeople) {
                Integer id = -1;
                for (int i = 1; i < args.length; i ++) {
                    if (  !((id = givePersonID(args[i])) == null) ) {
                        personDelete( id );      
                    }else {
                        System.out.println("Person " + id + " is not deleted.");
                    }
                }
            }
            break;

            default :
                errorFormat();
            break;
        }
        //напишите тут ваш код
        
        {
            System.out.println(personRead( 0 ));  
        }  
    }
}