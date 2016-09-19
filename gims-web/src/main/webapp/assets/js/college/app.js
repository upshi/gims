var app = angular.module('app', ['ui.router','collegeController','collegeService','collegeFilter','collegeDirective','nav','share']);

app.config(function($stateProvider, $urlRouterProvider) {
    // For any unmatched url, redirect to /state1
    $urlRouterProvider.otherwise("/index");
    // Now set up the states
    $stateProvider
        .state('index', {
            url: "/index",
            views: {
                '': {
                    templateUrl: 'assets/templates/common/content.html'
                },
                'nav@index': {
                    templateUrl: 'assets/templates/common/nav.html',
                    controller : 'navController'
                },
                'main@index': {
                    templateUrl: 'assets/templates/college/main.html'
                },
                'footer@index': {
                    templateUrl: 'assets/templates/common/footer.html'
                }
            }
        })
        .state('index.college', {
            url: '/college',
            views: {
                'main@index': {
                    templateUrl: 'assets/templates/college/main.html'
                }
            }
        })
        .state('index.college.grade', {
            url: '/college',
            templateUrl: 'assets/templates/college/college/gradeList.html',
            controller: 'gradeListController'
        })
        .state('index.college.major', {
            url: '/major/:grade',
            templateUrl: 'assets/templates/college/college/majorList.html',
            controller: 'majorListController'
        })
        .state('index.college.clazz', {
            url: '/clazz/:grade/:major',
            templateUrl: 'assets/templates/college/college/clazzList.html',
            controller: 'clazzListController'
        })
        .state('index.sheet', {
            url: '/sheet',
            views: {
                'main@index': {
                    templateUrl: 'assets/templates/college/main.html'
                }
            }
        })
        .state('index.sheet.createSheet', {
            url: '/createSheet',
            templateUrl: 'assets/templates/college/sheet/createSheet.html',
            controller: 'createSheetController'
        })
        .state('index.sheet.sheetList', {
            url: '/sheetList',
            templateUrl: 'assets/templates/college/sheet/sheetList.html',
            controller: 'sheetListController'
        })
        .state('index.sheet.designSheet', {
            url: '/designSheet/:sheetId',
            views: {
                'main@index': {
                    templateUrl: 'assets/templates/college/sheet/designSheet.html',
                    controller: 'designSheetController'
                }
            }
        })
        .state('index.sheet.updateSheet', {
            url: '/updateSheet/:sheetId',
            views: {
                'main@index': {
                    templateUrl: 'assets/templates/college/sheet/updateSheet.html',
                    controller: 'updateSheetController'
                }
            }
        })
        .state('index.settings', {
            url: '/settings',
            views: {
                'main@index': {
                    templateUrl: 'assets/templates/college/main.html'
                }
            }
        })
        .state('index.settings.personalInfo', {
            url: '/personalInfo',
            templateUrl: 'assets/templates/share/personalInfo.html',
            controller: 'personalInfoController'
        })
        .state('index.settings.updatePassword', {
            url: '/updatePassword',
            templateUrl: 'assets/templates/share/updatePassword.html',
            controller: 'updatePasswordController'
        })
});
