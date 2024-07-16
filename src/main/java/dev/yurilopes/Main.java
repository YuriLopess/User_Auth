package dev.yurilopes;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Util util = new Util();
        Map<String, String> users = new HashMap<>();

        byte option;
        boolean status;

        try {

            do {
                option = util.showMenu();

                switch (option) {

                    default:
                        System.out.println("nenhum");

                    case 1 :

                        String email = util.getValidEmail();
                        String password = util.getValidPassword();

                        users.put(email, password);
                        System.out.println("Email cadastrado com sucesso!");
                        break;

                    case 2:

                        break;

                    case 3:
                        System.out.println("Test - Saindo..");
                        break;
                }

            } while (option != 3);

        } catch (InputMismatchException e) {
            System.out.println("erro");
        }
    }
}