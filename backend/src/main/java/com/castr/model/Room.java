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
    private List<DiningTable> DiningTables;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getZone() {
        return zone;
    }

    public void setName(String name) {
        this.name = name;
    }
}