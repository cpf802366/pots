<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@    taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}/" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>紫砂版权网</title>
    <link rel="stylesheet"
          href="http://at.alicdn.com/t/font_378986_59e5tkhu0418aor.css">
    <link rel="stylesheet" href="${ctx}css/com[0].css">
    <link rel="stylesheet" href="${ctx}css/com[main].css">
    <link rel="stylesheet" href="${ctx}css/com[login].css">
    <link rel="stylesheet" href="${ctx}css/com[phone].css">
    <script type="text/javascript" src="${ctx}js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}js/js.js"></script>

</head>
<body>
<jsp:include page="/pages/header-nav.jsp"></jsp:include>


<div class="main" id="app">
    <div class="loginIndex">
        <h1 class="mt30 mb30">验证手机号</h1>
        <p class="fs12 ">验证码已发送至您手机</p>
        <p class="fs18 mb10">${phone}</p>
        <dl class="inputText mb10">
            <dt><span>输入验证码</span><a class="forgetKey" onclick="againyzm()">重新发送验证码</a></dt>
            <dd>
                <input type="text" id="yzm">
                <input type="hidden" id="uuid" value="${uuid}">
            </dd>
        </dl>
        <a class="loginBtn btnColor-violet mb10" href="javascript:void(0)" onclick="yzmyz()">验证</a>
        <div id="error" style="color:red"></div>
    </div>
</div>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>

<script>
    $(function () {
        var winHeight = $(window).innerHeight()
        var headerHeight = $('.header').innerHeight()
        var footerHeight = $('.footer').innerHeight()
        var mainHeight = winHeight - headerHeight - footerHeight - 3
        $('.main').css('min-height', mainHeight)
    })

    function yzmyz() {
        /*   $("body").mLoading("show");*/
        var url = "<%=basePath%>login/yzmyz"
        var param = "yzm=" + $("#yzm").val() + "&uuid=" + $("#uuid").val();

        $.ajax({
            type: "POST",
            url: url,
            data: param,
            //async: false,
            dataType: "json",
            error: function (r) {
                $("body").mLoading("hide");
                alert("发生错误" + r);
            },
            success: function (data) {
                /* $("body").mLoading("hide");*/
                if (data.code == "0") {
                    location.href = '<%=basePath%>login/usercenter';
                }
                else {
                    $("#error").html(data.msg);
                }
            }
        })
    }

    function againyzm() {
        $.ajax({
            type: "POST",
            url: url,
            data: param,
            //async: false,
            dataType: "json",
            error: function (r) {
                $("body").mLoading("hide");
                alert("发生错误" + r);
            },
            success: function (data) {
                /* $("body").mLoading("hide");*/
                if (data.code == "0") {
                    location.href = '<%=basePath%>login/usercenter';
                }
                else {
                    $("#error").html(data.msg);
                }
            }
        })
    }
</script>
</body>
</body>
</html>