package com.cms.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "activity")

public class Activity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;


    private double budget;

    private String activityHead;

    private String activityName;

    private String expenseHead;
    private String unit;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Project project;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "activity")
    private List<ActivityProgress> activityProgresses;

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;

    }

    public List<ActivityProgress> getActivityProgresses() {
        return activityProgresses;
    }

    public void setActivityProgresses(List<ActivityProgress> activityProgresses) {
        this.activityProgresses = activityProgresses;
    }
}
