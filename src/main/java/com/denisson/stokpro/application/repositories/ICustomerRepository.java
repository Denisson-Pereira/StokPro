package com.denisson.stokpro.application.repositories;

import com.denisson.stokpro.domain.classes.Email;
import com.denisson.stokpro.domain.classes.Name;
import com.denisson.stokpro.domain.collections.Customers;
import com.denisson.stokpro.domain.entities.Customer;

public interface ICustomerRepository {
    Customer getByEmail(Email email);
    Customer create(Customer customer);
    Customers getAll();
}
