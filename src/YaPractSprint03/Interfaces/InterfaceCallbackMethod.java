package YaPractSprint03.Interfaces;

import java.util.Random;

public class InterfaceCallbackMethod {
    public static void main(String[] args) {
        final WeatherSensor weatherSensor = new WeatherSensor();
        final MessageHandler messageHandler = new MessageHandler();

        weatherSensor.start(messageHandler);
    }
}

interface MessageCallback {

    // в слушателе мы зададим параметры, которые нужно передать для обратного вызова
    void onMessageSend(final int temperature, final int time);
}

class MessageHandler implements MessageCallback {

    @Override
    public void onMessageSend(final int temperature, final int time) {
        System.out.println("Сообщение получено. Время: " + time +
                ". Температура воздуха: " + temperature + ".");
    }
}

class WeatherSensor {

    void start(final MessageCallback callback) {
        for (int i = 0; i < 10; i++) {
            final Random random = new Random();
            // класс Random позволяет нам генерировать случайные значения

            final int sensorTimeToSend = random.nextInt(3);
            final int temperature = random.nextInt(30);

            // здесь мы создали примитивный пример случайной работы датчика
            // всякий раз, когда sensorTimeToSend равен 0 — мы будем отправлять сообщение,
            // которое будет обрабатываться в нашем слушателе
            if (sensorTimeToSend == 0) {
                callback.onMessageSend(temperature, i);
            }
        }
    }
}

