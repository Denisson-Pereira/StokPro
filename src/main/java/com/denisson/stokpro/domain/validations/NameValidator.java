package com.denisson.stokpro.domain.validations;

public class NameValidator {

    public static boolean isValidName(String name) {
        if (name == null) return false;
        return name.trim().contains(" ");
    }
}
