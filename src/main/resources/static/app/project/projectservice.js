/**
 * Created by i82298 on 6/4/2016.
 */
(function () {
    'use strict';
    angular
        .module('app.project')
        .factory('projectservice', projectservice);

    function projectservice($resource) {
        return $resource("/all/projects",
            {Id: "@Id"},
            {
               // editUser: {method: "PUT", 'params': {id: '@id'}},
                editProject: {method: "PUT"},
                findAllProjects: {'method': 'GET', isArray: true},
                addProject: {'url':'/admin/projects','method': 'POST'},
                deleteProject: {'url':'/admin/project/:id','method': 'DELETE','params': {id: '@id'}},
                getProject: {'url':'/all/project/pid/:id','method': 'GET','params': {id: '@id'}},
                getProjectsByFiscalYear: {'url':'/all/project/:fiscalYear','method': 'GET','params': {fiscalYear: '@fiscalYear'},isArray: true},
                findProjectByCode: {'url':'/admin/project/code/:code','method': 'GET' ,'params': {id: '@code'}}

            }
        )


    }
})();