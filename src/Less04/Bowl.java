package Less04;

import java.util.Scanner;

/**
 * * 2. Кот должен есть из миски. Создайте такую сущность, которая будет обладать объёмом и едой в ней,
 *  * а также методами наполнения и получения информации о количестве еды; (DONE)
 *  *
 *  3. Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е., конкретный кот ест из конкретной миски,
 *  * уменьшая объём еды в ней;
 *
 */
public class Bowl {

    private int bowlSize;
    private int bowlFullness = 0;
    private int bowlFill;
    private Scanner pourTheFeed = new Scanner(System.in);

    // конструктор миски
    public Bowl (int bowlSize){
        this.bowlSize = bowlSize;
    }

    // 2 метода отдельно - 1) наполнение миски(DONE), 2) информация о заполненности миски(DONE).
    public void bowlInfo () {
        System.out.println("В миске насыпано " + bowlFullness + " грамм корма.");
    }

    public void fillThisBowl () {
        int feedAmountToPour;

        System.out.print("Введите сколько корма насыпать в миску: ");
        feedAmountToPour = pourTheFeed.nextInt();
        bowlFullness = bowlFullness + feedAmountToPour;

        if (bowlFullness >bowlSize){
            bowlFullness = bowlSize;
            System.out.println("Вы насыпали слишком много корма, но не волнуйтесь, миска наполнилась, однако излишки пропали = (");
        }

        if (bowlFullness <1){
            bowlFullness = 0;
            System.out.println("Миска опустела.");
        }


    }



}
