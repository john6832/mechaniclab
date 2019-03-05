package com.softsolutions.mechaniclab.controller;

import com.softsolutions.mechaniclab.exception.ExceptionResponse;
import com.softsolutions.mechaniclab.exception.NoAvailableOrdersException;
import com.softsolutions.mechaniclab.model.OrderDetail;
import com.softsolutions.mechaniclab.service.OrderDetailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/orders")
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping(path = "")
    @ApiOperation(value = "Create a new order", response = OrderDetail.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Order was created and returned"),
            @ApiResponse(code = 400, response = ExceptionResponse.class, message = "Order could not be created because of a validation error")
    })
    public ResponseEntity save(@Valid @RequestBody OrderDetail orderDetail) {

        OrderDetail savedOrderDetail = orderDetailService.save(orderDetail);

        return ResponseEntity.ok(savedOrderDetail);
    }

    @PostMapping(path = "/next")
    @ApiOperation(value = "Get next available order from Queue", response = OrderDetail.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get next available order from the queue"),
            @ApiResponse(code = 404, response = ExceptionResponse.class, message = "There are no available orders")
    })
    public ResponseEntity getNextAvailableOrder() throws NoAvailableOrdersException {

        OrderDetail savedOrderDetail = orderDetailService.getNextAvailableOrder();

        if(savedOrderDetail == null){
            throw new NoAvailableOrdersException();
        }

        return ResponseEntity.ok(savedOrderDetail);
    }


}
