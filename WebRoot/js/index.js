var app = angular.module('myApp', []);
app.controller('customersCtrl', function ($scope, $http) {
    $http.get("indexjson.shtml")
        .success(function (response) {
            var array = [];
            for (var i = 0; i < 4; i++) {
                array.push(response.zpTop[i])
            }
            response.zpTop = array;
            $scope.index = response;

            setTimeout(function () {
                AngularJS_Init();
            }, 10);
        });
});

function closeJdApply() {

    $(".win").click()
}
	
 
