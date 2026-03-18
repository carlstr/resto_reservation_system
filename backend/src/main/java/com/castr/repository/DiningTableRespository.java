package com.castr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.castr.model.DiningTable;

@Repository
public interface DiningTableRespository extends JpaRepository<DiningTable, Long> {

}
