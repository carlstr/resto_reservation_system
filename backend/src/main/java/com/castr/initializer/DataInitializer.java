package com.castr.initializer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.castr.model.Booking;
import com.castr.model.DiningTable;
import com.castr.model.Room;
import com.castr.repository.BookingRepository;
import com.castr.repository.DiningTableRespository;
import com.castr.repository.RoomRepository;

@Configuration
public class DataInitializer {

    @Bean
    @ConditionalOnProperty(name = "app.init-db", havingValue = "true")
    CommandLineRunner initData(RoomRepository roomRepository,
            DiningTableRespository diningTableRespository,
            BookingRepository bookingRepository) {
        return args -> {
            Random random = new Random();

            Room roomT = new Room();
            roomT.setName("Terrace");

            Room roomIH = new Room();
            roomIH.setName("InsideHall");

            roomRepository.save(roomT);
            roomRepository.save(roomIH);

            for (int i = 0; i < 5; i++) {
                DiningTable diningTable = new DiningTable();
                diningTable.setCapacity(random.nextInt(1, 6));
                diningTable.setRoom(i % 2 == 0 ? roomT : roomIH);
                diningTableRespository.save(diningTable);
            }

            for (DiningTable diningTable : diningTableRespository.findAll()) {
                for (int i = 0; i < 2; i++) {
                    Booking booking = new Booking();

                    booking.setDiningTable(diningTable);
                    booking.setDate(LocalDate.now());

                    int startHour = random.nextInt(16, 21);
                    booking.setStartTime(LocalTime.of(startHour, 0));
                    booking.setEndTime(LocalTime.of(startHour + random.nextInt(1, 4), 0));

                    booking.setCapacity(diningTable.getCapacity());

                    bookingRepository.save(booking);
                }
            }

            System.out.println("Db populated with test data.");
        };
    }
}
