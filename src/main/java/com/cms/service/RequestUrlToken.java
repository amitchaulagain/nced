package com.cms.service;

import org.springframework.stereotype.Service;

/**
 * Created by amit on 6/16/16.
 */


public class RequestUrlToken {

   /* CRUD for Users*/
    public static final String CREATE_USER = "/user";
    public static final String UPDATE_USER = "/users";
    public static final String GET_USER = "/user/{id}";
    public static final String DELETE_USER = "/user/{id}";
    public static final String GET_USERS = "/users";

    /* CRUD for Projects*/
    public static final String CREATE_PROJECT = "/projects";
    public static final String UPDATE_PROJECT= "/projects";
    public static final String GET_PROJECT= "/project/pid/{id}";
    public static final String DELETE_PROJECT = "/project/{id}";
    public static final String GET_PROJECTS = "/projects";
    public static final String GET_PROJECTS_BY_FISCAL_YEAR = "/project/{fiscalYear}";
    public static final String GET_PROJECT_BY_CODE = "/project/code/{code}";

 /* CRUD for Activities*/
 public static final String CREATE_ACTIVITY = "/activity";
 public static final String UPDATE_ACTIVITY= "/activity";
 public static final String GET_ACTIVITY_BY_PROJECT_ID= "/activity/code/{code}";
 public static final String DELETE_ACTIVITY= "/activity/{id}";
 public static final String GET_ACTIVITY= "/activity/{id}";




 /* CRUD for GOAL*/
 public static final String CREATE_GOAL = "/activity-goal";
 public static final String UPDATE_GOAL = "/activity-goal";
 public static final String GET_GOALS_BY_ACTIVITY_ID = "/activity-goal/{id}";


 /* CRUD for TRAINING CENTERS*/
 public static final String CREATE_TC = "/trainingCenter";
 public static final String UPDATE_TC = "/trainingCenter";
 public static final String DELETE_TC = "/trainingCenter/{id}";
 public static final String GET_TC = "/trainingCenter/{id}";
 public static final String GET_TCS = "/trainingCenters";
 public static final String GET_PARENT_TCS = "/parentTrainingCenters";
 public static final String GET_CHILD_TCS = "/childTrainingCenter/{id}";





 /* CRUD for TRAINING  */
 public static final String CREATE_TRAINING = "/training";
 public static final String UPDATE_TRAINING = "/training";
 public static final String DELETE_TRAINING = "/training/{id}";
 public static final String GET_TRAINING = "/training/{id}";
 public static final String GET_TRAININGS_BY_TC_ID = "/trainings/{id}";
 public static final String GET_PARENT_TRAININGS = "/parentTrainingCenters";



 /* CRUD for Users*/
 public static final String CREATE_MEMBER= "/member";
 public static final String UPDATE_MEMBER= "/members";
 public static final String GET_MEMBER= "/member/{id}";
 public static final String DELETE_MEMBER= "/member/{id}";
 public static final String GET_MEMBERS_BY_TRAINING_ID = "/members/training/{trainingId}";


 /* CRUD for Progress*/
 public static final String CREATE_PROGRESS= "/progress";
 public static final String UPDATE_PROGRESS= "/progress";
 public static final String GET_PROGRESS= "/progress/{id}";
 public static final String DELETE_PROGRESS= "/progress/{id}";
 public static final String GET_PROGRESSES_BY_ACTIVITY_ID = "/activity-progress/{id}";



/* FOR REPORTS*/

 public static final String VIEW_REPORT = "/report/{fiscalYear}";
 public static final String VIEW_TRAINING_REPORT = "/treport/{fiscalYear}";
 public static final String VIEW_PROGRESS_REPORT = "/report/progresses/{fiscalYear}";


}
