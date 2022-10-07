package level5.task1523;
/*
 *  Создай 4 конструктора с разными модификаторами доступа в классе Solution.
    В отдельном файле создай класс SubSolution и сделай его потомком класса Solution.
    Внутри класса SubSolution создай конструкторы командой Alt+Insert -> Constructors.
    Исправь модификаторы доступа конструкторов в SubSolution так, чтобы получилось 3 разных (все, кроме private).
Требования:
    •    В классе SubSolution должно содержаться 3 различных конструктора.
    •    В классе Solution должно содержаться 4 различных конструктора.
    •    В классе Solution должны быть объявлены конструкторы со всеми возможными модификаторами доступа.
    •    В классе SubSolution должны быть объявлены конструкторы со всеми возможными модификаторами доступа, кроме private.
    •    Класс Solution должен быть родителем класса SubSolution.
 */

public class Solution {

    public Solution() {
    }
    protected Solution(int i) {
    }
    Solution(String s) {
    }
    // private Solution(Boolean bl) {
    // }

}