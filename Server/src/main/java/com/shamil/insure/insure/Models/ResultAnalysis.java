package com.shamil.insure.insure.Models;

import javax.persistence.*;

@Entity
public class ResultAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String fnName;
    private String timeTaken;
    private String userID;
    private String time;
    private String gasUsed;
    private String totalCost;

    public ResultAnalysis() {
    }

    public ResultAnalysis(Integer id, String fnName, String timeTaken, String userID, String time, String gasUsed, String totalCost) {
        this.id = id;
        this.fnName = fnName;
        this.timeTaken = timeTaken;
        this.userID = userID;
        this.time = time;
        this.gasUsed = gasUsed;
        this.totalCost = totalCost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFnName() {
        return fnName;
    }

    public void setFnName(String fnName) {
        this.fnName = fnName;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(String gasUsed) {
        this.gasUsed = gasUsed;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }
}
