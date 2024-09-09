package com.evengal.registry.person;


import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Person")
public record Person(
        @Id
        Long id,
        @NotEmpty
        String name,
        int age,
        @NotEmpty
        String gender,
        @NotEmpty
        String email,
        @Column("house_id")
        Long house_id
) {
}
