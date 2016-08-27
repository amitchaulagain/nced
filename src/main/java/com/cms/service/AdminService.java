package com.cms.service;

import com.cms.api.IProjectWorkApi;
import com.cms.api.ITrainingApi;
import com.cms.dto.*;
import com.cms.model.*;
import com.cms.utility.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 6/16/16.
 */

@Service
public class AdminService implements IAdminService {
    @Autowired
    IProjectWorkApi projectWorkApi;
    @Autowired
    ITrainingApi trainingApi;

    @Override
    public List<ProjectDTO> getAllProjectsByFiscalYear(String fiscalYear) {
        return ConvertUtils.convertToProjectDTOs(projectWorkApi.getAllProjectsByFiscalYear(fiscalYear));
    }

    @Override
    public String createOrEditProject(ProjectDTO dto) {
        return projectWorkApi.createOrEditProject(dto);
    }

    @Override
    public ProjectDTO getProject(Integer id) {
        return projectWorkApi.getProjectById(id);
    }

    @Override
    public String deleteProject(Integer id) {
        return projectWorkApi.deleteProject(id);
    }

    @Override
    public String createOrEditTrainingCenter(TrainingCenterDTO tc) {
        return trainingApi.createOrEditTrainingCenter(tc);
    }

    @Override
    public TrainingCenterDTO getTrainingCenter(Integer id) {
        return trainingApi.findTrainingCenterById(id);
    }

    @Override
    public String deleteTrainingCenter(Integer id) {
        return trainingApi.deleteTrainingCenter(id);
    }

    @Override
    public List<TrainingCenterDTO> getAllTrainingCenters() {
        return trainingApi.findAllTrainingCenter();
    }

    @Override
    public List<TrainingCenterDTO> getAllParentTrainingCenters() {
        return trainingApi.findAllParentTrainingCenter();
    }

    @Override
    public List<ReportDTO> getReportForProjectWork(String fiscalYear) {
        List<Activity> activities = projectWorkApi.getActivitiesByFiscalYear(fiscalYear);
        List<ReportDTO> dtos = new ArrayList<ReportDTO>();

        for (Activity a : activities) {
            List<Goal> ga = projectWorkApi.findGoalsByActivityId(a.getId());

            Progress q1 = new Progress();
            Progress q2 = new Progress();
            Progress q3 = new Progress();
            Progress yearlyProgress = new Progress();

            Goal yearlyGoal = calculateYearlyGoal(ga);
            Goal g1 = null;
            Goal g2 = null;
            Goal g3 = null;
            for (Goal g : ga) {
                if (g.getTimeFrame() == TimeFrame.FIRST_TRIMESTER) {
                    g1 = new Goal(g.getQty(), g.getWeightage(), g.getBudget());
                } else if (g.getTimeFrame() == TimeFrame.SECOND_TRIMESTER) {
                    g2 = new Goal(g.getQty(), g.getWeightage(), g.getBudget());
                } else if (g.getTimeFrame() == TimeFrame.THIRD_TRIMESTER) {
                    g3 = new Goal(g.getQty(), g.getWeightage(), g.getBudget());
                }

            }

            List<Progress> progressList = projectWorkApi.getProgressByActivityId(a.getId());
            int q1TotalProgressQty = 0;
            int q2TotalProgressQty = 0;
            int q3TotalProgressQty = 0;
            for (Progress p : progressList) {
                if (p.getTimeFrame() == TimeFrame.FIRST_TRIMESTER) {
                    q1TotalProgressQty += p.getProgressQty();
                } else if (p.getTimeFrame() == TimeFrame.SECOND_TRIMESTER) {
                    q2TotalProgressQty += p.getProgressQty();
                } else if (p.getTimeFrame() == TimeFrame.THIRD_TRIMESTER) {
                    q3TotalProgressQty += p.getProgressQty();
                }
            }
            int yearlyProgressQty = q1TotalProgressQty + q2TotalProgressQty + q3TotalProgressQty;

            q1.setProgressQty(q1TotalProgressQty);
            q1.setTimeFrame(TimeFrame.FIRST_TRIMESTER);
            if (g1 != null) {
                if (g1.getQty() == 0) {

                    q1.setWeightedProgress(0);
                }
                else{
                    q1.setWeightedProgress(q1TotalProgressQty / g1.getQty() * g1.getWeightage());
                }
            }

            q2.setProgressQty(q2TotalProgressQty);
            q2.setTimeFrame(TimeFrame.SECOND_TRIMESTER);
            if (g2 != null) {
                if (g2.getQty() == 0) {

                    q2.setWeightedProgress(0);
                }
                else{
                    q2.setWeightedProgress(q2TotalProgressQty / g2.getQty() * g2.getWeightage());
                }
            }

            q3.setProgressQty(q3TotalProgressQty);
            q3.setTimeFrame(TimeFrame.THIRD_TRIMESTER);
            if (g3 != null) {
                if (g3.getQty() == 0) {

                    q3.setWeightedProgress(0);
                }
                else{
                    q3.setWeightedProgress(q3TotalProgressQty / g3.getQty() * g3.getWeightage());
                }
            }

            yearlyProgress.setProgressQty(yearlyProgressQty);
            yearlyProgress.setTimeFrame(TimeFrame.YEARLY);
            if (yearlyGoal != null) {
                if (yearlyGoal.getQty() == 0) {

                    yearlyProgress.setWeightedProgress(0);
                }
                else{
                    double val=(double) yearlyProgressQty / yearlyGoal.getQty();
                    yearlyProgress.setWeightedProgress(val* yearlyGoal.getWeightage());
                }
            }

            ReportDTO dto = ConvertUtils.convertToReportDTO(a, g1, g2, g3, yearlyGoal, q1, q2, q3, yearlyProgress);

            dtos.add(dto);


        }


        return dtos;
    }

    @Override
    public List<TrainingReportDTO> getReportForTraining(String fiscalYear) {

        List<Training> trainings = trainingApi.getTrainingByFiscalYear(fiscalYear);
        List<TrainingReportDTO> dtos = new ArrayList<TrainingReportDTO>();

        for (Training oneTraining : trainings) {

            int id = oneTraining.getId();

            int numberOfAttendees = trainingApi.countNumberOfAttendeesInTraining(id);

            int numberOfMale = trainingApi.countNumberOfMale(id);

            int numberOfFemale = numberOfAttendees - numberOfMale;


            TrainingReportDTO dto = ConvertUtils.convertToTrainingReportDTO(oneTraining, numberOfAttendees, numberOfMale, numberOfFemale);
            dtos.add(dto);
        }


        return dtos;

    }

    @Override
    public List<ProgressDTO> getProgressReport(String fiscalYear) {
        return projectWorkApi.getAllSubmittedProgresses(fiscalYear);
    }

    @Override
    public String getChildTrainingCenter(Integer id) {
        return trainingApi.countChildTrainingCenter(id);
    }

    @Override
    public ProjectDTO getSingleProjectByCode(String code) {
        return ConvertUtils.convertToProjectDTO(projectWorkApi.getProjectByProjectCode(code));
    }

    private Goal calculateYearlyGoal(List<Goal> ga) {
        int qty = 0;
        int weightage = 0;
        double budget = 0;

        for (Goal g : ga) {
            qty += g.getQty();
            weightage += g.getWeightage();
            budget += g.getBudget();

        }
        Goal yearlyGoal = new Goal(qty, weightage, budget);

        return yearlyGoal;
    }
}
