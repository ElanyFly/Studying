/*
package YandexPracticum01;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Sprint02 {

    */
/*
//    В начале урока мы  уже видели улицу с хомяками в домах. Давайте создадим такую улицу.
//    Ваша задача создать массив hamsterStreet размером 5. Массив необходимо заполнить хомяками.
//
//    После чего вы должны пройтись по всему массиву и для каждого хомяка вывести сообщение
//    "В доме номер {номер дома} живет хомяк {имя хомяка}".
//
//    Важно! В реальном мире, мы не считаем номера домов с 0,
//    а значит, и в домах для хомяков номера домов должны начинаться с единицы. Подумайте, как это можно сделать.


    public static void main(String[] args) {
        final int expectedSize = 5;
        Hamster bite = new Hamster("Байт");
        Hamster kByte = new Hamster("Килобайт");
        Hamster ninja = new Hamster("Ниндзя");
        Hamster kuzya = new Hamster("Кузя");
        Hamster paskal = new Hamster("Паскаль");

        Hamster[] hamsterStreet = {bite, kByte, ninja, kuzya, paskal}; // создайте массив hamsterStreet и заполните его хомяками в соответствии с очерёдностью выше

        for (int i = 0; i < hamsterStreet.length; i++) {
            int houseNumber = i + 1; // помните, что в реальном мире нумерация домов начинается с 1
            Hamster hamster = hamsterStreet[i]; // а нумерация в java массиве с 0
            System.out.println(String.format("В доме номер %s живёт хомяк %s", houseNumber, hamster.name));
        }
    }

    static class Hamster {
        String name;

        Hamster(String name) {
            this.name = name;
        }
    }
*/
/*
 //Тема 3/6 урок 1 - массивы.

    //Задача. Списки.
    public static void main(String[] args) {

        HamsterFactory hamsterFactory = new HamsterFactory();
        hamsterFactory.start();

    }

}

class HamsterFactory {
    Scanner scanner = new Scanner(System.in);

    ArrayList<String> hamsterList = new ArrayList<>();
    // нужна структура данных, в которой можно хранить хомяков
    // мы не знаем, сколько будет хомяков: 10 или 10_000, поэтому нужна сущность, которая может изменять свой размер

    public void start() {
        System.out.println("Добро пожаловать на фабрику хомяков!");
        System.out.println("Здесь вы можете создавать, удалять и даже заменять одних хомяков на других");
        System.out.println("Для работы с фабрикой используйте следующие команды:");
        System.out.println("'Печать' — показать всех активных хомяков");
        System.out.println("'Создать [Имя]' — создать хомяка с выбранным именем");
        System.out.println("'Удалить [Индекс]' — удалить хомяка по выбранному индексу");
        System.out.println("'Очистить' — удалить всех, ранее созданных хомяков");
        System.out.println("'Заменить [Индекс] [Имя]' — заменить хомяка под выбранным индексом на нового с выбранным именем");
        System.out.println("'Размер' — вывести на экран текущее количество хомяков в хранилище");
        System.out.println("'Завершить' — завершить работу программы");

        while (true) {
            System.out.println("Введите команду...");

            String command = scanner.nextLine();

            if (command.equals("Завершить")) {
                System.out.println("Программа завершена! Спасибо, что пользуетесь нашей сетью хомячих фабрик");
                break;
            } else {
                executeCommand(command);
            }

            // если пользователь ввел команду "Завершить", надо закончить работу программы (остановить цикл)
            // при завершении работы вывести сообщение "Программа завершена! Спасибо, что пользуетесь нашей сетью хомячих фабрик"
            // иначе вызвать метод executeCommand(), который распознает команду и вызывает нужный метод для её обработки
            // обратите внимание, метод executeCommand() создавать не нужно, только вызвать
        }
    }

    private void executeCommand(String command) {


        if (command.contains("Печать")) {
            executePrint();
        } else if (command.contains("Создать")) {
            executeCreate(command.substring(8));
        } else if (command.contains("Удалить")) {
            executeRemoveByIndex(Integer.parseInt(command.substring(8)));
        } else if (command.contains("Очистить")) {
            executeClear();
        } else if (command.contains("Заменить")) {
            String[] splitCommand = command.trim().split("\\s+");
            executeSet(Integer.parseInt(splitCommand[1]), splitCommand[2]);
        } else if (command.contains("Размер")) {
            executeSize();
        } else {
            showErrorMessage();
        }

    }

    private void executePrint() {
        System.out.println("Вывожу актуальный список хомяков в хранилище:");
        for (int i = 0; i < hamsterList.size(); i++) {
            System.out.println("Хомяк '" + hamsterList.get(i) + "'");     //создать хомяков чтобы посмотреть
        }
        // выведите сообщение: "Вывожу актуальный список хомяков в хранилище:"
        // нужно напечатать всех хомяков, которые есть в хранилище в формате "Хомяк '[Имя хомяка]'"
    }

    private void executeCreate(String name) {
        hamsterList.add(name);
        System.out.println("Хомяк '" + name + "' создан и добавлен в хранилище");
        // создайте хомяка с именем [name] и добавьте его в ваше хранилище
        // выведите сообщение: "Хомяк '[name]' создан и добавлен в хранилище"
    }

    private void executeRemoveByIndex(int index) {
        if (index < hamsterList.size()) {
            String hamsterRemoved = hamsterList.remove(index);
            System.out.println("Хомяк '" + hamsterRemoved + "' удалён успешно");
        } else {
            System.out.println("Хомяка по заданному индексу не существует");
        }
        // если хомяк существует, надо удалить его и вывести сообщение: "Хомяк '[Имя удаленного хомяка]' удалён успешно"
        // иначе вывести сообщение: "Хомяка по заданному индексу не существует"
    }

    private void executeClear() {
        hamsterList.clear();
        System.out.println("Операция очистки завершена успешно! Все хомяки были удалены из хранилища");
        // очистить хранилище и вывести в лог сообщение: "Операция очистки завершена успешно! Все хомяки были удалены из хранилища"
    }

    private void executeSet(int index, String name) {
        String hamsterOld = hamsterList.set(index, name);
        String hamsterChanged = hamsterList.get(index);
        System.out.println("Хомяк '" + hamsterOld + "' был успешно заменён на хомяка '" + hamsterChanged + "'");
        // создайте хомяка с именем [name] и замените им хомяка на позиции [index]
        // выведите сообщение "Хомяк '[Имя удаленного хомяка]' был успешно заменён на хомяка '[Имя нового хомяка]'"
    }

    private void executeSize() {
        if (!hamsterList.isEmpty()) {
            System.out.println("Количество хомяков в хранилище равно " + hamsterList.size());
        } else {
            System.out.println("В хранилище нет хомяков");
        }
        // если в хранилище есть хомяки, надо вывести сообщение: "Количество хомяков в хранилище равно [текущее количество хомяков в хранилище]"
        // иначе вывести: "В хранилище нет хомяков"
    }

    private void showErrorMessage() {
        System.out.println("Неверная команда, попробуйте ещё раз.");
        // выведите сообщение: "Неверная команда, попробуйте ещё раз."
    }
}

//class Hamster {
//
//    String name;
//
//    public Hamster(String name) {
//        this.name = name;
//    }
//}

*/
