package com.denisson.stokpro.domain.validations;

public class EmailValidator {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.matches(EMAIL_REGEX);
    }

}