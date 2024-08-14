package dev.yurilopes.controller;

import dev.yurilopes.service.EmailService;

import java.util.Scanner;

public class EmailController {

    EmailService emailService = new EmailService();
    Scanner scanner = new Scanner(System.in);

    public void getValidCode() {
        System.out.print("Digite o código informado: ");
        int recebido = scanner.nextInt();

        boolean validation = emailService.verifyCode(recebido);
        while (!validation) {
            System.out.println("Código não reconhecido, por favor digite novamente:");
            recebido = scanner.nextInt();
            validation = emailService.verifyCode(recebido);
        }
    }
}
