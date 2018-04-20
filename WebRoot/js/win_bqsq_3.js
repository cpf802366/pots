var app = angular.module('myApp', []);
app.controller('customersCtrl', function ($scope, $http) {


    $scope.item = {};
    $http({"url": "banquan_get.shtml", timeout: 5 * 60 * 1000})
        .success(function (response) {

            $scope.item = response;


        });
});
var sfzimg = {"file1": null, "file2": null, "file3": null};
$().ready(function () {
    $('#file1,#file2,#file3').on("change", function () {
        var obj = this
        var ext = $(obj)[0].files[0];

        var formData = new FormData();
        var s = $('#' + obj.id)[0].files[0];
        formData.append(obj.id, s);
        $.ajax({
            url: 'banquan_zpzl_upload.shtml',
            type: 'POST',
            cache: false,
            data: formData,
            processData: false,
            contentType: false
        }).done(function (res) {
            if (res.indexOf("错误") >= 0) {
                sfzimg[obj.id] = 0;
                alert(res);
                return;
            }
            sfzimg[obj.id] = 1;
            $(obj).parents("a").css("background-image", "url(" + res + ")");
        }).fail(function (res) {
        });
    })
    $().ready(function () {
        $.ajax({
            "url": "banquan_get.shtml", dataType: "json", success: function (data) {
                debugger;
                if (typeof(data["草稿文件"]) != "undefined") {
                    if (data["草稿文件"][0] != null) {
                        sfzimg["file1"] = 1;
                        $("#file1").parents("a").css("background-image", "url(" + data["草稿文件"][0] + ")");
                    }
                    if (data["草稿文件"][1] != null) {
                        sfzimg["file2"] = 1;
                        $("#file2").parents("a").css("background-image", "url(" + data["草稿文件"][1] + ")");
                    }
                    if (data["草稿文件"][2] != null) {
                        sfzimg["file3"] = 1;
                        $("#file3").parents("a").css("background-image", "url(" + data["草稿文件"][2] + ")");
                    }
                }

            }
        })
    })
})