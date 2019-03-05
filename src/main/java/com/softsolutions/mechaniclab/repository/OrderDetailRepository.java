package com.softsolutions.mechaniclab.repository;

import com.softsolutions.mechaniclab.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query("select count(r) from OrderDetail od inner join od.repairs r where od =:orderDetail and r.repairStatus.id = 1")
    Long countPendingRepairs(@Param("orderDetail") OrderDetail orderDetail);
}
