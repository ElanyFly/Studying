package AdvLesson02.Exceptions;

import java.util.Scanner;

import static AdvLesson02.Exceptions.DayOfWeek.*;

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

        hoursLeft(day);

    }


    public static void hoursLeft(String dayOfWeek) {
        DayOfWeek day = Unknown;
        if (MONDAY.ru.equals(dayOfWeek) || MONDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("До конца рабочей недели осталось 40 часов.");
        } else if (TUESDAY.ru.equals(dayOfWeek) || TUESDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("До конца рабочей недели осталось 32 часов.");
        } else if (WEDNESDAY.ru.equals(dayOfWeek) || WEDNESDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("До конца рабочей недели осталось 24 часов.");
        } else if (THURSDAY.ru.equals(dayOfWeek) || THURSDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("До конца рабочей недели осталось 16 часов.");
        } else if (FRIDAY.ru.equals(dayOfWeek) || FRIDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("До конца рабочей недели осталось 8 часов.");
        } else if (SATURDAY.ru.equals(dayOfWeek) || SATURDAY.shortRu.equals(dayOfWeek) ||
                SUNDAY.shortRu.equals(dayOfWeek) || SUNDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("Сегодня выходной.");
        } else {
            System.out.println("Неправильно введён день.");
        }

    }
}

enum DayOfWeek {
    MONDAY("Понедельник", "Пн"),
    TUESDAY("Вторник", "Вт"),
    WEDNESDAY("Среда", "Ср"),
    THURSDAY("Четверг", "Чт"),
    FRIDAY("Пятница", "Пт"),
    SATURDAY("Суббота", "Сб"),
    SUNDAY("Воскресенье", "Вс"),

    Unknown("ХЗ", "ХЗ");

    final String ru;
    final String shortRu;

    DayOfWeek(String ru, String shortRu) {
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