/**
 * Created by i82298 on 6/4/2016.
 */
(function () {
    'use strict';
    angular
        .module('app.training')
        .factory('trainingservice', trainingservice);

    function trainingservice($resource) {
        return $resource("/privileged/training",
            {Id: "@Id"},
            {
                // editUser: {method: "PUT", 'params': {id: '@id'}},
                editTraining: {method: "PUT"},
                findAllTrainingsByTrainingCenterId: {url:'/privileged/trainings/:id','method': 'GET', isArray: true,'params': {id: '@id'}},
                addTraining: {url:'/privileged/training/',method: 'POST'},
                deleteTraining: {'url':'/privileged/training/:id','method': 'DELETE','params': {id: '@id'}},
                getTraining: {'url':'/privileged/training/:id','method': 'GET','params': {id: '@id'}},



            }
        )


    }
})();