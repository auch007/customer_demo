package com.auch.entity;

import java.util.Date;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="ta_cust")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cust_uid")
    private Long custUid;

    @Column(name="stus_cod")
    private String stusCod;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;
    
    @Column(name="phone")
    private String phone;

    @Column(name="dob")
    private Date dob;

    @Column(name="crt_ts")
    private Timestamp crtTs;

    @Column(name="lst_upd_ts")
    private Timestamp lstUpdTs;

    @Column(name="upd_cntr")
    private Long updCntr;

    public Customer() {
    }

    public Long getCustUid() {
        return custUid;
    }

    public void setCustUid(Long custUid) {
        this.custUid = custUid;
    }

    public String getStusCod() {
        return stusCod;
    }

    public void setStusCod(String stusCod) {
        this.stusCod = stusCod;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Timestamp getCrtTs() {
        return crtTs;
    }

    public void setCrtTs(Timestamp crtTs) {
        this.crtTs = crtTs;
    }

    public Timestamp getLstUpdTs() {
        return lstUpdTs;
    }

    public void setLstUpdTs(Timestamp lstUpdTs) {
        this.lstUpdTs = lstUpdTs;
    }

    public Long getUpdCntr() {
        return updCntr;
    }

    public void setUpdCntr(Long updCntr) {
        this.updCntr = updCntr;
    }
}
