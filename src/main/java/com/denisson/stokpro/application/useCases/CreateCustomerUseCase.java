package com.denisson.stokpro.application.useCases;

import com.denisson.stokpro.application.repositories.ICustomerRepository;
import com.denisson.stokpro.domain.entities.Customer;

public class CreateCustomerUseCase {

    private final ICustomerRepository repository;

    public CreateCustomerUseCase(ICustomerRepository repository) {
        this.repository = repository;
    }

    public Customer execute(Customer customer) {
        return repository.create(customer);
    }

}
