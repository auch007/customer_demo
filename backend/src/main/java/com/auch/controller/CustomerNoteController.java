package com.auch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Date;
import java.sql.Timestamp;

import com.auch.repo.CustomerNoteRepository;
import com.auch.entity.CustomerNote;
import com.auch.exception.RecordNotFoundException;

@RestController
public class CustomerNoteController {

    @Autowired
    private CustomerNoteRepository custNoteRepo;
    
    // Find customer note
    @GetMapping("/customerNote/{uid}") 
    public List<CustomerNote> getCustomerNote(@PathVariable Long uid) {
        return custNoteRepo.findByCustUid(uid);
    }
    
    // Update customer note
    @PatchMapping("/customerNote/{uid}")
    CustomerNote updateCustomerNote(@RequestBody Map<String,String> req, @PathVariable Long uid) {
        try {
            CustomerNote custNote = custNoteRepo.findById(uid).get();
            if (custNote != null) {
                custNote.setNote(req.get("note"));
                custNote.setLstUpdTs(new Timestamp(new Date().getTime()));
                custNote.setUpdCntr(custNote.getUpdCntr() + 1);
                custNoteRepo.save(custNote);
                return custNote;
            }
        } catch (Exception e) {
            throw new RecordNotFoundException(uid);
        }
        return null;
    }

    // Add customer note
    @PostMapping("/customerNote")
    CustomerNote addCustomerNote(@RequestBody CustomerNote req) {
        CustomerNote note = new CustomerNote();
        note.setCustUid(req.getCustUid());
        note.setNote(req.getNote());
        note.setCrtTs(new Timestamp(new Date().getTime()));
        note.setLstUpdTs(new Timestamp(new Date().getTime()));
        note.setUpdCntr(0L);
        return custNoteRepo.save(note);
    }
    
    // Delete customer note
    @DeleteMapping("/customerNote/{uid}")
    void deleteCustomerNote(@PathVariable Long uid) {
        custNoteRepo.deleteById(uid);
    }
}
