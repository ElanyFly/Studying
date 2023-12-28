package Less04;

public class Main {

    /**
     * Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть
     * наполовину сыт (это сделано для упрощения логики программы);
     * <p>
     * 6. Создать массив котов и одну тарелку с едой, попросить всех котов покушать из этой тарелки
     * и потом вывести информацию о сытости котов в консоль;
     */

    public static void main(String[] args) {


        employeesSummon();

        catsFeeding();

    }

    private static void printCatsFillInfo(Cat[] catList) {
        for (Cat cat : catList) {
            System.out.println("Голоден ли котик " + cat.getName() + "? Ответ: " + cat.getAreYouFull() + " Сытость котика - " + cat.getAppetite());
        }

    }

    private static void feedCat(Bowl bowl, Cat cat) {
        int bowlFill = bowl.getBowlFill();
        int catAppetite = cat.getAppetite();
        int leftInBowlResult = bowlFill - catAppetite;
        int hungryCat = leftInBowlResult * -1;          // срабатывает, только при отрицательном значении миски. По факту там выходит минус.


        if (leftInBowlResult >= 0) {                       // если съел столько же сколько было в миске, или меньше, то аппетит удовлетворен, а миска опустела
            cat.setAppetite(0);                         // не будем переписывать их аппетит. величина будет неизменной
            //bowlFill = leftInBowlResult;              // еды стало меньше в миске
            cat.setAreYouFull(true);                    // кот сыт
            System.out.println("Котик " + cat.getName() + " наелся и радуется жизни! :)");
        } else {                                        // Если при потреблении пищи, еда ушла в минус
            cat.setAppetite(hungryCat);
            leftInBowlResult = 0;
            System.out.println("Котик " + cat.getName() + " по прежнему голоден :(");
        }

        bowl.setBowlFill(leftInBowlResult);


    }


    public static void employeesSummon() {
        Employee[] PersonArray = new Employee[5];

        PersonArray[0] = new Employee("Надежда", "Власова", "Директор", "sdfwe@mail.ru", "+7 957 374 22 94", 240000, 49);
        PersonArray[1] = new Employee("Виктор", "Никулин", "Аналитик", "ofejuf@mail.ru", "+7 936 740 75 19 ", 83028, 35);
        PersonArray[2] = new Employee("Алина", "Долина", "Администратор", "sdfwo9@mail.ru", "+7 683 187 03 50", 86000, 28);
        PersonArray[3] = new Employee("Екатерина", "Некрасова", "Ассистент", "7yeb6f@mail.ru", "+7 463 926 78 94", 37000, 21);
        PersonArray[4] = new Employee("Андрей", "Пушкин", "Ведущий специалист", "39fjnhyy@mail.ru", "+7 846 937 63 01", 210000, 41);


        for (Employee employee : PersonArray) {
            if (employee.age > 40) System.out.println(employee.printEmployee());
        }
        //for (int i = 0; i < PersonArray.length; i++) {
        //            if (PersonArray[i].age > 40) System.out.println(PersonArray[i].printEmployee());
        //        }
    }

    public static void catsFeeding() {
        //пул котов
        Cat[] catList = new Cat[5];
        catList[0] = new Cat("Tucha", false, 200, 3, 200, false);
        catList[1] = new Cat("Monty", false, 250, 2.0f, 250, false);
        catList[2] = new Cat("Milka", false, 130, 2.0f, 185, false);
        catList[3] = new Cat("Sonya", false, 175, 1, 270, false);
        catList[4] = new Cat("Vasya", false, 210, 2.0f, 220, false);

        Bowl bowl = new Bowl(1700);    // создана миска
        bowl.bowlInfo();
        //bowl.setBowlFill(700);    // наполнили миску для проверки не полностью.
        bowl.fillThisBowl();        // Вызов ручного ввода наполнения миски
        bowl.bowlInfo();

        for (Cat cat : catList) {
            feedCat(bowl, cat);
            if (bowl.noFoodLeft()) {
                System.out.println("Насыпьте еще корма, он закончился");
                bowl.fillThisBowl();
                feedCat(bowl, cat);
            }
        }

        printCatsFillInfo(catList);
    }
    //ctl alt L = выровнять файл по стилю

}

