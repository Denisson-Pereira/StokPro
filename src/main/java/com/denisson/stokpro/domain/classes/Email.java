package com.denisson.stokpro.domain.classes;

import com.denisson.stokpro.domain.validations.EmailValidator;

public class Email extends ObjectValueAbstraction{

    public Email(String value) {
        super(value);
    }

    @Override
    protected boolean isValid(String value) {
        return EmailValidator.isValidEmail(value);
    }
}
