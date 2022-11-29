package level10.task2026;

import java.util.ArrayList;

/* 
 * 1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
Требования:
•	В классе Solution должен существовать метод getRectangleCount с одним параметром типа byte[][].
•	Метод getRectangleCount должен быть публичным.
•	Метод getRectangleCount должен быть статическим.
 */


/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

/* 
 * проверяем с верху в низ массив построчно. каждая строка возможно содержит часть прямоугольника
 * чать строки принадлежащей пямоугольнику от точки начала до точки конца образует паттрен его
 * который "растягивается" вниз до строки содержащей 0 в позоциях где в паттерне были 1 ил до конца 
 * массива класс реализует паттерн прямоугольника в массиве данных
 * (a,b) - а - начальный индекс паттерна в строке и конечный индекс в строке
 * если в выбранной строке элемент принадлежит паттерну то в этой строке существует этот прямоугольник
 * и так до 0
 */
    public static class RetcangleString {
        static ArrayList<RetcangleString> rectangleList = new ArrayList<>();
        private static int rectangleCounter = 0;

        private int start = 0;
        private int end = 0;
        private boolean formed;
        public RetcangleString(int start, int end) {
            this.start = start; 
            this.end = end;
        }
        public int getStart() {
            return start;
        }
        public void setStart(int start) {
            this.start = start;
        }
        public int getEnd() {
            return end;
        }
        public void setEnd(int end) {
            this.end = end;
        }
        public boolean isFormed() {
            return formed;
        }
        public void setFormed(boolean formed) {
            this.formed = formed;
        }

        /**
         * @param index -  индекс 
         * @return - показывает принадлежит ли элемент паттерну.
         */
        public boolean isIn(int index) {
            if ((index >= this.start) && (index <= this.end)) {
                return true;
            }
            return false;
        }

        public int inCurrentRectangle(int index) {
            for (int i = 0; i < rectangleList.size(); i++) {
                if (rectangleList.get(i).isIn(index)) {         //  проверяет прпадеет ли индекс в какой либо из паттернов прямоугольников
                    return i;
                }
            }                
            return -1;
        }
        // если еденица то увелииваем текуший незавершенный паттерн на 1 или создаем новый 
        public static void testOne(int index) {
            if (rectangleList.isEmpty()) {
                rectangleList.add(new RetcangleString(index, index));
            }
            for (RetcangleString current : rectangleList) {
                if (current.isIn(index)) {
                    return;
                }
            }

            ArrayList<RetcangleString> rectangleListListTmp = new ArrayList<>(rectangleList);
            for (RetcangleString current : rectangleList) {
                if ((index > 0) && (current.getEnd() == (index -1))) {      // если единица примыкает к концу какого-то паттена то мы его увеличиваем на эту единицу
                    current.setEnd(index);
                    
                } else {
                    rectangleListListTmp.add(new RetcangleString(index, index));
                }
            }
            rectangleList = rectangleListListTmp;
            
        }
// если ноль то смотрим если он попадает в какойто паттерн то значит прямоугольник  вверху
        public static void testZero(int index) {
            ArrayList<RetcangleString> rectangleListListTmp = new ArrayList<>(rectangleList);
            for (RetcangleString current : rectangleList) {
                if (current.isIn(index)) {
                    RetcangleString.rectangleCounter++;
                    rectangleListListTmp.remove(current);
                }
            }
            rectangleList = rectangleListListTmp;

        }

        public static int counTotal() {
            rectangleCounter += rectangleList.size();
            rectangleList.clear();
            return rectangleCounter;
        }

    }

    public static int getRectangleCount(byte[][] a) {
        RetcangleString.rectangleCounter = 0;
        int adepth = a.length;
        int awidth = a[0].length;

        for (int j = 0; j < adepth; j++) {
           for (int i = 0; i < awidth; i++) {
                if (a[j][i] == 1) {
                    RetcangleString.testOne(i);
                } else {
                    RetcangleString.testZero(i);
                }
           }

        }
        return RetcangleString.counTotal();
    }
}