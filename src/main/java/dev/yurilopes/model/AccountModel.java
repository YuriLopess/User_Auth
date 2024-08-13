package dev.yurilopes.model;

public class AccountModel {

    public boolean validationPassword(String enteredPassword) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{7,}$";
        return enteredPassword.matches(regex);
    }
}
