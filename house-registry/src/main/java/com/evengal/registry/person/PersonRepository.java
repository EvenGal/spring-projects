package com.evengal.registry.person;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends ListCrudRepository<Person, Integer> {

    Optional<Person> findByName(String name);

    @Query("SELECT * FROM Person WHERE house_id = :id")
    List<Person> findAllResidentsOfAHouse(Long id);
}
