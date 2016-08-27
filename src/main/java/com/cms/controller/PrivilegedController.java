package com.cms.controller;

import com.cms.dto.*;
import com.cms.model.Activity;
import com.cms.model.Goal;
import com.cms.service.IPrivilegedService;
import com.cms.service.RequestUrlToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
@Secured({"ROLE_ADMIN","ROLE_TRAINING_CENTER"})


@RequestMapping("/privileged")
public class PrivilegedController {

    @Autowired
    private IPrivilegedService privilegedService;

    @Secured({"ROLE_ADMIN","ROLE_TRAINING_CENTER"})
    @RequestMapping(value = RequestUrlToken.GET_ACTIVITY_BY_PROJECT_ID, method = RequestMethod.GET)
    @ResponseBody
    public List<ActivityDTO> showAllActivities(@PathVariable String code) throws JsonProcessingException {
        List<ActivityDTO> pjs = privilegedService.getAllActivitiesByProjectCode(code);
        return pjs;
    }
    @Secured({"ROLE_ADMIN","ROLE_TRAINING_CENTER"})
    @RequestMapping(value = RequestUrlToken.CREATE_ACTIVITY, method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody ActivityDTO dto)
            throws JsonProcessingException {
        String goalId = privilegedService.createOrEditActivity(dto);
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString(goalId + "  created successfully");
        return val;
    }
    @Secured({"ROLE_ADMIN","ROLE_TRAINING_CENTER"})
    @RequestMapping(value = RequestUrlToken.UPDATE_ACTIVITY, method = RequestMethod.PUT)
    @ResponseBody
    public String saveActivity(@RequestBody ActivityDTO dto)
            throws JsonProcessingException {
        String goalId = privilegedService.createOrEditActivity(dto);
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString(goalId + "  created successfully");
        return val;
    }
    @Secured({"ROLE_ADMIN","ROLE_TRAINING_CENTER"})
    @RequestMapping(value = RequestUrlToken.DELETE_ACTIVITY, method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteActivity(@PathVariable Integer id)
            throws JsonProcessingException {
        String activityId = privilegedService.deleteActivityWithGoalsIfProgressIsNotUpdated(id);
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString("Activity with " + activityId + "  deleted successfully");
        return val;
    }
    @Secured({"ROLE_ADMIN","ROLE_TRAINING_CENTER"})
    @RequestMapping(value = RequestUrlToken.GET_ACTIVITY, method = RequestMethod.GET)
    @ResponseBody
    public ActivityDTO getActivity(@PathVariable Integer id)
            throws JsonProcessingException {
        return privilegedService.getActivity(id);
    }


    @RequestMapping(value = RequestUrlToken.CREATE_GOAL, method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestBody GoalDTO dto)
            throws JsonProcessingException {
        String goalId = privilegedService.createOrEditGoal(dto);
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString(goalId + "  created successfully");
        return val;
    }

    @RequestMapping(value = RequestUrlToken.UPDATE_GOAL, method = RequestMethod.PUT)
    @ResponseBody
    public String saveUser(@RequestBody GoalDTO dto)
            throws JsonProcessingException {
        String goalId = privilegedService.createOrEditGoal(dto);
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString(goalId + "  updated successfully");
        return val;
    }

    @RequestMapping(value = RequestUrlToken.GET_GOALS_BY_ACTIVITY_ID, method = RequestMethod.GET)
    @ResponseBody
    public List<Goal> showAllGoals(@PathVariable Integer id)
            throws JsonProcessingException {
        List<Goal> ss = privilegedService.getAllGoalsByActivityId(id);
        return ss;
    }


    @RequestMapping(value = RequestUrlToken.GET_TRAININGS_BY_TC_ID, method = RequestMethod.GET)
    @ResponseBody
    public List<TrainingDTO> showAllActivities(@PathVariable Integer id) throws JsonProcessingException {
        List<TrainingDTO> dtos = privilegedService.getTrainingsByTrainingCenterId(id);
        return dtos;
    }

    @RequestMapping(value = RequestUrlToken.CREATE_TRAINING, method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestBody TrainingDTO dto)
            throws JsonProcessingException {
        String goalId = privilegedService.createOrEditTraining(dto);
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString(goalId + "  created successfully");
        return val;
    }

    @RequestMapping(value = RequestUrlToken.UPDATE_TRAINING, method = RequestMethod.PUT)
    @ResponseBody
    public String saveTraining(@RequestBody TrainingDTO dto)
            throws JsonProcessingException {
        String goalId = privilegedService.createOrEditTraining(dto);
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString(goalId + "  updated successfully");
        return val;
    }

    @RequestMapping(value = RequestUrlToken.DELETE_TRAINING, method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTraining(@PathVariable Integer id)
            throws JsonProcessingException {
        String goalId = privilegedService.deleteTraining(id);
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString("Training with " + goalId + "  deleted successfully");
        return val;
    }

    @RequestMapping(value = RequestUrlToken.GET_TRAINING, method = RequestMethod.GET)
    @ResponseBody
    public TrainingDTO getTraining(@PathVariable Integer id)
            throws JsonProcessingException {
        TrainingDTO dto = privilegedService.getTraining(id);
        return dto;
    }

    @RequestMapping(value = RequestUrlToken.CREATE_MEMBER, method = RequestMethod.POST)
    @ResponseBody
    public String edit(@RequestBody MemberDTO dto)
            throws JsonProcessingException {
        String memberId = privilegedService.createOrEditApplicationMember(dto);
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString(memberId + "  created successfully");
        return val;
    }

    @RequestMapping(value = RequestUrlToken.UPDATE_MEMBER, method = RequestMethod.PUT)
    @ResponseBody
    public String saveMember(@RequestBody MemberDTO dto)
            throws JsonProcessingException {
        String memberId = privilegedService.createOrEditApplicationMember(dto);
        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString(memberId + "  edited successfully");
        return val;
    }

    @RequestMapping(value = RequestUrlToken.GET_MEMBERS_BY_TRAINING_ID, method = RequestMethod.GET)
    @ResponseBody
    public List<MemberDTO> showAllMembers(@PathVariable Integer trainingId)
            throws JsonProcessingException {
        List<MemberDTO> ss = privilegedService.getAllMembersByTrainingId(trainingId);
        return ss;
    }

    @RequestMapping(value = RequestUrlToken.GET_MEMBER, method = RequestMethod.GET)
    @ResponseBody
    public MemberDTO getSingleMember(@PathVariable Integer id)
            throws JsonProcessingException {

        return privilegedService.getMemberByMemberId(id);
    }

    @RequestMapping(value = RequestUrlToken.DELETE_MEMBER, method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteMember(@PathVariable Integer id)
            throws JsonProcessingException {

        String memberId = privilegedService.deleteMember(id);

        ObjectMapper mapper = new ObjectMapper();
        String val = mapper.writeValueAsString(memberId);
        return val;
    }

    @RequestMapping(value = RequestUrlToken.CREATE_PROGRESS, method = RequestMethod.POST)
    @ResponseBody
    public String createProgress(@RequestBody ProgressDTO dto, Principal principal)
            throws JsonProcessingException {
         dto.setSubmittedBy(principal.getName());
        String progressId = privilegedService.createSubmittedProgress(dto);
        return progressId;
    }
    @RequestMapping(value = RequestUrlToken.GET_PROGRESSES_BY_ACTIVITY_ID, method = RequestMethod.GET)
    @ResponseBody
    public List<ProgressDTO> getAllProgresses(@PathVariable Integer id)
            throws JsonProcessingException {
        List<ProgressDTO> dtos = privilegedService.getAllProgressesByActivityId(id);
        return dtos;
    }

    @RequestMapping(value = RequestUrlToken.GET_PROGRESS, method = RequestMethod.GET)
    @ResponseBody
    public ProgressDTO getProgress(@PathVariable Integer id)
            throws JsonProcessingException {

        return privilegedService.getProgressByItsId(id);
    }
    @RequestMapping(value = RequestUrlToken.DELETE_PROGRESS, method = RequestMethod.DELETE)
    @ResponseBody
    public String  deleteProgress(@PathVariable Integer id)
            throws JsonProcessingException {

        return privilegedService.deleteProgress(id);
    }



}