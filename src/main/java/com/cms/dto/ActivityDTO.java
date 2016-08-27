package com.cms.dto;

/**
 * Created by amit on 7/15/16.
 */
public class ActivityDTO {
    private Integer id;


    private double budget;

    private String activityHead;
    private String activityName;

    private String expenseHead;
    private String unit;

    private String projectCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getActivityHead() {
        return activityHead;
    }

    public void setActivityHead(String activityHead) {
        this.activityHead = activityHead;
    }

    public String getExpenseHead() {
        return expenseHead;
    }

    public void setExpenseHead(String expenseHead) {
        this.expenseHead = expenseHead;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
