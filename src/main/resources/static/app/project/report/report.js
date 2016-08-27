(function () {
    'use strict';

    angular.module('app.project')
        .controller('Report', Report);
    Report.$inject = ['reportservice', 'trainingcenterservice', '$scope', 'NgTableParams', 'logger', '$routeParams'];

    function Report(reportservice, trainingcenterservice, $scope, NgTableParams, logger, $routeParams) {
        var vm = this;
        var self = this;
        findAllActivitiesProgress();
        $scope.fYear = ['2072-73', '2073-74', '2074-75', '2075-76', '2077-78'];
        $scope.selectedItem=$scope.fYear[0];
        findAllActivitiesReport({fiscalYear: $scope.selectedItem})
        $scope.dropboxitemselected = function (item) {

            $scope.selectedItem = item;
            findAllActivitiesReport({fiscalYear: $scope.selectedItem});
        }

        function findAllActivitiesProgress() {

            reportservice.findAllProgresses().$promise.then(function (data) {
                self.tableParams = new NgTableParams({}, {dataset: data});
            })

        }

        function findAllActivitiesReport(fiscalYear) {

                reportservice.getActivitiesReportByFiscalYear(fiscalYear).$promise.then(function (data) {
                    self.tableParams = new NgTableParams({}, {dataset: data});
                });



        }

        function getSingleProgress(pid) {
            reportservice.getProgress({id: pid}).$promise.then(function (data) {
                setProgressModel(data);
            });


        }

        function setProgressModel(progress) {
            $scope.progressmodel={};
            $scope.selectedTimeFrameItem = progress.timeFrame;
            $scope.progressmodel.description = progress.description;
            $scope.progressmodel.progressQty = progress.progressQty;
            $scope.progressmodel.goalQty = progress.goalQty;
            $scope.selectedTrainingCenterItem = progress.trainingCenter;

        }

    }

})();
