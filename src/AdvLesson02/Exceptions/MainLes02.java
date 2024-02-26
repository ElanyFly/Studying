package AdvLesson02.Exceptions;

public class MainLes02 {
    public static void main(String[] args) {

//        if (Fruit.APPLE == Fruit.APPLE) {
//            System.out.println("Apple");
//        }

//        for (Fruit f : Fruit.values()) {
//            System.out.println(f);
//        }

//        System.out.println(Fruit.valueOf("BANANA"));

        for (Fruit f : Fruit.values()) {
            System.out.println(f.getName() + " " + f.getWeight() + " " + f.ordinal());
        }

    }
}

enum Fruit {
    ORANGE("Апельсин", 3), APPLE("Яблоко", 2),
    BANANA("Банан", 2), CHERRY("Вишня", 1);

    private String name;
    private int weight;

    Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
