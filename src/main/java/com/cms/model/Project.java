package com.cms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "project")

public class Project implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;


    private String budgetSubHeadNumber;

    private String projectCode;

    private String projectName;

    private String fiscalYear;

    private String aidOrganisation;

    private double budget;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "project")
    private List<Activity> activities;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBudgetSubHeadNumber() {
        return budgetSubHeadNumber;
    }

    public void setBudgetSubHeadNumber(String budgetSubHeadNumber) {
        this.budgetSubHeadNumber = budgetSubHeadNumber;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public String getAidOrganisation() {
        return aidOrganisation;
    }

    public void setAidOrganisation(String aidOrganisation) {
        this.aidOrganisation = aidOrganisation;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
}
