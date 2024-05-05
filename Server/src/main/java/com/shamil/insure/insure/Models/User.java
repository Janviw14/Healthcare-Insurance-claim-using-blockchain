package com.shamil.insure.insure.Models;

import javax.persistence.*;
import java.util.Date;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(unique = true)
    public String pID;
    public String fName;
    public String lName;
    public String insID;
    public String city;
    public String state;
    public String phone;
    public String email;
    public Date dob;
    public int sex;

    public User() {
    }

    public User(int id, String pID, String fName, String lName, String insID, String city, String state, String phone, String email, Date dob, int sex) {
        this.id = id;
        this.pID = pID;
        this.fName = fName;
        this.lName = lName;
        this.insID = insID;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getInsID() {
        return insID;
    }

    public void setInsID(String insID) {
        this.insID = insID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
