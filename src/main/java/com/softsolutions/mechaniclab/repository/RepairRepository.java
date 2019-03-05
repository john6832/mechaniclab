package com.softsolutions.mechaniclab.repository;

import com.softsolutions.mechaniclab.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {
}
