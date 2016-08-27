package com.cms.dto;

import com.cms.model.TimeFrame;

import java.util.Date;

/**
 * Created by amit on 7/30/16.
 */
public class TrainingReportDTO {
    private Integer id;

    private String name;

    private String startDate;

    private String endDate;

    private int duration;

    private double budget;

    private int target;

    private int noOfAttendees;

    private int maleFrequency;

    private int femaleFrequency;

    private TimeFrame timeFrame;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getNoOfAttendees() {
        return noOfAttendees;
    }

    public void setNoOfAttendees(int noOfAttendees) {
        this.noOfAttendees = noOfAttendees;
    }

    public int getMaleFrequency() {
        return maleFrequency;
    }

    public void setMaleFrequency(int maleFrequency) {
        this.maleFrequency = maleFrequency;
    }

    public int getFemaleFrequency() {
        return femaleFrequency;
    }

    public void setFemaleFrequency(int femaleFrequency) {
        this.femaleFrequency = femaleFrequency;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }
}
