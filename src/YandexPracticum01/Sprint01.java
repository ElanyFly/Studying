package YandexPracticum01;

import java.util.Random;
import java.util.Scanner;

public class Sprint01 {
    public static void main(String[] args) {

//if - else
/*        int health = 25;
        boolean haveHealSpell = false;

        if (health <= 0) {
            System.out.println("Противник повержен!");
        } else if (health < 20) {
            if (haveHealSpell) {
                System.out.println("Противник вылечился!");
            } else {
                System.out.println("Противник убежал!");
            }
        } else {
            System.out.println("Противник атакует игрока!");
        }*/

//if-else
/*        int health = 15;
        boolean haveHealSpell = true;

        String lowHealthAction = haveHealSpell ? "Противник вылечился!" : "Противник убежал!";
        if (health <= 0) {
            System.out.println("Противник повержен!");
        } else if (health < 20) {
            System.out.println(lowHealthAction);
        } else {
            System.out.println("Противник атакует игрока!");
        }*/

//fori
/*        int money = 500; // Деньги на корм
        int packPrice = 100; // Стоимость пачки корма
        int days = 0; // Дни, когда вы сможете покупать корм

        for (int i = money - packPrice; i >= 0; i = i-packPrice) {
            days = days + 3;
            money = money - packPrice;
            System.out.println("На " + days + "-й день останется " + money +" рублей.");
        }

        System.out.println("Денег хватит на " + days + " дней.");*/

//while
/*        Scanner scanner = new Scanner(System.in);
        System.out.print("Сколько денег у вас сейчас: ");
        double balance = scanner.nextDouble(); // Ваши сбережения
        int years = 0;

        while (balance < 1000000) {
            balance = balance + (balance*0.05);
            System.out.println("год " + years + ", денег на счету: " + balance);
            years = years + 1;

        }

        System.out.println("Через " + years + " лет у вас будет миллион!");*/

// игра в рандомное число)
/*        Scanner scanner = new Scanner(System.in);
        int randomInt = new Random().nextInt(1001); // Генерирует новое число от 0 до 1000

        int userInput = -1; // Это нужно, чтобы цикл запустился, если Random выдаст 0
        System.out.println("Я загадал число от 0 до 1000.");
        System.out.println("Ваш ход:");

        // Напишите условие цикла для запуска игры
        while (userInput != randomInt) {
            userInput = scanner.nextInt();
            if (userInput > randomInt) { // Условие проверяется в цикле
                System.out.println("Меньше");
            }
            if (userInput < randomInt) {
                System.out.println("Больше");
            }
        }

        System.out.println("Вы великолепны! Именно это я загадал.");*/

//бесконечный цикл
/*        Scanner scanner = new Scanner(System.in);
        System.out.println("Оцените работу приложения Зеленоглазое-Такси по шкале от 1 до 3");

        while (true) { // Запускаем бесконечный цикл
            int x = scanner.nextInt(); // Получаем оценку от пользователя

            if (x == 1) { //Если пользователь вводит 1
                System.out.println("Спасибо за вашу оценку. Мы станем лучше!"); // Благодарим
                break; // Выходим из цикла
            }
            if (x == 2) { // Если оценка равна 2
                System.out.println("Спасибо за вашу оценку. Есть куда расти!");
                break; // И выходим из цикла
            }
            if (x == 3) { // Если оценка равна 3
                System.out.println("Спасибо за высокую оценку! Рады, что вы выбрали нас!");
                break; // И выходим из цикла
            }
            // Пользователь ввёл не 1, 2 или 3 - повторяем просьбу
            System.out.println("Ваша оценка должна быть в диапазоне от 1 до 3");
        }*/

//циклы бесконeчные задача 2
/*//        Scanner scanner = new Scanner(System.in);
//        int sum = 0;
//        int input;
//
//        while (true) {
//            input = scanner.nextInt();
//            if (input == 0) {
//                break;
//            }
//            sum = sum + input;
//        }
//
//        System.out.println("Сумма введённых чисел: " + sum);

        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int input;

        do {
            input = scanner.nextInt();
            sum = sum + input;
        } while (input != 0);

        System.out.println("Сумма введённых чисел: " + sum);*/

//while true
/*        Random random = new Random(); // Генерирует случайное число
        int secretCode;
        int pilotInput;

        // Добавьте цикл - ракета летает бесконечно
        while (true) {
            secretCode = random.nextInt(101); // Здесь задаётся код - случайное число от 0 до 100
            System.out.println("Ракета SpaceY на орбите!");
            pilotInput = random.nextInt(101); // Пилот пытается угадать код
            if (pilotInput == secretCode) { // Если пилот угадал код, то цикл должен завершиться
                System.out.println("Пилот угадал число! Летим домой!");
                break;
            }
        }*/

/*        for (int i = 1; i <= 30; i++) {
            System.out.println("День " + i);
            for (int j = 1; j <= 3; j++) {
                System.out.println(" Серия " + j);
            }
        }
        System.out.println("Ура! Вы прокачали и Java, и английский!");*/

        executeWorkingDay();

    }

    private static void executeWorkingDay() {
        System.out.println("Время 11.00");

        // опять этот надоедливый будильник

        alarmClock();

        // нам срочно нужен кофе
        System.out.println("Пойти на кухню");

        boilingWater();
        System.out.println("Взять кофе и включить ноутбук");

        System.out.println("Посмотреть мемы про менеджеров за кружкой кофе"); // да, куда же без мемов?
        watchingMemes();

        // О, на часах уже полдень, пора бы начать работать.
        int time = 12;

        time = workingTillEight(time);

        System.out.println("Пора бы поиграть в Playstation");

        while (time <= 24) {
            System.out.println("Пиу пи");
            time++;
        }

        System.out.println("Кажется, пора посмотреть фильм и пойти спать");
        watchingMovie();
        System.out.println("Ну вот, пора спать :(");
    }

    private static int workingTillEight(int time) {
        // поработаем-ка мы до 8 вечера
        while (time <= 20) {
            System.out.println("Писать код... Клац, клац...");
            time++;

            // не плохо бы приготовить ещё чашку кофе
            if (time % 3 == 0) {
                boilingWater();
                System.out.println("Взять кофе и вернуться делать: 'клац... клац...'");
            }
        }
        return time;
    }

    private static void watchingMovie() {
        System.out.println("Алиса, помоги выбрать фильм");

        while (isThisFilmInteresting()) {
            System.out.println("Алиса, не то");
        }

        System.out.println("То что нужно! Отличный фильм");
    }

    private static void watchingMemes() {
        for (int i = 5; i >= 0; i--) {
            if (i == 0) {
                System.out.println("Кажется, пора работать");
            } else {
                System.out.println("О_о, ещё мемчик");
            }
        }
    }

    private static void boilingWater() {
        if (isKettleEmpty()) {
            System.out.println("Налить воды в чайник");
        }
        System.out.println("Включить чайник");

        for (int i = 4; i >= 0; i--) {
            switch (i) {
                case 0:
                    System.out.println("Вода закипела");
                    break;
                case 1:
                    System.out.println("Вода закипит через минуту");
                    break;
                default:
                    System.out.println("Вода закипит через " + i + " минуты");
                    break;
            }
        }
        System.out.println("Приготовить кофе");
    }

    private static void alarmClock() {
        while (true) {
            System.out.println("Будильник: БЗЗЗЗЗЗЗЫЫЫЫЫЫЫНЬ!");
            if (isProgrammerWakeUp()) {
                break;
            }
        }
    }

    // программисты любят поспать подольше
    private static boolean isProgrammerWakeUp() {
        int random = new Random().nextInt(5); // этот метод позволяет сгенерировать случайное число от 0 до 4
        return random == 0;
    }

    // воды в чайнике может и не быть :(
    private static boolean isKettleEmpty() {
        return new Random().nextBoolean(); // этот метод позволяет сгенерировать случайное значение типа boolean (true или false)
    }

    // давайте выберем интересный фильм
    private static boolean isThisFilmInteresting() {
        int random = new Random().nextInt(3); // этот метод позволяет сгенерировать случайное число от 0 до 2
        return random != 0;
    }


}
