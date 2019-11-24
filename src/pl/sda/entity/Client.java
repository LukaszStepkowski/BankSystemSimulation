package pl.sda.entity;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private String surname;
    private String pesel;
    private String login;
    private String password;

    private List<Account> accounts;

    public Client(String name, String surname, String pesel, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.login = login;
        this.password = password;
        this.accounts = new ArrayList<>();
        this.accounts.add(new CurrentAccount());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
