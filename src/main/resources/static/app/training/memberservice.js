/**
 * Created by i82298 on 6/4/2016.
 */
(function () {
    'use strict';
    angular
        .module('app.demo')
        .factory('memberservice', memberservice);

    function memberservice($resource) {
        return $resource("/privileged/members",
            {Id: "@Id"},
            {
                // editMember: {method: "PUT", 'params': {id: '@id'}},
                editMember: {method: "PUT"},
                findAllMembers: {url:'/privileged/members/training/:id','method': 'GET', isArray: true,'params': {id: '@id'}},
                addMembers: {url:'/privileged/member/',method: 'POST'},
                deleteMember: {'url':'/privileged/member/:id','method': 'DELETE','params': {id: '@id'}},
                getMember: {'url':'/privileged/member/:id','method': 'GET','params': {id: '@id'}}


            }
        )


    }
})();