package com.softsolutions.mechaniclab.repository;

import com.softsolutions.mechaniclab.model.WorkStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface WorkStationRepository extends JpaRepository<WorkStation, Long> {

    @Query("select ws from WorkStation ws inner join ws.daysOfWeek d where d =:dayOfWeek")
    List<WorkStation> getWorkStationsByDayOfWeek(@Param("dayOfWeek") DayOfWeek dayOfWeek);
}
