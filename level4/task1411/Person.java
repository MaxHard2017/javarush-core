package level4.task1411;

public interface Person {

    static Person PersonFactory (String key) {
        Person person = null;
        switch (key) {
            case ( "user") :
                person = new User();
            break;
            case ( "loser") :
                person = new Loser();
            break;
            case ( "coder") :
                person = new Coder();
            break;
            case ( "proger") :
                person = new Proger();
            break;
            default :
            break;
        }

        return person;
    }

    class User implements Person {
        void live() {
            System.out.println("I usually just live.");
        }
    }

    class Loser implements Person {
        void doNothing() {
            System.out.println("I usually do nothing.");
        }
    }

    class Coder implements Person {
        void writeCode() {
            System.out.println("I usually write code.");
        }
    }

    class Proger implements Person {
        void enjoy() {
            System.out.println("It's a wonderful life!");
        }
    }
}