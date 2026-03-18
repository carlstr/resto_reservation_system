package com.castr.repository;

import com.castr.model.Booking;
import com.castr.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByRoomAndDateAndStartTimeLessThanAndEndTimeGreaterThan(
            Room room, LocalDate date, LocalTime endTime, LocalTime startTime);
}