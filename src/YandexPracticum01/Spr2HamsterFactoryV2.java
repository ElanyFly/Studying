package YandexPracticum01;

import com.sun.source.tree.WhileLoopTree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Spr2HamsterFactoryV2 {

    public static void main(String[] args) {
        HamsterFactory hamsterFactory = new HamsterFactory();
        hamsterFactory.start();
    }

}

class HamsterFactory {
    Scanner scanner = new Scanner(System.in);

    // нужна структура данных, в которой можно хранить только уникальных хомяков
    HashSet<Hamster> hamstersSet = new HashSet<>();

    public void start() {
        System.out.println("Добро пожаловать на фабрику хомяков!");
        System.out.println("Здесь вы можете создавать, удалять и даже печатать хомяков");
        System.out.println("Для работы с фабрикой используйте следующие команды:");
        System.out.println("'Печать' — показать всех хомяков в хранилище");
        System.out.println("'Создать [Имя]' — создать хомяка с выбранным именем");
        System.out.println("'Удалить [Имя]' — удалить хомяка с выбранным именем");
        System.out.println("'Очистить' — удалить всех, ранее созданных хомяков");
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
        }
    }

    private void executeCommand(String command) {


        if (command.contains("Печать")) {
            executePrint();
        } else if (command.contains("Создать")) {
            executeCreate(command.substring(8));
        } else if (command.contains("Удалить")) {
            String[] splitCommand = command.trim().split("\\s+");
            executeRemoveByName(splitCommand[1]);
        } else if (command.contains("Очистить")) {
            executeClear();
        } else if (command.contains("Заменить")) {
            String[] splitCommand = command.trim().split("\\s+");
//            executeSet(Integer.parseInt(splitCommand[1]), splitCommand[2]);
        } else if (command.contains("Размер")) {
            executeSize();
        } else {
            showErrorMessage();
        }

    }

    private void executePrint() {
        System.out.println("Вывожу актуальный список хомяков в хранилище:");
        for (Hamster hamster : hamstersSet) {
            System.out.println("Хомяк '" + hamster.name + "'");
        }

        // выведите сообщение: "Вывожу актуальный список хомяков в хранилище:"
        // напечатайте всех хомяков, которые есть в хранилище в формате "Хомяк '[Имя хомяка]'"
    }

    private void executeCreate(String name) {
        boolean isHamsterThere = hamstersSet.add(new Hamster(name));
        if (!isHamsterThere) {
            System.out.println("Хомяк '" + name + "' уже находится в хранилище");
        } else {
            System.out.println("Хомяк '" + name + "' создан и добавлен в хранилище");
        }
        // создайте хомяка с именем [name] и добавьте его в ваше хранилище
        // если такой хомяк уже есть в хранилище, выведите: "Хомяк '[name]' уже находится в хранилище"
        // иначе выведите сообщение: "Хомяк '[name]' создан и добавлен в хранилище"
    }

    private void executeRemoveByName(String name) {
        boolean isDeleted = false;

        Iterator<Hamster> hamsterIterator = hamstersSet.iterator();

        while (hamsterIterator.hasNext()) {
            Hamster hamsterCurrent = hamsterIterator.next();
            if (hamsterCurrent.name.equals(name)) {            //Objects.equals(hamsterCurrent.name, name)
                isDeleted = true;
                hamsterIterator.remove();
                System.out.println("Хомяк '" + name + "' удалён успешно");
            }
        }
        if (!isDeleted) {
            System.out.println("Хомяка с именем '" + name + "' не существует");
        }

        // если хомяк существует, то нужно удалить его и вывести сообщение: "Хомяк '[Имя удаленного хомяка]' удалён успешно"
        // иначе вывести сообщение: "Хомяка с именем '[Имя]' не существует"
    }

    private void executeClear() {
        Iterator<Hamster> hamsterIterator = hamstersSet.iterator();

        while (hamsterIterator.hasNext()) {
            Hamster hamsterToDelete = hamsterIterator.next();
            hamsterIterator.remove();
            System.out.println("Хомяк '" + hamsterToDelete.name + "' удалён успешно");
        }

        System.out.println("Операция очистки завершена успешно! Все хомяки были удалены из хранилища");

        // нужно удалить всех хомяков, которые есть в хранилище
        // каждый удаленный хомяк должен сопровождаться сообщением "Хомяк '[Имя удаленного хомяка]' удалён успешно"
        // после завершения очистки напечатайте "Операция очистки завершена успешно! Все хомяки были удалены из хранилища"
    }

    private void executeSize() {
        Iterator<Hamster> hamsterIterator = hamstersSet.iterator();
        int counter = 0;

        while (hamsterIterator.hasNext()) {
            hamsterIterator.next();
            counter++;
        }

        if (counter == 0) {
            System.out.println("В хранилище нет хомяков");
        } else {
            System.out.println("Количество хомяков в хранилище равно " + counter);
        }

        // если в хранилище есть хомяки, нужно вывести сообщение: "Количество хомяков в хранилище равно [текущее количество хомяков в хранилище]"
        // иначе вывести: "В хранилище нет хомяков"
    }

    // этот метод мы реализовывали в прошлой фабрике, оставим без изменений
    private void showErrorMessage() {
        System.out.println("Неверная команда, попробуйте еще раз.");
    }
}

class Hamster {

    String name;

    public Hamster(String name) {
        this.name = name;
    }

    // Функция boolean equals(Object object) определяет, равен ли один объект другому.
    // Функция int hashCode() возвращает хеш-код, связанный с вызывающим объектом.
    // Эти функции нужны для корректной работы HashSet, подробнее о них поговорим в одной из следующих тем спринта

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hamster hamster = (Hamster) o;
        return name.equals(hamster.name);
    }

    public boolean equals1(String o) {
        return name.equals(o);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}