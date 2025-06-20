package com.denisson.stokpro.domain.validations;

public class IdValidator {

    public static boolean isValidId(Long id) {
        return id != null && id > 0;
    }
}
