package dev.yurilopes.service;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

import java.util.Random;

import static dev.yurilopes.config.email.EmailConnectionFactory.createEmail;
import static java.lang.Math.abs;

public class EmailService {

    Random random = new Random();

    private int currentCode;

    private int generateCode() {
        int code = 0;
        for (int i = 0; i <= 5; i++) {
            code = random.nextInt() ;
        }
        return currentCode = abs(code);
    }

    public boolean verifyCode(int emailReceived) {
        return emailReceived == currentCode;
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
            System.out.println("Email enviado");
        } catch (EmailException e) {
            throw new RuntimeException(e);
        }
    }
}