(function () {
    'use strict';

    angular.module('app.training')
        .controller('TrainingCenter', TrainingCenter);
    TrainingCenter.$inject = ['trainingcenterservice', '$scope', 'NgTableParams', 'logger', '$rootScope', 'trainingservice'];

    function TrainingCenter(trainingcenterservice, $scope, NgTableParams, logger, $rootScope, trainingservice) {
        if ($rootScope.userHasRole("ROLE_ADMIN")) {
            $scope.showMe = true;
        }
        findAll();



        var self = this;

        var vm = this;
        $scope.tcmodel = {};

        $scope.trainingCenterDropboxitemselected = function (item) {

            $scope.selectedTrainingCenterItem = item;
        }
        $scope.initCreatePanel = function () {

            $scope.selectedTrainingCenterItem = "SELECT";
            vm.riskyId = 0;
            $scope.tcmodel = {};
            vm.title = "Create Training Center Panel";
            vm.showCreatePanel = !vm.showCreatePanel;
            $scope.btnText = "Create ";
        }
        $scope.initEditPanel = function (pid) {

           // pushAndPopSELECTmenu();
            $scope.btnText = "Update";
            vm.riskyId = pid;
            getSingleTrainingCenter(pid);

            vm.title = "Edit Training Center Panel";
            vm.showCreatePanel = true;
        }

        $scope.closeThePanel = function () {
            vm.showCreatePanel = !vm.showCreatePanel;
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


            var x = {
                id: vm.riskyId,
                name: $scope.tcmodel.name,
                address: $scope.tcmodel.address,
                district: $scope.tcmodel.district,
                zone: $scope.tcmodel.zone,
                parentTrainingCenter: $scope.selectedTrainingCenterItem

            }

            createOrEditTrainingCenter(x);

        }
        $scope.hasChildren = function (tcId) {


            return have;
        }
        $scope.deleteTrainingCenter = function (tcId) {
            var have = true;
            trainingservice.findAllTrainingsByTrainingCenterId({id: tcId}).$promise.then(function (data) {
                if (data.length > 0) {

                    alert("You must first delete all related trainings to delete this training center.");
                }


                else {
                    trainingcenterservice.findChildTrainingCenter({id: tcId}).$promise.then(function (data) {
                        if (data.count > 0) {
                            alert("Cannot delete this Traininig Center . Is parent Training Center");
                        }
                        else {
                            if (confirm("Are you sure you want to delete this training center")) {
                                trainingcenterservice.deleteTrainingCenterIfPossible({id: tcId}).$promise.then(function (data) {
                                    findAll();
                                });

                            }
                        }
                    });


                }
            });


        }
        $scope.clearValidationMessages = function () {

            $scope.submitted = false;

        }
        function createOrEditTrainingCenter(tc) {
            trainingcenterservice.addTrainingCenter(tc).$promise.then(function (data) {
                findAll();
                $scope.closeThePanel();
            });

        }

        function getSingleTrainingCenter(pid) {
            trainingcenterservice.getTrainingCenter({id: pid}).$promise.then(function (data) {

                settcmodels(data);
            });


        }

        function settcmodels(data) {
            vm.title = "Edit Training Center Panel of ' Training Center ' : " + "' "+data.name+" '" ;
            $scope.tcmodel.name = data.name;
            $scope.tcmodel.address = data.address;
            $scope.tcmodel.district = data.district;
            $scope.tcmodel.zone = data.zone
            if (data.parentTrainingCenter == undefined ) {

                $scope.selectedTrainingCenterItem = "SELECT";

            }
            else {

                $scope.selectedTrainingCenterItem = data.parentTrainingCenter;

            }


        }


        function findAll() {
            findAllParentTC();
            trainingcenterservice.findAllTrainingCenters().$promise.then(function (data) {
                self.tableParams = new NgTableParams({}, {dataset: data});
            });

        }

        function pushAndPopSELECTmenu() {
           // $scope.trainingCenters.push("SELECT");
            //$scope.selectedTrainingCenterItem = $scope.trainingCenters[$scope.trainingCenters.length - 1];
            //$scope.trainingCenters.pop();

        }

        function findAllParentTC() {
            $scope.trainingCenters = [];
            trainingcenterservice.findAllParentTrainingCenters().$promise.then(function (data) {

                data.forEach(function (tc) {
                    $scope.trainingCenters.push(tc.name);
                });
                $scope.trainingCenters.push("SELECT");


            });

        }

    }

})();
