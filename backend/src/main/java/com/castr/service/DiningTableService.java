package com.castr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.castr.model.DiningTable;
import com.castr.repository.DiningTableRespository;

@Service
public class DiningTableService {

    private final DiningTableRespository diningTableRespository;

    public DiningTableService(DiningTableRespository diningTableRespository) {
        this.diningTableRespository = diningTableRespository;
    }

    public List<DiningTable> getDiningTables() {
        return diningTableRespository.findAll();
    }

    public DiningTable getDiningTableById(Long id) {
        return diningTableRespository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}
