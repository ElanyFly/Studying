/**3. Написать метод, вычисляющий выражение a (b + (c d)) и возвращающий результат,
//где a, b, c, d – входные параметры этого метода;

//4. Написать метод, принимающий на вход два числа, и проверяющий,
// что их сумма лежит в пределах
//от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;

 *5. Написать метод, которому в качестве параметра передается целое
 * число, метод должен напечатать в консоль положительное число передали
 * или отрицательное (Замечание ноль считаем положительным числом.);
  * 6. Написать метод, которому в качестве параметра передается целое число,
 *  * метод должен вернуть true, если число отрицательное;
 *  7. Написать метод, по которому в качестве параметра передается строка,
 *  * обозначающая имя, метод должен вывести в консоль сообщение
 *  * «Привет, указанное_имя!»;
 *  8.  Написать метод, который определяет, является ли год високосным,
 *  * и выводит сообщение в консоль.
 *  * Каждый 4-й год является високосным, кроме каждого 100-го,
 *  * при этом каждый 400-й – високосный.
 */

import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {

        int resPrim = primer(4, 9, 2, 8);
        System.out.println("Результат выражения: " + resPrim);

        checkSum(7, 9);

        checkNum(-7);

        boolean negCh = negativeCheck(8);
        System.out.println(negCh);

        sayName();

        yearCheck();

    }

    public static int primer (int a, int b, int c, int d) {
        return a * ( b + ( c * d ));
    }

    public static void checkSum (int a, int b){
        boolean result = ((a + b) > 10) && ((a + b) < 20);

        System.out.println(result);

    }

    public static void checkNum (int a){
        if (a<0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    public static boolean negativeCheck (int a){
        return (a<0);

    }

    public static void sayName(){
        Scanner name = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String userName = name.nextLine();
        System.out.println("Привет, " + userName + "!");


    }

    public static void yearCheck (){

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = scan.nextInt();

        boolean yearCh = ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0));

        if (yearCh) {
            System.out.println("Этот год високосный");
        } else {
            System.out.println("Этот год не високосный");
        }


    }


}


