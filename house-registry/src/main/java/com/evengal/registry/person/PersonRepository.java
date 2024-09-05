package com.evengal.registry.person;

import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface PersonRepository extends ListCrudRepository<Person, Integer> {

    Optional<Person> findByName(String name);
}
