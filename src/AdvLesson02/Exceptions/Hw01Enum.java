package AdvLesson02.Exceptions;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Hw01Enum {
/*
    Написать метод, на вход в который подаётся енум (что-то про дни недели?)
    Нужно определить количество рабочих часов до конца недели.

    Приходит понедельник, тогда надо распечатать на консоль, что до конца раб.
    Недели осталось 40 часов. Вт- 32часа. И т.д. Суббота – сегодня выходной.
*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите день недели: ");
        String day = scanner.next();

//        if (!day.equals(DayOfWeek.valueOf(day).toString())) {
//        if (!DayOfWeek.values().equals(day)) {
//            System.out.println("Введён неверный день!!.");
//        } else {
//            hoursLeft(DayOfWeek.valueOf(day));
//        }

        hoursLeft(DayOfWeek.valueOf(day));

    }

    public static void hoursLeft(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case Понедельник: {
                System.out.println("До конца рабочей недели осталось 40 часов.");
                break;
            }
            case Вторник: {
                System.out.println("До конца рабочей недели осталось 32 часов.");
                break;
            }
            case Среда: {
                System.out.println("До конца рабочей недели осталось 24 часов.");
                break;
            }
            case Четверг: {
                System.out.println("До конца рабочей недели осталось 16 часов.");
                break;
            }
            case Пятница: {
                System.out.println("До конца рабочей недели осталось 8 часов.");
                break;
            }
            case Суббота:
            case Воскресенье: {
                System.out.println("Сегодня выходной.");
                break;
            }
            default: assert false: "Неизвестный день.";

//                System.out.println("Введён неправильный день недели.");
//                break;

        }
    }
}

enum DayOfWeek {
    Понедельник, Вторник, Среда, Четверг, Пятница, Суббота, Воскресенье;

}

enum DayOfWeek2 {
    Monday("Понедельник", "Пн"),
    Tuesday("Вторник", "Вт"),
    Wednesday("Среда", "Ср"),
    Thursday("Четверг", "Чт"),
    Friday("Пятница", "Пт"),
    Saturday("Суббота", "Сб"),
    Sunday("Воскресенье", "Вс");

    private String ru;
    private String shortRu;

    DayOfWeek2(String ru, String shortRu) {
        this.ru = ru;
        this.shortRu = shortRu;
    }

    public String getRu() {
        return ru;
    }

    public String getShortRu() {
        return shortRu;
    }
}

class CheckingDays {
    DayOfWeek2 dayOfWeek2;
    String monday = DayOfWeek2.Monday.getRu();
    String mondayShortRu = DayOfWeek2.Monday.getShortRu();

//    public void checkHoursLeft(DayOfWeek2 dayOfWeek2) {
//        switch (dayOfWeek2 || dayOfWeek2.getRu() || dayOfWeek2.getShortRu()) {
//            case Monday:
//            case DayOfWeek2.Monday.getRu():
//            case DayOfWeek2.Monday.getShortRu():
//        }
//    }


}