package pl.sda.dao;

import pl.sda.entity.Client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ClientDAO {

    void save(List<Client> clients) throws IOException;

    List<Client> get() throws IOException;

}
