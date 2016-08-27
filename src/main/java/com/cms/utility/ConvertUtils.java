package com.cms.utility;

import com.cms.dto.*;
import com.cms.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ConvertUtils {


    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        if (user.getUserInfo() != null) {

            userDTO.setFirstName(user.getUserInfo().getFirstName());
            userDTO.setLastName(user.getUserInfo().getLastName());
            userDTO.setMiddleName(user.getUserInfo().getMiddleName());
            userDTO.setStreetAddress(user.getUserInfo().getStreetAddress());
            userDTO.setVdcOrMunicipality(user.getUserInfo().getVdc());
            userDTO.setDistrict(user.getUserInfo().getDistrict());
            userDTO.setZone(user.getUserInfo().getZone());
            userDTO.setCountry(user.getUserInfo().getCountry());
            userDTO.setEmail(user.getUserInfo().getEmail());
            userDTO.setLandlineNumber(user.getUserInfo().getLandlineNumber());
            userDTO.setMobileNumber(user.getUserInfo().getMobileNumber());
//            Date date=null;
//            SimpleDateFormat tt= new SimpleDateFormat("mm/dd/yyyy");
//            try {
//                  date =(Date) tt.parse("");
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
            userDTO.setDob(user.getUserInfo().getDob());
            userDTO.setMale(user.getUserInfo().isMale());
        }
        if (user.getRoles() != null) {
            userDTO.setRoles(user.getRoles());
        }

        return userDTO;
    }

    public static List<UserDTO> convertToUserDTOs(List<User> users) {
        List<UserDTO> dtos = new ArrayList<UserDTO>();
        for (User user : users) {
            dtos.add(ConvertUtils.convertToUserDTO(user));
        }
        return dtos;
    }

    public static ProjectDTO convertToProjectDTO(Project p) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(p.getId());
        dto.setProjectCode(p.getProjectCode());
        dto.setFiscalYear(p.getFiscalYear());
        dto.setBudgetSubHeadNumber(p.getBudgetSubHeadNumber());
        dto.setAidOrganisation(p.getAidOrganisation());
        dto.setProjectName(p.getProjectName());
        dto.setBudget(p.getBudget());
        return dto;
    }

    public static List<ProjectDTO> convertToProjectDTOs(List<Project> projects) {
        List<ProjectDTO> dtos = new ArrayList<ProjectDTO>();
        for (Project project : projects) {
            dtos.add(ConvertUtils.convertToProjectDTO(project));
        }
        return dtos;
    }


    public static List<TrainingCenterDTO> convertToTrainingCenterDTOs(List<TrainingCenter> tcs) {
        List<TrainingCenterDTO> dtos = new ArrayList<TrainingCenterDTO>();
        for (TrainingCenter tc : tcs) {
            dtos.add(ConvertUtils.convertToTrainingCenterDTO(tc));
        }
        return dtos;

    }

    public static TrainingCenterDTO convertToTrainingCenterDTO(TrainingCenter tc) {
        TrainingCenterDTO dto = new TrainingCenterDTO();
        dto.setId(tc.getId());
        dto.setName(tc.getName());
        dto.setAddress(tc.getAddress());
        dto.setDistrict(tc.getDistrict());
        dto.setZone(tc.getZone());
        if (tc.getParentTrainingCenter() != null) {
            dto.setParentTrainingCenter(tc.getParentTrainingCenter().getName());
        }
        return dto;
    }

    public static List<TrainingDTO> convertToTrainingDTOs(List<Training> trainings) {
        List<TrainingDTO> dtos = new ArrayList<TrainingDTO>();
        for (Training t : trainings) {
            dtos.add(ConvertUtils.convertToTrainingDTO(t));
        }
        return dtos;
    }


    public static TrainingDTO convertToTrainingDTO(Training t) {
        TrainingDTO dto = new TrainingDTO();
        dto.setId(t.getId());
        dto.setName(t.getName());
        dto.setBudget(t.getBudget());
        dto.setStart(t.getStartDate() );
        dto.setEnd(t.getEndDate());
        dto.setTarget(t.getTarget());
        dto.setDuration(t.getDuration());
        return dto;

    }


    public static List<MemberDTO> convertToMemberDTOs(List<Member> members) {
        List<MemberDTO> dtos = new ArrayList<MemberDTO>();
        for (Member m : members) {
            dtos.add(ConvertUtils.convertToMemberDTO(m));
        }
        return dtos;


    }

    public static MemberDTO convertToMemberDTO(Member m) {
        MemberDTO dto = new MemberDTO();
        dto.setMemberId(m.getId());
        dto.setFirstName(m.getFirstName());
        dto.setMiddleName(m.getMiddleName());
        dto.setLastName(m.getLastName());
        dto.setMobileNumber(m.getMobileNumber());
        dto.setLandlineNumber(m.getLandlineNumber());
        dto.setEmail(m.getEmail());
        dto.setStreetAddress(m.getStreetAddress());
        dto.setVdcOrMunicipality(m.getVdcOrMunicipality());
        dto.setDistrict(m.getDistrict());
        dto.setZone(m.getZone());
        dto.setCountry(m.getCountry());
        dto.setDob(m.getDob());
        dto.setWorkplace(m.getWorkplace());
        dto.setOrganisation(m.getOrganisation());
        dto.setMemberType(m.getMemberType());
        dto.setTrainingId(m.getTraining().getId());
        dto.setMale(m.isMale());
        return dto;
    }

    public static List<ActivityDTO> convertToAcctivityDTO(List<Activity> activities) {
        List<ActivityDTO> dtos = new ArrayList<ActivityDTO>();
        for (Activity a : activities) {
            dtos.add(ConvertUtils.convertToActivityDTO(a));
        }
        return dtos;
    }

    private static ActivityDTO convertToActivityDTO(Activity a) {
        ActivityDTO dto = new ActivityDTO();
        dto.setId(a.getId());
        dto.setUnit(a.getUnit());
        dto.setActivityName(a.getActivityName());
        dto.setExpenseHead(a.getExpenseHead());
        dto.setActivityHead(a.getActivityHead());
        dto.setProjectCode(a.getProject().getProjectCode());
        dto.setBudget(a.getBudget());

        return dto;
    }


    public static List<ProgressDTO> convertToProgressesDTO(List<ActivityProgress> all) {
        List<ProgressDTO> dtos = new ArrayList<ProgressDTO>();
        for (ActivityProgress ap : all) {
            dtos.add(ConvertUtils.convertToProgressDTO(ap));
        }
        return dtos;

    }

    public static ProgressDTO convertToProgressDTO(ActivityProgress ap) {
        Progress progress = ap.getProgress();
        Activity a = ap.getActivity();
        TrainingCenter tc = ap.getTrainingCenter();

        ProgressDTO dto = new ProgressDTO();
        dto.setId(progress.getId());
        dto.setDescription(progress.getDescription());
        dto.setGoalQty(progress.getGoalQty());
        dto.setProgressQty(progress.getProgressQty());
        dto.setTimeFrame(progress.getTimeFrame());

        dto.setTrainingCenter(tc.getName());
        dto.setDate(progress.getDate());

        dto.setSubmittedBy(progress.getSubmittedBy());
        dto.setActivityId(a.getId());
        dto.setActivityName(a.getActivityName());
        dto.setProjectName(ap.getActivity().getProject().getProjectName());
        return dto;
    }

    public static ReportDTO convertToReportDTO(Activity a, Goal g1, Goal g2, Goal g3, Goal yearlyGoal, Progress q1, Progress q2, Progress q3, Progress yearlyProgress) {
        ReportDTO dto = new ReportDTO();
        dto.setActivityDTO(ConvertUtils.convertToActivityDTO(a));
        dto.setG(yearlyGoal);
        dto.setG1(g1);
        dto.setG2(g2);
        dto.setG3(g3);
        dto.setP(yearlyProgress);
        dto.setP1(q1);
        dto.setP2(q2);
        dto.setP3(q3);
        return dto;
    }

    public static TrainingReportDTO convertToTrainingReportDTO(Training oneTraining, int numberOfAttendees, int numberOfMale, int numberOfFemale) {

        TrainingReportDTO dto = new TrainingReportDTO();
        dto.setName(oneTraining.getName());
        //dto.setTimeFrame(oneTraining.get);
        dto.setBudget(oneTraining.getBudget());
        dto.setStartDate(oneTraining.getStartDate());
        dto.setEndDate(oneTraining.getEndDate());
        dto.setDuration(oneTraining.getDuration());
        dto.setTarget(oneTraining.getTarget());
        dto.setMaleFrequency(numberOfMale);
        dto.setFemaleFrequency(numberOfFemale);
        dto.setNoOfAttendees(numberOfAttendees);
        return dto;
    }

    public static ActivityDTO converToActivityDTO(Activity activity) {
        ActivityDTO dto = new ActivityDTO();
        dto.setId(activity.getId());
        dto.setBudget(activity.getBudget());
        dto.setProjectCode(activity.getProject().getProjectCode());
        dto.setExpenseHead(activity.getExpenseHead());
        dto.setUnit(activity.getUnit());
        dto.setActivityHead(activity.getActivityHead());
        dto.setActivityName(activity.getActivityName());
        return dto;
    }




}

