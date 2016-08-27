package com.cms.api;

import com.cms.dto.*;
import com.cms.model.*;
import com.cms.repository.*;
import com.cms.utility.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by amit on 7/10/16.
 */
@Service
public class ProjectWorkApi implements IProjectWorkApi {

    @Autowired
    IProjectDAO projectDAO;
    @Autowired
    IActivityDao activityDAO;
    @Autowired
    IGoalDAO goalDAO;
    @Autowired
    IGoalActivity goalActivityDAO;
    @Autowired
    IProgressDAO progressDAO;
    @Autowired
    IProgressActivityDAO progressActivityDAO;
    @Autowired
    ITrainingCenterDAO trainingCenterDAO;


    @Override
    public String createOrEditProject(ProjectDTO dto) {

        Project project = projectDAO.findOne(dto.getId());
        if (project == null) {
            project = new Project();
        }
        project.setAidOrganisation(dto.getAidOrganisation());
        project.setBudget(dto.getBudget());
        project.setBudgetSubHeadNumber(dto.getBudgetSubHeadNumber());
        project.setProjectCode(dto.getProjectCode());
        project.setFiscalYear(dto.getFiscalYear());
        project.setProjectName(dto.getProjectName());
        project = projectDAO.save(project);
        String projectCode = project.getProjectCode();
        return projectCode;
    }

    @Override
    public List<Project> getAllProjectsByFiscalYear(String fiscalYear) {
        return projectDAO.findProjectsByFiscalYear(fiscalYear);
    }

    @Override
    public String deleteProject(Integer id) {
        projectDAO.delete(id);
        return id.toString();
    }

    @Override
    public ProjectDTO getProjectById(Integer id) {
        return ConvertUtils.convertToProjectDTO(projectDAO.findOne(id));
    }

    @Override
    public List<ActivityDTO> getActivitiesByProjectId(Integer projectId) {
        return ConvertUtils.convertToAcctivityDTO(activityDAO.findActivitiesByProjectId(projectId));
    }

    @Override
    public Project getProjectByProjectCode(String code) {
        return projectDAO.findProjectByProjectCode(code);
    }

    @Override
    public String createOrEditGoal(GoalDTO dto) {
        Goal goal = goalDAO.save(dto.getGoal());


        GoalActivity ga = goalActivityDAO.findGoalActivityByGoalIdAndActivityId(dto.getGoal().getId(), dto.getActivityId());

        if (ga == null) {
            ga = new GoalActivity();
        }
        ga.setGoal(goal);
        Activity activity = activityDAO.findOne(dto.getActivityId());
        ga.setActivity(activity);
        goalActivityDAO.save(ga);
        return goal.getId().toString();


    }

    @Override
    public List<Goal> findGoalsByActivityId(Integer activityId) {
        return goalActivityDAO.getAllGoalsByActivityId(activityId);
    }

    @Override
    public String createOrEditActivity(ActivityDTO dto) {
        Activity activity = activityDAO.findOne(dto.getId());
        if (activity == null) {
            activity = new Activity();
        }
        activity.setActivityHead(dto.getActivityHead());
        activity.setBudget(dto.getBudget());
        activity.setUnit(dto.getUnit());
        activity.setExpenseHead(dto.getExpenseHead());
        activity.setActivityName(dto.getActivityName());
        Project project = getProjectByProjectCode(dto.getProjectCode());
        activity.setProject(project);

        activityDAO.save(activity);


        return dto.getId().toString();
    }

    @Override
    public Activity getActivityById(Integer id) {
        return activityDAO.findOne(id);
    }

    @Override
    public String createOrEditProgress(ProgressDTO dto) {

        if (dto.getId() == 0) {
            return createProgress(dto);
        } else {
            return editProgress(dto);

        }

    }

    @Override
    public List<ProgressDTO> getAllSubmittedProgresses(String fiscalYear) {
        return ConvertUtils.convertToProgressesDTO(progressActivityDAO.findAllProgressSubmittedInFiscalYear(fiscalYear));
    }

    @Override
    public ProgressDTO getProgressByProgressId(Integer id) {
        return ConvertUtils.convertToProgressDTO(progressActivityDAO.findActivityProgressByProgressId(id));
    }

    @Override
    @Transactional
    public String deleteProgress(Integer id) {
        ActivityProgress pa = progressActivityDAO.findActivityProgressByProgressId(id);
        progressActivityDAO.delete(pa.getId());
        progressDAO.delete(id);
        return id.toString();
    }

    @Override
    public List<ReportDTO> getReport() {
        return null;
    }

    @Override
    public List<ReportDTO> getReportByFiscalYear(String fiscalYear) {
        return null;
    }

    @Override
    public List<Activity> getActivitiesByFiscalYear(String fiscalYear) {
        return activityDAO.findActivitiesByFiscalYear(fiscalYear);
    }

    @Override
    public List<Progress> getProgressByActivityId(Integer id) {
        return progressActivityDAO.findProgressByActivityId(id);
    }

    @Override
    public List<ProgressDTO> findProgressesByActivityId(Integer id) {
        return ConvertUtils.convertToProgressesDTO(progressActivityDAO.findProgressActivityByActivityId(id));
    }

    @Override
    public String deleteActivityWithGoals(Integer id) {
        List<GoalActivity> goalActivities = goalActivityDAO.findGoalActivityByActivityId(id);
        if (goalActivities != null) {
            goalActivityDAO.delete(goalActivities);
            for (GoalActivity ga : goalActivities) {
                goalDAO.delete(ga.getGoal().getId());

            }
        }
        activityDAO.delete(id);
        return id.toString();
    }


    private String editProgress(ProgressDTO dto) {
        Progress progress = progressDAO.findOne(dto.getId());
        progress.setDescription(dto.getDescription());
        progress.setGoalQty(dto.getGoalQty());
        progress.setProgressQty(dto.getProgressQty());
        progress.setTimeFrame(dto.getTimeFrame());
        Progress pp = progressDAO.save(progress);

        ActivityProgress activityProgress = progressActivityDAO.findActivityProgressByProgressId(dto.getId());
        activityProgress.setProgress(progress);
        activityProgress.setTrainingCenter(trainingCenterDAO.findTrainingCenterByName(dto.getTrainingCenter()));
        activityProgress.setActivity(activityDAO.findOne(dto.getActivityId()));

        progressActivityDAO.save(activityProgress);
        return progress.getId().toString();

    }

    private String createProgress(ProgressDTO dto) {
        Progress progress = new Progress();
        progress.setDescription(dto.getDescription());
        progress.setGoalQty(dto.getGoalQty());
        progress.setProgressQty(dto.getProgressQty());
        progress.setTimeFrame(dto.getTimeFrame());
        progress.setDate(new Date().toString());
        progress.setSubmittedBy(dto.getSubmittedBy());


        Progress savedProgress = progressDAO.save(progress);

        ActivityProgress ap = new ActivityProgress();

        ap.setActivity(activityDAO.findOne(dto.getActivityId()));
        ap.setProgress(savedProgress);
        ap.setTrainingCenter(trainingCenterDAO.findTrainingCenterByName(dto.getTrainingCenter()));
        progressActivityDAO.save(ap);
        return savedProgress.getId().toString();

    }


}
