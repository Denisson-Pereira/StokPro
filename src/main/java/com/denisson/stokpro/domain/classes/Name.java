package com.denisson.stokpro.domain.classes;

import com.denisson.stokpro.domain.validations.NameValidator;

public class Name extends ObjectValueAbstraction{

    public Name(String value) {
        super(value);
    }

    @Override
    protected boolean isValid(String value) {
        return NameValidator.isValidName(value);
    }
}
