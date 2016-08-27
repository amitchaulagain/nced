/**
 * Created by i82298 on 6/4/2016.
 */
(function () {
    'use strict';
    angular
        .module('app.project')
        .factory('progressservice', progressservice);

    function progressservice($resource) {
        return $resource("/privileged/progress",
            {Id: "@Id"},
            {
               // editUser: {method: "PUT", 'params': {id: '@id'}},
                editProgress: {method: "PUT"},
                findAllProgressesByActivityId: {'url':'/privileged/activity-progress/:id','method': 'GET', isArray: true,'params': {id: '@id'}},
                addProgress: {'url':'/privileged/progress','method': 'POST'},
                deleteProgress: {'url':'/privileged/progress/:id','method': 'DELETE','params': {id: '@id'}},
                getProgress: {'url':'/privileged/progress/:id','method': 'GET','params': {id: '@id'}},
                getProgresssByFiscalYear: {'url':'/all/progress/:fiscalYear','method': 'GET','params': {fiscalYear: '@fiscalYear'},isArray: true}


            }
        )


    }
})();