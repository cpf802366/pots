var app = angular.module('myApp', []);
var customersCtrlScope;
var date = new Date().Format("yyyy-MM-dd");
app.controller('customersCtrl', function ($scope, $http) {
    customersCtrlScope = $scope;
    $scope.wtr = "";
    $scope.wtrq = date
    $scope.item = {};
    $http({"url": "banquan_get.shtml", timeout: 5 * 60 * 1000})
        .success(function (response) {

            $scope.item = response;
            $scope.wtr = $scope.item.name;


        });


});

function tj() {

    if ($(".icon-biaodankongjianfuxuan").length > 0)
        $.get("banquan_tj.shtml", function (data, status) {
            alert("提交成功");
            $(".win", window.parent.document).click()
        });

    else
        alert("未勾选条款");
}