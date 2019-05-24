package com.auch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.lang.Iterable;

import com.auch.repo.CustomerStatusRepository;
import com.auch.entity.CustomerStatus;

@RestController
public class CustomerStatusController {

    @Autowired
    private CustomerStatusRepository custStusRepo;

    // List all customer status
    @GetMapping("/custStusList")
    public List<CustomerStatus> listCustomerStatus() {
        Iterable<CustomerStatus> custStusItr = custStusRepo.findAll();
        List<CustomerStatus> custStusList = new ArrayList<CustomerStatus>();
        if (custStusItr != null) {
            custStusItr.forEach(stus -> custStusList.add(stus));
        }
        return custStusList;
    }
}
