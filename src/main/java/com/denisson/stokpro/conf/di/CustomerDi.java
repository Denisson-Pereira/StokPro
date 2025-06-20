package com.denisson.stokpro.conf.di;

import com.denisson.stokpro.application.repositories.ICustomerRepository;
import com.denisson.stokpro.application.useCases.CreateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerDi {
    private final ICustomerRepository repository;

    public CustomerDi(ICustomerRepository repository) {
        this.repository = repository;
    }

    @Bean
    public CreateCustomerUseCase createCustomerUseCase() {
        return new CreateCustomerUseCase(repository);
    }

}
