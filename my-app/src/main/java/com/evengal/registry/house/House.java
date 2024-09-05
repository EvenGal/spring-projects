package com.evengal.registry.house;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public record House(
        @Id
        Long id,
        @NotEmpty
        String address,
        @NotEmpty
        PropertyType type
) {
}
