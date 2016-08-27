(function() {
    'use strict';

    angular
        .module('app.dashboard')
        .controller('Dashboard', Dashboard);

    Dashboard.$inject = ['$q', 'dataservice', 'logger','$rootScope','$scope'];

    function Dashboard($q, dataservice, logger,$rootScope,$scope) {

        /*jshint validthis: true */
        if ($rootScope.userHasRole("ROLE_ADMIN")) {
            $scope.showAdminDashboard = true;
        }
        if ($rootScope.userHasRole("ROLE_TRAINING_CENTER")) {
            $scope.showTCDashboard = true;
        }
        var vm = this;

        vm.news = {
            title: 'Marvel Avengers',
            description: 'Marvel Avengers 2 is now in production!'
        };
        vm.avengerCount = 0;
        vm.avengers = [];
        vm.title = 'Dashboard';

        activate();

        function activate() {
            var promises = [getAvengerCount(), getAvengersCast()];
//            Using a resolver on all routes or dataservice.ready in every controller
//            return dataservice.ready(promises).then(function(){
            return $q.all(promises).then(function() {
                logger.info('Activated Dashboard View');
            });
        }

        function getAvengerCount() {
            return dataservice.getAvengerCount().then(function(data) {
                vm.avengerCount = data;
                return vm.avengerCount;
            });
        }

        function getAvengersCast() {
            return dataservice.getAvengersCast().then(function(data) {
                vm.avengers = data;
                return vm.avengers;
            });
        }
    }
})();
