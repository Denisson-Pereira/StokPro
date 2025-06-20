package com.denisson.stokpro.adapters.mappers;

import com.denisson.stokpro.domain.classes.*;
import com.denisson.stokpro.domain.entities.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
                new Id(rs.getLong("id")),
                new Name(rs.getString("name")),
                new Email(rs.getString("email")),
                new Password(rs.getString("password"))
        );
    }
}
