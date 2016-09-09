var adminFilter = angular.module('collegeFilter', []);

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