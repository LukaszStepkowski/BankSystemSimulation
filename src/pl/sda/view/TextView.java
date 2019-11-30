package pl.sda.view;

import pl.sda.entity.Account;
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

            do {
                System.out.println("Wybierz operację którą chcesz wykonać:");
                System.out.println("0. Zakończ");
                System.out.println("1. Wyświetl wszystkie konta");

                int choice  = scanner.nextInt();

                switch (choice) {
                    case 0: System.exit(0);

                    case 1: {
                        for (Account account : client.getAccounts()){
                            System.out.println("Typ: " + account.getType() + ", numer: " + account.getNumber()
                            + ", stan: " + account.getBalance() + " zł");
                        }
                    } break;

                    default:
                        System.out.println("Poadana wartość jest nieobsługiwana");
                        break;
                }

            } while (true);

        } else {
            System.out.println("Logowanie się nie powiodło");
            System.exit(0);
        }

    }
}
