package Less04;

/**5. Создать классы Собака и Кот с наследованием от класса Животное;

 6. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра
 каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков);

 7. У каждого животного есть ограничения на действия (бег: кот – 200 м., собака – 500 м.; прыжок: кот – 2 м., собака – 0.5 м.;
 плавание: кот не умеет плавать, собака – 10 м.);

 8. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
 (Например, dog1.run(150); -> результат: run: true);
 */
public abstract class Animal {

    private boolean swim;
    private int runLenght;
    private int swimLenght;
    private float jumpHeight;

    public Animal (boolean swim, int runLenght, float jumpHeight, int swimLenght){
        this.swim = swim;
        this.runLenght = runLenght;
        this.swimLenght = swimLenght;
        this.jumpHeight = jumpHeight;
    }

    public Animal (boolean swim, int runLenght, float jumpHeight){
        this.swim = swim;
        this.runLenght = runLenght;
        this.jumpHeight = jumpHeight;
    }

    public void jump(int jumpHeight) {
        if (this.jumpHeight >= jumpHeight){
            System.out.println("Это животное успешно прыгнуло на высоту " + jumpHeight + "м.");
        }else System.out.println("Это животное не может так высоко прыгать =(");
    }

    public void run(int runLenght) {
        if (this.runLenght >= runLenght){
            System.out.println("Это животное успешно пробежало " + runLenght + "м.");
        }else System.out.println("Это животное не может пробежать такое большое расстояние =(");
    }

    public void swimming(int swimLenght) {
        if (!swim) {
            System.out.println("Это животное не умеет плавать =(");
        } else if (swim && this.swimLenght >= swimLenght) {
            System.out.println("Это животное успешно проплыло " + swimLenght + "м.");
        }else {
            System.out.println("Животное не может столько проплыть =(");
        }
    }

}
