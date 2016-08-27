/**
 * Created by i82298 on 6/4/2016.
 */
(function () {
    'use strict';
    angular
        .module('app.home')
        .factory('LoginService', LoginService);
    LoginService.$inject = ['$resource'];
    function LoginService($resource) {

        return $resource('auth/login', {Id: '@id'}, {
            login: {'method': 'POST'}
        })


    }
})();