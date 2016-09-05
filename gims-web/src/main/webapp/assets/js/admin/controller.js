var adminController = angular.module('adminController', []);

adminController.controller('collegeListController', ['$scope','$state', '$stateParams', function ($scope) {
    $scope.init = function () {
        $.ajax({
            url: "api/dept/collegeList",
            type: "post",
            cache: false,
            dataType: "json",
            success: function (data) {
                $scope.$apply(function(){
                    $scope.colleges = data.colleges;
                });
            }
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
            $.ajax({
                url : "api/dept/addCollege",
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
}]);

adminController.controller('deptListController', ['$scope','$state', '$stateParams', function ($scope, $state, $stateParams) {
    $scope.init = function () {
        $.ajax({
            url: "api/dept/deptList",
            type: "post",
            cache: false,
            dataType: "json",
            success: function (data) {
                $scope.$apply(function(){
                    $scope.depts = data.depts;
                });
            }
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
            $.ajax({
                url : "api/dept/addDept",
                type : "post" ,
                cache : false ,
                data : {name : $scope.newDept.name },
                dataType : "json" ,
                success : function(data) {
                    location.reload();
                }
            });
        }
    }
}]);

adminController.controller('officeListController', ['$scope','$state', '$stateParams', '$filter', function ($scope, $state, $stateParams, $filter) {
    $scope.deptName = $stateParams.deptName;
    if($stateParams.isCollege === '1') {
        $scope.head = '学院管理';
    } else {
        $scope.head = '部门管理';
    }

    $scope.init = function () {
        $.ajax({
            url: "api/dept/officeList",
            type: "post",
            cache: false,
            data : {deptName : $scope.deptName},
            dataType: "json",
            success: function (data) {
                $scope.$apply(function(){
                    $scope.offices = $filter('filterDept')(data.offices);
                });
            }
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
            $.ajax({
                url : "api/dept/addOffice",
                type : "post" ,
                cache : false ,
                data : {
                    name : $scope.deptName,
                    office : $scope.newOffice.name,
                    isCollege : $stateParams.isCollege
                },
                dataType : "json" ,
                success : function(data) {
                    location.reload();
                }
            });
        }
    }
}]);

adminController.controller('userListController', ['$scope','$state', '$stateParams', function ($scope, $state, $stateParams) {
    $scope.init = function () {
        $.ajax({
            url: "api/user/userList",
            type: "post",
            cache: false,
            dataType: "json",
            success: function (data) {
                $scope.$apply(function(){
                    $scope.users = data.users;
                });
            }
        });
    };
}]);

adminController.controller('addUserController', ['$scope', function ($scope) {

}]);