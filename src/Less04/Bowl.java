package Less04;
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
    private int bowlFulness = 0;
    private int bowlFill;


    // конструктор миски
    public Bowl (int bowlSize){
        this.bowlSize = bowlSize;
    }

    // 2 метода отдельно - 1) наполнение миски(DONE), 2) информация о заполненности миски(DONE).
    public void bowlInfo () {
        System.out.println("В миске насыпано " + bowlFulness + " грамм корма.");
    }

    public void fillThisBowl (int fill) {

        bowlFulness = fill;
        bowlFill = bowlFulness;

        if (bowlFulness>bowlSize){
            bowlFulness = bowlSize;
            System.out.println("Вы насыпали слишком много корма, но не волнуйтесь, миска наполнилась, однако излишки пропали = (");
        }

    }



}
