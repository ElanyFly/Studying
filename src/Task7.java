/**
 * 7. Написать метод, по которому в качестве параметра передается строка,
 * обозначающая имя, метод должен вывести в консоль сообщение
 * «Привет, указанное_имя!»;
 */
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args){
        Scanner name = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String userName = name.nextLine();
        System.out.println("Привет, " + userName + "!");


    }
}
