(function() {
    'use strict';

    angular
        .module('app.dashboard')
        .run(appRun);

    // appRun.$inject = ['routehelper'];

    /* @ngInject */
    function appRun(routehelper) {
        routehelper.configureRoutes(getRoutes());
    }

    function getRoutes() {
        return [
            {
                url: '/Dashboard',
                config: {
                    templateUrl: 'app/dashboard/dashboard.html',
                    controller: 'Dashboard',
                     controllerAs: 'vm',
                    title: 'dashboard',
                    sidebar:true,

                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-dashboard"></i> Dashboard'
                    },
                    roles:['ROLE_ADMIN','ROLE_USER']
                }
            }
        ];
    }
})();
