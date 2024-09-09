package com.evengal.registry.person;

import com.evengal.exceptions.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Component
@ApplicationScope
public class PersonBean {

    @Autowired
    private final PersonRepository personRepository;

    public PersonBean(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAllPersons() {
        List<Person> persons = personRepository.findAll();
        if (persons.isEmpty()) {
            throw new NoContentException("No persons found");
        }
        return persons;
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAllResidentsOfAHouse(Long id) {
        return personRepository.findAllResidentsOfAHouse(id);
    }
}
