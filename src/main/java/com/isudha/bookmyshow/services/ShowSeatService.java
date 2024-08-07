package com.isudha.bookmyshow.services;

import com.isudha.bookmyshow.models.ShowSeat;
import com.isudha.bookmyshow.repositories.ShowSeatRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowSeatService {
    private ShowSeatRepo showSeatRepo;

    public List<ShowSeat> saveAll(List<ShowSeat> seats){
        return showSeatRepo.saveAll(seats);
    }

    public List<ShowSeat> findAllByShowSeatIds(List<Long> showSeatIds){
        return showSeatRepo.findAllById(showSeatIds);
    }
}
