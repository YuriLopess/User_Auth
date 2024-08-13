package dev.yurilopes.model;

public class AccountModel {

    public boolean validationName(String enteredName) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?!.*\\d)(?!.*[@#$%^&+=!]).*$";
        return enteredName.matches(regex);
    }

    public boolean validationPassword(String enteredPassword) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{7,}$";
        return enteredPassword.matches(regex);
    }
}
