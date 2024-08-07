package com.isudha.bookmyshow.services;

import com.isudha.bookmyshow.dtos.CreateBookingDto;
import com.isudha.bookmyshow.enums.BookingStatus;
import com.isudha.bookmyshow.enums.SeatStatus;
import com.isudha.bookmyshow.models.Booking;
import com.isudha.bookmyshow.models.Customer;
import com.isudha.bookmyshow.models.Show;
import com.isudha.bookmyshow.models.ShowSeat;
import com.isudha.bookmyshow.repositories.BookingRepo;
import com.isudha.bookmyshow.strategies.PricingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
    private BookingRepo bookingRepo;
    private ShowSeatService showSeatService;
    private CustomerService customerService;
    private ShowService showService;
    private PricingStrategy pricingStrategy;

    public Booking getBookingById(Long id){
        return bookingRepo.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking createBooking(CreateBookingDto reqDto){
        // fetch customer
        Customer customer = customerService.getCustomerById(reqDto.getCustomerId());
        Show show = showService.getShowById(reqDto.getShowId());
        List<Long> showSeatIds = reqDto.getShowSeatIds();

        // check if seats available and lock them
        List<ShowSeat> savedShowSeats = lockShowSeats(reqDto.getShowSeatIds());

        // create booking
        Booking newBooking = Booking
                .builder()
                .customer(customer)
                .show(show)
                .showSeats(savedShowSeats)
                .status(BookingStatus.IN_PROGRESS)
                .build();

        newBooking.setAmount(pricingStrategy.calculatePrice(newBooking));
        return bookingRepo.save(newBooking);

    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> lockShowSeats(List<Long> showSeatIds){
        // fetch show seat status
        int showSeatCount = showSeatIds.size();
        List<ShowSeat> showSeats = showSeatService.findAllByShowSeatIds(showSeatIds);
        if(showSeats == null || showSeats.size() != showSeatCount){
            throw new RuntimeException("Some seats not found");
        }

        // if not available -> throw error
        int availableSeats = (int) showSeats.stream().filter(showSeat -> showSeat.getSeatStatus() == SeatStatus.AVAILABLE).count();
        if(availableSeats != showSeatCount){
            throw new RuntimeException("Seat status not available for some seats");
        }

        // change status to locked
        showSeats.stream().forEach(showSeat -> showSeat.setSeatStatus(SeatStatus.LOCKED));
        return showSeatService.saveAll(showSeats);

    }

    public Booking processFullPayment(Booking booking){
        List<ShowSeat> showSeats = booking.getShowSeats();
        showSeats.stream().forEach(showSeat -> showSeat.setSeatStatus(SeatStatus.BOOKED));
        showSeatService.saveAll(showSeats);

        booking.setStatus(BookingStatus.BOOKED);
        return bookingRepo.save(booking);
    }
}
