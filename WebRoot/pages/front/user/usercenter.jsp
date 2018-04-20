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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>紫砂版权网</title>
    <link rel="stylesheet" href="http://at.alicdn.com/t/font_378986_59e5tkhu0418aor.css">
    <link rel="stylesheet" href="${ctx}css/com[0].css">
    <link rel="stylesheet" href="${ctx}css/com[main].css">
    <link rel="stylesheet" href="${ctx}css/com[fwjd].css">
    <link rel="stylesheet" href="${ctx}css/com[userCenter].css">
    <link rel="stylesheet" href="${ctx}css/com[phone].css">

    <script type="text/javascript" src="${ctx}js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}js/js.js"></script>


<body>
<jsp:include page="/pages/header-nav.jsp"></jsp:include>
<div class="main">
    <div class="hall-bz">
        <div class="userCenter">
            <div class="title">
                <h1>我的紫砂</h1>
            </div>
            <ul class="buttonBar">
                <li><a href="<%=basePath%>memAddr/listByUser">
                    <div class="info">
                        <h4>收货地址</h4>
                        <span>添加或编辑地址信息</span>
                    </div>
                </a></li>
                <li><a href="<%=basePath%>user/dlaq">
                    <div class="info">
                        <h4>登录安全</h4>
                        <span>编辑登录名、姓名和手机号码</span>
                    </div>
                </a></li>

                <li><a href="<%=basePath%>user/myhu">
                    <div class="info">
                        <h4>我的紫砂壶</h4>
                        <span>查看、追踪紫砂壶</span>
                    </div>
                </a></li>

            </ul>
        </div>
    </div>
</div>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>
<!--menu end-->
<script>
    $(function () {
        var winHeight = $(window).innerHeight()
        var headerHeight = $('.header').innerHeight()
        var footerHeight = $('.footer').innerHeight()
        var mainHeight = winHeight - headerHeight - footerHeight - 3


        $('.main').css('min-height', mainHeight)

        var nextHeight = $('.next4').innerHeight()
        var hallBz = $('.hall-bz')
        hallBz.css({
            minHeight: mainHeight - nextHeight,
            paddingBottom: nextHeight
        })
    })
</script>
</body>
</html>
