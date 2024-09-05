package com.evengal.registry;

import com.evengal.registry.house.House;
import com.evengal.registry.house.HouseBean;
import com.evengal.registry.house.PropertyType;
import com.evengal.registry.person.Person;
import com.evengal.registry.person.PersonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class RegistryService {

    @Autowired
    PersonBean personBean;

    @Autowired
    HouseBean houseBean;

    public List<Person> findAllPersons() {
        return personBean.findAllPersons();
    }

    public List<House> findAllHouses() {
        return houseBean.findAllHouses();
    }

    public Person addPerson(Person person) {
        return personBean.addPerson(person);
    }

    public House addHouse(House person) {
        return houseBean.addHouse(person);
    }

    public House findHouse(Long id) {
        return houseBean.findHouse(id);
    }

    public List<House> findAllHousesOfType(String type) {
        return houseBean.findAllHousesOfType(type);
    }
}
