package level4.task1415;

import java.util.ArrayList;
import java.util.List;


/*
 *  Реализовать метод cleanAllApartments().
    Пройтись по списку объектов apartments:
        для однокомнатных квартир (OneRoomApt) вызвать метод clean1Room();
        для двухкомнатных квартир (TwoRoomApt) вызвать метод clean2Rooms();
        для трехкомнатных квартир (ThreeRoomApt) вызвать метод clean3Rooms().
        Использовать instanceof.
Требования:
    •    Метод cleanAllApartments должен принимать список аппартаметов в качестве параметра.
    •    В методе cleanAllApartments для всех однокомнатных аппартаментов (OneRoomApt), содержащихся в списке, необходимо вызвать метод clean1Room().
    •    В методе cleanAllApartments для всех двухкомнатных аппартаментов (TwoRoomApt), содержащихся в списке, необходимо вызвать метод clean2Rooms().
    •    В методе cleanAllApartments для всех трехкомнатных аппартаментов (ThreeRoomApt), содержащихся в списке, необходимо вызвать метод clean3Rooms().
    •    Классы OneRoomApt, TwoRoomApt, ThreeRoomApt должны поддерживать (реализовывать) интерфейс Apartment.
    
    начальный код
        public class Solution {
            public static void main(String[] args) {
                List<Apartment> apartments = new ArrayList<Apartment>();
                apartments.add(new OneRoomApt());
                apartments.add(new TwoRoomApt());
                apartments.add(new ThreeRoomApt());
                cleanAllApartments(apartments);
            }

            public static void cleanAllApartments(List<Apartment> apartments) {        //написать тут вашу реализацию пунктов 1-4    }

            static interface Apartment {    }

            static class OneRoomApt implements Apartment {
                void clean1Room() {
                    System.out.println("1 room is cleaned");
                }
            }
            static class TwoRoomApt implements Apartment {
                void clean2Rooms() {
                    System.out.println("2 rooms are cleaned");
                }
            }
            static class ThreeRoomApt implements Apartment {
                void clean3Rooms() {
                    System.out.println("3 rooms are cleaned");
                }
            }
        }
*/
public class Solution {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<Apartment>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());
        cleanAllApartments(apartments);
    }
    public static void cleanAllApartments(List<Apartment> apartments) {
        
        for (Apartment apartment : apartments) {
            if (apartment instanceof OneRoomApt) {
                ((OneRoomApt) apartment).clean1Room();
            } else if (apartment instanceof TwoRoomApt) {
                ((TwoRoomApt) apartment).clean2Rooms();
            }else if (apartment instanceof ThreeRoomApt) {
                ((ThreeRoomApt) apartment).clean3Rooms();
            }
        }
    }

    static interface Apartment {
    }

    static class OneRoomApt implements Apartment {
        void clean1Room() {
            System.out.println("1 room is cleaned");
        }
    }

    static class TwoRoomApt implements Apartment {
        void clean2Rooms() {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class ThreeRoomApt implements Apartment {
        void clean3Rooms() {
            System.out.println("3 rooms are cleaned");
        }
    }
}



