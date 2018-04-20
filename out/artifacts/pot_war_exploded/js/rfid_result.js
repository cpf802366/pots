var app = angular.module('myApp', []);
app.controller('customersCtrl', function ($scope, $http) {


    $scope.item = {};
    $http({"url": "getRFID_Result.shtml", timeout: 5 * 60 * 1000})
        .success(function (response) {


            $scope.item = response;


        });
});
 
 
 
	
