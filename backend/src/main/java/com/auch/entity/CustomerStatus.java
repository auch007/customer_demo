package com.auch.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
@Table(name="ta_cust_stus")
public class CustomerStatus {

    @Id
    @Column(name="stus_cod")
    private String stusCod;

    @Column(name="stus")
    private String stus;

    @Column(name="crt_ts")
    private Timestamp crtTs;

    @Column(name="lst_upd_ts")
    private Timestamp lstUpdTs;

    @Column(name="upd_cntr")
    private Long updCntr;

    public CustomerStatus() {
    }

    public String getStusCod() {
        return stusCod;
    }

    public void setStusCod(String stusCod) {
        this.stusCod = stusCod;
    }
    
    public String getStus() {
        return stus;
    }

    public void setStus(String stus) {
        this.stus = stus;
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
