var adminController = angular.module('collegeController', []);

/* 年级管理 */
adminController.controller('gradeListController', ['$scope', '$http', '$httpParamSerializerJQLike', function ($scope, $http, $httpParamSerializerJQLike) {
    $scope.init = function () {
        $http({
            method : 'POST',
            url : 'api/teachClass/gradeList',
            cache : false
        }).success(function(data){
            $scope.grades = data.grades;
        });
    };

    $scope.newTeachClass = {
        grade : '',
        error : false,
        msg : ''
    };

    $scope.checkGradeName = function () {
        var error = false;
        $.each($scope.grades, function (i, n) {
            if($scope.newTeachClass.grade == n.grade) {
                error = true;
                $scope.newTeachClass.error = true;
                $scope.newTeachClass.msg = '该年级已经存在';
                return false;
            }
        });

        if(!error) {
            $scope.newTeachClass.error = false;
        }
    }

    $scope.addGrade = function() {
        if(!$scope.newTeachClass.error) {
            $http({
                method : 'POST',
                url : 'api/teachClass/addGrade',
                data : $httpParamSerializerJQLike({grade : $scope.newTeachClass.grade}),
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                cache : false
            }).success(function(){
                location.reload();
            });
        }
    }
}]);


adminController.controller('majorListController', ['$scope', '$http', '$filter', '$stateParams', '$httpParamSerializerJQLike',
                                           function ($scope, $http, $filter, $stateParams, $httpParamSerializerJQLike) {

    $scope.grade = $stateParams.grade;

    $scope.init = function () {
        $http({
            method : 'POST',
            url : 'api/teachClass/majorList',
            cache : false,
            data : $httpParamSerializerJQLike({grade : $scope.grade}),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
        }).success(function(data){
            $scope.majors = $filter('filterEmpty')(data.majors, 'major');
        });
    };

    $scope.newTeachClass = {
        major : '',
        error : false,
        msg : ''
    };

    $scope.checkMajorName = function () {
        var error = false;
        $.each($scope.majors, function (i, n) {
            if($scope.newTeachClass.major == n.major) {
                error = true;
                $scope.newTeachClass.error = true;
                $scope.newTeachClass.msg = '该专业已经存在';
                return false;
            }
        });

        if(!error) {
            $scope.newTeachClass.error = false;
        }
    }

    $scope.addMajor = function() {
        if(!$scope.newTeachClass.error) {
            $http({
                method : 'POST',
                url : 'api/teachClass/addMajor',
                data : $httpParamSerializerJQLike({grade : $scope.grade, major : $scope.newTeachClass.major}),
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                cache : false
            }).success(function(){
                location.reload();
            });
        }
    }
}]);

adminController.controller('clazzListController', ['$scope', '$http', '$filter', '$stateParams', '$httpParamSerializerJQLike',
    function ($scope, $http, $filter, $stateParams, $httpParamSerializerJQLike) {

        $scope.grade = $stateParams.grade;
        $scope.major = $stateParams.major;

        $scope.init = function () {
            $http({
                method : 'POST',
                url : 'api/teachClass/clazzList',
                cache : false,
                data : $httpParamSerializerJQLike({grade : $scope.grade, major : $scope.major}),
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
            }).success(function(data){
                $scope.clazzs = $filter('filterEmpty')(data.clazzs, 'clazz');
            });
        };

        $scope.newTeachClass = {
            clazz : '',
            error : false,
            msg : ''
        };

        $scope.checkClazzName = function () {
            var error = false;
            $.each($scope.clazzs, function (i, n) {
                if($scope.newTeachClass.clazz == n.clazz) {
                    error = true;
                    $scope.newTeachClass.error = true;
                    $scope.newTeachClass.msg = '该班级已经存在';
                    return false;
                }
            });

            if(!error) {
                $scope.newTeachClass.error = false;
            }
        }

        $scope.addClazz = function() {
            if(!$scope.newTeachClass.error) {
                $http({
                    method : 'POST',
                    url : 'api/teachClass/addClazz',
                    data : $httpParamSerializerJQLike({grade : $scope.grade, major: $scope.major, clazz : $scope.newTeachClass.clazz}),
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    },
                    cache : false
                }).success(function(){
                    location.reload();
                });
            }
        }
    }]);

/*
 * 设置
 */
/* 个人信息 */
adminController.controller('personalInfoController', ['$scope', function ($scope) {

}]);

/* 修改密码 */
adminController.controller('updatePasswordController', ['$scope', function ($scope) {

}]);