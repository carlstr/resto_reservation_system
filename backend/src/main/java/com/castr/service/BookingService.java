package com.castr.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.castr.model.Booking;
import com.castr.repository.BookingRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}
