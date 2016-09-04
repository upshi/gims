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