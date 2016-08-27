package com.cms.api;

import com.cms.dto.*;
import com.cms.model.*;

import java.util.List;

/**
 * Created by amit on 7/10/16.
 */
public interface IProjectWorkApi {

    String createOrEditProject(ProjectDTO dto);

    List<Project> getAllProjectsByFiscalYear(String fiscalYear);

    String deleteProject(Integer id);

    ProjectDTO getProjectById(Integer id);

    List<ActivityDTO> getActivitiesByProjectId(Integer projectId);

    Project getProjectByProjectCode(String code);

    String createOrEditGoal(GoalDTO dto);

    List<Goal> findGoalsByActivityId(Integer activityId);

    String createOrEditActivity(ActivityDTO a);

    Activity getActivityById(Integer id);

    String createOrEditProgress(ProgressDTO dto);

    List<ProgressDTO> getAllSubmittedProgresses(String fiscalYear);

    ProgressDTO getProgressByProgressId(Integer id);

    String deleteProgress(Integer id);

    List<ReportDTO> getReport();


    List<ReportDTO> getReportByFiscalYear(String fiscalYear);

    List<Activity> getActivitiesByFiscalYear(String fiscalYear);

    List<Progress> getProgressByActivityId(Integer id);

    List<ProgressDTO> findProgressesByActivityId(Integer id);

    String deleteActivityWithGoals(Integer id);
}


