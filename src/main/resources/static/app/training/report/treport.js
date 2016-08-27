(function () {
    'use strict';

    angular.module('app.training')
        .controller('TReport', TReport);
    TReport.$inject = ['treportservice', '$scope', 'NgTableParams', 'logger', '$routeParams'];

    function TReport(treportservice, $scope, NgTableParams, logger, $routeParams) {
        var vm = this;
        var self = this;

        $scope.fYear = ['2072-73', '2073-74', '2074-75', '2075-76', '2077-78'];
        $scope.selectedItem=$scope.fYear[0];
        findAllTrainingsReport({fiscalYear: $scope.selectedItem})
        $scope.dropboxitemselected = function (item) {

            $scope.selectedItem = item;
            findAllTrainingsReport({fiscalYear: $scope.selectedItem});
        }



        function findAllTrainingsReport(fiscalYear) {

                treportservice.getTrainingsReportByFiscalYear(fiscalYear).$promise.then(function (data) {
                    self.tableParams = new NgTableParams({}, {dataset: data});
                });



        }



    }

})();
