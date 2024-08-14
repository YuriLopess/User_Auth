package dev.yurilopes.config.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EmailConnectionFactory {

    private static Properties loadProperties() {
        Properties props = new Properties();
        try (InputStream input = EmailConnectionFactory.class.getClassLoader().getResourceAsStream("email.properties")) {
            if (input == null) {
                throw new IOException("Properties file not found");
            }
            props.load(input);
        } catch (IOException e) {
            System.out.println("Erro ao carregar propriedades: " + e.getMessage());
        }
        return props;
    }

    public static Email createEmail() throws EmailException {
        Properties props = loadProperties();
        String host = props.getProperty("mail.host");
        int port = Integer.parseInt(props.getProperty("mail.port"));
        String user = props.getProperty("mail.username");
        String password = props.getProperty("mail.password");

        HtmlEmail email = new HtmlEmail();
        email.setHostName(host);
        email.setSmtpPort(port);
        email.setAuthenticator(new DefaultAuthenticator(user, password));
        email.setSSLOnConnect(true);

        return email;
    }
}