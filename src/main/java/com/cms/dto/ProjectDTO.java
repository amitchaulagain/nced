package com.cms.dto;

import com.cms.model.Activity;

/**
 * Created by amit on 7/10/16.
 */
public class ProjectDTO {
    private Integer id;


    private String budgetSubHeadNumber;

    private String projectCode;


    private String projectName;


    private String fiscalYear;

    private String aidOrganisation;

    private double budget;

    private Activity activityDTO;

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

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
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
}
