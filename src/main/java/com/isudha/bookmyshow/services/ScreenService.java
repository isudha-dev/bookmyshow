package com.isudha.bookmyshow.services;

import com.isudha.bookmyshow.dtos.CreateScreenDto;
import com.isudha.bookmyshow.exceptions.ScreenAlreadyExists;
import com.isudha.bookmyshow.exceptions.ScreenNotFound;
import com.isudha.bookmyshow.models.Screen;
import com.isudha.bookmyshow.models.Seat;
import com.isudha.bookmyshow.models.Theater;
import com.isudha.bookmyshow.repositories.ScreenRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class ScreenService {
    private ScreenRepo screenRepo;
    private TheaterService theaterService;
    private SeatService seatService;

    public List<Screen> getAllScreensByTheaterId(Long theaterId) {
        return screenRepo.findAllByTheater_Id(theaterId).orElseThrow(() -> new ScreenNotFound());
    }

    public Screen getScreenById(Long id){
        return screenRepo.findById(id).orElseThrow(() -> new ScreenNotFound());
    }

    public Screen createScreen(CreateScreenDto requestDto) {
        Optional<Screen> existingScreen = screenRepo.findByNumberAndTheater_Id(requestDto.getNumber(), requestDto.getTheaterId());
        if (existingScreen.isPresent()){
            throw new ScreenAlreadyExists();
        }

        Theater theater = theaterService.getTheaterById(requestDto.getTheaterId());
        Screen screen = requestDto.toScreen(theater);
        screenRepo.save(screen);
        List<Seat> seats = seatService.createSeats(
                requestDto.getPlatinumCount(),
                requestDto.getGoldCount(),
                requestDto.getEconomyCount(),
                requestDto.getCols(),
                screen);
        screen.addSeats(seats);
        return screenRepo.findById(screen.getId()).get();
    }


}
