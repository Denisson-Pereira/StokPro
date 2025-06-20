package com.denisson.stokpro.adapters.controllers;

import com.denisson.stokpro.adapters.dto.CustomerRequestDTO;
import com.denisson.stokpro.adapters.dto.CustomerResponseDTO;
import com.denisson.stokpro.adapters.mappers.CustomerMapper;
import com.denisson.stokpro.application.useCases.CreateCustomerUseCase;
import com.denisson.stokpro.application.useCases.GetAllCustomersUseCase;
import com.denisson.stokpro.domain.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.denisson.stokpro.adapters.mappers.CustomerMapper.toDomain;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final GetAllCustomersUseCase getAllCustomersUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase, GetAllCustomersUseCase getAllCustomersUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.getAllCustomersUseCase = getAllCustomersUseCase;
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(CustomerMapper.fromDomainList(getAllCustomersUseCase.execute()));
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
