var share = angular.module('share', []);

/* 个人信息 */
share.controller('personalInfoController', ['$scope', '$http', function ($scope, $http) {
    $scope.init = function () {
        $http({
            method: 'POST',
            url: 'api/user/personalInfo',
            cache: false
        }).success(function (data) {
            $scope.user = data.user;
        });
    };
}]);

/* 修改密码 */
share.controller('updatePasswordController', ['$scope', '$http', '$httpParamSerializerJQLike', '$state', function ($scope, $http, $httpParamSerializerJQLike, $state) {
    $scope.password = {
        oldPassword: '',
        newPassword: '',
        rePassword: '',
        correct: 'true',
        msg: ''
    }
    $scope.checkPassword = function () {
        $http({
            method: 'POST',
            url: 'api/user/checkPassword',
            data: $httpParamSerializerJQLike({password: $scope.password.oldPassword}),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            cache: false
        }).success(function (data) {
            $scope.password.correct = data.correct;
            $scope.password.msg = '您输入的原密码不正确';
        });
    };

    $scope.updatePassword = function () {
        $http({
            method: 'POST',
            url: 'api/user/updatePassword',
            data: $httpParamSerializerJQLike({
                oldPassword: $scope.password.oldPassword,
                newPassword: $scope.password.newPassword
            }),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            cache: false
        }).success(function (data) {
            if(data.result === "success") {
                alert('修改成功！');
                $state.reload('index.settings.updatePassword');
            }
        });
    };
}]);