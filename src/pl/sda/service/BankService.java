package pl.sda.service;

import pl.sda.entity.Account;
import pl.sda.exception.IndexValidationException;
import pl.sda.exception.InsufficientBalanceException;
import pl.sda.exception.NegativeAmountException;

import java.util.List;

public class BankService {

    public void payment (List<Account> accounts, double amount, int index) throws IndexValidationException, NegativeAmountException {

        index = index - 1;

        validateIndex(accounts.size(), index);

        accounts.get(index).payment(amount);

    }

    public void withdrawal (List<Account> accounts, double amount, int index) throws IndexValidationException,
            InsufficientBalanceException, NegativeAmountException {

        index = index - 1;

        validateIndex(accounts.size(), index);

        accounts.get(index).withdrawal(amount);

    }

    private void validateIndex(int size, int index) throws IndexValidationException {
        if (index < 0 || index >= size) {
            throw new IndexValidationException("Podano nieprawidłowy index");
        }
    }

}
