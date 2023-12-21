package Less06b;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {

    //зададим нужные нам переменные
    JFrame frame;
    JTextField textField;                                       //будет содержать наши цифры и результат (окошка ввода)
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;         // назвали кнопки операций
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;                                               // панель на которой будут все эти кнопки

    Font myFont = new Font("Helvetica", Font.BOLD, 30);     //задали шрифт для кнопок

    double num1 = 0, num2 = 0, result = 0;                      // задали дробные параметры
    char operator;

    //создадим конструктор для этого класса
    Main(){

        frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //позволяет закрыть программу.
        frame.setSize(420, 550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);   //задали позицию этого элемента
        textField.setFont(myFont);                                  //задали шрифт в этом поле.
        textField.setEditable(false);                               //запретили печатать в этом поле. Там будет только вывод

        addButton = new JButton("+");                           // добавили кнопку
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("CE");

        functionButtons[0] = addButton;             //назначили кнопки в массив
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);                 // чтобы не было обводки у кнопки при ее нажатии.
        }

        for (int i = 0; i < 10; i++) {                              //луп для обработки кнопок с цифрами
            numberButtons[i] = new JButton(String.valueOf(i));      //задали цифры
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50, 430, 145,50);       //предустановили позицию этих кнопок
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));          // задали сетку для кнопок. ряды, колонки, расстояние между кнопками\
        //panel.setBackground(Color.CYAN);                                            //временно подкрасили панель

        //добавим кнопки на эту панель, в определенном порядке.
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);                                       //добавили эти две кнопки на панель.
        frame.add(clrButton);
        frame.add(textField);                                       //добавили его во фрейм
        frame.setVisible(true);                                     //установили видимость

    }


    public static void main (String[] args) {
        Main calc = new Main();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
