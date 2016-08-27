(function () {
    'use strict';

    angular.module('app.training')
        .controller('Member', Member);
    Member.$inject = ['trainingservice','memberservice', '$scope', 'NgTableParams', 'logger', '$routeParams','$filter','$rootScope'];

    function Member(trainingservice,memberservice, $scope, NgTableParams, logger, $routeParams,$filter,$rootScope ) {
        var trainingId = $routeParams.id;





        trainingservice.getTraining({id:trainingId}).$promise.then(function(data){
          /*  var hero=($filter('date')(new Date(), 'yyyy/MM/dd')) ;
            var today   = parseInt(hero.substring(8,10));
             var startDay= parseInt(data.start.substring(8,10));*/


            var today= new Date();
            var startDate=new Date(data.start);

            if((today.getTime()-startDate.getTime())<1000*60*60*24*2  || ($rootScope.userHasRole("ROLE_ADMIN"))) {
                vm.can=true;

            }
            else{
                vm.can=false;

            }

            vm.mainTitle = "Edit Trainees View Panel of ' Training ' : " + "' "+data.name+" '" ;
        });
        findAll(trainingId);
        $scope.submitted = false;
        var self = this;


        var vm = this;
        vm.user = {};
        $scope.membermodel = {};
        vm.showCreatePanel = false;

        $scope.clearValidationMessages = function () {

            $scope.submitted = false;


            //clear validation messages for username
            //clear validation messages for firstName
            $scope.membermodel.firstName = "";
            $scope.mForm.firstName.$pristine = true;
            //clear validation messages for lastName
            $scope.membermodel.lastName = "";
            $scope.mForm.lastName.$pristine = true;
            //clear validation messages for date of birth
            $scope.membermodel.dob = "";
            $scope.mForm.dob.$pristine = true;
            //clear validation messages for landlineNumber
            $scope.membermodel.landlineNumber = "";
            $scope.mForm.landlineNumber.$pristine = true;
            //clear validation messages for mobileNumber
            $scope.membermodel.mobileNumber = "";
            $scope.mForm.mobileNumber.$pristine = true;
            //clear validation messages for streetAddress
            $scope.membermodel.streetAddress = "";
            $scope.mForm.streetAddress.$pristine = true;

            //clear validation messages for vdc or municipality
            $scope.membermodel.vdcOrMunicipality = "";
            $scope.mForm.vdcOrMunicipality.$pristine = true;
            //clear validation messages for district
            $scope.membermodel.district = "";
            $scope.mForm.district.$pristine = true;
            //clear validation messages for zone
            $scope.membermodel.zone = "";
            $scope.mForm.zone.$pristine = true;
            //clear validation messages for country
            $scope.membermodel.country = "";
            $scope.mForm.country.$pristine = true;
            $scope.membermodel.email = "";
            $scope.mForm.email.$pristine = true;
            $scope.membermodel.organisation = "";
            $scope.mForm.organisation.$pristine = true;
            $scope.membermodel.workplace = "";
            $scope.mForm.workplace.$pristine = true;


            //$scope.mForm.password.$error.required=true;
        }

        var xyz = []
        $scope.initCreatePanel = function () {
            $scope.clearValidationMessages();
            vm.riskyId = 0;
            $scope.membermodel = {};
            $scope.membermodel.selection = {
                ids: xyz
            };
            vm.title = "Create Trainee Panel";
            vm.showCreatePanel = !vm.showCreatePanel;
            $scope.btnText = "Create ";
        }

        $scope.eitherCreateOrEdit = function () {
            var x = {
                memberId: vm.riskyId,
                trainingId: trainingId,
                firstName: $scope.membermodel.firstName,
                middleName: $scope.membermodel.middleName,
                lastName: $scope.membermodel.lastName,
                streetAddress: $scope.membermodel.streetAddress,
                vdcOrMunicipality: $scope.membermodel.vdcOrMunicipality,
                district: $scope.membermodel.district,
                zone: $scope.membermodel.zone,
                country: $scope.membermodel.country,

                landlineNumber: $scope.membermodel.landlineNumber,
                mobileNumber: $scope.membermodel.mobileNumber,
                dob: $scope.membermodel.dob,
                organisation: $scope.membermodel.organisation,
                workplace: $scope.membermodel.workplace,
                email: $scope.membermodel.email,
                memberType: "TRAINEE"

            }

            if ($scope.membermodel.sex == "male") {

                x.male = true;
            }
            else {
                x.male = false;
            }
            if(vm.can){

            createOrEditMember(x);
            }
            else{
                alert("Cannot be updated. Contact your administrator to change it !");
            }

        }
        $scope.closeThePanel = function () {
            vm.showCreatePanel = !vm.showCreatePanel;
        }
        $scope.initEditPanel = function (memberId) {
            $scope.clearValidationMessages();
            $scope.btnText = "Update";
            vm.riskyId = memberId;
            getSingleMember(memberId);


            vm.showCreatePanel = true;
        }

        $scope.submitFormss = function (isValid) {

            if (isValid) {
                $scope.eitherCreateOrEdit();
            }
            else {
                showValidationErrors();
            }

        }



        $scope.deleteTheMember = function (memberId) {
            if(vm.can){

            if (confirm("Are you sure you want to delete trainee?")) {
                memberservice.deleteMember({id: memberId}).$promise.then(function (data) {
                    findAll(trainingId);
                });
            }
            }
            else{
                alert("Cannot be deleted. Contact your administrator to delete this member")
            }


        }

        $scope.roles = [{"id": "ROLE_ADMIN", "name": "ROLE_ADMIN"},
            {"id": "ROLE_USER", "name": "ROLE_USER"},
            {"id": "ROLE_TRAINING_CENTER", "name": "ROLE_TRAINING_CENTER"}
        ];

        vm.title = 'Member Create Panel';


        activate();
        /*I am testing*/


        function activate() {
            logger.info('Activated Demo View');
        }

        function createOrEditMember(x) {
            memberservice.addMembers(x).$promise.then(function (data) {
                findAll(trainingId);
                $scope.closeThePanel();
            });

        }

        function getSingleMember(memberId) {
            memberservice.getMember({id: memberId}).$promise.then(function (data) {
                setmembermodels(data);
            });


        }

        function setmembermodels(data) {
            vm.title = "Edit Trainee Panel of ' Trainee   ' : " + "' "+data.firstName+" "+data.middleName+" "+data.lastName+" '" ;

            $scope.membermodel.firstName = data.firstName;
            $scope.membermodel.middleName = data.middleName;
            $scope.membermodel.lastName = data.lastName;
            $scope.membermodel.dob = data.dob;
            $scope.membermodel.email = data.email;
            if (data.male) {
                $scope.membermodel.sex = "male";
            }
            else {
                $scope.membermodel.sex = "female";
            }

            $scope.membermodel.mobileNumber = data.mobileNumber;
            $scope.membermodel.landlineNumber = data.landlineNumber;
            $scope.membermodel.streetAddress = data.streetAddress;
            $scope.membermodel.vdcOrMunicipality = data.vdcOrMunicipality;

            $scope.membermodel.zone = data.zone;

            $scope.membermodel.district = data.district;
            $scope.membermodel.country = data.country;
            $scope.membermodel.organisation = data.organisation;
            $scope.membermodel.workplace = data.workplace;
            $scope.membermodel.memberType = data.memberType;


        }

        function showValidationErrors() {
            $scope.submitted = true;
            // $scope.mForm.username.$error.required=true;
        }


        function findAll(tId) {
            memberservice.findAllMembers({id: tId}).$promise.then(function (data) {
                data.forEach(function (val) {
                    if (val.male) {
                        val.male = "M"
                    }
                    else {
                        val.male = "F"
                    }
                })
                self.tableParams = new NgTableParams({}, {dataset: data});
            });

        }

    }

})();
