package pl.sda.service;

import pl.sda.dao.ClientDAO;
import pl.sda.dao.ClientDAOFile;
import pl.sda.entity.Account;
import pl.sda.entity.Client;
import pl.sda.exception.IndexValidationException;
import pl.sda.exception.InsufficientBalanceException;
import pl.sda.exception.InvalidAccountNumberException;
import pl.sda.exception.NegativeAmountException;

import java.io.IOException;
import java.util.List;

public class BankService {

    private List<Client> clients;
    private ClientDAO clientDAO;

    public BankService() throws IOException {
        clientDAO = new ClientDAOFile();
        clients = clientDAO.get();
    }

    public List<Client> get() {
        return clients;
    }

    public void save() throws IOException {
        clientDAO.save(clients);
    }

    public void payment(List<Account> accounts, double amount, int index) throws IndexValidationException, NegativeAmountException {

        index = index - 1;

        validateIndex(accounts.size(), index);

        accounts.get(index).payment(amount);

    }

    public void withdrawal(List<Account> accounts, double amount, int index) throws IndexValidationException,
            InsufficientBalanceException, NegativeAmountException {

        index = index - 1;

        validateIndex(accounts.size(), index);

        accounts.get(index).withdrawal(amount);

    }

    public void transfer(List<Account> accounts, double amount, int index, String targetAccount) throws InvalidAccountNumberException,
            IndexValidationException, InsufficientBalanceException, NegativeAmountException {

        index = index - 1;

        validateIndex(accounts.size(), index);

        Account destinationAccount = getAccountByNumber(targetAccount);

        accounts.get(index).transfer(destinationAccount, amount);

    }

    private Account getAccountByNumber(String targetAccount) throws InvalidAccountNumberException {

        return clients.stream()
                .map(c -> c.getAccounts())
                .flatMap(a -> a.stream())
                .filter(a -> a.getNumber().endsWith(targetAccount))
                .findFirst()
                .orElseThrow(() -> new InvalidAccountNumberException("Invalid account number"));

    }

    private void validateIndex(int size, int index) throws IndexValidationException {
        if (index < 0 || index >= size) {
            throw new IndexValidationException("Podano nieprawidłowy index");
        }
    }

}
