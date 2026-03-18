package com.castr.repository;

import com.castr.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByZoneAndCapacityGreaterThanEqual(String zone, int capacity);
}