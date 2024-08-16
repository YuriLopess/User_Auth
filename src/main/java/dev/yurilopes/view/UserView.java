package dev.yurilopes.view;

import dev.yurilopes.controller.AccountController;
import dev.yurilopes.controller.EmailController;
import dev.yurilopes.dao.UserDAO;
import dev.yurilopes.model.UserModel;
import dev.yurilopes.service.EmailService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserView {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AccountController accountController = new AccountController();
        EmailController emailController = new EmailController();
        UserModel user = new UserModel();
        UserDAO userDAO = new UserDAO();
        EmailService emailService = new EmailService();

        byte option = 0;
        byte attempts = 0;
        boolean validMenu;
        String decision;

        System.out.println("---- User Auth ----");

        do {
            validMenu = false;
            while (!validMenu) {
                try {
                    System.out.print("""
                            Escolha sua opção:
                            
                            1 - Criar conta
                            2 - Fazer login
                            3 - Sair
                            
                            Qual a sua opção:""");
                    option = scanner.nextByte();
                    validMenu = true;
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[31mErro: Entrada inválida. Por favor, digite um número.\u001B[0m");  // Mensagem vermelha para erros
                    scanner.next();
                }
            }

            switch (option) {
                default:
                    System.out.println("\u001B[31mOpção inválida. Tente novamente.\u001B[0m");  // Mensagem vermelha para opções inválidas
                    break;

                case 1:
                    user.setName(accountController.getValidName());
                    user.setEmail(accountController.getValidEmail());
                    user.setPassword(accountController.getValidPassword());
                    userDAO.save(user);

                    System.out.println("\u001B[32mEmail cadastrado com sucesso!\u001B[0m");
                    break;

                case 2:
                    System.out.println("Faça o login");
                    String comparisonEmail = accountController.getValidEmail();
                    while (!comparisonEmail.equals(user.getEmail())) {
                        attempts += 1;
                        System.out.println("\u001B[31mEmail não cadastrado. Digite novamente\u001B[0m");
                        comparisonEmail = accountController.getValidEmail();


                        if (attempts >= 3) {
                            System.out.println("Não tem cadastro?[s, n]");
                            decision = scanner.next();
                            if (decision.equals("s")) {
                                attempts = 0;
                                user.setName(accountController.getValidName());
                                user.setEmail(accountController.getValidEmail());
                                user.setPassword(accountController.getValidPassword());
                                userDAO.save(user);
                            }
                        }
                    }

                    attempts = 0;

                    String comparisonPassword = accountController.getValidPassword();
                    while (!comparisonPassword.equals(user.getPassword())) {
                        attempts += 1;
                        System.out.println("\u001B[31mSenha incorreta. Digite novamente\u001B[0m");
                        comparisonPassword = accountController.getValidPassword();

                        if (attempts >= 3) {
                            System.out.println("Esqueceu a senha?[s, n]");
                            decision = scanner.next();
                            if (decision.equals("s")) {
                                attempts = 0;
                                emailService.forgotPassword(user.getEmail());
                            }
                        }
                    }

                    System.out.println("Veficação de 2 etapas: ");

                    emailService.twoSteps(user.getEmail());

                    emailController.getValidCode();

                    System.out.println("\u001B[32mLogin finalizado.\u001B[0m");
                    break;

                case 3:
                    System.out.println("Test - Saindo..");
                    break;
            }

        } while (option != 3);
    }
}