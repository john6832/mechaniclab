package com.softsolutions.mechaniclab.service;

import com.softsolutions.mechaniclab.model.OrderDetail;
import com.softsolutions.mechaniclab.model.OrderStatus;
import com.softsolutions.mechaniclab.model.Repair;
import com.softsolutions.mechaniclab.model.RepairType;
import com.softsolutions.mechaniclab.repository.OrderDetailRepository;
import com.softsolutions.mechaniclab.repository.RepairRepository;
import com.softsolutions.mechaniclab.repository.RepairTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderDetailService {

    private final OrderExecutorService orderExecutorService;

    private final OrderDetailRepository orderDetailRepository;

    private final RepairTypeRepository repairTypeRepository;

    @Autowired
    public OrderDetailService(OrderDetailRepository orderDetailRepository, OrderExecutorService orderExecutorService, RepairTypeRepository repairTypeRepository) {
        this.orderDetailRepository = orderDetailRepository;
        this.orderExecutorService = orderExecutorService;
        this.repairTypeRepository = repairTypeRepository;
    }

    public OrderDetail save(OrderDetail orderDetail) {

        orderDetail.setReceptionDate(LocalDateTime.now());

        orderDetail.setEstimatedCompletionDate(calculateEstimatedCompletionDate(orderDetail.getReceptionDate(), orderDetail.getRepairs(), orderDetail.getSeatsNumber()));

        orderDetail.setOrderStatus(OrderStatus.PENDING);

        for (Repair repair : orderDetail.getRepairs()) {
            repair.setOrderDetail(orderDetail);
        }

        OrderDetail savedOrder = orderDetailRepository.save(orderDetail);

        // Send the created order id to the JMS Service
        // This queue will make possible FIFO operations
        orderExecutorService.add(savedOrder.getId());

        return savedOrder;

    }


    public LocalDateTime calculateEstimatedCompletionDate(LocalDateTime startDate, List<Repair> repairs, Integer seatsNumber) {

        LocalDateTime completionDate = startDate;

        for (Repair repair : repairs) {
            RepairType repairType = repairTypeRepository.getOne(repair.getRepairType().getId());
            completionDate = completionDate.plusMinutes(repairType.getCompletionTimeInMinutes() * seatsNumber);
        }

        return completionDate;
    }

    public OrderDetail getNextAvailableOrder(){

        Long orderDetailId =  orderExecutorService.poll();

        if(orderDetailId != null) {
            return orderDetailRepository.getOne(orderDetailId);
        }

        return null;
    }


}
