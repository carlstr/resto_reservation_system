package com.castr.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int peopleCount;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
