(function () {
    'use strict';

    angular.module('app.demo')
        .controller('Demo', Demo);
    Demo.$inject = ['userservice', '$scope', 'NgTableParams', 'logger'];

    function Demo(userservice, $scope, NgTableParams, logger) {
        $scope.submitted = false;
        var self = this;
        findAll();

        /*        $http.get('/admin/users', {}, {
         isArray:true
         })                                Just an another way to solve the same thing..////
         .success(hero);*/


        /***********************VERY IMPORTANT****************************

         var x={username:"hero",password:"pass"}
         userservice.addUsers(x).$promise.then(function(data){
            alert(data);
        });
         var x={id:3,username:"heross",password:"passss"}
         userservice.editUser(x).$promise.then(function(data){
            alert(data);
        });
         var z=3;
         userservice.getUser({id:3}).$promise.then(function(data){
            alert(data);
        });
         /***********************END OF VERY IMPORTANT****************************
         */



        var vm = this;
        vm.user = {};
        $scope.usermodel = {};
        vm.showCreatePanel = false;

        $scope.clearValidationMessages = function () {

            $scope.submitted = false;


            //clear validation messages for username
            $scope.usermodel.username = "";
            $scope.userForm.username.$pristine = true;

            //clear validation messages for password
           // $scope.usermodel.password = "";
            $scope.userForm.password.$pristine = true;

            //clear validation messages for firstName
           // $scope.usermodel.firstName = "";
            $scope.userForm.firstName.$pristine = true;
            //clear validation messages for lastName
            $scope.usermodel.lastName = "";
            $scope.userForm.lastName.$pristine = true;
            //clear validation messages for date of birth
            $scope.usermodel.dob = "";
            $scope.userForm.dob.$pristine = true;
            //clear validation messages for landlineNumber
            $scope.usermodel.landlineNumber = "";
            $scope.userForm.landlineNumber.$pristine = true;
            //clear validation messages for mobileNumber
            $scope.usermodel.mobileNumber = "";
            $scope.userForm.mobileNumber.$pristine = true;
            //clear validation messages for streetAddress
            $scope.usermodel.streetAddress = "";
            $scope.userForm.streetAddress.$pristine = true;

            //clear validation messages for vdc or municipality
            $scope.usermodel.vdcOrMunicipality = "";
            $scope.userForm.vdcOrMunicipality.$pristine = true;
            //clear validation messages for district
            $scope.usermodel.district = "";
            $scope.userForm.district.$pristine = true;
            //clear validation messages for zone
            $scope.usermodel.zone = "";
            $scope.userForm.zone.$pristine = true;
            //clear validation messages for country
            $scope.usermodel.country = "";
            $scope.userForm.country.$pristine = true;


            $scope.userForm.username.$invalid=false;
            //$scope.userForm.password.$error.required=true;
        }

            var xyz=[]
        $scope.initCreatePanel = function () {
            $scope.clearValidationMessages();
            vm.riskyId = 0;
            $scope.usermodel = {};
            $scope.usermodel.selection = {
                ids: xyz
            };
            vm.title = "Create User";
            vm.showCreatePanel = !vm.showCreatePanel;
            $scope.btnText = "Create ";
        }

        $scope.eitherCreateOrEdit = function () {
            var x = {id: vm.riskyId,
                username: $scope.usermodel.username,
                password: $scope.usermodel.password,
                firstName:$scope.usermodel.firstName,
                middleName:$scope.usermodel.middleName,
                lastName:$scope.usermodel.lastName,
                streetAddress:$scope.usermodel.streetAddress,
                vdcOrMunicipality:$scope.usermodel.vdcOrMunicipality,
                district:$scope.usermodel.district,
                zone:$scope.usermodel.zone,
                country:$scope.usermodel.country,

                landlineNumber:$scope.usermodel.landlineNumber,
                mobileNumber:$scope.usermodel.mobileNumber,
                dob:$scope.usermodel.dob
            }

                if($scope.usermodel.sex=="male"){

                    x.male=true;
                }
                else {
                    x.male=false;
                }

            var y=new Array(3);
            var target=$scope.usermodel.selection.ids;
            for (var k in target){
                if (target.hasOwnProperty(k)) {
                   if(target[k]==true){
                      y.push(k);
                   }
                }
            }

            x.roless=y;
            createOrEditUser(x);

        }
        $scope.closeThePanel = function () {
            vm.showCreatePanel = !vm.showCreatePanel;
        }
        $scope.initEditPanel = function (userId) {
            $scope.btnText = "Update";
            vm.riskyId = userId;
            getSingleUser(userId);


            vm.showCreatePanel = true;
        }

        $scope.submitFormss = function (isValid) {
            alert(xyz);
            if (isValid) {
                $scope.eitherCreateOrEdit();
            }
            else {
                showValidationErrors();
            }

        }

        $scope.deleteTheUser = function (userId) {
            userservice.deleteUser({id: userId}).$promise.then(function (data) {
                findAll();
            });

        }

        $scope.roles = [{"id": "ROLE_ADMIN", "name": "ROLE_ADMIN"},
            {"id": "ROLE_TRAINING_CENTER", "name": "ROLE_TRAINING_CENTER"}
        ];

        vm.title = 'User Create Panel';


        activate();
        /*I am testing*/


        function activate() {
            logger.info('Activated Demo View');
        }

        function createOrEditUser(x) {
            userservice.addUsers(x).$promise.then(function (data) {
                findAll();
                $scope.closeThePanel();
            });

        }

        function getSingleUser(userId) {
            userservice.getUser({id: userId}).$promise.then(function (data) {
                vm.title = "Edit User Panel of ' Username ' : " + "' "+data.username+" '" ;
                setUserModels(data);
            });


        }

        function setUserModels(data) {
            $scope.usermodel.username = data.username;
            $scope.usermodel.password = data.password;
            $scope.usermodel.firstName = data.firstName;
            $scope.usermodel.middleName = data.middleName;
            $scope.usermodel.lastName = data.lastName;
            $scope.usermodel.dob = data.dob;
            if (data.male) {
                $scope.usermodel.sex = "male";
            }
            else {
                $scope.usermodel.sex = "female";
            }

            $scope.usermodel.mobileNumber = data.mobileNumber;
            $scope.usermodel.landlineNumber = data.landlineNumber;
            $scope.usermodel.streetAddress = data.streetAddress;
            $scope.usermodel.vdcOrMunicipality = data.vdcOrMunicipality;

            $scope.usermodel.zone = data.zone;

            $scope.usermodel.district = data.district;
            $scope.usermodel.country = data.country;
            var xyz = new Array(3);
            data.roles.forEach(function (val, idx) {
                if (val.role === "ROLE_ADMIN") {
                    xyz["ROLE_ADMIN"] = true;
                }
                //if (val.role === "ROLE_USER") {
                //    xyz["ROLE_USER"] = true;
                //}
                if (val.role === "ROLE_TRAINING_CENTER") {
                    xyz["ROLE_TRAINING_CENTER"] = true;
                }

            });

            $scope.usermodel.selection = {
                ids: xyz
            };


        }

        function showValidationErrors() {
            $scope.submitted = true;
            // $scope.userForm.username.$error.required=true;
        }


        function findAll() {
            userservice.findAllUsers().$promise.then(function (data) {
                self.tableParams = new NgTableParams({}, {dataset: data});
            });

        }

    }

})();
