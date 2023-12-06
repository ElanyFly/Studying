package Less04;

public class Main {

    public static void main (String[] args) {

       /* Employee[] PersonArray = new Employee[5];

        PersonArray[0] = new Employee("Надежда", "Власова", "Директор", "sdfwe@mail.ru", "+7 957 374 22 94", 240000, 49);
        PersonArray[1] = new Employee("Виктор", "Никулин", "Аналитик", "ofejuf@mail.ru", "+7 936 740 75 19 ", 83028, 35);
        PersonArray[2] = new Employee("Алина", "Долина", "Администратор", "sdfwo9@mail.ru", "+7 683 187 03 50", 86000, 28);
        PersonArray[3] = new Employee("Екатерина", "Некрасова", "Ассистент", "7yeb6f@mail.ru", "+7 463 926 78 94", 37000, 21);
        PersonArray[4] = new Employee("Андрей", "Пушкин", "Ведущий специалист", "39fjnhyy@mail.ru", "+7 846 937 63 01", 210000, 41);


        for (int i = 0; i < PersonArray.length; i++) {
            if (PersonArray[i].age > 40) System.out.println(PersonArray[i].printEmployee());
        }*/

        Cat cat1 = new Cat("Tucha", false, 200, 2.0f, 200);
        Dog dog1 = new Dog("Pon4ik", true, 500, 0.5f, 10);

        cat1.jump(1);
        cat1.swimming(5);
        dog1.swimming(7);

    }
}

