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

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>紫砂版权网</title>
    <link rel="stylesheet" href="http://at.alicdn.com/t/font_378986_59e5tkhu0418aor.css">
    <link rel="stylesheet" href="${ctx}css/com[0].css">
    <link rel="stylesheet" href="${ctx}css/com[main].css">
    <link rel="stylesheet" href="${ctx}css/com[fwjd].css">
    <link rel="stylesheet" href="${ctx}css/com[userCenter].css">
    <link rel="stylesheet" href="${ctx}css/com[phone].css">
    <link rel="stylesheet" href="${ctx}css/com[animation].css">
    <link rel="stylesheet" href="${ctx}css/com[salesProcess].css">
    <script type="text/javascript" src="${ctx}js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}js/js.js"></script>






<body>
<jsp:include page="/pages/header-nav.jsp"></jsp:include>
<div class="main">
    <div class="hall-dz">
        <ul class="sub-nav">
            <li>
                <a href="#.html">我的紫砂</a>
            </li>
            <li>
                <a href="#.html">购买</a>
            </li>
        </ul>
        <div class="userCenter">
            <div class="title">
                <h2>请选择支付方式</h2>
            </div>
        </div>
        <div class="salesProcess">

            <div class="paySelect"><ul>
                <li>
                    <a class="weixinPay">
                        <span><i class="iconfont icon-0268 radio"></i><i class="iconfont icon-0267 radio"></i><img src="<%=basePath%>images/pay/pay_1.jpg" /></span>
                    </a>
                    <a class="zhifubaoPay">
                        <span><i class="iconfont icon-0268 radio"></i><i class="iconfont icon-0267 radio"></i><img src="<%=basePath%>images/pay/pay_2.jpg" /></span>
                    </a>
                </li>
            </ul>
                <p class="selectTips">请在6个小时内完成付款</p></div>
            <div class="buttons">
                <a href="">继续</a>
            </div>

        </div>
    </div>
</div>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>
<!--menu end-->
<script>
    $(function(){
        var winHeight = $(window).innerHeight()
        var headerHeight = $('.header').innerHeight()
        var footerHeight = $('.footer').innerHeight()
        var mainHeight = winHeight - headerHeight - footerHeight - 3

        //console.log('winHeight = ' + winHeight)
        //console.log('headerHeight = ' + headerHeight)
        //console.log('footerHeight = ' + footerHeight)
        //console.log('mainHeight = ' + mainHeight)

        $('.main').css('min-height',mainHeight)

        var nextHeight = $('.next4').innerHeight()
        var hallBz = $('.hall-bz')
        hallBz.css({
            minHeight:mainHeight-nextHeight,
            paddingBottom:nextHeight
        })
    })
    $(function(){
        alert(123)
        var salesProcess = $('.salesProcess')
        var select = salesProcess.find('.paySelect')
        var btn = select.find('li a')
        var icon = btn.find('i')

        btn.click(function(){
            btn.removeClass('active')
            $(this).addClass('active')
            if($(this).is('.weixinPay')){
                $('.buttons a').attr('href','salesProcess_2_weixinPay.html')
            }else if($(this).is('.zhifubaoPay')){
                $('.buttons a').attr('href','salesProcess_2_zhifubaoPay.html')
            }
        })
    })
</script>
</body>
</html>
