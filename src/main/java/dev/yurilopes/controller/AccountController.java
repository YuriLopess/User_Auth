package dev.yurilopes.controller;

import dev.yurilopes.model.AccountModel;

import java.util.Scanner;

public class AccountController {

    Scanner scanner = new Scanner(System.in);
    AccountModel accountModel = new AccountModel();

    public String askForEmail() {
        System.out.println("Digite o email:");
        return scanner.next();
    }

    public String getValidEmail() {
        String email = askForEmail();
        boolean status = accountModel.validationEmail(email);

        while (!status) {
            System.out.println("Tente de novo, email não valido.");
            email = askForEmail();
            status = accountModel.validationEmail(email);
        }
        return email;
    }

    public String askForPassword() {
        System.out.println("Digite a senha:");
        return scanner.next();
    }

    public String getValidPassword() {
        String password = askForPassword();
        boolean status = accountModel.validationPassword(password);

        while (!status) {
            System.out.println("Tente de novo, senha não valida");
            password = askForPassword();
            status = accountModel.validationPassword(password);
        }
        return password;
    }
}
