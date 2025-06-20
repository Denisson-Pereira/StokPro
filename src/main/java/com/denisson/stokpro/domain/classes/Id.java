package com.denisson.stokpro.domain.classes;

import com.denisson.stokpro.domain.validations.IdValidator;

public class Id {

    private final Long id;

    public Id(Long id) {
        idValidation(id);
        this.id = id;
    }

    private void idValidation(Long id) {
        if (!IdValidator.isValidId(id)) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }

    public Long getValue() {
        return id;
    }
}
