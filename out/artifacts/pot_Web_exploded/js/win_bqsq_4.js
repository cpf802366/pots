var app = angular.module('myApp', []);
var customersCtrlScope;
app.controller('customersCtrl', function ($scope, $http) {
    customersCtrlScope = $scope;
    $scope.czxzs = ["原创", "改编", "翻译", "汇编", "注释", "整理", "其他"];
    $scope.qlgsfs = ["法人作品", "合作作品", "职务作品"]
    $scope.fbzts = ["已发表", "未发表"];
    $scope.item = {czgcjj: "", "czdd": "", "ccsj": ""};
    $http({"url": "banquan_get.shtml", timeout: 5 * 60 * 1000})
        .success(function (response) {

            $scope.item = response;

            if ($scope.item.productczxz == null) {
                $scope.item.productczxz = "原创";
            }
            if ($scope.item.qlgs == null) {
                $scope.item.qlgs = "法人作品";
            }
            if ($scope.item.fbzt == null) {
                $scope.item.fbzt = "已发表";
            }

        });
});

function setValues() {

    $("input[name='productczxz']").val($(".productczxz .icon-0267").next().text());
    $("input[name='qlgs']").val($(".qlgs .icon-0267").next().text());
    $("input[name='fbzt']").val($(".fbzt .icon-0267").next().text());
    form1.submit();
}