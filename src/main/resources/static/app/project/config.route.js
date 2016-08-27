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
                url: '/project',
                config: {
                    templateUrl: 'app/project/project.html',
                    controller: 'Project',
                    sidebar:true,
                    controllerAs: 'vm',
                    title: 'project',

                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-shield fa-rotate-270"></i> Project'
                    },
                    roles:['ROLE_ADMIN','ROLE_TRAINING_CENTER']
                }
            },
           /* {
                url: '/activity/:code',
                config: {
                    templateUrl: 'app/project/project-activity/activity.html',
                    controller: 'Activity',
                    controllerAs: 'vm',
                    title: 'project-activity',

                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-shield fa-rotate-270"></i> Activities'
                    },
                    roles:['ROLE_ADMIN']
                }
            },*/
            {
                url: '/activity/:code/:fiscalYear',
                config: {
                    templateUrl: 'app/project/project-activity/activity.html',
                    controller: 'Activity',
                    controllerAs: 'vm',
                    sidebar:true,
                    title: 'project-activity',

                   /* settings: {
                        nav: 1,
                        content: '<i class="fa fa-shield fa-rotate-270"></i> Activities'
                    },*/
                    roles:['ROLE_ADMIN']
                }
            },
            {
                url: '/progress/:activityId',
                config: {
                    templateUrl: 'app/project/activity-progress/progress.html',
                    controller: 'Progress',
                    controllerAs: 'vm',
                    sidebar:true,
                    title: 'progress',

                   /* settings: {
                        nav: 1,
                        content: '<i class="fa fa-shield fa-rotate-270"></i> Progress'
                    },*/
                    roles:['ROLE_ADMIN']
                }
            },
            {
                url: '/allprogresses',
                config: {
                    templateUrl: 'app/project/activity-progress/progress.html',
                    controller: 'Progress',
                    controllerAs: 'vm',
                    sidebar:true,
                    title: 'progress',

                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-shield fa-rotate-270"></i> Progress Report'
                    },
                    roles:['ROLE_ADMIN']
                }
            },
            {
                url: '/report',
                config: {
                    templateUrl: 'app/project/report/report.html',
                    controller: 'Report',
                    controllerAs: 'vm',
                    sidebar:true,
                    title: 'report',

                    settings: {
                        nav: 1,
                        content: '<i class="fa fa-shield fa-rotate-270"></i>Project Report'
                    },
                    roles:['ROLE_ADMIN']
                }
            }
        ];
    }
})();
