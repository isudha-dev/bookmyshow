package com.isudha.bookmyshow.repositories;

import com.isudha.bookmyshow.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {

    public Optional<City> findByName(String name);

}
