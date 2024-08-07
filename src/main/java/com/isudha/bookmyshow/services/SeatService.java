package com.isudha.bookmyshow.services;

import com.isudha.bookmyshow.enums.SeatType;
import com.isudha.bookmyshow.models.Screen;
import com.isudha.bookmyshow.models.Seat;
import com.isudha.bookmyshow.repositories.SeatRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {
    private SeatRepo seatRepo;

    public Seat createSeat(int row, int col, Screen screen, SeatType type){
        Seat seat = Seat
                .builder()
                .rowNum(row)
                .colNum(col)
                .screen(screen)
                .seatType(type)
                .build();

        return seatRepo.save(seat);
    }

    public List<Seat> createSeats(int platinumCount, int goldCount, int economyCount, int cols, Screen screen){
        List<Seat> seats = new ArrayList<>();
        for (int col = 1; col <= cols ; col++) {
            for (int i = 1; i <= economyCount ; i++) {
                seats.add(createSeat(i, col, screen, SeatType.ECONOMY));
            }
            for (int i = economyCount+1; i <= goldCount ; i++) {
                seats.add(createSeat(i, col, screen, SeatType.GOLD));
            }
            for (int i = goldCount+1; i <= platinumCount ; i++) {
                seats.add(createSeat(i, col, screen, SeatType.PLATINUM));
            }
        }
        seatRepo.saveAll(seats);
        return seats;
    }

}
