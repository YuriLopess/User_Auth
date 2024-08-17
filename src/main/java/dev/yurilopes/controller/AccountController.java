package dev.yurilopes.controller;

import dev.yurilopes.model.AccountModel;
import dev.yurilopes.service.EmailVerifierService;

import java.util.Scanner;

public class AccountController {

    Scanner scanner = new Scanner(System.in);
    AccountModel accountModel = new AccountModel();

    private String askForName() {
        System.out.print("Digite o seu nome:");
        return scanner.next();
    }

    public String getValidName() {
        String name = askForName();
        boolean status = accountModel.validationName(name);

        while (!status) {
            System.out.println("\u001B[31mTente de novo, nome não valido.\u001B[0m");
            name = askForName();
            status = accountModel.validationName(name);
        }
        return name;
    }

    private String askForEmail() {
        System.out.print("Digite o email:");
        return scanner.next();
    }

    public String getValidEmail() {
        String email = askForEmail();
        boolean status = EmailVerifierService.isValidEmail(email);

        while (!status) {
            System.out.println("\u001B[31mTente de novo, email não valido.\u001B[0m");
            email = askForEmail();
            status = EmailVerifierService.isValidEmail(email);
        }
        return email;
    }

    private String askForPassword() {
        System.out.print("Digite a senha:");
        return scanner.next();
    }

    public String getValidPassword() {
        String password = askForPassword();
        boolean status = accountModel.validationPassword(password);

        while (!status) {
            System.out.println("\u001B[31mTente de novo, senha não valida\u001B[0m");
            password = askForPassword();
            status = accountModel.validationPassword(password);
        }
        return password;
    }

}
