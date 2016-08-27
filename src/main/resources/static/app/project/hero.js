(function () {
    'use strict';

    angular.module('app.project')
        .controller('Hero', Hero);
    Hero.$inject = [ '$scope','$routeParams'];

    function Hero( $scope ,$routeParams) {
        alert("hero");
        alert($routeParams.id);

    }

})();
