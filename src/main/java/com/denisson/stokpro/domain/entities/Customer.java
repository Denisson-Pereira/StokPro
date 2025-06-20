package com.denisson.stokpro.domain.entities;

import com.denisson.stokpro.domain.classes.Email;
import com.denisson.stokpro.domain.classes.Id;
import com.denisson.stokpro.domain.classes.Name;
import com.denisson.stokpro.domain.classes.Password;

public class Customer {
    private Id id;
    private Name name;
    private Email email;
    private Password password;

    public Customer(Id id, Name name, Email email, Password password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Customer(Name name, Email email, Password password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}
