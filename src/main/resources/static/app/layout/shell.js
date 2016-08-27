(function () {
    'use strict';

    angular
        .module('app.layout')
        .controller('Shell', Shell);

    Shell.$inject = ['$timeout', 'config', 'logger','$scope','$rootScope','DTO'];

    function Shell($timeout, config, logger, $scope,$rootScope,DTO) {
        /*jshint validthis: true */
        var vm = this;
        vm.sideBar = true;
        vm.title = config.appTitle;

    }
})();
