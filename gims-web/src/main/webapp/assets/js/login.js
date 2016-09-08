var app = angular.module('app', []);

app.controller('loginController', ['$scope', '$http', '$httpParamSerializerJQLike', function ($scope, $http, $httpParamSerializerJQLike) {
    $scope.user = {
        userName : '',
        password : ''
    }
    
    $scope.doLogin = function () {
        $http({
            method : 'POST',
            url : 'api/verify/userLogin',
            data : $httpParamSerializerJQLike($scope.user),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            cache : false
        }).success(function(data){
            if(data.correct === 0) {
                alert('用户名或密码错误');
            } else {
                if(data.role === 2) {
                    location.href = 'admin.html';
                } else if(data.role === 1) {
                    location.href = 'college.html';
                } else if(data.role === 0) {
                    location.href = 'dept.html';
                }
            }
        });
    }

}]);