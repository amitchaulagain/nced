/**
 * Created by i82298 on 6/4/2016.
 */
(function () {
    'use strict';
    angular
        .module('app.training')
        .factory('trainingcenterservice', trainingcenterservice);

    function trainingcenterservice($resource) {
        return $resource("/admin/trainingcenters",
            {Id: "@Id"},
            {
               // editUser: {method: "PUT", 'params': {id: '@id'}},
                editUser: {method: "PUT"},
                findAllTrainingCenters: {url:'/admin/trainingCenters/','method': 'GET', isArray: true},
                addTrainingCenter: {url:'/admin/trainingCenter/',method: 'POST'},
                deleteTrainingCenterIfPossible: {'url':'/admin/trainingCenter/:id','method': 'DELETE','params': {id: '@id'}},
                getTrainingCenter: {'url':'/admin/trainingCenter/:id','method': 'GET','params': {id: '@id'}},
                findAllParentTrainingCenters: {url:'/admin/parentTrainingCenters/','method': 'GET', isArray: true},
                findChildTrainingCenter:{'url':'/admin/childTrainingCenter/:id','method': 'GET','params': {id: '@id'}}


            }
        )


    }
})();