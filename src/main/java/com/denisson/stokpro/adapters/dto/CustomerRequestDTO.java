package com.denisson.stokpro.adapters.dto;

public record CustomerRequestDTO(
        String name,
        String email,
        String password
) {}
