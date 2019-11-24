package pl.sda.entity;

import pl.sda.exception.NegativeAmountException;
import pl.sda.exception.insufficientBalanceException;

import java.math.BigDecimal;

public abstract class Account {

    protected String number;
    protected BigDecimal balance;
    protected AccountType type;

    public Account() {
        number = "" + System.nanoTime();
        balance = BigDecimal.ZERO;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void payment(double amount) throws NegativeAmountException {

        if (amount <= 0) {
            throw new NegativeAmountException("Amount cannot be negative or zero");
        }

        balance = balance.add(BigDecimal.valueOf(amount));
    }

    public void withdrawal (double amount) throws NegativeAmountException, insufficientBalanceException {

        if (amount <= 0) {
            throw new NegativeAmountException("Amount cannot be negative or zero");
        }

        if (amount > balance.doubleValue()){
            throw new insufficientBalanceException("Not enough resources to complete the transaction");
        }

        balance = balance.subtract(BigDecimal.valueOf(amount));

    }

    public void transfer (Account targetAccount, double amount) throws NegativeAmountException, insufficientBalanceException {

        withdrawal(amount);
        targetAccount.payment(amount);

    }

}
