package com.isudha.bookmyshow.repositories;

import com.isudha.bookmyshow.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TheaterRepo extends JpaRepository<Theater, Long> {
    Optional<Theater> findByNameAndCity_Id(String name, Long id);
}
