package pl.sda.entity;

import pl.sda.exception.NegativeAmountException;
import pl.sda.exception.InsufficientBalanceException;

import java.math.BigDecimal;

public class CorporateAccount extends Account {

    private double corporateFee = 1.0;

    public CorporateAccount (){
        super();
        type = AccountType.CORPORATE;
    }

    public CorporateAccount(String number, BigDecimal balance) {
        super(number, balance);
        type = AccountType.CORPORATE;
    }

    public double getCorporateFee() {
        return corporateFee;
    }

    @Override
    public void withdrawal(double amount) throws NegativeAmountException, InsufficientBalanceException {
        super.withdrawal(amount + corporateFee);
    }
}
