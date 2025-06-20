package com.denisson.stokpro.adapters.mappers;

import com.denisson.stokpro.adapters.dto.CustomerRequestDTO;
import com.denisson.stokpro.adapters.dto.CustomerResponseDTO;
import com.denisson.stokpro.domain.classes.Email;
import com.denisson.stokpro.domain.classes.Name;
import com.denisson.stokpro.domain.classes.Password;
import com.denisson.stokpro.domain.entities.Customer;

public class CustomerMapper {
    public static Customer toDomain(CustomerRequestDTO dto) {
        return new Customer(
                new Name(dto.name()),
                new Email(dto.email()),
                new Password(dto.password())
        );
    }

    public static CustomerResponseDTO fromDomain(Customer customer) {
        return new CustomerResponseDTO(
                customer.getId().getValue(),
                customer.getName().getValue(),
                customer.getEmail().getValue(),
                customer.getPassword().getValue()
        );
    }
}
