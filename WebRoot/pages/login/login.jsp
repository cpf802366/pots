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
<form action="<%=basePath%>login/login" method="post" name="form1">
    <div class="main" id="app">
        <div class="loginIndex">
            <h1 class="mt30 mb30">登陆</h1>
            <dl class="inputText mb20">
                <dt>用户名</dt>
                <dd>
                    <input type="text" name="username">
                </dd>
            </dl>
            <dl class="inputText mb10">
                <dt>
                    <span>密码</span><a class="forgetKey" href="login_helpKey.html">忘记密码</a>
                </dt>
                <dd>
                    <input type="text" name="password">
                </dd>
            </dl>
            <a class="loginBtn btnColor-violet mb10"
               href="javascript:form1.submit()">登录</a>
            <div class="customOption mb20">
                <label><input type="checkbox">记住登陆状态。</label> <a>详情<i
                    class="iconfont icon-xia"></i></a> <span id="error" style="color: red"></span>
            </div>
            <div class="lineTitle mb10">
                <span>新用户？</span>
            </div>
            <a class="loginBtn btnColor-gray mb10" href="<%=basePath%>login/toregister">创建您的账号</a>
            <p class="tips">
                登陆即表示您同意网站的 <a href="#">使用条件</a> 及 <a href="#">隐私声明</a>
            </p>
        </div>
    </div>
</form>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>
<!--menu end-->
<script>
    $(function () {
        var winHeight = $(window).innerHeight()
        var headerHeight = $('.header').innerHeight()
        var footerHeight = $('.footer').innerHeight()
        var mainHeight = winHeight - headerHeight - footerHeight - 3
        $('.main').css('min-height', mainHeight)
    })
</script>
</body>
</html>