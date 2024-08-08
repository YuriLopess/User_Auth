package dev.yurilopes.service;


import static dev.yurilopes.config.email.EmailConnectionFactory.sendTestEmail;

public class EmailService {
    public static void main(String[] args) {
        sendTestEmail();
    }

}
