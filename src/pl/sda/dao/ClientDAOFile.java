package pl.sda.dao;

import pl.sda.entity.Account;
import pl.sda.entity.Client;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ClientDAOFile implements ClientDAO {

    public static final String FILE_NAME = "clients.txt";
    public static final String CLIENT = "CLIENT";
    public static final char COMMA = ',';

    @Override
    public void save(List<Client> clients) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

        for (Client client : clients){
            bw.write(getClientLine(client));
            bw.newLine();
            for (Account account : client.getAccounts()){
                bw.write(getAccountLine(account));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();

    }

    @Override
    public List<Client> get() {
        return null;
    }

    private String getClientLine (Client client){
        StringBuilder sb = new StringBuilder();
        sb
                .append(CLIENT)
                .append(COMMA)
                .append(client.getName())
                .append(COMMA)
                .append(client.getSurname())
                .append(COMMA)
                .append(client.getPesel())
                .append(COMMA)
                .append(client.getLogin())
                .append(COMMA)
                .append(client.getPassword());

        return sb.toString();
    }

    private String getAccountLine (Account account) {
        return new StringBuilder()
                .append(account.getType().toString())
                .append(COMMA)
                .append(account.getBalance())
                .append(COMMA)
                .append(account.getNumber())
                .toString();
    }
}
