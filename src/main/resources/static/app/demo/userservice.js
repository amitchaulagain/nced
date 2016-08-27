/**
 * Created by i82298 on 6/4/2016.
 */
(function () {
    'use strict';
    angular
        .module('app.demo')
        .factory('userservice', userservice);

    function userservice($resource) {
        return $resource("/admin/users",
            {Id: "@Id"},
            {
               // editUser: {method: "PUT", 'params': {id: '@id'}},
                editUser: {method: "PUT"},
                findAllUsers: {url:'/admin/users/','method': 'GET', isArray: true},
                addUsers: {url:'/admin/user/',method: 'POST'},
                deleteUser: {'url':'/admin/user/:id','method': 'DELETE','params': {id: '@id'}},
                getUser: {'url':'/admin/user/:id','method': 'GET','params': {id: '@id'}}


            }
        )


    }
})();