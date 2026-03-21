package com.castr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castr.model.DiningTable;
import com.castr.service.DiningTableService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/diningTables")
public class DiningTableController {

    private final DiningTableService diningTableService;

    public DiningTableController(DiningTableService diningTableService) {
        this.diningTableService = diningTableService;
    }

    @GetMapping("/")
    public List<DiningTable> getDiningTables() {
        return diningTableService.getDiningTables();
    }

    @GetMapping("{id}")
    public DiningTable getDiningTableById(@PathVariable Long id) {
        return diningTableService.getDiningTableById(id);
    }
}
