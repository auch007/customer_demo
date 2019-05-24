package com.auch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.lang.Iterable;
import java.util.Map;
import java.util.Date;
import java.sql.Timestamp;

import com.auch.repo.CustomerRepository;
import com.auch.entity.Customer;
import com.auch.exception.RecordNotFoundException;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository custRepo;

    // List all customer
    @GetMapping("/customerList")
    public List<Customer> listCustomer() {
        Iterable<Customer> custItr = custRepo.findAll();
        List<Customer> custList = new ArrayList<Customer>();
        if (custItr != null) {
            custItr.forEach(cust -> custList.add(cust));
        }
        return custList;
    }

    // Update customer status
    @PatchMapping("/customer/{uid}")
    Customer updateCustStus(@RequestBody Map<String,String> req, @PathVariable Long uid) {
        try {
            Customer cust = custRepo.findById(uid).get();
            if (cust != null) {
                cust.setStusCod(req.get("stusCod"));
                cust.setLstUpdTs(new Timestamp(new Date().getTime()));
                cust.setUpdCntr(cust.getUpdCntr() + 1);
                custRepo.save(cust);
                return cust;
            }
        } catch (Exception e) {
            throw new RecordNotFoundException(uid);
        }
        return null;
    }    
}
