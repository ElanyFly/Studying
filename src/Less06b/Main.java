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
