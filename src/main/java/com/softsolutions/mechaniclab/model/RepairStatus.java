package com.softsolutions.mechaniclab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@ApiModel(description = "Class encapsulating the order status details")
public class RepairStatus {

    public static RepairStatus PENDING = new RepairStatus(1);
    public static RepairStatus COMPLETED = new RepairStatus(2);
    public static RepairStatus CANCELLED = new RepairStatus(3);
    public static RepairStatus TOO_HARD = new RepairStatus(4);
    public static RepairStatus NO_EQUIPMENT = new RepairStatus(5);
    public static RepairStatus NO_QUALIFIED_PERSONAL = new RepairStatus(6);
    public static RepairStatus IMPOSSIBLE = new RepairStatus(7);

    public RepairStatus() {
    }

    private RepairStatus(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "OrderDetail status name", example = "Completed")
    @Length(min = 2, max = 100)
    @NotNull
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
