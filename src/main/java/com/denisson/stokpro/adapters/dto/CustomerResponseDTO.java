package com.denisson.stokpro.adapters.dto;

public record CustomerResponseDTO(
        Long id,
        String name,
        String email,
        String password
) {}
