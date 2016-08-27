package com.cms.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "training_center")
public class TrainingCenter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    private String name;

    private String address;

    private String zone;

    private String district;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private TrainingCenter parentTrainingCenter;


    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "trainingCenter")
    private List<ActivityProgress> progressActivities;

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public TrainingCenter getParentTrainingCenter() {
        return parentTrainingCenter;
    }

    public void setParentTrainingCenter(TrainingCenter parentTrainingCenter) {
        this.parentTrainingCenter = parentTrainingCenter;
    }

    public List<ActivityProgress> getProgressActivities() {
        return progressActivities;
    }

    public void setProgressActivities(List<ActivityProgress> progressActivities) {
        this.progressActivities = progressActivities;
    }
}
