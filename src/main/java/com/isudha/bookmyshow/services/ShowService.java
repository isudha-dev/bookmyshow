package com.isudha.bookmyshow.services;

import com.isudha.bookmyshow.dtos.CreateShowDto;
import com.isudha.bookmyshow.enums.SeatStatus;
import com.isudha.bookmyshow.exceptions.ShowNotFound;
import com.isudha.bookmyshow.models.*;
import com.isudha.bookmyshow.repositories.ShowRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@Service
public class ShowService {
    private ShowRepo showRepo;
    private MovieService movieService;
    private ScreenService screenService;
    private ShowSeatService showSeatService;

    public Show getShowById(Long id){
        return showRepo.findById(id).orElseThrow(() -> new ShowNotFound());
    }

    public Show createShow(CreateShowDto reqDto){
        Movie movie = movieService.getMovieById(reqDto.getMovieId());
        Screen screen = screenService.getScreenById(reqDto.getScreenId());

        Show show = Show
                .builder()
                .movie(movie)
                .screen(screen)
                .startTime(reqDto.getDateTime())
                .build();

        Show savedShow = showRepo.save(show);

        List<Seat> seats = screen.getSeats();
        List<ShowSeat> showSeats = seats
                .stream()
                .map( seat -> ShowSeat
                        .builder()
                        .show(savedShow)
                        .seatStatus(SeatStatus.AVAILABLE)
                        .seat(seat)
                        .build())
                .collect(Collectors.toList());

        showSeatService.saveAll(showSeats);
        savedShow.setShowSeats(showSeats);

        return showRepo.save(savedShow);
    }
}
