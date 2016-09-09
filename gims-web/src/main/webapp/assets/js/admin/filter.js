var adminFilter = angular.module('adminFilter', []);

adminFilter.filter('filterEmpty', function () {
    return function(inputs, param1){
        var arr = [];
        angular.forEach(inputs, function (n) {
            if(n[param1] !== '') {
                arr.push(n);
            }
        });
        return arr;
    }
});

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
