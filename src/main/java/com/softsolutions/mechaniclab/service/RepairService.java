package com.softsolutions.mechaniclab.service;

import com.softsolutions.mechaniclab.model.OrderDetail;
import com.softsolutions.mechaniclab.model.OrderStatus;
import com.softsolutions.mechaniclab.model.Repair;
import com.softsolutions.mechaniclab.repository.OrderDetailRepository;
import com.softsolutions.mechaniclab.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairService {

    private final RepairRepository repairRepository;

    private final OrderDetailRepository orderDetailRepository;


    @Autowired
    public RepairService(RepairRepository repairRepository, OrderDetailRepository orderDetailRepository) {
        this.repairRepository = repairRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public Repair update(Repair repair) {

        Repair savedRepair = repairRepository.save(repair);

        Long pendingRepairs = orderDetailRepository.countPendingRepairs(savedRepair.getOrderDetail());

        if (pendingRepairs == 0) {
            OrderDetail orderDetail = savedRepair.getOrderDetail();
            orderDetail.setOrderStatus(OrderStatus.COMPLETED);
            orderDetailRepository.save(orderDetail);
        }

        return savedRepair;
    }

    public Repair getOne(Long id){
        return repairRepository.getOne(id);
    }

}
