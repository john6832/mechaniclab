package com.softsolutions.mechaniclab.model;

import java.time.LocalDate;
import java.util.List;

public class DaySchedule {

    private LocalDate date;
    private List<WorkStation> workStations;

    public DaySchedule(LocalDate date, List<WorkStation> workStations) {
        this.date = date;
        this.workStations = workStations;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<WorkStation> getWorkStations() {
        return workStations;
    }

    public void setWorkStations(List<WorkStation> workStations) {
        this.workStations = workStations;
    }
}
