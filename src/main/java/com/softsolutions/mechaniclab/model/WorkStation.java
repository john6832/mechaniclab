package com.softsolutions.mechaniclab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.util.List;

@Entity
@ApiModel(description = "Class encapsulating the work station details")
public class WorkStation {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Work station name", example = "Trucks and Buses station")
    @Length(min = 2, max = 100)
    @NotNull
    private String name;

    @ManyToMany
    private List<VehicleCategory> vehicleCategories;

    @ManyToMany
    private List<RepairType> repairTypes;

    @JsonIgnore
    @ElementCollection
    private List<DayOfWeek> daysOfWeek;

    @Min(0)
    @Max(23)
    @ApiModelProperty(value = "Opening hour", example = "08")
    private Integer startHour;

    @Min(0)
    @Max(23)
    @ApiModelProperty(value = "Closing hour", example = "20")
    private Integer endHour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RepairType> getRepairTypes() {
        return repairTypes;
    }

    public void setRepairTypes(List<RepairType> repairTypes) {
        this.repairTypes = repairTypes;
    }

    public List<VehicleCategory> getVehicleCategories() {
        return vehicleCategories;
    }

    public void setVehicleCategories(List<VehicleCategory> vehicleCategories) {
        this.vehicleCategories = vehicleCategories;
    }

    public List<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<DayOfWeek> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }
}
