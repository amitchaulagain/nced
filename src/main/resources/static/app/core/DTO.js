/**
 * Created by i82298 on 6/4/2016.
 */

angular
    .module('app.core')
    .service('DTO', DTO);
DTO.$inject = ['$rootScope'];
function DTO($rootScope){
    var obj = this;
    var isShowSideBar = true;
    obj.isShowSideBar = function(){
        return isShowSideBar;
    }
    obj.setShowSideBar = function(bool){
        isShowSideBar = bool;

    }
    return obj;
}
