package com.cms.repository;

import com.cms.model.Goal;
import com.cms.model.GoalActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGoalActivity extends JpaRepository<GoalActivity, Integer>,
        JpaSpecificationExecutor<GoalActivity> {


    @Query("SELECT u.goal FROM GoalActivity u WHERE u.activity.id=:activityId")
    List<Goal> getAllGoalsByActivityId(@Param("activityId")Integer activityId);

    @Query("SELECT u  FROM GoalActivity u WHERE u.activity.id=:activityId AND u.goal.id=:goalId")
    GoalActivity findGoalActivityByGoalIdAndActivityId(@Param("goalId")Integer goalId, @Param("activityId") Integer activityId);

    @Query("SELECT u  FROM GoalActivity u WHERE u.activity.id=:activityId ")
    List<GoalActivity> findGoalActivityByActivityId(@Param("activityId")Integer activityId );





	/*
     * @Query("SELECT u FROM Role u WHERE LOWER(u.Rolename) = LOWER(:name)")
	 * Role retrieveByName(@Param("name") String name);
	 */
}
