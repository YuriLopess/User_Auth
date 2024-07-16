package dev.yurilopes;

import java.awt.desktop.ScreenSleepEvent;
import java.util.Scanner;

public class Util {

    Scanner scanner = new Scanner(System.in);

    byte showMenu() {
        System.out.println("""
                Escolha sua oção:
                
                1 - Criar conta
                2 - Fazer login
                3 - Sair
                
                Qual a sua opção:""");

        return scanner.nextByte();
    }

    String askForEmail() {
        System.out.println("Digite o email:");
        return scanner.next();
    }

    boolean validationEmail(String enteredEmail) {
        return (enteredEmail.contains("@") && enteredEmail.contains(".com"));
    }

    String getValidEmail() {
        String email = askForEmail();
        boolean status = validationEmail(email);

        while (!status) {
            System.out.println("Tente de novo, email não valido.");
            email = askForEmail();
            status = validationEmail(email);
        }
        return email;
    }

    String askForPassword() {
        System.out.println("Digite a senha:");
        return scanner.next();
    }

    boolean validationPassword(String enteredPassword) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{7,}$";
        return enteredPassword.matches(regex);
    }

    String getValidPassword() {
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
