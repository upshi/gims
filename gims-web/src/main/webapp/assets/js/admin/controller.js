var adminController = angular.module('adminController', []);

/*
* 学院部门管理
*/

/* 学院管理 */
adminController.controller('collegeListController', ['$scope', '$http', '$httpParamSerializerJQLike', function ($scope, $http, $httpParamSerializerJQLike) {
    $scope.init = function () {
        $http({
            method : 'POST',
            url : 'api/dept/collegeList',
            cache : false
        }).success(function(data){
            $scope.colleges = data.colleges;
        });
    };

    $scope.newCollege = {
        name : '',
        error : false,
        msg : ''
    };

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
            $http({
                method : 'POST',
                url : 'api/dept/addCollege',
                data : $httpParamSerializerJQLike({name : $scope.newCollege.name}),
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

/* 部门管理 */
adminController.controller('deptListController', ['$scope', '$http', '$httpParamSerializerJQLike', function ($scope, $http, $httpParamSerializerJQLike) {
    $scope.init = function () {
        $http({
            method : 'POST',
            url : 'api/dept/deptList',
            cache : false
        }).success(function(data){
            $scope.depts = data.depts;
        });
    };

    $scope.newDept = {
        name : '',
        error : false,
        msg : ''
    };

    $scope.checkDeptName = function () {
        var error = false;
        $.each($scope.depts, function (i, n) {
            if($scope.newDept.name == n.name) {
                error = true;
                $scope.newDept.error = true;
                $scope.newDept.msg = '该部门已经存在';
                return false;
            }
        });

        if(!error) {
            $scope.newDept.error = false;
        }
    }

    $scope.addDept = function() {
        if(!$scope.newDept.error) {
            $http({
                method : 'POST',
                url : 'api/dept/addDept',
                data : $httpParamSerializerJQLike({name : $scope.newDept.name}),
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

/* 办公室管理 */
adminController.controller('officeListController', ['$scope','$http', '$httpParamSerializerJQLike', '$state', '$stateParams', '$filter',
                                function ($scope, $http, $httpParamSerializerJQLike, $state, $stateParams, $filter) {
    $scope.deptName = $stateParams.deptName;
    if($stateParams.isCollege === '1') {
        $scope.head = '学院管理';
    } else {
        $scope.head = '部门管理';
    }

    $scope.init = function () {
        $http({
            method : 'POST',
            url : 'api/dept/officeList',
            data : $httpParamSerializerJQLike({deptName : $scope.deptName}),
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            cache : false
        }).success(function(data){
            $scope.offices = $filter('filterEmpty')(data.offices, 'office');
        });
    };

    $scope.newOffice = {
        name : '',
        error : false,
        msg : ''
    };

    $scope.checkOfficeName = function () {
        var error = false;
        $.each($scope.offices, function (i, n) {
            if($scope.newOffice.name == n.office) {
                error = true;
                $scope.newOffice.error = true;
                $scope.newOffice.msg = '该办公室已经存在';
                return false;
            }
        });

        if(!error) {
            $scope.newOffice.error = false;
        }
    }

    $scope.addOffice = function() {
        if(!$scope.newOffice.error) {
            var dept = {
                name : $scope.deptName,
                office : $scope.newOffice.name,
                isCollege : $stateParams.isCollege
            };
            $http({
                method : 'POST',
                url : 'api/dept/addOffice',
                data : $httpParamSerializerJQLike(dept),
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

/* 用户列表 */
adminController.controller('userListController', ['$scope', '$http', '$httpParamSerializerJQLike', function ($scope, $http, $httpParamSerializerJQLike) {
    $scope.init = function () {
        $http({
            method : 'POST',
            url : 'api/user/userList',
            cache : false
        }).success(function(data){
            $scope.users = data.users;
        });
    };
}]);

/* 添加用户 */
adminFilter.filter('filterAllDept', function () {
    return function(depts){
        var arr = [];
        angular.forEach(depts, function (dept) {
            if(dept.office == '') {
                arr.push(dept);
            }
        });
        return arr;
    }
});

adminFilter.filter('filterOffice', function () {
    return function(depts, deptName){
        var arr = [];
        angular.forEach(depts, function (dept) {
            if(dept.name == deptName && dept.office !=='') {
                arr.push(dept);
            }
        });
        return arr;
    }
});


/*
 * 设置
 */
/* 个人信息 */
adminController.controller('personalInfoController', ['$scope', function ($scope) {

}]);

/* 修改密码 */
adminController.controller('updatePasswordController', ['$scope', function ($scope) {

}]);