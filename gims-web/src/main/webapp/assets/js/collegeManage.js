/**
 * Created by upshi on 2016-8-29.
 */
var app = angular.module('app', [])
app.controller('collegeController', function($scope, $http) {

    $scope.newCollege = {
        name : '',
        error : false,
        msg : ''
    };

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
    
    $scope.checkCollegeName = function () {
        var error = false;
        $.each($scope.colleges, function (i, n) {
            if($scope.newCollege.name == n.name) {
                error = true;
                $scope.newCollege.error = true;
                $scope.newCollege.msg = '该学院已经存在';
                return false;
            }
        });

        if(!error) {
            $scope.newCollege.error = false;
        }
    }

    $scope.addCollege = function() {
        if(!$scope.newCollege.error) {
            $.ajax({
                url : "dept/addCollege",
                type : "post" ,
                cache : false ,
                data : {name : $scope.newCollege.name },
                dataType : "json" ,
                success : function(data) {
                    location.reload();
                }
            });
        }
    }
});

