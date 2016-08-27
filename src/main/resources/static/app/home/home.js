(function () {
    'use strict';

    angular
        .module('app.home')
        .controller('home', home);

    /* @ngInject */
    home.$inject = ['$scope', '$rootScope', 'logger', 'LoginService','AUTH_EVENTS','$cookieStore'];

    function home($scope, $rootScope, logger, LoginService,AUTH_EVENTS,$cookieStore) {
        /*jshint validthis: true */
        var vm = this;
        vm.home = [];
        vm.title = 'home';
        this.submitLogin = Login;
        function Login(credentials) {
            LoginService.login(credentials).$promise.then(
                function (responseUser) {

                    $rootScope.$broadcast(AUTH_EVENTS.loginSuccess,responseUser);
                }, function (response) {
                    logger.info("Login Failed!!!!")
                }
            )

        }


    }
})();
