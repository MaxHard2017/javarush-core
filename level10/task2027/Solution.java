package level10.task2027;
    /* 
    * 1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
    2. Метод detectAllWords должен найти все слова из words в массиве crossword.
    3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
    text - это само слово, располагается между начальным и конечным элементами
    4. Все слова есть в массиве.
    5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
    6. Метод main не участвует в тестировании.
    Требования:
    •	В классе Solution должен существовать метод detectAllWords.
    •	В классе Solution должен существовать статический класс Word.
    •	Класс Solution не должен содержать статические поля.
    •	Метод detectAllWords должен быть статическим.
    •	Метод detectAllWords должен быть публичным.
    •	Метод detectAllWords должен возвращать список всех слов в кроссворде (согласно условию задачи).
    */


    import java.util.ArrayList;
    import java.util.List;

    /* 
    Кроссворд
    */

    public class Solution {
        public static void main(String[] args) {
            int[][] crossword = new int[][]{
                    {'i', 'i', 'i'},
                    {'i', 'o', 'i'},
                    {'i', 'i', 'i'}
            };
            List<Word> w = detectAllWords(crossword, "oi");
            System.out.println("total words count:" + w.size());
            System.out.println(w);

            /*
                Ожидаемый результат
                home - (5, 3) - (2, 0)
                same - (1, 1) - (4, 1)
            */
        }

        public static List<Word> detectAllWords(int[][] crossword, String... words) {
            List<Word> allWords = new ArrayList<>();

            for (String word : words) {
                for (int j = 0; j < crossword.length; j++) {
                    for (int i = 0; i < crossword[0].length; i++) {
                        forwardWord(crossword, i, j, word, allWords);
                        backwardWord(crossword, i, j, word, allWords); 
                        upwardWord(crossword, i, j, word, allWords); 
                        downwardWord(crossword, i, j, word, allWords); 
                        dioganalWordNe(crossword, i, j, word, allWords);
                        dioganalWordNw(crossword, i, j, word, allWords);
                        dioganalWordSw(crossword, i, j, word, allWords);
                        dioganalWordSe(crossword, i, j, word, allWords);
                    }
                    
                }
            }
            return allWords;
        }

        // если нашел то добавляет слово в список и возвращает кол-во добавленнх
        public static int forwardWord( int[][] crossword, int xIndex, int yIndex, String word, List<Word> allWords) {
            //индекс конца слова - меньше на 1 его длины так как индекс считаеся с 0
            int wordIndexEnd = word.length() - 1;
            if ((xIndex + wordIndexEnd) > crossword[0].length - 1) {
                return 0;
            }
            for (int i = 0; i < wordIndexEnd + 1 ; i++) {
                if ( (char) (crossword[yIndex][xIndex + i]) != word.charAt(i) ) {
                    return 0;
                }
            }
            
            addWord(word, xIndex, yIndex, xIndex + word.length() - 1, yIndex, allWords);
            return 1;
        }

        // если нашел то добавляет слово в список и возвращает кол-во добавленнх
        public static int backwardWord( int[][] crossword, int xIndex, int yIndex, String word, List<Word> allWords ) {
            //индекс конца слова - меньше на 1 его длины так как индекс считаеся с 0
            int wordIndexEnd = word.length() - 1;
            if (xIndex < wordIndexEnd) {
                return 0;
            }
            for (int i = 0; i < wordIndexEnd + 1 ; i++) {
                if ( (char) (crossword[yIndex][xIndex - i]) != word.charAt(i) ) {
                    return 0;
                }
            }
            addWord(word, xIndex, yIndex, xIndex - wordIndexEnd, yIndex, allWords);
            return 1;
        }
        
        // если нашел то добавляет слово в список и возвращает кол-во добавленнх
        public static int upwardWord( int[][] crossword, int xIndex, int yIndex, String word, List<Word> allWords ) {
            //индекс конца слова - меньше на 1 его длины так как индекс считаеся с 0
            int wordIndexEnd = word.length() - 1;
            if (yIndex < wordIndexEnd) {
                return 0;
            }
            // проверка совпадения букв по диоганали
            for (int i = 0; i < wordIndexEnd + 1 ; i++) {
                if ( ((char) (crossword[yIndex - i][xIndex]) != word.charAt(i)) ) {
                    return 0;
                }
            }
            addWord(word, xIndex, yIndex, xIndex, yIndex - wordIndexEnd, allWords);
            return 1; 
        }

        // если нашел то добавляет слово в список и возвращает кол-во добавленнх
        public static int downwardWord( int[][] crossword, int xIndex, int yIndex, String word, List<Word> allWords ) {
            //индекс конца слова - меньше на 1 его длины так как индекс считаеся с 0
            int wordIndexEnd = word.length() - 1;
            if ( (yIndex  + wordIndexEnd) > crossword.length - 1) {
                return 0;
            }
            // проверка совпадения букв по диоганали
            for (int i = 0; i < wordIndexEnd + 1 ; i++) {
                if ( ((char) (crossword[yIndex + i][xIndex]) != word.charAt(i)) ) {
                    return 0;
                }
            }
            addWord(word, xIndex, yIndex, xIndex, yIndex + wordIndexEnd, allWords);
            return 1; 
        }

        /* *
        * проверка нахождения слова начиная с указанного индекса по диоганали на северо-восток North-East
        */
        public static int dioganalWordNe( int[][] crossword, int xIndex, int yIndex, String word,  List<Word> allWords ) {
            //индекс конца слова - меньше на 1 его длины так как индекс считаеся с 0
            int wordIndexEnd = word.length() - 1;
            // проверка может ли слово начиная с указанного индекса уместиться в границах массива
            if ( ((xIndex + wordIndexEnd) > crossword[0].length - 1) ||
                (yIndex < wordIndexEnd) ) {

                return 0;
            }
            // проверка совпадения букв по диоганали
            for (int i = 0; i < wordIndexEnd + 1 ; i++) {
                if ( ((char) (crossword[yIndex - i][xIndex + i]) != word.charAt(i)) ) {
                    return 0;
                }
            }
            addWord(word, xIndex, yIndex, xIndex + wordIndexEnd, yIndex - wordIndexEnd, allWords);
            return 1;
        }

        /* *
        * провеерка на North-West
        */  
        public static int dioganalWordNw( int[][] crossword, int xIndex, int yIndex, String word,  List<Word> allWords ) {
            int wordIndexEnd = word.length() - 1;
            // проверка может ли слово начиная с указанного индекса уместиться в границах массива
            if ( (xIndex < wordIndexEnd) ||
                (yIndex < wordIndexEnd) ) {

                return 0;
            }
            // проверка совпадения букв по диоганали
            for (int i = 0; i < wordIndexEnd + 1; i++) {
                if ( (char) crossword[yIndex - i][xIndex - i] != word.charAt(i) )  {
                    return 0;
                }
            }
            addWord(word, xIndex, yIndex, xIndex - wordIndexEnd, yIndex - wordIndexEnd, allWords);
            return 1;
        }

        /* *
        * проверка на South-West
        */    
        public static int dioganalWordSw( int[][] crossword, int xIndex, int yIndex, String word,  List<Word> allWords ) {
            int wordIndexEnd = word.length() - 1;
            // проверка может ли слово начиная с указанного индекса уместиться в границах массива
            if ( (xIndex < wordIndexEnd ) ||
                (yIndex + wordIndexEnd > crossword.length - 1) ) {
                
                return 0;
            }

            // проверка совпадения букв по диоганали
            for (int i = 0; i < wordIndexEnd + 1; i++) {
                if ( (char) crossword[yIndex + i][xIndex - i] != word.charAt(i) )  {
                    return 0;
                }
            }
            addWord(word, xIndex, yIndex, xIndex - wordIndexEnd, yIndex + wordIndexEnd, allWords);
            return 1;
        }

        /* *
        * проверка на South-East
        */    
        public static int dioganalWordSe( int[][] crossword, int xIndex, int yIndex, String word,  List<Word> allWords ) {
            int wordIndexEnd = word.length() - 1;
            // проверка может ли слово начиная с указанного индекса уместиться в границах массива
            if ( (xIndex + wordIndexEnd > crossword[0].length - 1) ||
                (yIndex + wordIndexEnd > crossword.length - 1) ) {
                
                return 0;
            }

            // проверка совпадения букв по диоганали
            for (int i = 0; i < wordIndexEnd + 1; i++) {
                if ( (char) crossword[yIndex + i][xIndex + i] != word.charAt(i) )  {
                    return 0;
                }
            }
            addWord(word, xIndex, yIndex, xIndex + wordIndexEnd, yIndex + wordIndexEnd, allWords);
            return 1;
        }

        public static void addWord(String word, int xStartIndex, int yStartIndex, int xEndIndex, int yEndIndex,  List<Word> allWords) {
            Word newWord = new Word(word, xStartIndex, yStartIndex, xEndIndex, yEndIndex);

            for (Word existWord : allWords) {
                
                if ( (existWord.getStartX() == newWord.getEndX()) &&
                     (existWord.getStartY() == newWord.getEndY()) &&
                     (existWord.getEndX() == newWord.getStartX()) &&
                     (existWord.getEndY() == newWord.getStartY()) ) {
                
                    return; // если начало существующей совпадает с концом новой и конец новой с началом этой существующей то не добавляем, считаем что уже такое слоов есть
                }
            }
            allWords.add(newWord);
        }
        
        /* 
        * Класс для хранения найденного слова и его координат
        */
        public static class Word {        
            private String text;
            private int startX;
            private int startY;
            private int endX;
            private int endY;
            public Word(String text, int startX1, int startY1, int endX1, int endY1) {
                this.text = text;
                setStartPoint(startX1, startY1);
                setEndPoint(endX1, endY1);
            }

            public void setStartPoint(int i, int j) {
                startX = i;
                startY = j;
            }

            public void setEndPoint(int i, int j) {
                endX = i;
                endY = j;
            }

            // кастомный вывод слова и его координат
            @Override
            public String toString() {
                return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getStartX() {
                return startX;
            }

            public void setStartX(int startX) {
                this.startX = startX;
            }

            public int getStartY() {
                return startY;
            }

            public void setStartY(int startY) {
                this.startY = startY;
            }

            public int getEndX() {
                return endX;
            }

            public void setEndX(int endX) {
                this.endX = endX;
            }

            public int getEndY() {
                return endY;
            }

            public void setEndY(int endY) {
                this.endY = endY;
            }
        }
    }