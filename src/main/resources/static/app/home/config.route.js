(function() {
    'use strict';

    angular
        .module('app.home')
        .run(appRun);

    // appRun.$inject = ['routehelper']

    /* @ngInject */
    function appRun(routehelper) {
        routehelper.configureRoutes(getRoutes());
    }

    function getRoutes() {
        return [
            {
                url: '/home',
                config: {
                    templateUrl: 'app/home/home.html',
                    controller: 'home',
                    controllerAs: 'vm',
                    title: 'home',
                    sidebar:false,
                    role:'ALL'
                }
            }
        ];
    }
})();
