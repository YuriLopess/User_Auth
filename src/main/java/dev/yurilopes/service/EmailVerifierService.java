package dev.yurilopes.service;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailVerifierService {

    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }
}