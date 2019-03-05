package com.softsolutions.mechaniclab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@ApiModel(description = "Class encapsulating the vehicle category details")
public class VehicleCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Vehicle category name", example = "Bus")
    @Length(min = 2, max = 100)
    @NotNull
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "vehicleCategories")
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

    public List<WorkStation> getWorkStations() {
        return workStations;
    }

    public void setWorkStations(List<WorkStation> workStations) {
        this.workStations = workStations;
    }
}
