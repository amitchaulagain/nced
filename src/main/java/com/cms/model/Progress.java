package com.cms.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "progress")

public class Progress implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;


    private TimeFrame timeFrame;

    private String description;

    private int progressQty;

    private int goalQty;

    private String date;

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    private String submittedBy;

    public String getWeightedProgress() {
        return weightedProgress;
    }

    public void setWeightedProgress(double weightedProgress) {

        Double toBeTruncated = new Double(weightedProgress);

        Double truncatedDouble = new BigDecimal(toBeTruncated)
                .setScale(4, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        this.weightedProgress = truncatedDouble.toString();

    }

    @Transient
    private String weightedProgress;



    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "activity")
    private List<ActivityProgress> activityProgresses;




    public List<ActivityProgress> getActivityProgresses() {
        return activityProgresses;
    }

    public void setActivityProgresses(List<ActivityProgress> activityProgresses) {
        this.activityProgresses = activityProgresses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TimeFrame getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(TimeFrame timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProgressQty() {
        return progressQty;
    }

    public void setProgressQty(int progressQty) {
        this.progressQty = progressQty;
    }

    public int getGoalQty() {
        return goalQty;
    }

    public void setGoalQty(int goalQty) {
        this.goalQty = goalQty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
