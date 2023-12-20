package Less06b;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {

    //зададим нужные нам переменные
    JFrame frame;
    JTextField textField;
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
        


        frame.setVisible(true);                                     //установили видимость

    }


    public static void main (String[] args) {
        Main calc = new Main();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
