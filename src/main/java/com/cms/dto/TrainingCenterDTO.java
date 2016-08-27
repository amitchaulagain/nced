package com.cms.dto;

/**
 * Created by amit on 7/20/16.
 */
public class TrainingCenterDTO {
    private Integer id;

    private String name;

    private String address;

    private String zone;

    private String district;

    private String parentTrainingCenter;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    private String count;

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

    public String getParentTrainingCenter() {
        return parentTrainingCenter;
    }

    public void setParentTrainingCenter(String parentTrainingCenter) {
        this.parentTrainingCenter = parentTrainingCenter;
    }
}
