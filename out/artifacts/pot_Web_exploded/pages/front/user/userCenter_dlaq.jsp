<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@    taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}/" scope="request"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cmn-Hans">
<head>
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0 minimal-ui"/>

    <base href="/"/>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0 minimal-ui"/>
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="yes" name="apple-touch-fullscreen">
    <title>紫砂版权网</title>
    <link rel="stylesheet" href="http://at.alicdn.com/t/font_378986_59e5tkhu0418aor.css">
    <link rel="stylesheet" href="${ctx}css/com[0].css">
    <link rel="stylesheet" href="${ctx}css/com[main].css">
    <link rel="stylesheet" href="${ctx}css/com[fwjd].css">
    <link rel="stylesheet" href="${ctx}css/com[userCenter].css">
    <link rel="stylesheet" href="${ctx}css/com[phone].css">
    <link rel="stylesheet" href="${ctx}css/com[animation].css">

    <script type="text/javascript" src="${ctx}js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}js/js.js"></script>
</head>

<body>
<jsp:include page="/pages/header-nav.jsp"></jsp:include>
<div class="main">
    <div class="hall-dz">
        <div class="userCenter">
            <ul class="sub-nav">
                <li><a href="user/userCenter.html">我的紫砂</a></li>
                <li><a>登陆安全</a></li>
            </ul>
            <div class="dlaq">
                <dl>
                    <dt>
                        <h1>您的安全级别</h1>
                    </dt>
                    <dd>
                        <div class="level">
                            <span>安全级别：</span>
                            <div class="ooo">
                                <div class="iii"></div>
                            </div>
                            <span>较高</span>
                        </div>
                        <p class="fr">建议您启动全部安全设置，以保障账户资金安全。</p>
                    </dd>
                </dl>
                <dl>
                    <dt>
                        <h1>登陆密码</h1>
                        <i class="iconfont icon-ziyuan"></i><a>修改</a>
                    </dt>
                    <dd>
                        <p>互联网账号存在被盗风险，建议您定期更改密码以保护账户安全。</p>
                    </dd>
                </dl>
                <dl>
                    <dt>
                        <h1>邮箱验证</h1>
                        <i class="iconfont icon-ziyuan"></i><a>修改</a>
                    </dt>
                    <dd>
                        <p>
                            您的验证邮箱：<span class="fb">${user.email }</span>
                        </p>
                    </dd>
                </dl>
                <dl>
                    <dt>
                        <h1>手机验证</h1>
                        <i class="iconfont icon-ziyuan1"></i><a>修改</a>
                    </dt>
                    <dd>
                        <p>
                            您的验证手机：<span class="fb">${user.mobile }</span><span lass="fr">若已丢失或停用，请立即更换，避免账号被盗</span>
                        </p>
                    </dd>
                </dl>
                <dl>
                    <dt>
                        <h1>实名认证</h1>
                        <i class="iconfont icon-ziyuan"></i><a>修改</a>
                    </dt>
                    <dd>
                        <p>
                        <p>
                            您的实名认证信息：<span class="fb mr10">${user.name }</span><span class="fb"></span>
                        </p>
                        </p>
                    </dd>
                </dl>
                <div class="tips">
                    <h5>安全服务提示</h5>
                    <p>1.注意防范进入钓鱼网站，不要轻信各种即时通讯工具发送的商品或支付链接，谨防网购诈骗。</p>
                    <p>2.建议您安装杀毒软件，并定期更新操作系统等软件补丁，确保账户及交易安全。</p>
                </div>
            </div>
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
