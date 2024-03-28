package YaPractSprint03;

import java.util.Arrays;

public class ConstantFinal {
    public static void main(String[] args) {
        final int value;
        // System.out.println(value);
        // здесь будет ошибка "Variable 'value' might not have been initialized"
        value = 12;
        System.out.println(value);
        // а вот этот код отработает корректно, потому как выше мы присвоили значение 12
    }
}

// константы часто используются для определения ограниченного набора значений.

// в данном примере мы как бы говорим: "Все поддерживаемые курсы валют есть в данном классе,
// если чего-то нет, значит, оно не поддерживается"

// есть и другие более ограниченные способы определять ограниченные наборы данных, но с ними
// мы с вами познакомимся позже на курсе
class Currencies {

    // в Java принято объявлять константы в верхнем регистре, а слова в имени разделять подчёркиванием
    public final static String RUBBLE = "RUB";
    public final static String AMERICAN_DOLLAR = "USD";
    public final static String AUSTRALIAN_DOLLAR = "AUD";
    public final static String EURO = "EUR";
}
