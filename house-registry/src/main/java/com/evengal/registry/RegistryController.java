package com.evengal.registry;

import com.evengal.registry.house.House;
import com.evengal.registry.person.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registry")
public class RegistryController {

    private static final Logger log = LoggerFactory.getLogger(RegistryController.class);

    @Autowired
    RegistryService registryService;

    @GetMapping(value = "/houses", produces = "application/json")
    public List<House> getAllHouses(@RequestParam(name = "type", required = false) String type) {
        if (type != null) {
            type = type.toUpperCase().replaceAll("[\"']", "");
            return registryService.findAllHousesOfType(type);
        }
        return registryService.findAllHouses();
    }

    @GetMapping(value = "/houses/{id}", produces = "application/json")
    public House getHouse(@PathVariable("id") Long id) {
        return registryService.findHouse(id);
    }

    @GetMapping(value = "/persons", produces = "application/json")
    public List<Person> getAllPersons() {
        return registryService.findAllPersons();
    }

    @PostMapping(value = "/persons", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody @Validated Person person) {
        return registryService.addPerson(person);
    }

    @PostMapping(value = "/houses", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public House addHouse(@RequestBody @Validated House house) {
        return registryService.addHouse(house);
    }
}
