package AdvLesson02.Exceptions;

public class MainEx {
    public static void main(String[] args) {
//        a();

//        try {
//            int b = 10 / 0;
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println("End");

/*        int a, b;
        try {
            int[] mass = {1, 2, 3};
            a = 0;
            b = 10 / a;
            mass[20] = 20;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }*/

//        try {
//            FileInputStream fileInputStream = new FileInputStream("1.txt");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

//        throw new RuntimeException("qwesdf");

//        System.out.println(squareRoot(-10));


//        try {
//            something();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            System.out.println("Освобождение ресурсов!");
//        }

//        System.out.println(something());

//        try(FileInputStream fileInputStream = new FileInputStream("1.txt")) {
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }

//    public static int squareRoot(int a) {
//        if (a > 0) {
//            return a / 2;
//        }
//        throw new ArithmeticException("нельзя отрицательное!");
//    }

    public static int something() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }


//
//    public static void a() {
//        b();
//    }
//
//    public static void b() {
//        c();
//    }
//
//    public static void c() {
//        int b = 10 / 0;
//    }
}

/*
class FactorialException extends Exception {
    private int num;

    FactorialException(String message, int num) {
        super(message);
        this.num = num;
    }
}

class Factorial {
    public static int getFactorial(int num) throws FactorialException {
        int result = 1;

        if (num < 1) throw new FactorialException("Число не может быть меньше 1", num);
        for (int i = 1; i < num; i++) {
            result *= i;
        }
        return result;
    }
}

class MainFactorialEx {
    public static void main(String[] args) {
        try {
            int result = Factorial.getFactorial(-10);
        } catch (FactorialException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}*/
