package YaPractSprint03;

import java.util.Objects;

public class ObjectInfo {
    public static void main(String[] args) {

        Person kirill = new Person("Kirill", 25);
        Person anotherKirill = new Person("Kirill", 25);

        System.out.println(kirill.equals(anotherKirill)); // true

    }
}

class Person {

    final String name;
    final int age;

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        // в большинстве случаев мы можем использовать статический метод hash() класса Objects
        // и передавать в него поля, которые должны влиять на результирующий хеш-код

        // как и в случае с equals(), совершенно не обязательно указывать все поля класса.
        // Выбор всегда за вами, и зависит от задачи.
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(final Object o) {
        // проверяем ссылки. Если они равны, то они указывают на один и тот же участок памяти,
        // а значит, объекты точно эквивалентны между собой
        if (this == o) return true;

        // проверяем, что наш Object o действительно является объектом класса Person. Если это не так,
        // то объекты точно не равны
        if (o != null && getClass() != o.getClass()) return false;

        // сравниваем поля. Если все поля равны, значит, и объекты эквивалентны друг другу
        final Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }
}

