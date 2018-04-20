var jsonData = null;

$().ready(function () {
    if ($(".drop-down .province").length > 0) {
        $.getJSON("/jsondata/province.json", function (province_jsonData) {
            jsonData = province_jsonData;
            for (var i = 0; i < jsonData.length; i++) {
                $(".drop-down .province").append("<li>" + jsonData[i].name + "</li>")
            }
            initListener($(".drop-down .province li"));
            $(".drop-down .province li").on('click', function () {
                var thisText = $(this).text()
                setCity(thisText);
            })
            if ($("#province").val() != "") {

                setCity($("#province").val());
                $(".drop-down .province").parents(".drop-down").find(".target").text($("#province").val())
                $("#province").val("");
            }

        })

    }

});

function setCity(province) {
    $(".drop-down   .city").html("")
    for (var i = 0; i < jsonData.length; i++) {
        if (jsonData[i].name == province) {

            for (var j = 0; j < jsonData[i].city.length; j++) {
                $(".drop-down   .city").append("<li>" + jsonData[i].city[j].name + "</li>")
            }
            initListener($(".drop-down .city li"));
            $(".drop-down   .city li").on('click', function () {
                var thisText = $(this).text()
                setArea(province, thisText);
            })
            if ($("#city").val() != "") {

                setArea(province, $("#city").val());

                $(".drop-down .city").parents(".drop-down").find(".target").text($("#city").val())
                $("#city").val("");
            }
            return;
        }
    }
}

function setArea(province, city) {
    $(".drop-down   .area").html("")
    for (var i = 0; i < jsonData.length; i++) {
        if (jsonData[i].name == province) {

            for (var j = 0; j < jsonData[i].city.length; j++) {
                if (jsonData[i].city[j].name == city) {
                    for (var k = 0; k < jsonData[i].city[j].area.length; k++) {
                        $(".drop-down   .area").append("<li>" + jsonData[i].city[j].area[k] + "</li>")
                    }
                    initListener($(".drop-down .area li"));
                    if ($("#area").val() != "") {

                        $(".drop-down .area").parents(".drop-down").find(".target").text($("#area").val())
                    }
                    return;
                }


            }


        }
    }
}

function setProvinceCity() {
    $("#province").val($(".province").parents(".drop-down").find(".target").text());
    $("#city").val($(".city").parents(".drop-down").find(".target").text());
    $("#area").val($(".area").parents(".drop-down").find(".target").text());
}

function initListener(dropdown_list_li) {

    var dropdown_target = dropdown_list_li.parents(".drop-down").find('.target')
    dropdown_list_li.on('click', function () {
        var thisText = $(this).text()
        dropdown_target.text(thisText)
    })
}

function setDefaultDz(id) {
    $.get("user/userCenter_shdz_setDefaultDz.shtml?id=" + id, function (data) {

        location.reload(true);
    })
}

var vue = null;

function initShdzWinInfo(obj) {
    var url = "user/userCenter_shdz_json.shtml?id=" + obj.id;
    if (vue != null) {
        initVuedata(vue, url)
        return;
    }
    vue = new Vue({
        el: '#app',
        data: {t: {name: 1}},
        beforeCreate: function () {

            var _self = this;
            initVuedata(_self, url)
        },

//         created:function(){
//             var url="user/userCenter_shdz_json.shtml?id="+obj.id;
//         
//             this.$http.get(url).then(function(data){
//                 var json=data.body;
//                 this.data=eval("(" + json +")");
//             },function(response){
//                 console.info(response);
//             })
//         }
    });


}

function initVuedata(_self, url) {
    $.get(url, function (data) {

        _self.t = eval("(" + data + ")");
    })
}