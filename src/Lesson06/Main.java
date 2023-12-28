package Lesson06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends JFrame implements ActionListener {

    static JFrame frame;  //задала переменную
    static JTextField result;       // объект в джаве - текст филд. с его помощью будем выводить результат в калькуляторе.
    static String a = "", b = "", operation = "";

    public static void main (String[] args) {
        Main listen = new Main();                            //нужно создать объект нашего же класса. Поставим его во все кнопки.

        frame = new JFrame("Calculator");               //выделила на нее память и задала имя

        result = new JTextField(16);                // в скобках мы указали количество символов, которое будет вмещать это поле.
        result.setEditable(false);                          // сделали данное поле не изменяемым.
        //result.setText("text Info");                      // тестовый текст

        //создаем кнопки
        ArrayList<JButton> btns = new ArrayList<>();                            // будет просто список с кнопками (10 number buttons)
        for (int i = 0; i < 10; i++) {
            JButton jTmpButton = new JButton(Integer.toString(i));              // переводим переменную в строку и передаем ее в качестве заголовка.
            jTmpButton.addActionListener(listen);                               // указываем объект отвечающий за наше событие. Аналогичное сделать для действия ???
            btns.add(jTmpButton);                                               // помещаем эти кнопки в массив.
        }

        List<String> operations = Arrays.asList("+", "-", "*", "/", "=", "C");       // сделали список с операциями. Эти штуки it

        JPanel buttons = new JPanel();                      // создали место куда мы будем помещать кнопки
        btns.forEach(buttons::add);                         //перетаскиваем все кнопки на панель (что это за точки?)

//        for (JButton button: btns) {                      //с двумя точками - это краткая форма такой записи.
//            buttons.add(button);
//        }
        operations.forEach(operation -> {                          // т.к. стринги необходимо преквратить все в кнопки и потом добавить. it можно переименовать как угодно.
            JButton jTmpButton = new JButton(operation);           // я тут типа это и сделала. Сейчас кнопки отображаются, но ничего не делают.
            jTmpButton.addActionListener(listen);
            buttons.add(jTmpButton);
        });

        GridLayout numsAndOpsLayout = new GridLayout(4, 4);     //В скобках нужно понять, сколько всего кнопок будет. 10 цифр + 7 операций
        buttons.setLayout(numsAndOpsLayout);                               //установили кнопки в эту сетку.

        //Создадим еще одну панель
        JPanel mainPanel = new JPanel();
        mainPanel.add(result);
        mainPanel.add(buttons);


        frame.add(mainPanel);                            //просто поместили резалт внутрь фрэйма. - - - отправили во фрейм мейнПэнэл. кнопки в одну строку, Для исправления создадим gridLayout
        //frame.add(buttons);                            //добавили кнопки
        frame.setSize(400, 200);            //установила размеры
        frame.setVisible(true);                          // включила видимость
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());       //будет отображать то действие, которое мы нажали.

        String s = e.getActionCommand();                //сохранили наш гет экшн команд??
        // дальше напишем условие для чисел.
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {     // необходимо понять, была ли нажата какая-либо операция, и нужно хранить левую и правую части выражения. Для этого сделаем еще 3 переменных (в начале)
            if (operation.equals("")) {                      // если оперэйшнс пустой,то нужно все складывать в переменную а
                a = a + s;
            } else {
                b = b + s;
            }
            result.setText(a + operation + b);
        } else if (s.charAt(0) == 'C') {                    // прописали условие стирания
            a = operation = b = "";
            result.setText(a + operation + b);
        } else if (s.charAt(0) == '=') {                    // операция равно
            if (operation.isBlank()){return;}               //чтобы не было ошибки при нажатии = до вычислений
            int rslt = switch (operation) {
                case "+" -> Integer.parseInt(a) + Integer.parseInt(b);
                case "-" -> Integer.parseInt(a) - Integer.parseInt(b);
                case "/" -> Integer.parseInt(a) / Integer.parseInt(b);
                default -> Integer.parseInt(a) * Integer.parseInt(b);
            };
            a = String.valueOf(rslt);                                     // сохраняем результат в а
            result.setText(a);
            operation = b = "";                                             // операции и б равны пустой строке, для обнуления
        } else {
            if (operation.equals(""))
                operation = s;
            result.setText(a + operation + b);
        }

    }
}
