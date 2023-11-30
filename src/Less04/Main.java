package Less04;

public class Main {

    public static void main (String[] args) {

        Employee[] emplArray = new Employee[5];

        emplArray[0] = new Employee("Надежда", "Власова", "Директор", "sdfwe@mail.ru", "+7 957 374 22 94", 240000, 49);
        emplArray[1] = new Employee("Виктор", "Никулин", "Аналитик", "ofejuf@mail.ru", "+7 936 740 75 19 ", 83028, 35);
        emplArray[2] = new Employee("Алина", "Долина", "Администратор", "sdfwo9@mail.ru", "+7 683 187 03 50", 86000, 28);
        emplArray[3] = new Employee("Екатерина", "Некрасова", "Ассистент", "7yeb6f@mail.ru", "+7 463 926 78 94", 37000, 21);
        emplArray[4] = new Employee("Андрей", "Пушкин", "Ведущий специалист", "39fjnhyy@mail.ru", "+7 846 937 63 01", 210000, 41);


        for (int i = 0; i < emplArray.length; i++) {
            if (emplArray[i].age > 40) {
                System.out.println(emplArray[i].printEmployee());
            }
        }


    }
}
