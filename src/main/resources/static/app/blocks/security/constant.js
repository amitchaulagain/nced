/**
 * Created by amit on 6/12/16.
 */
(function () {
    'use strict';

    angular.module("blocks.security").constant('AUTH_EVENTS', {
            loginSuccess: 'auth-login-success',
            loginFailed: 'auth-login-failed',
            logoutSuccess: 'auth-logout-success',
            sessionTimeout: 'auth-session-timeout',
            notAuthenticated: 'auth-not-authenticated',
            notAuthorized: 'auth-not-authorized'
        })
        .constant('ROLES', {
            any: 'ANY',
            adminUser: 'ROLE_ADMIN',
            user: 'ROLE_USER'
        })

})();