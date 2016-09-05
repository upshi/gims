var app = angular.module('app', ['ui.router','adminController','adminService','adminFilter','adminDirective']);

app.config(function($stateProvider, $urlRouterProvider) {
    // For any unmatched url, redirect to /state1
    $urlRouterProvider.otherwise("/index");
    // Now set up the states
    $stateProvider
        .state('index', {
            url: "/index",
            views: {
                '': {
                    templateUrl: 'assets/templates/admin/index.html'
                },
                'nav@index': {
                    templateUrl: 'assets/templates/common/nav.html'
                },
                'main@index': {
                    templateUrl: 'assets/templates/admin/main.html'
                },
                'footer@index': {
                    templateUrl: 'assets/templates/common/footer.html'
                }
            }
        })
        .state('index.dept', {
            url: '/dept',
            views: {
                'main@index': {
                    templateUrl: 'assets/templates/admin/main.html'
                }
            }
        })
        .state('index.dept.college', {
            url: '/college',
            templateUrl: 'assets/templates/admin/dept/collegeList.html',
            controller: 'collegeListController'
        })
        .state('index.dept.dept', {
            url: '/dept',
            templateUrl: 'assets/templates/admin/dept/deptList.html',
            controller: 'deptListController'
        })
        .state('index.dept.office', {
            url: '/office/:deptName/:isCollege',
            templateUrl: 'assets/templates/admin/dept/officeList.html',
            controller: 'officeListController'
        })
        .state('index.dept.user', {
            url: '/user',
            templateUrl: 'assets/templates/admin/dept/userList.html',
            controller: 'userListController'
        })
        .state('index.dept.addUser', {
            url: '/addUser',
            templateUrl: 'assets/templates/admin/dept/addUser.html',
            controller: 'addUserController'
        })
});
