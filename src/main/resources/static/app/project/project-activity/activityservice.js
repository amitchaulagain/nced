/**
 * Created by i82298 on 6/4/2016.
 */
(function () {
    'use strict';
    angular
        .module('app.project')
        .factory('activityservice', activityservice);

    function activityservice($resource) {
        return $resource("/privileged/activity",
            {Id: "@Id"},
            {
               // editUser: {method: "PUT", 'params': {id: '@id'}},
                editProject: {method: "PUT"},
                findAllActivities: {'url':'/privileged/activity/code/:id','method': 'GET', isArray: true,'params': {id: '@id'}},
                addActivity: {'url':'/privileged/activity/','method': 'POST'},
                deleteActivity: {'url':'/privileged/activity/:id','method': 'DELETE','params': {id: '@id'}},
                getSingleActivity: {'url':'/privileged/activity/:id','method': 'GET','params': {id: '@id'}},
                getProjectsByFiscalYear: {'url':'/all/project/:fiscalYear','method': 'GET','params': {fiscalYear: '@fiscalYear'},isArray: true}


            }
        )


    }
})();