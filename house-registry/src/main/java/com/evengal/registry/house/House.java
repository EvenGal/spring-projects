package com.evengal.registry.house;

import com.evengal.registry.person.Person;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("House")
public record House(
        @Id
        Long id,
        @NotEmpty
        String address,
        @NotEmpty @Column("type")
        PropertyType type,
        @MappedCollection(idColumn = "house_id")
        List<Person> residents
) {
}
