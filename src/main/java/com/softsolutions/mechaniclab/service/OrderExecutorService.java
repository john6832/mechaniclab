package com.softsolutions.mechaniclab.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
@ApplicationScope
public class OrderExecutorService {

    //For project simplicity, I will emulate a JMS service with an application scoped queue
    private Queue<Long> orderDetailQueue;

    @PostConstruct
    public void init(){
        orderDetailQueue = new ConcurrentLinkedQueue<>();
    }

    public boolean add(Long orderDetailId) {
        return orderDetailQueue.add(orderDetailId);
    }

    public Long poll() {
        return orderDetailQueue.poll();
    }
}
