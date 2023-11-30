package Less04;

/**1. Создать класс «Сотрудник» с полями: ФИО, должность, email, телефон, зарплата, возраст;
 2. Конструктор класса должен заполнять эти поля при создании объекта;
 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;

 4. Создать массив из 5 сотрудников:
 Пример: Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 persArray[0] = new Person("Ivanov Ivan", "Engineer", " ivivan@mailbox.com ", "892312312", 30000, 30); //
 потом для каждой ячейки массива задаем объект persArray[1] = new Person(...);... persArray[4] = new Person(...);
 С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */
public class Employee {


    public  String name;
    public  String surName;
    public  String position;
    public  String eMail;
    public  String phoneNumber;
    public int salary;
    public int age;

    public Employee (String _name, String _surName, String _position, String _eMail, String _phoneNumber, int _salary, int _age) {
        name = _name;
        surName = _surName;
        position = _position;
        eMail = _eMail;
        phoneNumber = _phoneNumber;
        salary = _salary;
        age = _age;

    }

    public String printEmployee() {
        String info = "ФИО: " + surName + " " + name + "\n" + "Должность: " + position + "\n" + "E-mail: " + eMail + "\n" + "Тел.: " + phoneNumber + "\n" + "Зарплата: " + salary + " руб.\n" + "Возраст: " + age;
        System.out.println();
        return info;
    }

}
