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

        byte option = 0;
        boolean validMenu;

        String email = null;
        String password = null;

        do {
            validMenu = false;
            while (!validMenu) {
                try {
                    System.out.println("""
                            Escolha sua opção:
                            
                            1 - Criar conta
                            2 - Fazer login
                            3 - Sair
                            
                            Qual a sua opção:""");
                    option = scanner.nextByte();
                    validMenu = true;
                } catch (InputMismatchException e) {
                    System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                    scanner.next(); // Limpa o buffer de entrada
                }
            }

            switch (option) {
                default:
                    System.out.println("nenhum");
                    break;

                case 1:
                    email = util.getValidEmail();
                    password = util.getValidPassword();

                    users.put(email, password);
                    System.out.println("Email cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Faça o login");
                    String comparisonEmail = util.getValidEmail();
                    while (!comparisonEmail.equals(email)) {
                        System.out.println("Email não cadastrado. Digite novamente");
                        comparisonEmail = util.getValidEmail();
                    }

                    String comparisonPassword = util.getValidPassword();
                    while (!comparisonPassword.equals(password)) {
                        System.out.println("Senha incorreta. Digite novamente");
                        comparisonPassword = util.getValidPassword();
                    }

                    System.out.println("Login finalizado.");
                    break;

                case 3:
                    System.out.println("Test - Saindo..");
                    break;
            }

        } while (option != 3);

    }
}