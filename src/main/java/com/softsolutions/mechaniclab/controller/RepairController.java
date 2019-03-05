package com.softsolutions.mechaniclab.controller;

import com.softsolutions.mechaniclab.exception.EntityNotFoundException;
import com.softsolutions.mechaniclab.model.Repair;
import com.softsolutions.mechaniclab.model.RepairStatus;
import com.softsolutions.mechaniclab.service.RepairService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/repairs")
public class RepairController {

    private final RepairService repairService;

    @Autowired
    public RepairController(RepairService repairService) {
        this.repairService = repairService;
    }

    @PutMapping(path = "/{id}")
    @ApiOperation(value = "Updates repair by id", response = Repair.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Repair updated successfully"),
            @ApiResponse(code = 404, message = "No repair found with given id")
    })
    public ResponseEntity update(@Valid @RequestBody Repair repair, @PathVariable Long id) throws EntityNotFoundException {

        Repair savedRepair = repairService.getOne(id);

        if (savedRepair == null) {
            throw new EntityNotFoundException(Repair.class, id);
        }

        savedRepair =  repairService.update(repair);

        return ResponseEntity.ok(savedRepair);
    }

    @PutMapping(path = "/{id}/complete")
    @ApiOperation(value = "Completes a repair by id", response = Repair.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Repair updated successfully"),
            @ApiResponse(code = 404, message = "No repair found with given id")
    })
    public ResponseEntity complete(@Valid @RequestBody Repair repair, @PathVariable Long id) throws EntityNotFoundException {

        Repair savedRepair = repairService.getOne(id);

        if (savedRepair == null) {
            throw new EntityNotFoundException(Repair.class, id);
        }

        savedRepair.setRepairStatus(RepairStatus.COMPLETED);

        savedRepair =  repairService.update(savedRepair);

        return ResponseEntity.ok(savedRepair);
    }

}
