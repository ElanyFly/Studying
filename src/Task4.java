//4. Написать метод, принимающий на вход два числа, и проверяющий,
// что их сумма лежит в пределах
//от 10 до 20 (включительно), если да – вернуть true, в противном случае – false;
public class Task4 {
    public static void main(String[] args) {
        int a = 75;
        int b = 12;

        if ( ((a + b) > 10) && ((a + b) < 20) ) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }


    }
}
