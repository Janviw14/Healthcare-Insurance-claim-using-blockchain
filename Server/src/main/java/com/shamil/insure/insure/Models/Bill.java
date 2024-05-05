package com.shamil.insure.insure.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bill {
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User patient;
    public String rNum;
    public Date date;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    public Bill() {
    }

    public Bill(User patient, String rNum, Date date, int id) {
        this.patient = patient;
        this.rNum = rNum;
        this.date = date;
        this.id = id;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public String getrNum() {
        return rNum;
    }

    public void setrNum(String rNum) {
        this.rNum = rNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
