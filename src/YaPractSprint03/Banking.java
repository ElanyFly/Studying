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

    public String getCurrency() {           //ADDED
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void replenishBalance(int amount) {
        this.amount += amount;
    }


    public void withdrawCash(int amount) {
        this.amount -= amount;
    }


    public void showBalance() {

        System.out.println("На вашем счету осталось " + amount + " " + currency);
    }
}

class DebitAccount extends BankAccount {
    public DebitAccount(int amount, String currency) {
        if (amount >= 0) {

            setAmount(amount);
            setCurrency(currency);
        } else {
            System.out.println("Баланс дебетового счета не может быть меньше 0");
        }
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
    }

    @Override
    public void showBalance() {
        // вывести сообщение "На вашем счету осталось {amount} {currency}"
        System.out.println("На вашем счету осталось " + amount + " " + currency);

    }
}

class CreditAccount extends BankAccount {
    private int creditLimit;

    public int getCreditLimit() {       //ADDED
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    CreditAccount(int amount, String currency, int creditLimit) {
        setAmount(amount);
        setCurrency(currency);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdrawCash(int amount) {
        int realLimit = creditLimit + getAmount();
        if (realLimit >= amount) {
            int takenAmount = getAmount() - amount;
            setAmount(takenAmount);
            System.out.println("Вы сняли " + amount + " " + currency);
        } else {
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

class Bank {


    private int checkCreditLimit(String currency) {
        int limitChecked;
        switch (currency) {
            case "RUB":
                return limitChecked = 100000;
            case "USD":
                return limitChecked = 1250;
            case "EUR":
                return limitChecked = 1000;
            default:
                return limitChecked = 0;
        }
    }

    public BankAccount createNewAccount(String bankAccount, String currency) {
        switch (bankAccount) {
            case "debit_account":
                System.out.println("Ваш дебетовый счёт создан");
                return new DebitAccount(0, currency);
            case "credit_account":
                int limit = checkCreditLimit(currency);
                System.out.println("Кредитный счёт создан. Ваш лимит по счёту " + limit + " " + currency);
                return new CreditAccount(0, currency, limit);
            default:
                System.out.println("Неверно указан тип создаваемого счёта");
                return new BankAccount();
        }
    }

    public void closeAccount(BankAccount bankAccount) {
        int amountLeft = bankAccount.getAmount();
        if (bankAccount instanceof DebitAccount) {   //true false
            if (amountLeft > 0) {
                System.out.println("Ваш дебетовый счёт закрыт. " +
                        "Вы можете получить остаток по вашему счёту в размере " + amountLeft + " "
                        + bankAccount.getCurrency() +
                        " в отделении банка");
            } else {
                System.out.println("Ваш дебетовый счёт закрыт");
            }
        } else if (bankAccount instanceof CreditAccount) {
            if (amountLeft > 0) {
                System.out.println("Ваш кредитный счёт закрыт. Вы можете получить остаток по вашему счёту " +
                        "в размере " + amountLeft + " " +
                        bankAccount.getCurrency() + " в отделении банка");
            } else if (amountLeft < 0) {
                System.out.println("Вы не можете закрыть кредитный счёт, потому что на нём есть задолженность. " +
                        "Задолженность по счёту составляет " + amountLeft + " " +
                        bankAccount.getCurrency());
            } else {
                System.out.println("Ваш кредитный счёт закрыт");
            }

        } else {
            System.out.println("Пока что мы не можем закрыть данный вид счёта");
        }

    }
    // создать метод createNewAccount, который принимает на вход строку с типом аккаунта
    // и строку с создаваемой валютой


    // если тип "debit_account"
    // вывести сообщение "Ваш дебетовый счет создан"
    // создать дебетовый аккаунт в выбранной валюте и с нулевым балансом


    // если тип "credit_account"
    // посчитать кредитный лимит в зависимости от валюты
    // вывести сообщение "Кредитный счет создан. Ваш лимит по счету {limit} {currency}"
    // создать кредитный аккаунт в выборанной валюты и с посчитанным кредитным лимитом

    // иначе
    // вывести сообщение "Неверно указа тип создаваемого счета"
    // создать пустой объект BankAccount()

    // создать метод closeAccount, который принимает на вход переменную типа BankAccount
    // если переданный аккаунт дебетовый
    // если на счету нет денег вывести сообщение "Ваш дебетовый счет закрыт"
    // иначе вывести сообщение "Ваш дебетовый счет закрыт. Вы можете получить остаток по вашему счету
    // в размере {amount} {currency} в отделении банка"


    // если переданный аккаунт кредитный
    // если на счету нет денег вывести сообщение "Ваш кредитный счет закрыт"

    // если на счету положительный баланс вывести сообщение "Ваш кредитный счет закрыт.
    // Вы можете получить остаток по вашему счету в размере {amount} {currency} в отделении банка"
    // если на счету отрицательный баланс вывести сообщение
    // "Вы не можете закрыть кредитный счет потому как на нем еще есть задолженность.
    // Ваша задолженность по счету составляет {amount} {currency}"

    // иначе вывести сообщение "Пока что мы не можем закрыть данный вид счета"
}




