package Less04;

import java.util.Scanner;

/**
 * * 2. Кот должен есть из миски. Создайте такую сущность, которая будет обладать объёмом и едой в ней,
 *  * а также методами наполнения и получения информации о количестве еды; (DONE)
 *  *
 *  3. Метод из первого пункта ДЗ должен взаимодействовать с миской, т.е., конкретный кот ест из конкретной миски,
 *  * уменьшая объём еды в ней;
 *
 *7. Когда еда в тарелке кончается, нужно оповещать об этом и наполнять её едой.
 *
 */
public class Bowl {

    private int bowlSize;

    private int bowlFill = 0;
    private Scanner pourTheFeed = new Scanner(System.in);

    // конструктор миски
    public Bowl (int bowlSize){
        this.bowlSize = bowlSize;
    }

    // 2 метода отдельно - 1) наполнение миски(DONE), 2) информация о заполненности миски(DONE).
    public void bowlInfo () {
        System.out.println("В миске насыпано " + bowlFill + " грамм корма.");
    }

    public void fillThisBowl () {

        System.out.print("Введите сколько корма насыпать в миску: ");
        int feedAmountToPour = pourTheFeed.nextInt();
        bowlFill = bowlFill + feedAmountToPour;

        if (bowlFill >bowlSize){
            bowlFill = bowlSize;
            System.out.println("Вы насыпали слишком много корма, но не волнуйтесь, миска наполнилась, однако излишки пропали = (");
        }

        if (bowlFill <=0){
            bowlFill = 0;
            System.out.println("Миска опустела.");
        }
    }

    public int getBowlFill(){
        return bowlFill;
    }

    public void setBowlFill (int bowlFill){
        this.bowlFill = bowlFill;
    }
    
    public boolean noFoodLeft () {
        boolean result = bowlFill <= 0;
        return result;
    }


}
