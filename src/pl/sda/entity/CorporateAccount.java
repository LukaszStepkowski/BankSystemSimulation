package pl.sda.entity;

import pl.sda.exception.NegativeAmountException;
import pl.sda.exception.insufficientBalanceException;

public class CorporateAccount extends Account {

    private double corporateFee = 1.0;

    public CorporateAccount (){
        super();
        type = AccountType.CORPORATE;
    }

    @Override
    public void withdrawal(double amount) throws NegativeAmountException, insufficientBalanceException {
        super.withdrawal(amount + corporateFee);
    }
}