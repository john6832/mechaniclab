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
public class OrderStatus {

    public static OrderStatus PENDING = new OrderStatus(1);
    public static OrderStatus COMPLETED = new OrderStatus(2);
    public static OrderStatus CANCELLED = new OrderStatus(3);
    public static OrderStatus WONT_DO = new OrderStatus(4);

    public OrderStatus() {
    }

    private OrderStatus(Integer id) {
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
