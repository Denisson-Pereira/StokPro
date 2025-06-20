package com.denisson.stokpro.domain.classes;

import com.denisson.stokpro.domain.validations.PasswordValidator;

public class Password extends ObjectValueAbstraction{

    public Password(String value) {
        super(value);
    }

    @Override
    protected boolean isValid(String value) {
        return PasswordValidator.isValidPassword(value);
    }
}
