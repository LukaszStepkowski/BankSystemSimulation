package pl.sda.main;

import pl.sda.dao.ClientDAO;
import pl.sda.dao.ClientDAOFile;
import pl.sda.entity.Client;
import pl.sda.exception.NegativeAmountException;
import pl.sda.exception.InsufficientBalanceException;

import java.io.IOException;
import java.util.List;

public class ClientDAOFileMain2 {
    public static void main(String[] args) throws IOException, NegativeAmountException, InsufficientBalanceException {

        ClientDAO clientDAO = new ClientDAOFile();

        List<Client> clients = clientDAO.get();

        clients.get(0).getAccounts().get(0).payment(1000);
        clients.get(0).getAccounts().get(0).transfer(clients.get(1).getAccounts().get(0), 500);

        clientDAO.save(clients);

    }
}
