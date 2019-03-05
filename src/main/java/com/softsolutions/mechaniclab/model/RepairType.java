package com.softsolutions.mechaniclab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@ApiModel(description = "Class encapsulating the repair type details")
public class RepairType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Repair type name", example = "Change Tires")
    @Length(min = 2, max = 100)
    @NotNull
    private String name;

    @ApiModelProperty(value = "Completion time in minutes, it includes moving the vehicle to the location", example = "86400")
    @NotNull
    @Min(1)
    @Max(9999999)
    private Integer completionTimeInMinutes;

    @JsonIgnore
    @ManyToMany(mappedBy = "repairTypes")
    private List<WorkStation> workStations;

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

    public Integer getCompletionTimeInMinutes() {
        return completionTimeInMinutes;
    }

    public void setCompletionTimeInMinutes(Integer completionTimeInMinutes) {
        this.completionTimeInMinutes = completionTimeInMinutes;
    }

    public List<WorkStation> getWorkStations() {
        return workStations;
    }

    public void setWorkStations(List<WorkStation> workStations) {
        this.workStations = workStations;
    }
}
