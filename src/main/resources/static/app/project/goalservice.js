/**
 * Created by i82298 on 6/4/2016.
 */
(function () {
    'use strict';
    angular
        .module('app.project')
        .factory('goalservice', goalservice);

    function goalservice($resource) {
        return $resource("/all/projects",
            {Id: "@Id"},
            {

                addGoal: {url:'/privileged/activity-goal','method': 'POST'},
                editGoal: {url:'/privileged/activity-goal','method': 'GET','params': {id: '@id'}},
                getGoalsByActivityId: {'url':'/privileged/activity-goal/:id','method': 'GET', isArray: true,'params': {id: '@id'}},


            }
        )


    }
})();