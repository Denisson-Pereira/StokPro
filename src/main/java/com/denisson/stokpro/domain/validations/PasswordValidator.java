package com.denisson.stokpro.domain.validations;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        if (password == null) return false;
        return password.length() >= 6;
    }
}
