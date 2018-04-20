var img = {};

$().ready(function () {
    $("input[type='file']").on("change", function () {
        var obj = this
        var ext = $(obj)[0].files[0];

        var formData = new FormData();
        var s = $('#' + obj.id)[0].files[0];
        formData.append(obj.id, s);
        $.ajax({
            url: 'zjjd_upload.shtml',
            type: 'POST',
            cache: false,
            data: formData,
            processData: false,
            contentType: false
        }).done(function (res) {
            if (res.indexOf("错误") >= 0) {
                img[obj.id] = 0;
                alert(res);
                return;
            }
            img[obj.id] = 1;
            $(obj).parents("div.pic").css("background-image", "url(" + res + ")");
        }).fail(function (res) {
        });
    })

})

function checkImages(ids, page) {
    for (var i = 0; i < ids; i++) {
        if (typeof(img[id]) == "undefined" || img[id] != 1) {
            alert("还有图片没有上传");
        }
    }
    if (page == "win_fwjd_zjjd_0.html") {
        $.get("zjjd_finsh.shtml", function () {
            location.href = page;
        })
    }
    else
        location.href = page;

}