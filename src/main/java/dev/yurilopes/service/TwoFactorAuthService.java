package dev.yurilopes.service;

import java.util.Random;
import java.util.Scanner;

import dev.yurilopes.model.UserModel;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

import static dev.yurilopes.config.email.EmailConnectionFactory.createEmail;
import static java.lang.Math.abs;

public class TwoFactorAuthService {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    UserModel user = new UserModel();

    private int code;

    private int generateCode() {
        code = random.nextInt(900000) + 100000;
        return code = abs(code);
    }

    public boolean verifyCode(int emailReceived) {
        return emailReceived == code;
    }

    public void twoSteps(String emailToSend) {
        try {
            Email email = createEmail();
            email.setFrom("y1008880@gmail.com");
            email.setSubject("Verificação de 2 Etapas");
            email.setMsg("Seu código de verificação é " + generateCode() +
                    ". Confirme o código recebido no terminal para continuar");
            email.addTo(emailToSend);
            email.send();
            System.out.println("\u001B[32mEmail enviado!\u001B[0m");
        } catch (EmailException e) {
            throw new RuntimeException(e);
        }
    }

    public void getValidCode() {
        System.out.print("Digite o código informado: ");
        int recebido = scanner.nextInt();

        boolean validation = verifyCode(recebido);
        while (!validation) {
            System.out.println("\u001B[31mCódigo não reconhecido, por favor digite novamente:\u001B[0m");
            recebido = scanner.nextInt();
            validation = verifyCode(recebido);
        }
    }
}
