package dev.yurilopes;

import java.util.Scanner;

public class Util {

    Scanner scanner = new Scanner(System.in);

    public String askForEmail() {
        System.out.println("Digite o email:");
        return scanner.next();
    }

    public boolean validationEmail(String enteredEmail) {
        return (enteredEmail.contains("@") && enteredEmail.contains(".com"));
    }

    public String getValidEmail() {
        String email = askForEmail();
        boolean status = validationEmail(email);

        while (!status) {
            System.out.println("Tente de novo, email não valido.");
            email = askForEmail();
            status = validationEmail(email);
        }
        return email;
    }

    public String askForPassword() {
        System.out.println("Digite a senha:");
        return scanner.next();
    }

    public boolean validationPassword(String enteredPassword) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{7,}$";
        return enteredPassword.matches(regex);
    }

    public String getValidPassword() {
        String password = askForPassword();
        boolean status = validationPassword(password);

        while (!status) {
            System.out.println("Tente de novo, senha não valida");
            password = askForPassword();
            status = validationPassword(password);
        }
        return password;
    }
}
