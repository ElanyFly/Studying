package Less04;

/**
 * 8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
 *  (Например, dog1.run(150); -> результат: run: true);
 *  1. Класс кота из прошлого ДЗ расширить функционалом потребления пищи. У каждого кота есть аппетит,
 * т.е. количество еды, которое он съедает за один раз;
 * 2. Кот должен есть из миски. Создайте такую сущность, которая будет обладать объёмом и едой в ней,
 * а также методами наполнения и получения информации о количестве еды;
 * 3. Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е., конкретный кот ест из конкретной миски,
 * уменьшая объём еды в ней;
 * 5. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
 * Если коту удалось поесть (хватило еды), сытость = true; DONE
 */
public class Cat extends Animal {
    private int appetite;
    private boolean areYouFull;
    private float jumpHeight;

    public boolean getAreYouFull() {
        return areYouFull;
    }
    public void setAreYouFull(boolean areYouFull) {
        this.areYouFull = areYouFull;
    }

    public int getAppetite() {
        return appetite;
    }
    public void setAppetite(int appetite){
        this.appetite = appetite;
    }

    // конструктор 1
    public Cat (String name, boolean swim, int runLength, float jumpHeight, int swimLength, int appetite, boolean areYouFull) {
        super(name, swim, runLength, jumpHeight, swimLength);
        this.jumpHeight = jumpHeight;
        this.appetite = appetite;
        this.areYouFull = areYouFull;
    }
    // конструктор 2
    public Cat(String name, boolean swim, int runLength, float jumpHeight, int appetite, boolean areYouFull) {
        super(name, swim, runLength, jumpHeight);
        this.appetite = appetite;
        this.areYouFull = areYouFull;
    }



    @Override
    public void jump (int jumpHeight) {
        if (this.jumpHeight >= jumpHeight){
            System.out.println("Этa кошечка успешно прыгнула на высоту " + jumpHeight + "м.");
        }else System.out.println("Этa кошечка не может так высоко прыгнуть =(");
    }

}


