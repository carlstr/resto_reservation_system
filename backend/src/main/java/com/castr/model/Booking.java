package com.castr.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "diningTable_id")
    private DiningTable diningTable;

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    };

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public Long getDiningTableId() {
        return diningTable != null ? diningTable.getId() : null;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDiningTable(DiningTable diningTable) {
        this.diningTable = diningTable;
    }
}
