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

    private String name;
    private boolean swim;
    private int runLength;
    private int swimLenght;
    private float jumpHeight;

    public Animal (String name, boolean swim, int runLength, float jumpHeight, int swimLength){
        this.name = name;
        this.swim = swim;
        this.runLength = runLength;
        this.swimLenght = swimLength;
        this.jumpHeight = jumpHeight;
    }

    public Animal (String name, boolean swim, int runLength, float jumpHeight){
        this.name = name;
        this.swim = swim;
        this.runLength = runLength;
        this.jumpHeight = jumpHeight;
    }

    public void jump(int jumpHeight) {
        if (this.jumpHeight >= jumpHeight){
            System.out.println("Это животное успешно прыгнуло на высоту " + jumpHeight + "м.");
        }else System.out.println("Это животное не может так высоко прыгать =(");
    }

    public void run(int runLength) {
        if (this.runLength >= runLength){
            System.out.println("Это животное успешно пробежало " + runLength + "м.");
        }else System.out.println("Это животное не может пробежать такое большое расстояние =(");
    }

    public void swimming(int swimLength) {
        if (!swim) {
            System.out.println("Это животное не умеет плавать =(");
        } else if (swim && this.swimLenght >= swimLength) {
            System.out.println("Это животное успешно проплыло " + swimLength + "м.");
        }else {
            System.out.println("Животное не может столько проплыть =(");
        }
    }

}
