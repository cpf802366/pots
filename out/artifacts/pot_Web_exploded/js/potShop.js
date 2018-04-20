var app = angular.module('myApp', []);
app.controller('customersCtrl', function ($scope, $http) {

    $http.get("potShopList.shtml").then(function (response) {

        var potlist = [];
        for (var i = 0; i < response.data.potlist1.length && i < 4; i++) {
            potlist.push(response.data.potlist1[i]);
        }
        response.data.potlist = potlist;
        $scope.data = response.data;
    });
    $scope.getPot = function (event) {
        var zx = $(event.target).text();

        $http.get("potShopList.shtml", {
            params: {
                "zx": zx
            }
        }).then(function (response) {

            $scope.data.potlist1 = response.data.potlist1;
            setTimeout(function () {

                $(".main .dtlist li.osBottom").addClass("activate")

            }, 200);

        });
    }
});
