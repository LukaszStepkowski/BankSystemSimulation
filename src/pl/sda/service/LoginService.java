package pl.sda.service;

import pl.sda.dao.ClientDAO;
import pl.sda.dao.ClientDAOFile;
import pl.sda.entity.Client;

import java.io.IOException;
import java.util.List;

public class LoginService {

    private ClientDAO clientDAO = new ClientDAOFile();

    public boolean isAuthenticated(String login, String password) {

        List<Client> clients;

        try {
            clients = clientDAO.get();
        } catch (IOException e) {
            return false;
        }

        for(Client client : clients){

            if (client.getLogin().equals(login) && client.getPassword().equals(password)){
                return true;
            }

        }

        return false;
    }

    public Client getClientByLoginAndPassword (String login, String password){

        List<Client> clients;

        try {
            clients = clientDAO.get();
        } catch (IOException e) {
            return null;
        }

        return clients.stream()
                .filter(c -> c.getLogin().equals(login) && c.getPassword().equals(password))
                .findFirst()
                .get();

    }

}
