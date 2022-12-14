package level10.task2017;



/* 
 * На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуй объект в методе getOriginalObject так, чтобы в случае возникновения исключения было выведено сообщение на экран и возвращен null.
Реализуй интерфейс Serializable где необходимо.
Требования:
    •    Класс B должен быть потомком класса A.
    •    Класс A должен поддерживать интерфейс Serializable.
    •    Класс B не должен явно поддерживать интерфейс Serializable.
    •    Метод getOriginalObject должен возвращать объект типа A полученный из потока ObjectInputStream.
    •    Метод getOriginalObject должен возвращать null, если при попытке десериализации не был получен объект типа A.
    •    Метод getOriginalObject должен возвращать null, если при попытке десериализации возникло исключение.

CODE

import java.io.ObjectInputStream;
import java.io.Serializable;
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) { return null;  }
    public class A {   }
    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
    public static void main(String[] args) { }
}
 */

 
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.IOException;

/* 
Десериализация
*/

public class Solution {

    public A getOriginalObject(ObjectInputStream objectStream) {
        
        try {
            Solution.A result = (Solution.A) objectStream.readObject();
            return result;

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } 
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
