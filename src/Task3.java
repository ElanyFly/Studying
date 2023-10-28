//3. Написать метод, вычисляющий выражение a  (b + (c  d)) и возвращающий результат,
//где a, b, c, d – входные параметры этого метода;
public class Task3 {
    public static void main(String[] args) {
        int a = 4;
        int b = 9;
        int c = 2;
        int d = 8;

        int x = a * ( b + ( c * d ) );
        System.out.println(x);
        System.out.print(x+"\n");
        System.out.print(x);
        System.out.print(x);

    }
}
