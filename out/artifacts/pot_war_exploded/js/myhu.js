var app = angular.module('myApp', []);
app.controller('myhuCtrl', function ($scope, $http) {
    $http.get("user/myhu_list.shtml").then(function (response) {
        /*
        var array = [];
        for (var i = 0; i < response.data.myhuList.length; i++) {
            if (response.data.myhuList[i].img == "upload/yiren/00.jpg") {
                continue;
            }
            // response.data.yrlist[i].jianjie=response.data.yrlist[i].replace("</br>","")
            array.push(response.data.myhuList[i]);
        }
        response.data.yrlist = array;
        */
        $scope.data = response.data;

    });
});

/*
 * $(document).ready( function() {
 * 
 * $.ajax({
 * 
 * url : "user/myhu_list.shtml", data : null, type : "get", dateType : "json",
 * success : function(msg) {
 * 
 * alert(msg.cnt); var str = ""; var data = msg.data;
 * 
 * for (i in data) { str += "<tr>" + "<td>" + data[i].order.orderNo + "</td>" + "<td>" +
 * data[i].prod.author + "</td>" + "</tr>"; } alert(str);
 * 
 * alert(msg); }, error : function(msg) { alert(msg); } }); });
 */