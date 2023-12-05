package Less04;

/**
 * 8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
 *  (Например, dog1.run(150); -> результат: run: true);
 */
public class Cat extends Animal {

    public Cat(boolean swim, int runLenght, float jumpHeight, int swimLenght) {
        super(swim, runLenght, jumpHeight, swimLenght);

    }

    public Cat(boolean swim, int runLenght, float jumpHeight) {
        super(swim, runLenght, jumpHeight);

    }


}


