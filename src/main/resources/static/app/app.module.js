(function() {
    'use strict';

    angular.module('app', [
        'app.core',
        'app.widgets',
        /*
         * Feature areas
         */
        'app.home',
        'app.dashboard',
        'app.demo',
        'app.layout',
        'app.project',
        'app.training'
    ]);

})();
