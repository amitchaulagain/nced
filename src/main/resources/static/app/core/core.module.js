(function() {
    'use strict';

    angular.module('app.core', [
        /*
         * Angular modules
         */
        'ngAnimate', 'ngRoute', 'ngSanitize','ngResource','ngCookies',
        /*
         * Our reusable cross app code modules
         */
        'blocks.exception', 'blocks.logger', 'blocks.router','blocks.security',
        /*
         * 3rd Party modules
         */
        'ngplus'
    ]);
})();
