package com.denisson.stokpro.adapters.repositories;

import com.denisson.stokpro.adapters.mappers.CustomerRowMapper;
import com.denisson.stokpro.application.repositories.ICustomerRepository;
import com.denisson.stokpro.domain.classes.Email;
import com.denisson.stokpro.domain.collections.Customers;
import com.denisson.stokpro.domain.entities.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer getByEmail(Email email) {
        String sql = "SELECT * FROM customers WHERE email = ?";
        var results = jdbcTemplate.query(
                sql,
                ps -> ps.setString(1, email.getValue()),
                new CustomerRowMapper()
        );
        return results.isEmpty() ? null : results.get(0);
    }


    @Override
    public Customer create(Customer customer) {
        String sql = "INSERT INTO customers (name, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                sql,
                customer.getName().getValue(),
                customer.getEmail().getValue(),
                customer.getPassword().getValue()
        );
        return getByEmail(customer.getEmail());
    }

    @Override
    public Customers getAll() {
        String sql = "SELECT * FROM customers";
        var results = jdbcTemplate.query(
                sql,
                new CustomerRowMapper()
        );
        return new Customers(results);
    }
}
