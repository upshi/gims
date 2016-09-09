var adminFilter = angular.module('adminFilter', []);

adminFilter.filter('filterDept', function () {
    return function(depts){
        var arr = [];
        angular.forEach(depts, function (dept) {
            if(dept.office !== '') {
                arr.push(dept);
            }
        });
        return arr;
    }
})

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
})

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
})
