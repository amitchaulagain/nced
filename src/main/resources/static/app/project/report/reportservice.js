/**
 * Created by i82298 on 6/4/2016.
 */
(function () {
    'use strict';
    angular
        .module('app.project')
        .factory('reportservice', reportservice);

    function reportservice($resource) {
        return $resource("/privileged/progress",
            {Id: "@Id"},
            {
               // editUser: {method: "PUT", 'params': {id: '@id'}},
                editProgress: {method: "PUT"},
                findAllProgresses: {'url':'/admin/report/progresses/:fiscalYear','method': 'GET', isArray: true,'params': {fiscalYear: '@fiscalYear'}},
                addProgress: {'url':'/privileged/progress','method': 'POST'},
                deleteProgress: {'url':'/privileged/progress/:id','method': 'DELETE','params': {id: '@id'}},
                getProgress: {'url':'/privileged/progress/:id','method': 'GET','params': {id: '@id'}},
                getActivitiesReportByFiscalYear: {'url':'/admin/report/:fiscalYear','method': 'GET','params': {fiscalYear: '@fiscalYear'},isArray: true}


            }
        )


    }
})();