package com.denisson.stokpro.domain.classes;

public abstract class ObjectValueAbstraction {

    private final String value;

    public ObjectValueAbstraction(String value) {
        validation(value);
        this.value = value;
    }

    protected abstract boolean isValid(String value);

    private void validation(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException(String.format("%s is not valid.", value));
        }
    }

    public String getValue() {
        return value;
    }
}
