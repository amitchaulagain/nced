package com.cms.dto;

/**
 * Created by amit on 7/20/16.
 */
public class TrainingDTO {
    private Integer id;

    private String name;

    private String start;

    private String end;

    private double budget;

    private  int target;

    private int trainingCenterId;

    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTrainingCenterId() {
        return trainingCenterId;
    }

    public void setTrainingCenterId(int trainingCenterId) {
        this.trainingCenterId = trainingCenterId;
    }

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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
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
}
