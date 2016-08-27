package com.cms.dto;

import com.cms.model.Goal;
import com.cms.model.Progress;

/**
 * Created by amit on 7/26/16.
 */
public class ReportDTO {

    ActivityDTO activityDTO;
    ProjectDTO projectDTO;
    Goal g1;
    Goal g2;
    Goal g3;
    Goal g;
    Progress p1;
    Progress p2;

    Progress p3;

    Progress p;

    public ActivityDTO getActivityDTO() {
        return activityDTO;
    }

    public void setActivityDTO(ActivityDTO activityDTO) {
        this.activityDTO = activityDTO;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public Goal getG1() {
        return g1;
    }

    public void setG1(Goal g1) {
        this.g1 = g1;
    }

    public Goal getG2() {
        return g2;
    }

    public void setG2(Goal g2) {
        this.g2 = g2;
    }

    public Goal getG3() {
        return g3;
    }

    public void setG3(Goal g3) {
        this.g3 = g3;
    }

    public Goal getG() {
        return g;
    }

    public void setG(Goal g) {
        this.g = g;
    }

    public Progress getP1() {
        return p1;
    }

    public void setP1(Progress p1) {
        this.p1 = p1;
    }

    public Progress getP2() {
        return p2;
    }

    public void setP2(Progress p2) {
        this.p2 = p2;
    }

    public Progress getP3() {
        return p3;
    }

    public void setP3(Progress p3) {
        this.p3 = p3;
    }

    public Progress getP() {
        return p;
    }

    public void setP(Progress p) {
        this.p = p;
    }
}
