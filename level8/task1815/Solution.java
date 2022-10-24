package level8.task1815;
/* 
 * Измени класс TableInterfaceWrapper так, чтобы он стал Wrapper-ом для TableInterface.
Метод setModel должен вывести в консоль количество элементов в списке перед обновлением модели (вызовом метода setModel у объекта типа TableInterface).
Метод getHeaderText должен возвращать текст в верхнем регистре - используй метод toUpperCase().
Требования:
    •    Класс TableInterfaceWrapper должен реализовывать интерфейс TableInterface.
    •    Класс TableInterfaceWrapper должен инициализировать в конструкторе поле типа TableInterface.
    •    Метод setModel() должен вывести в консоль количество элементов в новом листе перед обновлением модели.
    •    Метод getHeaderText() должен возвращать текст в верхнем регистре.
    •    Метод setHeaderText() должен устанавливать текст для заголовка без изменений.
 */

import java.util.List;

public class Solution {
    public class TableInterfaceWrapper  implements TableInterface{
        private TableInterface ti;


        
        public TableInterfaceWrapper(TableInterface ti) {
            this.ti = ti;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            ti.setModel(rows);            
        }

        @Override
        public String getHeaderText() {
            return ti.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            ti.setHeaderText(newHeaderText);
        }

    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}