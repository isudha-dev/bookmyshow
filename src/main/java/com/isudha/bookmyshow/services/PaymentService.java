package com.isudha.bookmyshow.services;

import com.isudha.bookmyshow.dtos.CreatePaymentDto;
import com.isudha.bookmyshow.enums.PaymentStatus;
import com.isudha.bookmyshow.models.Booking;
import com.isudha.bookmyshow.models.Payment;
import com.isudha.bookmyshow.repositories.PaymentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {
    private PaymentRepo paymentRepo;
    private BookingService bookingService;

    public Payment makePayment(CreatePaymentDto reqDto){
        Booking booking = bookingService.getBookingById(reqDto.getBookingId());
        Payment payment = Payment
                .builder()
                .booking(booking)
                .paymentStatus(PaymentStatus.IN_PROGRESS)
                .paymentMethodType(reqDto.getPaymentMethodType())
                .amount(reqDto.getAmount())
                .build();

        // call the third party for payment
        boolean thirdPartyPaymentStatus = true;

        if(thirdPartyPaymentStatus) {
            payment = processPaymentSuccess(booking, payment);
            return payment;
        }

        throw new RuntimeException("Payment unsuccessful");

    }

    private Payment processPaymentSuccess(Booking booking, Payment payment) {
        payment.setPaymentStatus(PaymentStatus.SUCCESS);
        paymentRepo.save(payment);

        if(booking.getPayments().stream().filter(pay -> pay.getPaymentStatus() == PaymentStatus.SUCCESS).mapToDouble(i -> i.getAmount()).sum() >= booking.getAmount()){
            bookingService.processFullPayment(booking);
        }
        return payment;
    }
}
