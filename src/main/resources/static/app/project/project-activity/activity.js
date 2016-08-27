(function () {
    'use strict';

    angular.module('app.project')
        .controller('Activity', Activity);
    Activity.$inject = ['projectservice','progressservice', 'activityservice', 'goalservice', '$scope', 'NgTableParams', 'logger', '$routeParams', '$http','$rootScope'];
    function Activity(projectservice,progressservice, activityservice, goalservice, $scope, NgTableParams, logger, $routeParams, $http,$rootScope) {
        if ($rootScope.userHasRole("ROLE_ADMIN")) {
            $scope.showMe = true;
        }
        var pCode = $routeParams.code;
        var fYear = $routeParams.fiscalYear;
        projectservice.findProjectByCode({code:pCode}).$promise.then(function(data){
            vm.mainTitle = " Activity Panel of ' Project  ' : " + "' "+data.projectName+" '" ;
        })
        findAllActivities(pCode, fYear);

        $scope.activitymodel = {};


        // alert($routeParams.code);
        $scope.initCreatePanel = function () {
            $scope.clearValidationMessages();
            // $scope.clearValidationMessages();
            vm.riskyId = 0;


            vm.title = "Create Project Activity Panel";

            vm.showCreatePanel = !vm.showCreatePanel;
            $scope.btnText = "Create ";
        }

        $scope.submitFormss = function (isValid) {
            if (isValid) {
                $scope.eitherCreateOrEdit();
            }
            else {
                showValidationErrors();
            }

        }
        function showValidationErrors() {
            $scope.submitted = true;
            // $scope.userForm.username.$error.required=true;
        }

        $scope.eitherCreateOrEdit = function () {


            var p = {projectCode: pCode};
            var x = {
                id: vm.riskyId,
                activityHead: $scope.activitymodel.activityHead,
                activityName: $scope.activitymodel.activityName,
                expenseHead: $scope.activitymodel.expenseHead,
                budget: $scope.activitymodel.budget,
                unit: $scope.activitymodel.unit,
                projectCode: pCode


            }

            createOrEditActivity(x);

        }


        $scope.clearValidationMessages = function () {
            $scope.submitted = false;

            //clear validation messages for username
            $scope.activitymodel.activityHead = "";
            $scope.activityForm.activityHead.$pristine = true;

            $scope.activitymodel.activityName = "";
            $scope.activityForm.activityName.$pristine = true;

            //clear validation messages for username
            $scope.activitymodel.expenseHead = "";
            $scope.activityForm.expenseHead.$pristine = true;
            //clear validation messages for username
            $scope.activitymodel.unit = "";
            $scope.activityForm.unit.$pristine = true;
            //clear validation messages for username
            $scope.activitymodel.budget = "";
            $scope.activityForm.budget.$pristine = true;


        }


        $scope.initEditPanel = function (aid) {
            $scope.clearValidationMessages();
            $scope.btnText = "Update";
            vm.riskyId = aid;
            getSingleProjectActivity(aid);

            vm.title = "Edit Project Activity Panel";
            vm.showCreatePanel = true;
        }


        $scope.deleteTheActivity = function (aId) {


            progressservice.findAllProgressesByActivityId({id: aId}).$promise.then(function (data) {
                if (data.length > 0) {
                    alert("cannot delete ! This activity is associated with progress");
                }
                else {
                    if (confirm("Are you sure you want to delete ?")) {
                        activityservice.deleteActivity({id: aId}).$promise.then(function (data) {
                            findAllActivities(pCode, fYear);
                        });

                    }

                }
            })


        }


        $scope.initializeGoalPanel = function (aid,activityName) {

            vm.showGoalPanel = true;
            vm.goalTitle = "Update Goal Panel in ' Activity ' : " + "' "+activityName+" '" ;
            $scope.q1btnText = "Create";
            $scope.q2btnText = "Create";
            $scope.q3btnText = "Create";
            $scope.activityId = aid;
            getGoalsByActivityIdAndSetModels(aid);


        }
        $scope.q1submitFormss = function (isValid) {
            if (isValid) {
                var x = {
                    goal: {
                        id: $scope.q1goalmodel.id,
                        qty: $scope.q1goalmodel.qty,
                        weightage: $scope.q1goalmodel.weightage,
                        budget: $scope.q1goalmodel.budget,
                        timeFrame: "FIRST_TRIMESTER"
                    },
                    activityId: $scope.activityId
                }
                $scope.eitherCreateOrEditGoal(x);
            }
            else {
                //showValidationErrors();
            }

        }
        $scope.q2submitFormss = function (isValid) {
            if (isValid) {
                var x = {
                    goal: {
                        id: $scope.q2goalmodel.id,
                        qty: $scope.q2goalmodel.qty,
                        weightage: $scope.q2goalmodel.weightage,
                        budget: $scope.q2goalmodel.budget,
                        timeFrame: "SECOND_TRIMESTER"

                    },
                    activityId: $scope.activityId
                }
                $scope.eitherCreateOrEditGoal(x);
            }
            else {
                // showValidationErrors();
            }

        }
        $scope.q3submitFormss = function (isValid) {
            if (isValid) {
                var x = {
                    goal: {

                        id: $scope.q3goalmodel.id,
                        qty: $scope.q3goalmodel.qty,
                        weightage: $scope.q3goalmodel.weightage,
                        budget: $scope.q3goalmodel.budget,
                        timeFrame: "THIRD_TRIMESTER"

                    },
                    activityId: $scope.activityId
                }
                $scope.eitherCreateOrEditGoal(x);
            }
            else {
                // showValidationErrors();
            }

        }
        $scope.submitFormss = function (isValid) {
            if (isValid) {
                $scope.eitherCreateOrEdit();
            }
            else {
                // showValidationErrors();
            }

        }

        $scope.closeThePanel = function () {
            vm.showCreatePanel = !vm.showCreatePanel;
        }
        $scope.closeTheGoalPanel = function () {
            vm.showGoalPanel = !vm.showGoalPanel;
        }

        $scope.eitherCreateOrEditGoal = function (goal) {


            createOrEditGoal(goal);

        }
        $scope.clearForm = function () {
            $scope.q1goalmodel = {};
            $scope.q2goalmodel = {};
            $scope.q3goalmodel = {};
            $scope.q1goalmodel.id = 0;
            $scope.q1goalmodel.qty = "";
            $scope.q1goalmodel.weightage = "";
            $scope.q1goalmodel.budget = "";
            $scope.q2goalmodel.id = 0;
            $scope.q2goalmodel.qty = "";
            $scope.q2goalmodel.weightage = "";
            $scope.q2goalmodel.budget = "";
            $scope.q3goalmodel.id = 0;
            $scope.q3goalmodel.qty = "";
            $scope.q3goalmodel.weightage = "";
            $scope.q3goalmodel.budget = "";
            //$scope.projectmodel.projectCode = "";
            //$scope.projectForm.projectCode.$pristine = true;


            //clear validation messages for username
            //$scope.projectmodel.projectName = "";
            $scope.q1GoalForm.qty.$pristine = true;
            $scope.q2GoalForm.qty.$pristine = true;
            $scope.q3GoalForm.qty.$pristine = true;
            $scope.q1GoalForm.weightage.$pristine = true;
            $scope.q2GoalForm.weightage.$pristine = true;
            $scope.q3GoalForm.weightage.$pristine = true;
            $scope.q1GoalForm.budget.$pristine = true;
            $scope.q2GoalForm.budget.$pristine = true;
            $scope.q3GoalForm.budget.$pristine = true;


        }

        findAllActivities(pCode, fYear);
        //$scope.submitted = false;
        var self = this;
        var vm = this;

        function createOrEditGoal(goal) {
            goalservice.addGoal(goal).$promise.then(function (data) {
                // findAll();
               if(goal.goal.id==undefined){
                   alert("Goal created successfully");

               }
                else{
                   alert("Goal updated successfully")
               }
                getGoalsByActivityIdAndSetModels($scope.activityId);
               // $scope.closeTheGoalPanel();
            });

        }

        function getSingleProjectActivity(activityId) {
            activityservice.getSingleActivity({id: activityId}).$promise.then(function (data) {
                setProjectModels(data);
                vm.title = "Edit Activity Panel of ' Activity ' : " + "' " + data.activityName + " '";

            });


        }

        function setProjectModels(data) {
            $scope.activitymodel.activityHead = data.activityHead;
            $scope.activitymodel.expenseHead = data.expenseHead;
            $scope.activitymodel.budget = data.budget;
            $scope.activitymodel.unit = data.unit;
            $scope.activitymodel.activityName = data.activityName;


            //$scope.activitymodel.project = data.fiscalYear;

        }

        function createOrEditActivity(activity) {
            activityservice.addActivity(activity).$promise.then(function (data) {
                findAllActivities(pCode, fYear);
                $scope.closeThePanel();
            });

        }

        var heroes = [];

        function findAllActivities(pCode, fYear) {


            activityservice.findAllActivities({id: pCode}).$promise.then(function (data) {

                self.tableParams = new NgTableParams({}, {dataset: data});
            });


        }

        function getGoalsByActivityIdAndSetModels(aid) {

            $scope.clearForm();
            goalservice.getGoalsByActivityId({id: aid}).$promise.then(function (goals) {
                goals.forEach(function (goal) {
                    if (goal.timeFrame == "FIRST_TRIMESTER") {
                        $scope.q1goalmodel = {};
                        $scope.q1goalmodel.id = goal.id;
                        $scope.q1goalmodel.qty = goal.qty;
                        $scope.q1goalmodel.weightage = goal.weightage;
                        $scope.q1goalmodel.budget = goal.budget;
                        $scope.q1btnText = "Update";

                    }

                    if (goal.timeFrame == "SECOND_TRIMESTER") {
                        $scope.q2goalmodel = {};
                        $scope.q2goalmodel.id = goal.id;
                        $scope.q2goalmodel.qty = goal.qty;
                        $scope.q2goalmodel.weightage = goal.weightage;
                        $scope.q2goalmodel.budget = goal.budget;
                        $scope.q2btnText = "Update";

                    }

                    if (goal.timeFrame == "THIRD_TRIMESTER") {
                        $scope.q3goalmodel = {};
                        $scope.q3goalmodel.id = goal.id;
                        $scope.q3goalmodel.qty = goal.qty;
                        $scope.q3goalmodel.weightage = goal.weightage;
                        $scope.q3goalmodel.budget = goal.budget;
                        $scope.q3btnText = "Update";

                    }

                });
            });
        }
    }

})();
