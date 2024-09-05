package com.evengal.registry.house;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HouseRepository extends ListCrudRepository<House, Long> {

    @Query(value = """
            SELECT * FROM House WHERE type = CAST(:type AS property_type)
            """)
    List<House> findByType(@Param("type") String type);

    Optional<House> findById(Long id);

}
