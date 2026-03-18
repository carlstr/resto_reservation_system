package com.castr.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class DiningTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int capacity;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "diningTable")
    private List<Booking> booking;

    public Long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public Long getRoomId() {
        return room.getId();
    }
}
