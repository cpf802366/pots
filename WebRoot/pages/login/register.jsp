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
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0 minimal-ui"/>

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
<form action="login_reg_submit" id="form1">
    <div class="main">
        <div class="loginIndex">
            <h1 class="mt30 mb30">创建账户</h1>
            <dl class="inputText mb20">
                <dt>您的姓名</dt>
                <dd>
                    <input type="text" name="name">
                </dd>
            </dl>
            <dl class="inputText mb20">
                <dt>手机号码(必选)</dt>
                <dd class="EC">
                    <div class="areaCode mr10">CN+86 <i class="iconfont icon-shangxia2 fs12"></i></div>
                    <input class="col db" type="text" name="mobile">
                </dd>
            </dl>
            <dl class="inputText mb20">
                <dt>电子邮件地址</dt>
                <dd>
                    <input type="text" name="email">
                </dd>
            </dl>
            <dl class="inputText mb10">
                <dt>密码</dt>
                <dd>
                    <input type="text" placeholder="至少6个字符" name="password">
                </dd>
            </dl>
            <div class="customOption mb20">
                <label>
                    <input type="checkbox">
                    我已阅读并同意
                    <a href="#">使用条件</a>
                    及
                    <a href="#">隐私声明</a>
                </label>
            </div>
            <div id="error" style="color:red"></div>
            <p class="fb mb20">我们将向您发送短信验证您的手机。<br>
                可能收取消息和数据费用。</p>
            <a class="loginBtn btnColor-violet mb10" href="Javascript:valid()">继续</a>
            <p>已拥有账户？
                <a href="login.shtml">登陆</a>
            </p>
            <div>loading</div>
        </div>
    </div>
</form>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>

<script>
    $(function () {
        var winHeight = $(window).innerHeight()
        var headerHeight = $('.header').innerHeight()
        var footerHeight = $('.footer').innerHeight()
        var mainHeight = winHeight - headerHeight - footerHeight - 3
        $('.main').css('min-height', mainHeight)
    })

    function valid() {
        /*  $("body").mLoading("show");*/
        var url = "<%=basePath%>login/register"
        $.ajax({
            type: "POST",
            url: url,
            data: $('#form1').serialize(),// 序列化表单值
            //async: false,
            dataType: "json",
            error: function (r) {
                $("body").mLoading("hide");
                alert("发生错误" + r);
            },
            success: function (data) {
                /*$("body").mLoading("hide");*/
                if (data.code == "0") {
                    location.href = '<%=basePath%>login/validate?uuid=' + data.msg;
                }
                else {
                    $("#error").html(data.msg);
                }
            }
        });
    }
</script>
</body>
</body>
</html>