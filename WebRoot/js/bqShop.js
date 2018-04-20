var app = angular.module('myApp', []);
app.controller('customersCtrl', function ($scope, $http) {
    $http.get("bqShopList.shtml")
        .then(function (response) {

            $scope.data = response.data;

        });
    $scope.getBanQuanSale = function (event) {
        var bqcrfs = $(event.target).text();

        $http.get("bqShopList.shtml", {params: {"bqcrfs": bqcrfs}})
            .then(function (response) {

                $scope.data.bqlist1 = response.data.bqlist1;
                setTimeout(function () {

                    $(".main .dtlist li.osBottom").addClass("activate")

                }, 200);

            });
    }
});

 
	
 
