var ulacitServices = angular.module('ulacitServices', ['ngResource']);

ulacitServices.factory('ULACITService', function ($http) {
        var serviceURL = 'http://localhost:8080/services/api/employees';
        var serviceURL1 = 'http://localhost:8080/services/api/accounts';

        return {
			getAllAccounts: function(callback) {
                $http.get(serviceURL)
                    .success(function (data) {
                        callback(null, data);
                    })
                    .error(function (e) {
                        callback(e);
                    });
            },
            getAllEmployees: function(callback) {
                $http.get(serviceURL)
                    .success(function (data) {
                        callback(null, data);
                    })
                    .error(function (e) {
                        callback(e);
                    });
            },
            getAccountLogin: function(userId,password,callback) {
                var url = serviceURL1 + '/'+userId+'/'+password;
                $http.get(url)
                    .success(function (r) {
                        callback(r);
                    })
                    .error(function (e) {
                        callback(e);
                    });
            }                   
        }
    }
);

ulacitServices.factory('StorageService', function StorageService($window) {
    return {
        get: function (key) {
            var data = angular.fromJson($window.sessionStorage.getItem(key));

            return data;
        },

        save: function (key, dataToSave) {
            var dataToSaveInJson = angular.toJson(dataToSave);

            return $window.sessionStorage.setItem(key, dataToSaveInJson);
        },

        remove: function(key) {
            return $window.sessionStorage.removeItem(key);
        },

        clear: function () {
            $window.sessionStorage.clear();
        }
    }
});