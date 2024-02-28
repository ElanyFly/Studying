package AdvLesson02.Exceptions;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static AdvLesson02.Exceptions.DayOfWeek2.*;

public class Hw01Enum {
/*
    Написать метод, на вход в который подаётся енум (что-то про дни недели?)
    Нужно определить количество рабочих часов до конца недели.

    Приходит понедельник, тогда надо распечатать на консоль, что до конца раб.
    Недели осталось 40 часов. Вт- 32часа. И т.д. Суббота – сегодня выходной.
*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*        String day = "";
        DayOfWeek[] arrayOfWeekDays = DayOfWeek.values();
        String weekDayLikeString = Arrays.toString(arrayOfWeekDays);

        Boolean isNotValidInput = false;
        while (!isNotValidInput) {
            System.out.println("Введите день недели: ");
            day = scanner.next();
            try {

                isNotValidInput = weekDayLikeString.contains(day);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                System.out.println("Try again");
            }
        }
        hoursLeft(DayOfWeek.valueOf(day));*/   // Пример перевода массива в список и стринг, чтобы было возможно сравнить день и енам дней.

        System.out.println("Введите день недели: ");
        String day = scanner.next();

        hoursLeft(day);

    }



   /* public static void hoursLeft(DayOfWeek dayOfWeek) {
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
            default:
                assert false : "Неизвестный день.";

//                System.out.println("Введён неправильный день недели.");
//                break;

        }
    }*/

    public static void hoursLeft(String dayOfWeek) {
        DayOfWeek2 day = Unknown;
        if (MONDAY.ru.equals(dayOfWeek) || MONDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("До конца рабочей недели осталось 40 часов.");
        } else if (TUESDAY.ru.equals(dayOfWeek) || TUESDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("До конца рабочей недели осталось 32 часов.");
        }else if (WEDNESDAY.ru.equals(dayOfWeek) || WEDNESDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("До конца рабочей недели осталось 24 часов.");
        }else if (THURSDAY.ru.equals(dayOfWeek) || THURSDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("До конца рабочей недели осталось 16 часов.");
        }else if (FRIDAY.ru.equals(dayOfWeek) || FRIDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("До конца рабочей недели осталось 8 часов.");
        }else if (SATURDAY.ru.equals(dayOfWeek) || SATURDAY.shortRu.equals(dayOfWeek) ||
                SUNDAY.shortRu.equals(dayOfWeek) || SUNDAY.shortRu.equals(dayOfWeek)) {
            System.out.println("Сегодня выходной.");
        } else {
            System.out.println("Неправильно введён день.");
        }

    }
}

//enum DayOfWeek {
//    Понедельник, Вторник, Среда, Четверг, Пятница, Суббота, Воскресенье;
//
//}

enum DayOfWeek2 {
    MONDAY("Понедельник", "Пн"),
    TUESDAY("Вторник", "Вт"),
    WEDNESDAY("Среда", "Ср"),
    THURSDAY("Четверг", "Чт"),
    FRIDAY("Пятница", "Пт"),
    SATURDAY("Суббота", "Сб"),
    SUNDAY("Воскресенье", "Вс"),

    Unknown("ХЗ","ХЗ");

    final String ru;
    final String shortRu;

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