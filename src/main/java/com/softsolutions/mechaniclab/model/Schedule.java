package com.softsolutions.mechaniclab.model;

import java.util.LinkedList;
import java.util.List;

public class Schedule {

    public Schedule() {
        daySchedules = new LinkedList<>();
    }

    private List<DaySchedule> daySchedules;

    public List<DaySchedule> getDaySchedules() {
        return daySchedules;
    }

    public void setDaySchedules(List<DaySchedule> daySchedules) {
        this.daySchedules = daySchedules;
    }

    public boolean add(DaySchedule daySchedule) {
        return daySchedules.add(daySchedule);
    }
}
