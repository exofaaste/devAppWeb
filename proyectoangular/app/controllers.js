var ulacitControllers = angular.module('ulacitControllers', ['mgcrea.ngStrap']);

ulacitControllers.controller('employeesListController', ['$scope', 'ULACITService',
    function ($scope, ULACITService) {
        $scope.data = {};

        ULACITService.getAllEmployees(function (error, data) {
            if (!error) {
                $scope.data.employees = data;
            }
        });

    }]);

ulacitControllers.controller('accountListController', ['$scope', 'ULACITService',
    function ($scope, ULACITService) {
        $scope.data = {};

        ULACITService.getAllAccounts(function (error, data) {
            if (!error) {
                $scope.data.accounts = data;
            }
        });

    }]);

ulacitControllers.controller('accountController', ['$scope','$location','StorageService', 'ULACITService',
    function ($scope, $location,StorageService, ULACITService) {

        $scope.getAccountLogin = function(myForm) {
            $scope.data = {};

            ULACITService.getAccountLogin(myForm.username,myForm.password, function (response) {
                if (response == 'true') {
                    StorageService.save('myDataObject', myForm);
                    $location.path('/employees'); //Redirect to the another page
                }
               else{
                    $location.path('/error');
                }                
            });
        };
    }]);