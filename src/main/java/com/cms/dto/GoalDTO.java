package com.cms.dto;

import com.cms.model.Goal;

/**
 * Created by amit on 7/16/16.
 */
public class GoalDTO {
    Goal goal;
    Integer activityId;

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }


    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }




}
