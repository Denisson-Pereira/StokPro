package com.denisson.stokpro.adapters.controllers;

import com.denisson.stokpro.adapters.dto.CustomerRequestDTO;
import com.denisson.stokpro.application.useCases.CreateCustomerUseCase;
import com.denisson.stokpro.domain.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.denisson.stokpro.adapters.mappers.CustomerMapper.toDomain;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    @PostMapping()
    public ResponseEntity<Customer> create(@RequestBody CustomerRequestDTO dto) {
        Customer customer = toDomain(dto);
        Customer createdCustomer = createCustomerUseCase.execute(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }
}
