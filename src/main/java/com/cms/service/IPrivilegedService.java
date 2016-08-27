package com.cms.service;

import com.cms.dto.*;
import com.cms.model.Activity;
import com.cms.model.Goal;

import java.util.List;

/**
 * Created by amit on 7/15/16.
 */
public interface IPrivilegedService {
    List<ActivityDTO> getAllActivitiesByProjectId(Integer projectId);

    String createOrEditActivity(ActivityDTO dto);

    ActivityDTO getActivity(Integer id);

    String deleteActivity(Integer projectId,Integer activityId);


    public List<ActivityDTO> getAllActivitiesByProjectCode(String  code);

    String createOrEditGoal(GoalDTO  dto);

    List<Goal> getAllGoalsByActivityId(Integer activityId);

    List<TrainingDTO> getTrainingsByTrainingCenterId(Integer id);

    String createOrEditTraining(TrainingDTO dto);

    TrainingDTO getTraining(Integer id);

    String createOrEditApplicationMember(MemberDTO dto);

    List<MemberDTO> getAllMembersByTrainingId(Integer trainingId);

    MemberDTO getMemberByMemberId(Integer id);

    String deleteMember(Integer id);

    String deleteTraining(Integer trainingId);


    String createSubmittedProgress(ProgressDTO dto);

  //  List<ProgressDTO> getAllProgresses();

    ProgressDTO getProgressByItsId(Integer id);

    String deleteProgress(Integer id);

    List<ReportDTO> getReportForProjectWork();

    List<ProgressDTO> getAllProgressesByActivityId(Integer id);

    String deleteActivityWithGoalsIfProgressIsNotUpdated(Integer id);
}
