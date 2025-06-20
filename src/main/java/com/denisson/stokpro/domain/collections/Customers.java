package com.denisson.stokpro.domain.collections;

import com.denisson.stokpro.domain.entities.Customer;

import java.util.Collections;
import java.util.List;

public class Customers {

    private final List<Customer> items;

    public Customers(List<Customer> items) {
        this.items = items;
    }
}
