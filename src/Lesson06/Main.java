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

    public static void main (String[] args) {
        Main listen = new Main();               //нужно создать объект нашего же класса. Поставим его во все кнопки.

        frame = new JFrame("Calculator");   //выделила на нее память и задала имя

        result = new JTextField(16);    // в скобках мы указали количество символов, которое будет вмещать это поле.
        result.setEditable(false);              // сделали данное поле не изменяемым.
        //result.setText("text Info");            // тестовый текст

        //создаем кнопки
        ArrayList<JButton> btns = new ArrayList<>();                        // будет просто список с кнопками (10 number buttons)
        for (int i = 0; i < 10; i++) {
            JButton jTmpButton = new JButton(Integer.toString(i));              // переводим переменную в строку и передаем ее в качестве заголовка.
            jTmpButton.addActionListener(listen);                                   // указываем объект отвечающий за наше событие
            btns.add(jTmpButton);                                                // помещаем эти кнопки в массив.
        }

        List<String> operations = Arrays.asList("+", "-", "*", "/", "=", "c");           // сделали список с операциями.

        JPanel buttons = new JPanel();                                              // создали место куда мы будем помещать кнопки
        btns.forEach(buttons::add);                         //перетаскиваем все кнопки на панель (что это за точки?)
        operations.forEach(it -> {                          // т.к. стринги необходимо преквратить все в кнопки и потом добавить. Что здесь происходит?)
            JButton jTmpButton = new JButton(it);           // я тут типа это и сделала. Сейчас кнопки отображаются, но ничего не делают.
            buttons.add(jTmpButton);
        });

        GridLayout numsAndOpsLayout = new GridLayout(4, 4);     //В скобках нужно понять, сколько всего кнопок будет. 10 цифр + 7 операций
        buttons.setLayout(numsAndOpsLayout);                               //установили кнопки в эту сетку.

        //Создадим еще одну панель
        JPanel mainPanel = new JPanel();
        mainPanel.add(result);
        mainPanel.add(buttons);


        frame.add(mainPanel);                      //просто поместили резалт внутрь фрэйма. - - - отправили во фрейм мейнПэнэл. кнопки в одну строку, Для исправления создадим gridLayout
        //frame.add(buttons);                         //добавили кнопки
        frame.setSize(400, 200);    //установила размеры
        frame.setVisible(true);                 // включила видимость
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
