package YaPractSprint03;

import java.util.Arrays;

public class SortingPersons {
    public static void main(String[] args) {
        final Product iPhone = new Product("IPhone 13", 80_000, 4.5f);
        // при написании больших чисел можно использовать '_'
        // для разделения числа для удобочитаемости. Компилятор будет игнорировать эти символы
        final Product playstation = new Product("Sony Playstation 5", 80_000, 4.6f);
        final Product sonyHeadPhones = new Product("Sony WH-1000XM5", 54_000, 4.8f);

        final Product[] products = {iPhone, playstation, sonyHeadPhones};

        bubbleSort(products);
        System.out.println(Arrays.toString(products));

        final Person rita = new Person("Рита", 23);
        final Person kirill = new Person("Кирилл", 20);
        final Person anna = new Person("Анна", 17);
        final Person[] persons = {rita, kirill, anna};

        bubbleSort(persons);
        System.out.println(Arrays.toString(persons));
    }

    private static void bubbleSort(final Comparable[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                final Comparable current = arr[j];
                final Comparable next = arr[j + 1];
                // теперь наш метод стал универсальным. Ему не важно, какой объект сюда попадёт,
                // важно лишь то, что в нём есть метод compare(), который для каждого объекта подскажет,
                // как его сравнивать
                if (current.compare(next) > 0) {
                    final Comparable tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
interface Comparable {

    // в интерфейсах все методы являются абстрактными по умолчанию,
    // нам не нужно указывать ключевое слово abstract

    // все методы, объявленные в интерфейсе, имеют модификатор доступа public.
    // При наследовании мы могли определять любой модификатор доступа, кроме private
    int compare(final Comparable comparable);
}


class Product implements Comparable {

    final String name;
    final int price;
    final float rating;

    public Product(final String name, final int price, final float rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    // переопределяемый метод должен иметь модификатор доступа public
    // класс, реализующий интерфейс, обязан реализовать **все** методы
    // (в противном случае программа просто не скомпилируется), которые определены в интерфейсах,
    // прямо как абстрактные методы в абстрактных классах.
    @Override
    public int compare(final Comparable other) {
        if (other instanceof Product) {
            if (price > ((Product) other).price) {
                return 1;
            } else if (price == ((Product) other).price && rating < ((Product) other).rating) {
                return 1;
            } else if (price == ((Product) other).price && rating == ((Product) other).rating) {
                return 0;
            } else {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}

class Person implements Comparable {

    final String name;
    final int age;

    Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compare(final Comparable other) {
        if (other instanceof Person) {
            if (age > ((Person) other).age) {
                return 1;
            } else if (age < ((Person) other).age) {
                return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

