package com.softsolutions.mechaniclab.service;

import com.softsolutions.mechaniclab.model.DaySchedule;
import com.softsolutions.mechaniclab.model.Schedule;
import com.softsolutions.mechaniclab.repository.WorkStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WorkStationService {

    @Autowired
    private WorkStationRepository workStationRepository;

    public Schedule getSchedule(LocalDate from, LocalDate to) {

        Schedule schedule = new Schedule();

        while (from.isBefore(to) || from.isEqual(to)) {
            schedule.add(new DaySchedule(from, workStationRepository.getWorkStationsByDayOfWeek(from.getDayOfWeek())));
            from = from.plusDays(1);
        }

        return schedule;
    }
}
