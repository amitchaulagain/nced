package com.cms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "goal")
public class Goal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private int qty;
    private double weightage;
    private double budget;
    private TimeFrame timeFrame;


public  Goal(){

}

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "activity")
    private List<ActivityProgress> activityProgresses;

    public Goal(int qty, double weightage, double budget) {
        this.qty=qty;
        this.weightage=weightage;
        this.budget=budget;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getWeightage() {
        return weightage;
    }

    public void setWeightage(double weightage) {
        this.weightage = weightage;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }
    public List<ActivityProgress> getActivityProgresses() {
        return activityProgresses;
    }

    public void setActivityProgresses(List<ActivityProgress> activityProgresses) {
        this.activityProgresses = activityProgresses;
    }

}
