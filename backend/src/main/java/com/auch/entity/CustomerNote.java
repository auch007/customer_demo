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
@Table(name="ta_cust_note")
public class CustomerNote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="cust_note_uid")
    private Long custNoteUid;

    @Column(name="cust_uid")
    private Long custUid;

    @Column(name="note")
    private String note;

    @Column(name="crt_ts")
    private Timestamp crtTs;

    @Column(name="lst_upd_ts")
    private Timestamp lstUpdTs;

    @Column(name="upd_cntr")
    private Long updCntr;

    public CustomerNote() {
    }

    public Long getCustNoteUid() {
        return custNoteUid;
    }

    public void setCustNoteUid(Long custNoteUid) {
        this.custNoteUid = custNoteUid;
    }

    public Long getCustUid() {
        return custUid;
    }

    public void setCustUid(Long custUid) {
        this.custUid = custUid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
