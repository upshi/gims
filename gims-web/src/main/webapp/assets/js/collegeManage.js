/**
 * Created by upshi on 2016-8-29.
 */
var app = angular.module('app', [])
app.controller('collegeController', function($scope) {
    $scope.init = function() {
        $.ajax({
            url : "dept/collegeList",
            type : "post" ,
            cache : false ,
            dataType : "json" ,
            success : function(data) {
                $scope.colleges = data.colleges;
            }
        });
    }
});
