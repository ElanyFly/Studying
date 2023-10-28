/**
 *  Написать метод, который определяет, является ли год високосным,
 *  и выводит сообщение в консоль.
 *  Каждый 4-й год является високосным, кроме каждого 100-го,
 *  при этом каждый 400-й – високосный.
 */
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = scan.nextInt();

        if ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) {
            System.out.println("Этот год високосный");
        }
        else {
            System.out.println("Этот год не високосный");
        }


    }


}
