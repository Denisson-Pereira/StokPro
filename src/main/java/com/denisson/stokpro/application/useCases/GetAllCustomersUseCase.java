package com.denisson.stokpro.application.useCases;

import com.denisson.stokpro.application.repositories.ICustomerRepository;
import com.denisson.stokpro.domain.collections.Customers;

public class GetAllCustomersUseCase {

    private final ICustomerRepository repository;

    public GetAllCustomersUseCase(ICustomerRepository repository) {
        this.repository = repository;
    }

    public Customers execute() {
        return repository.getAll();
    }
}
