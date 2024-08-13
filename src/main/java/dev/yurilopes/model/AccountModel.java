package dev.yurilopes.model;

public class AccountModel {

    public boolean validationEmail(String enteredEmail) {
        return (enteredEmail.contains("@") && enteredEmail.contains(".com"));
    }

    public boolean validationPassword(String enteredPassword) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{7,}$";
        return enteredPassword.matches(regex);
    }
}
