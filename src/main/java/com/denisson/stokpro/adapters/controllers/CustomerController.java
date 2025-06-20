package com.denisson.stokpro.adapters.controllers;

import com.denisson.stokpro.adapters.dto.CustomerRequestDTO;
import com.denisson.stokpro.adapters.dto.CustomerResponseDTO;
import com.denisson.stokpro.adapters.mappers.CustomerMapper;
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
    public ResponseEntity<?> create(@RequestBody CustomerRequestDTO dto) {
        try {
            Customer customer = toDomain(dto);
            Customer createdCustomer = createCustomerUseCase.execute(customer);
            CustomerResponseDTO response = CustomerMapper.fromDomain(createdCustomer);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
