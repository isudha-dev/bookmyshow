package com.isudha.bookmyshow.repositories;

import com.isudha.bookmyshow.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScreenRepo extends JpaRepository<Screen, Long> {

    Optional<List<Screen>> findAllByTheater_Id(Long theaterId);
    Optional<Screen> findByNumberAndTheater_Id(int num, Long id);
}
