package pl.sda.service;

import pl.sda.entity.Account;
import pl.sda.exception.IndexValidationException;
import pl.sda.exception.NegativeAmountException;

import java.util.List;

public class BankService {

    public void payment (List<Account> accounts, double amount, int index) throws IndexValidationException, NegativeAmountException {

        index = index - 1;

        if (index < 0 || index >= accounts.size()){
            throw new IndexValidationException("Podano nieprawidłowy indeks.");
        }

        accounts.get(index).payment(amount);

    }

}
