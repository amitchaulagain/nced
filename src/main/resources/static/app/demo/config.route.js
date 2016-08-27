(function () {
    'use strict';

    angular
        .module('app.demo')
        .run(appRun);


    /* @ngInject */
    function appRun(routehelper) {
        routehelper.configureRoutes(getRoutes());
    }

    function getRoutes() {
        return [
            {
                url: '/app-users',
                config: {
                    templateUrl: 'app/demo/demo.html',
                    controller: 'Demo',
                    controllerAs: 'vm',
                    title: 'demo',
                    sidebar:true,
                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-shield fa-rotate-270"></i> Application Users '
                    },
                    roles:['ROLE_ADMIN']
                }
            }
        ];
    }
})();
