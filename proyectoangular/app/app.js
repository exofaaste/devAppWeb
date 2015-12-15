var dicApp = angular.module('dicApp', [
  'ngRoute',
  'ulacitControllers',
  'ulacitServices'
]);

dicApp.config(['$routeProvider',
  function ($routeProvider) {
      $routeProvider.
        when('/login', {
          templateUrl: 'app/views/login.html',
          controller: 'accountController'
        }).
        when('/accounts', {
          templateUrl: 'app/views/accounts.html',
          controller: 'accountListController'
        }).
        when('/employees', {
            templateUrl: 'app/views/employees.html',
            controller: 'employeesListController'
        }).
        when('/error', {
          templateUrl: 'app/views/error.html'
          //controller: 'candidatesController'
        })
        /*
        otherwise({
            redirectTo: '/login'
        });*/
  }]);