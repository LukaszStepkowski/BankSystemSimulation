package pl.sda.main;

import pl.sda.dao.ClientDAO;
import pl.sda.dao.ClientDAOFile;
import pl.sda.entity.Client;
import pl.sda.entity.CorporateAccount;
import pl.sda.entity.CurrentAccount;
import pl.sda.entity.SavingAccount;
import pl.sda.exception.NegativeAmountException;
import pl.sda.exception.insufficientBalanceException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ClientDAOFileMain {

    public static void main(String[] args) throws IOException, NegativeAmountException, insufficientBalanceException {
        ClientDAO clientDAO = new ClientDAOFile();

//        Client client1 = new Client("Jan", "Kowalski", "12345678912", "jan.kowalski", "password");
//        Client client2 = new Client("Michał", "Nowak", "98765432198", "michal.nowak", "drowssap");
//
//        client1.getAccounts().add(new SavingAccount());
//        client1.getAccounts().add(new CurrentAccount());
//
//        client2.getAccounts().add(new CorporateAccount());
//        client2.getAccounts().add(new CurrentAccount());
//
//        clientDAO.save(Arrays.asList(client1, client2));

        List<Client> clients = clientDAO.get();

//        clients.get(0).getAccounts().get(0).payment(1000);
        clients.get(0).getAccounts().get(0).transfer(clients.get(1).getAccounts().get(0), 500);

        clientDAO.save(clients);
    }

}
