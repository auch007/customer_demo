package com.auch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;
import java.util.ArrayList;
import java.lang.Iterable;
import java.util.Date;
import java.sql.Timestamp;

import com.auch.repo.*;
import com.auch.entity.*;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerDemoAppJpaTest {

    @Autowired
    private CustomerRepository custRepo;

    @Autowired
    private CustomerStatusRepository custStusRepo;

    @Autowired
    private CustomerNoteRepository custNoteRepo;

    @Test
    public void testFindAllCustomer() {
        Iterable<Customer> custItr = custRepo.findAll();
        List<Customer> custList = new ArrayList<Customer>();
        if (custItr != null) {
            custItr.forEach(cust -> custList.add(cust));
        }
        assertTrue(custList.size() > 0);
    }

    @Test
    public void testFindAllCustomerStus() {
        Iterable<CustomerStatus> custStusItr = custStusRepo.findAll();
        List<CustomerStatus> custStusList = new ArrayList<CustomerStatus>();
        if (custStusItr != null) {
            custStusItr.forEach(stus -> custStusList.add(stus));
        }
        assertTrue(custStusList.size() == 3);
    }

    @Test
    public void testCustomerNoteNotFound() {
        List<CustomerNote> custNoteList = custNoteRepo.findByCustUid(99999L);
        assertTrue(custNoteList == null || custNoteList.isEmpty());
    }

    @Test 
    public void testSaveCustomerNote() {
        Long cusUid = 1L;
        String text = "jUnit testNote";
        CustomerNote note = new CustomerNote();
        note.setCustUid(cusUid);
        note.setNote(text);
        note.setCrtTs(new Timestamp(new Date().getTime()));
        note.setLstUpdTs(new Timestamp(new Date().getTime()));
        note.setUpdCntr(0L);
        custNoteRepo.save(note);
        
        List<CustomerNote> checkNoteList = custNoteRepo.findByCustUid(cusUid);
        assertTrue(checkNoteList.size() > 0);
    }
}