package com.cms.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "training")

public class Training implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String fiscalYear;

    private String startDate;

    private String endDate;

    private int duration;

    private double budget;

    private int target;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainer_id")
    Member trainer;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tc_id")
    TrainingCenter trainingCenter;


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

//    public TrainingType getTrainingType() {
//        return trainingType;
//    }
//
//    public void setTrainingType(TrainingType trainingType) {
//        this.trainingType = trainingType;
//    }
/*public TrainingType getMemberType() {
        return memberType;
    }

    public void setMemberType(TrainingType memberType) {
        this.memberType = memberType;
    }*/

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

    /* public int getAttendantMember() {
             return attendantMember;
         }

         public void setAttendantMember(int attendantMember) {
             this.attendantMember = attendantMember;
         }
     */
    public Member getTrainer() {
        return trainer;
    }

    public void setTrainer(Member trainer) {
        this.trainer = trainer;
    }

    public TrainingCenter getTrainingCenter() {
        return trainingCenter;
    }

    public void setTrainingCenter(TrainingCenter trainingCenter) {
        this.trainingCenter = trainingCenter;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
}

