(function() {
    'use strict';

    angular
        .module('app.widgets')
        .directive('formPanel', formPanel);

    /* @ngInject */
    function formPanel () {
        //Usage:
        //<div cms-cc-widget-header title="vm.map.title"></div>
        // Creates:
        // <div cms-cc-widget-header=""
        //      title="Avengers Movie"
        //      allow-collapse="true" </div>
        var directive = {
            link: link,
            scope: {
                'title': '@',
                'subtitle': '@',
                'rightText': '@',
                'allowCollapse': '@'
            },
            templateUrl: 'app/widgets/formpanel.html',
            restrict: 'A'
        };
        return directive;
        function link(scope, element, attrs) {

            attrs.$set('href', '#');
            attrs.$set('wclose');

            var currentElement = angular.element('#close');

           // scope.

            currentElement.click(closeEl);

            function closeEl(e) {
                e.preventDefault();
                element.parent().parent().hide(100);
            }
        }
    }
})();
