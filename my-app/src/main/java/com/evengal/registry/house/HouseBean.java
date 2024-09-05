package com.evengal.registry.house;

import com.evengal.exceptions.NoContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.Optional;

@Component
@ApplicationScope
public class HouseBean {

    @Autowired
    private final HouseRepository houseRepository;

    public HouseBean(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<House> findAllHouses() {
        List<House> houses = houseRepository.findAll();
        if (houses.isEmpty()) {
            throw new NoContentException("No houses found");
        }
        return houses;
    }

    public House addHouse(House house) {
        return houseRepository.save(house);
    }

    public House findHouse(Long id) {
        Optional<House> house = houseRepository.findById(id);
        if (house.isEmpty()) throw new NoContentException("House not found for ID: " + id);
        return house.get();
    }

    public List<House> findAllHousesOfType(String type) {
        List<House> houses = houseRepository.findByType(type);
        if (houses.isEmpty()) throw new NoContentException("No houses found for type: " + type);
        return houses;
    }
}
