package dev.yurilopes.service;

import dev.yurilopes.model.UserModel;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;

import static dev.yurilopes.config.email.EmailConnectionFactory.createEmail;

public class PasswordRecoveryService {

    UserModel user = new UserModel();

    public void forgotPassword(String emailToSend) {
        try {
            Email email = createEmail();
            email.setFrom("y1008880@gmail.com");
            email.setSubject("Reecuperação de Senha");
            email.setMsg("A senha de cadastro do " + user.getName() + "é: " + user.getPassword() + ".");
            email.addTo(emailToSend);
            System.out.println("Email enviado");
        } catch (EmailException e) {
            throw new RuntimeException(e);
        }
    }
}
