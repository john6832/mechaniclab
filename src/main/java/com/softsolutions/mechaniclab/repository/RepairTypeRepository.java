package com.softsolutions.mechaniclab.repository;

import com.softsolutions.mechaniclab.model.RepairType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairTypeRepository extends JpaRepository<RepairType, Long> {
}
