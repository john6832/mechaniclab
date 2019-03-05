package com.softsolutions.mechaniclab.controller;

import com.softsolutions.mechaniclab.exception.EntityNotFoundException;
import com.softsolutions.mechaniclab.model.Repair;
import com.softsolutions.mechaniclab.model.RepairStatus;
import com.softsolutions.mechaniclab.model.Schedule;
import com.softsolutions.mechaniclab.service.RepairService;
import com.softsolutions.mechaniclab.service.WorkStationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/workStations")
public class WorkStationController {

    private final WorkStationService workStationService;

    @Autowired
    public WorkStationController(WorkStationService workStationService) {
        this.workStationService = workStationService;
    }

    @RequestMapping(path = "/schedule")
    @ApiOperation(value = "Updates repair by id", response = Repair.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get schedule by date range")
    })
    public ResponseEntity update(
            @RequestParam(value = "from", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @ApiParam(
                    value = "Start date the user wish to get the schedule",
                    format = "yyyy-MM-dd",
                    example = "2019-02-13") LocalDate from,
            @RequestParam(value = "to", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            @ApiParam(
                    value = "End date the user wish to get the schedule",
                    format = "yyyy-MM-dd",
                    example = "2019-02-15") LocalDate to
    ) {

        Schedule schedule = workStationService.getSchedule(from, to);

        return ResponseEntity.ok(schedule);
    }

}
