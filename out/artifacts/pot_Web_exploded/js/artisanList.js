var app = angular.module('myApp', []);
app.controller('customersCtrl', function ($scope, $http) {
    $http.get("artisanList.shtml").then(function (response) {
        var array = [];
        for (var i = 0; i < response.data.yrlist.length; i++) {
            if (response.data.yrlist[i].img == "upload/yiren/00.jpg") {
                continue;
            }
            // response.data.yrlist[i].jianjie=response.data.yrlist[i].replace("</br>","")
            array.push(response.data.yrlist[i]);
        }
        response.data.yrlist = array;
        $scope.data = response.data;

    });
    $scope.getYiren = function (event) {
        var zhicheng = $(event.target).text();

        $http.get("artisanList.shtml", {
            params: {
                "zhicheng": zhicheng
            }
        }).then(function (response) {
            var array = [];
            for (var i = 0; i < response.data.yrlist.length; i++) {
                if (response.data.yrlist[i].img == "upload/yiren/00.jpg") {
                    continue;
                }
                // response.data.yrlist[i].jianjie=response.data.yrlist[i].replace("</br>","")
                array.push(response.data.yrlist[i]);
            }
            $scope.data.yrlist = array;

            setTimeout(function () {

                $(".main .dtlist li.osBottom").addClass("activate")

            }, 200);
        });
    }
});
