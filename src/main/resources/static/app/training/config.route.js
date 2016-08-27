(function () {
    'use strict';

    angular
        .module('app.training')
        .run(appRun);


    /* @ngInject */
    function appRun(routehelper) {
        routehelper.configureRoutes(getRoutes());
    }

    function getRoutes() {
        return [
            {
                url: '/trainingCenter',
                config: {
                    templateUrl: 'app/training/trainingcenter.html',
                    controller: 'TrainingCenter',
                    controllerAs: 'vm',
                    sidebar:true,
                    title: 'training',

                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-shield fa-rotate-270"></i> Training Center'
                    },
                    roles:['ROLE_ADMIN','ROLE_TRAINING_CENTER']
                }
            },
            {
                url: '/trainingCenter/:id',
                config: {
                    templateUrl: 'app/training/training.html',
                    controller: 'Training',
                    controllerAs: 'vm',
                    sidebar:true,
                    title: 'training',

                   /* settings: {
                        nav: 1,
                        content: '<i class="fa fa-shield fa-rotate-270"></i> Training  '
                    },*/
                    roles:['ROLE_ADMIN','ROLE_TRAINING_CENTER']
                }
            },
            {
                url: '/training/:id',
                config: {
                    templateUrl: 'app/training/member.html',
                    controller: 'Member',
                    sidebar:true,
                    controllerAs: 'vm',
                    title: 'training',

                   /* settings: {
                        nav: 1,
                        content: '<i class="fa fa-shield fa-rotate-270"></i> Training  '
                    },*/
                    roles:['ROLE_ADMIN','ROLE_TRAINING_CENTER']
                }
            },
            {
                url: '/treport',
                config: {
                    templateUrl: 'app/training/report/trainingReport.html',
                    controller: 'TReport',
                    controllerAs: 'vm',
                    sidebar:true,
                    title: 'treport',

                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-shield fa-rotate-270"></i> Training Report'
                    },
                    roles:['ROLE_ADMIN']
                }
            }
        ];
    }
})();
