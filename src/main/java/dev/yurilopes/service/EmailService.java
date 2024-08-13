package dev.yurilopes.service;

import dev.yurilopes.config.email.EmailConnectionFactory;

public class EmailService {
    public static void main(String[] args) {
        EmailConnectionFactory emailConnectionFactory = new EmailConnectionFactory();

        emailConnectionFactory.sendTestEmail();
    }
}
