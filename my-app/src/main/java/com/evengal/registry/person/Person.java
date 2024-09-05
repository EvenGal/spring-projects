package com.evengal.registry.person;


import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public record Person(
        @Id
        Long id,
        @NotEmpty
        String name,
        int age,
        @NotEmpty
        String gender,
        @NotEmpty
        String email
) {
}
