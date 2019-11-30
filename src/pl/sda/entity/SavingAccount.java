package pl.sda.entity;

import pl.sda.exception.NegativeAmountException;

import java.math.BigDecimal;

public class SavingAccount extends Account {

    private double savingFactor = 1.01;

    public SavingAccount (){
        super();
        type = AccountType.SAVING;
    }

    public SavingAccount(String number, BigDecimal balance) {
        super(number, balance);
        type = AccountType.SAVING;
    }

    public double getSavingFactor() {
        return savingFactor;
    }

    @Override
    public void payment(double amount) throws NegativeAmountException {
        super.payment(amount * savingFactor);
    }
}
