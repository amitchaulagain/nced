(function () {
    'use strict';

    angular.module('app.project')
        .controller('Progress', Progress);
    Progress.$inject = ['activityservice', 'reportservice', 'progressservice', 'trainingcenterservice', '$scope', 'NgTableParams', 'logger', '$routeParams', '$rootScope'];

    function Progress(activityservice, reportservice, progressservice, trainingcenterservice, $scope, NgTableParams, logger, $routeParams, $rootScope) {
        var vm = this;
        var self = this;
        var activityId = $routeParams.activityId;
        // alert(pCode);
        if (activityId != undefined) {
            vm.forReport = true;
            activityservice.getSingleActivity({id: activityId}).$promise.then(function (data) {
                vm.title = "Progress View Panel of ' Activity ' : " + "' " + data.activityName + " '";

            });

            $scope.timeFrame = ["FIRST_TRIMESTER", "SECOND_TRIMESTER", "THIRD_TRIMESTER", "SELECT"];
            $scope.selectedTimeFrameItem = $scope.timeFrame[3];
            findAllTC();
            findAllActivitiesProgressByActivityId(activityId);
        }
        else {
            vm.title = "Progress View Panel";
            vm.forReport = false;
            $scope.fYear = ['2072-73', '2073-74', '2074-75', '2075-76', '2077-78'];
            $scope.selectedItem = $scope.fYear[0];
            findAllProgressesByFiscalYear({fiscalYear: $scope.selectedItem});

            $scope.dropboxitemselected = function (item) {

                $scope.selectedItem = item;
                findAllProgressesByFiscalYear({fiscalYear: $scope.selectedItem});
            }
        }

        $scope.initCreatePanel = function () {
            $scope.clearValidationMessages();
            vm.riskyId = 0;


            vm.title = "Create Progress Panel";
            vm.showCreatePanel = !vm.showCreatePanel;
            $scope.btnText = "Create ";
        }
        $scope.clearValidationMessages = function () {
            $scope.progressmodel = {};
            $scope.progressmodel.description = "";
            $scope.progressmodel.progressQty = "";
            $scope.progressmodel.goalQty = "";
            $scope.selectedTimeFrameItem = $scope.timeFrame[3];


        }
        $scope.closeThePanel = function () {
            vm.showCreatePanel = !vm.showCreatePanel;
        }

        $scope.trainingCenterDropboxitemselected = function (item) {

            $scope.selectedTrainingCenterItem = item;

        }

        $scope.timeFrameDropboxitemselected = function (item) {

            $scope.selectedTimeFrameItem = item;

        }

        $scope.initEditPanel = function (pid) {
            $scope.btnText = "Update";
            vm.riskyId = pid;

            getSingleProgress(pid);


            vm.title = "Progress View Panel";
        }

        $scope.submitFormss = function (isValid) {
            if (isValid) {
                $scope.eitherCreateOrEdit();
            }
            else {
                showValidationErrors();
            }

        }
        $scope.deleteThisProgress = function (pid,submittedBy) {
            if ($rootScope.userAuth.username==submittedBy | $rootScope.userHasRole("ROLE_ADMIN")) {


                if (confirm("Are you sure you want to delete this progress ?")) {
                    progressservice.deleteProgress({id: pid}).$promise.then(function (data) {
                        findAllActivitiesProgressByActivityId(activityId);
                    });

                }
            }

            else{
                alert("Cannot delete !. You don't have permission to delete this progress.")
            }



        }
        function showValidationErrors() {
            $scope.submitted = true;
            // $scope.userForm.username.$error.required=true;
        }

        $scope.eitherCreateOrEdit = function () {


            var x = {
                id: vm.riskyId,
                timeFrame: $scope.selectedTimeFrameItem,
                description: $scope.progressmodel.description,
                progressQty: $scope.progressmodel.progressQty,
                goalQty: $scope.progressmodel.goalQty,
                trainingCenter: $scope.selectedTrainingCenterItem,
                activityId: activityId


            }

            createOrEditProgress(x);

        }

        function createOrEditProgress(progress) {
            progressservice.addProgress(progress).$promise.then(function (data) {
                findAllActivitiesProgressByActivityId(activityId);
                $scope.closeThePanel();
            });

        }


        function findAllTC() {
            trainingcenterservice.findAllTrainingCenters().$promise.then(function (data) {
                $scope.trainingCenters = [];
                data.forEach(function (tc) {
                    $scope.trainingCenters.push(tc.name);
                });
                $scope.trainingCenters.push("SELECT");
                $scope.selectedTrainingCenterItem = $scope.trainingCenters[$scope.trainingCenters.length - 1];
                $scope.trainingCenters.pop();

            });

        }

        function findAllActivitiesProgressByActivityId(aid) {

            progressservice.findAllProgressesByActivityId({id: aid}).$promise.then(function (data) {
                self.tableParams = new NgTableParams({}, {dataset: data});
            })

        }

        function getSingleProgress(pid) {
            progressservice.getProgress({id: pid}).$promise.then(function (data) {
                setProgressModel(data);
            });


        }

        function setProgressModel(progress) {
            if ($rootScope.userAuth.username==progress.submittedBy | $rootScope.userHasRole("ROLE_ADMIN")) {
                vm.showCreatePanel = true;
            }
            else {
                vm.showCreatePanel = false;
                alert("Cannot edit. You don't have permission to open this progress");


            }
            $scope.progressmodel = {};
            $scope.selectedTimeFrameItem = progress.timeFrame;
            $scope.progressmodel.description = progress.description;
            $scope.progressmodel.progressQty = progress.progressQty;
            $scope.progressmodel.goalQty = progress.goalQty;
            $scope.selectedTrainingCenterItem = progress.trainingCenter;

        }

        function findAllProgressesByFiscalYear(fYear) {
            reportservice.findAllProgresses(fYear).$promise.then(function (data) {
                self.tableParams = new NgTableParams({}, {dataset: data});

            })

        }

    }

})();
