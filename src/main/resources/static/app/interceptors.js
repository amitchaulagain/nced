'use strict';
angular.module('app')
    .config(['$httpProvider', function ($httpProvider) {

        $httpProvider.responseInterceptors.push(['$rootScope', '$q', 'AUTH_EVENTS',
            function ($rootScope, $q, AUTH_EVENTS) {

                function success(response) {
                    $rootScope.error = null;
                    return response;
                }

                function error(response) {

                    var status = response.status;

                    if (status === 401) {
                        if (angular.isDefined(response.data.errorMessage)) {
                            $rootScope.error = response.data.errorMessage;
                        }
                        $rootScope.$broadcast(AUTH_EVENTS.notAuthorized);

                    } else if (status === 403) {
                        $rootScope.$broadcast(AUTH_EVENTS.notAuthenticated);

                    } else if (status === 400 && angular.isDefined(response.data.errorMessage)) {
                        $rootScope.error = response.data.errorMessage;

                    } else {
                        $rootScope.error = 'OOPS! Something went wrong. :(';
                    }

                    return $q.reject(response);
                }

                return function (promise) {
                    return promise.then(success, error);
                };
            }]);

        $httpProvider.interceptors.push(['$rootScope', function ($rootScope) {
            return {
                'request': function (config) {
                    if ($rootScope.isLoggedIn()) {
                        config.headers['x-auth-token'] = $rootScope.userAuth.token;
                    }
                    return config;
                }
            };
        }]);
    }]);