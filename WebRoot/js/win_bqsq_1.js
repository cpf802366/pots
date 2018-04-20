var app = angular.module('myApp', []);
app.controller('customersCtrl', function ($scope, $http) {


    $scope.item = {};
    $http({"url": "banquan_get.shtml", timeout: 5 * 60 * 1000})
        .success(function (response) {

            $scope.item = response;


        });
});

function setValues() {
    $("input[name='zjlx']").val($("#zjlx .icon-xiangxiajiantou").prev().text());
    $("input[name='djlx']").val($("#djlx .icon-xiangxiajiantou").prev().text());

    form1.submit()
}
