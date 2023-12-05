package Less04;

/**
 * 8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
 *  (Например, dog1.run(150); -> результат: run: true);
 */
public class Dog extends Animal {
//    this.runLenght = 500;
//    this.jumpHeight = 0.5f;
//    this.swimLenght = 10;


    public Dog(boolean swim, int runLenght, float jumpHeight, int swimLenght) {
        super(swim, runLenght, jumpHeight, swimLenght);

    }

}
