package YaPractSprint03;

public class AbstractInherit {
    public static void main(String[] args) {

    }
}
abstract class Transport {
    abstract void run();
    abstract void makeStunt(final String stunt);
}

class Bicycle extends Transport {
    @Override
    void run() {
        System.out.println("Я кручу, кручу, кручу педали.");
    }

    // при переопределении метода очень важна сигнатура. Мы не можем переопределить метод
    // makeStunt() с другим набором параметров или другим возвращаемым типом
    @Override
    void makeStunt(final String stunt) {
        System.out.println("Прыжок, с рампы!");
    }
}

class BrokenBicycle extends Transport {
    @Override
    void run() {
        System.out.println("Пейн, я колёс не чувствую.");
    }
    @Override
    void makeStunt(final String stunt) {
        System.out.println("Я велосипедик, который смог!");
    }
}
