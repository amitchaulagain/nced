package com.cms.service;

import com.cms.api.IProjectWorkApi;
import com.cms.api.ITrainingApi;
import com.cms.dto.*;
import com.cms.model.Activity;
import com.cms.model.Goal;
import com.cms.model.Project;
import com.cms.utility.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by amit on 6/16/16.
 */

@Service
public class PriviligedService implements IPrivilegedService {
    @Autowired
    IProjectWorkApi projectWorkApi;
    @Autowired
    ITrainingApi trainingApi;


    @Override
    public List<ActivityDTO> getAllActivitiesByProjectId(Integer projectId) {
        return projectWorkApi.getActivitiesByProjectId(projectId);
    }
    @Override
    public List<ActivityDTO> getAllActivitiesByProjectCode(String code) {
          Project project= projectWorkApi.getProjectByProjectCode(code);
       return projectWorkApi.getActivitiesByProjectId(project.getId());

    }

    @Override
    public String createOrEditGoal(GoalDTO dto) {
        return projectWorkApi.createOrEditGoal(dto);
    }

    @Override
    public List<Goal> getAllGoalsByActivityId(Integer activityId) {
        return projectWorkApi.findGoalsByActivityId(activityId);
    }


    @Override
    public String createOrEditActivity(ActivityDTO a) {
        return projectWorkApi.createOrEditActivity(a);
    }

    @Override
    public ActivityDTO getActivity(Integer id) {
        return ConvertUtils.converToActivityDTO(projectWorkApi.getActivityById(id));
    }

    @Override
    public String deleteActivity(Integer projectId, Integer activityId) {
        return null;
    }

    @Override
    public List<TrainingDTO> getTrainingsByTrainingCenterId(Integer id) {
        return trainingApi.findTrainingsConductedByTrainingCenterId(id);
    }

    @Override
    public String createOrEditTraining(TrainingDTO dto) {
        return trainingApi.createOrEditTraining(dto);
    }

    @Override
    public TrainingDTO getTraining(Integer id) {
        return trainingApi.getSingleTraining(id);
    }

    @Override
    public String createOrEditApplicationMember(MemberDTO dto) {
        return trainingApi.createOrEditMember(dto);
    }

    @Override
    public List<MemberDTO> getAllMembersByTrainingId(Integer trainingId) {
        return trainingApi.findMembersByTrainingId(trainingId);
    }

    @Override
    public MemberDTO getMemberByMemberId(Integer id) {
        return trainingApi.getSingleMember(id);
    }

    @Override
    public String deleteMember(Integer id) {
        return trainingApi.deleteMember(id);
    }

    @Override
    public String deleteTraining(Integer trainingId) {
        return trainingApi.deleteTraining(trainingId);
    }

    @Override
    public String createSubmittedProgress(ProgressDTO dto) {
        return projectWorkApi.createOrEditProgress(dto);
    }

//    @Override
//    public List<ProgressDTO> getAllProgresses() {
//        return projectWorkApi.getAllSubmittedProgresses();
//    }

    @Override
    public ProgressDTO getProgressByItsId(Integer id) {
        return projectWorkApi.getProgressByProgressId(id);
    }

    @Override
    public String deleteProgress(Integer id) {
        return projectWorkApi.deleteProgress(id);
    }

    @Override
    public List<ReportDTO> getReportForProjectWork() {
        return projectWorkApi.getReport();
    }

    @Override
    public List<ProgressDTO> getAllProgressesByActivityId(Integer id) {
        return projectWorkApi.findProgressesByActivityId(id);
    }

    @Override
    public String deleteActivityWithGoalsIfProgressIsNotUpdated(Integer id) {
        return projectWorkApi.deleteActivityWithGoals(id);
    }


}
