(function() {
    'use strict';

    angular
        .module('app.layout')
        .controller('Sidebar', Sidebar);

    Sidebar.$inject = ['$route', 'routehelper' ,'$rootScope'];

    function Sidebar($route, routehelper,$rootScope) {
        /*jshint validthis: true */
        var vm = this;
        var routes = routehelper.getRoutes();

        vm.isCurrent = isCurrent;
        vm.isAuthorisedNav = isAuthorisedNav;
        //vm.sidebarReady = function(){console.log('done animating menu')}; // example

        activate();

        function activate() { getNavRoutes(); }

        function getNavRoutes() {
            vm.navRoutes = routes.filter(function(r) {
                return r.settings && r.settings.nav;
            }).sort(function(r1, r2) {
                return r1.settings.nav - r2.settings.nav;
            });
        }

        function isCurrent(route) {
            if (!route.title || !$route.current || !$route.current.title) {
                return '';
            }
            var menuName = route.title;
            return $route.current.title.substr(0, menuName.length) === menuName ? 'current' : '';
        }

        function isAuthorisedNav(r) {
            var a = false;
            angular.forEach(r.roles,function(role) {

                if ($rootScope.userAuth.roles.indexOf(role)!=-1) {
                    a= true;
               return false;

                }else {
                    return true;
                }

            })
            return a;
        }

    }
})();
