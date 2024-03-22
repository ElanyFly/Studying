package YaPractSprint03;

public class Banking {
    public static void main(String[] args) {
        CreditAccount creditAccount = new CreditAccount(10, "USD", 10);
        creditAccount.withdrawCash(10);
        creditAccount.withdrawCash(10);
        creditAccount.withdrawCash(10);

    }
}


class BankAccount {

    protected int amount;
    protected String currency;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    //валюта трёхсимвольным кодом.
    // создайте переменную int amount. Доступ к переменной должен быть только из наследников и классов в
    // текущем пакете

    // создайте переменную String currency. Доступ к переменной должен быть только из наследников
    // и классов в текущем пакете

    public void replenishBalance(int amount) {
        this.amount += amount;
    }


    public void withdrawCash(int amount) {
        this.amount -= amount;
        //снятие наличных
    }


    public void showBalance() {
        //показать остаток на счету

        System.out.println("На вашем счету осталось " + amount + " " + currency);
    }
}

class DebitAccount extends BankAccount {
    /* унаследуйте класс от BankAccount */
    public DebitAccount(int amount, String currency) {
        if (amount >= 0) {

            setAmount(amount);
            setCurrency(currency);
        } else {
            System.out.println("Баланс дебетового счета не может быть меньше 0");
        }
        // если amount < 0, вывести сообщение "Баланс дебетового счета не может быть меньше 0"
        // иначе присвоить переменным amount и currency значения, переданные в конструкторе
    }

    @Override
    public void withdrawCash(int amount) {
        if (getAmount() >= amount) {
            int takenAmount = getAmount() - amount;
            setAmount(takenAmount);
            System.out.println("Вы сняли " + amount + " " + currency);
        } else {
            System.out.println("У вас недостаточно средств для снятия суммы " + amount + " " + currency);
        }
        // если на счету достаточно денег
        // вычесть amount из amount класса
        // вывести сообщение "Вы сняли {amount} {currency}"
        // иначе вывести сообщение "У вас недостаточно средств для снятия суммы {amount} {currency}"
    }

    @Override
    public void showBalance() {
        // вывести сообщение "На вашем счету осталось {amount} {currency}"
        System.out.println("На вашем счету осталось " + amount + " " + currency);

    }
}

class CreditAccount extends BankAccount {
    private int creditLimit;

    CreditAccount(int amount, String currency, int creditLimit) {
        setAmount(amount);
        setCurrency(currency);
        this.creditLimit = creditLimit;
    }

//    @Override
//    public void replenishBalance(int amount) {
//        int addingMoney = getAmount() + amount;
//        setAmount(addingMoney);
//        System.out.println("Счёт пополнен на " + amount + " " + currency);
//    }
    @Override
    public void withdrawCash(int amount) {
        int realLimit = creditLimit + getAmount();
        if (realLimit >= amount) {
            int takenAmount = getAmount() - amount;
            setAmount(takenAmount);
            System.out.println("Вы сняли " + amount + " " + currency);
        }
        else {
            System.out.println("У вас недостаточно средств для снятия суммы " + amount + " " + currency);
        }
    }
    @Override
    public void showBalance() {
        if (getAmount() >= 0) {
            System.out.println("На вашем счету осталось " + amount + " " + currency);
        } else {
            System.out.println("Задолженность по кредитному счёту составляет " + Math.abs(amount) + " " + currency);
        }
    }
}

/*9.	При вызове public void withdrawCash(int amount) должна проводиться проверка:

не будет ли превышен кредитный лимит после снятия данной суммы.
Если кредитный лимит не будет превышен,

то уменьшить значение amount класса BankAccount на размер amount,
переданной в аргументах и вывести сообщение: "Вы сняли {amount} {currency}".

Если после снятия наличных будет превышен кредитный лимит, вывести сообщение:
"У вас недостаточно средств для снятия суммы {amount} {currency}".*/


//- Ошибка в результатах работы CreditAccount для метода withdrawCash
// при недостаточном количестве средств без превышения лимита


