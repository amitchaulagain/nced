(function () {
    'use strict';

    angular.module('app.training')
        .controller('Training', Training);
    Training.$inject = ['trainingcenterservice','trainingservice', 'memberservice', '$scope', 'NgTableParams', 'logger', '$routeParams'];

    function Training(trainingcenterservice,trainingservice, memberservice, $scope, NgTableParams, logger, $routeParams) {
        var tcId = $routeParams.id;
        findAll(tcId);

        var self = this;

        var vm = this;

        vm.riskyId = 0;

        $scope.tmodel = {};
        trainingcenterservice.getTrainingCenter({id:tcId}).$promise.then(function(data){
            vm.mainTitle = "Trainings View Panel of ' Training Center ' : " + "' "+data.name+" '" ;

        });

        $scope.initCreatePanel = function () {
            $scope.clearValidationMessages();
            vm.riskyId = 0;
            vm.title = "Create Training Panel ";
            vm.showCreatePanel = !vm.showCreatePanel;
            $scope.btnText = "Create ";
        }


        $scope.clearValidationMessages = function () {
            $scope.submitted = false;

            //clear validation messages for username
            $scope.tmodel.name = "";
            $scope.tmodel.budget ="";
            $scope.tmodel.start ="";
            $scope.tmodel.end ="";
            $scope.tmodel.target = "";
            $scope.tmodel.duration = "";
            $scope.tForm.duration.$pristine = true;
            $scope.tForm.name.$pristine = true;
            $scope.tForm.budget.$pristine = true;
            $scope.tForm.start.$pristine = true;
            $scope.tForm.end.$pristine = true;
            $scope.tForm.target.$pristine = true;
        }





        $scope.initEditPanel = function (pid) {
            $scope.clearValidationMessages();
            $scope.btnText = "Update";
            vm.riskyId = pid;
            getSingleTraining(pid);

            vm.title = "Edit Training Panel";
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
        }

        $scope.eitherCreateOrEdit = function () {
            var x = {
                id: vm.riskyId,
                name: $scope.tmodel.name,
                budget: $scope.tmodel.budget,
                start: $scope.tmodel.start,
                end: $scope.tmodel.end,
                target: $scope.tmodel.target,
                trainingCenterId: tcId,


            }

            createOrEditTraining(x);

        }
        $scope.deleteTheTraining = function (trainingId) {
            memberservice.findAllMembers({id:trainingId}).$promise.then(function (data) {
                if (data.length > 0) {
                    alert("Cannot delete ! Has memberes in it")
                }
                else {
                    if (confirm("Are you sure you want to delete ?")) {

                        trainingservice.deleteTraining({id: trainingId}).$promise.then(function (data) {
                            findAll(tcId);
                        });
                    }

                }
            });

        }
        function createOrEditTraining(tc) {
            trainingservice.addTraining(tc).$promise.then(function (data) {
                findAll(tcId);
                $scope.closeThePanel();
            });

        }

        function getSingleTraining(pid) {
            trainingservice.getTraining({id: pid}).$promise.then(function (data) {
                settmodels(data);
            });


        }

        function settmodels(data) {
            $scope.tmodel.name = data.name;
            $scope.tmodel.budget = data.budget;
            $scope.tmodel.start = data.start;

            $scope.tmodel.end = data.end;
            $scope.tmodel.target = data.target;
            $scope.tmodel.duration = data.duration ;

        }


        function findAll(tcId) {
            trainingservice.findAllTrainingsByTrainingCenterId({id: tcId}).$promise.then(function (data) {
                self.tableParams = new NgTableParams({}, {dataset: data});
            });

        }


    }

})();
