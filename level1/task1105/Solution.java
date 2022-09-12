package level1.task1105;

/* 
ИТ-компания
Исправь девять классов: Worker (сотрудник), Clerk (клерк), IT (ИТ-специалист), Programmer (программист), ProjectManager (менеджер проекта), CTO (технический директор), HR (рекрутер), OfficeManager (офис-менеджер), Cleaner (уборщик).
Унаследуй программиста, менеджера проекта и технического директора от ИТ-специалиста.
Унаследуй рекрутера, уборщика и офис-менеджера от клерка.
Унаследуй клерка и ИТ-специалиста от сотрудника.
Требования:
    •    В классе Solution должен быть public класс Worker (сотрудник).
    •    В классе Solution должен быть public класс Clerk (клерк).
    •    В классе Solution должен быть public класс IT (ИТ-специалист).
    •    В классе Solution должен быть public класс Programmer (программист).
    •    В классе Solution должен быть public класс ProjectManager (менеджер проекта).
    •    В классе Solution должен быть public класс CTO (технический директор).
    •    В классе Solution должен быть public класс HR (рекрутер).
    •    В классе Solution должен быть public класс OfficeManager (офис-менеджер).
    •    В классе Solution должен быть public класс Cleaner (уборщик).
    •    Классы Programmer, ProjectManager и CTO должны быть унаследованы от класса IT.
    •    Классы HR, Cleaner и OfficeManager должны быть унаследованы от класса Clerk.
    •    Классы Clerk и IT должны быть унаследованы от класса Worker.
*/
public class Solution {
    public static void main(String[] args) {
    }

    public class Worker {}

    public class Clerk extends Worker {}

    public class IT extends Worker {}

    public class Programmer extends IT {}

    public class ProjectManager extends IT {}

    public class CTO extends IT {}

    public class OfficeManager extends Clerk {}

    public class HR extends Clerk {}

    public class Cleaner extends Clerk {}
}
