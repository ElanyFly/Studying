package YaPractSprint03;

public class InterfaceSmartHome {

    public static void main(String[] args) {
/*        final SmartHomeController yandexStation = new YandexStation();
        final Person2 person2 = new Person2(yandexStation);

        System.out.println("Алиса, включи телевизор");
        person2.turnOnTv();
        System.out.println("Алиса, выключи свет в гостиной");
        person2.turnOffLight();

        System.out.println("2 часа спустя...");

        System.out.println("Отличный был фильм. Алиса, выключи телевизор и включи свет");
        person2.turnOffTv();
        person2.turnOnLight();*/

        final SmartHomeController bestFriend = new BestFriend();
        final Person2 person2 = new Person2(bestFriend);

        System.out.println("Умный дом, включи телевизор");
        person2.turnOnTv();
        System.out.println("Умный дом, выключи свет в гостинной");
        person2.turnOffLight();

        System.out.println("2 часа спустя...");

        System.out.println("Отличный был фильм. Умный дом, выключи телевизор и включи свет");
        person2.turnOffTv();
        person2.turnOnLight();
    }

}

interface SmartHomeController {

    void toggleTv(final boolean isTurnedOn);

    void toggleLight(final boolean isTurnedOn);
}

class BestFriend implements SmartHomeController {

    @Override
    public void toggleTv(final boolean isTurnedOn) {
        if (isTurnedOn) {
            System.out.println("Блин блинский, ну зачем я с тобой спорил? Включаю телевизор :(");
        } else {
            System.out.println("Наконец-то этот фильм закончился. Пойду выключу телек");
        }
    }

    @Override
    public void toggleLight(final boolean isTurnedOn) {
        if (isTurnedOn) {
            System.out.println("Я что ещё и свет должен включать?");
        } else {
            System.out.println("Выключать свет, видимо, тоже мне придётся");
        }
    }
}

class YandexStation implements SmartHomeController {

    @Override
    public void toggleTv(final boolean isTurnedOn) {
        if (isTurnedOn) {
            System.out.println("Включаю телевизор. Вот список фильмов, которые стоит посмотреть сегодня");
        } else {
            System.out.println("Выключаю телевизор");
        }
    }

    @Override
    public void toggleLight(final boolean isTurnedOn) {
        if (isTurnedOn) {
            System.out.println("Свет в гостиной включен");
        } else {
            System.out.println("Сделано. Свет в гостиной выключен");
        }
    }
}

class Person2 {

    private final SmartHomeController controller;

    public Person2(final SmartHomeController controller) {
        this.controller = controller;
    }

    void turnOnTv() {
        controller.toggleTv(true);
    }

    void turnOffTv() {
        controller.toggleTv(false);
    }

    void turnOnLight() {
        controller.toggleLight(true);
    }

    void turnOffLight() {
        controller.toggleLight(false);
    }
}