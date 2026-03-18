package com.castr.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int capacity;
    private String zone;

    @OneToMany(mappedBy = "room")
    private List<Booking> bookings;
}