package pl.sda.view;

import pl.sda.entity.Client;
import pl.sda.service.LoginService;

import java.util.Scanner;

public class TextView {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();

        Client client = null;

        System.out.println("Podaj login:");
        String login = scanner.next();

        System.out.println("Podaj hasło:");
        String password = scanner.next();

        if (loginService.isAuthenticated(login, password)){
            client = loginService.getClientByLoginAndPassword(login, password);

            System.out.println("Logowanie udane");

        } else {
            System.out.println("Logowanie się nie powiodło");
            System.exit(0);
        }

    }
}
