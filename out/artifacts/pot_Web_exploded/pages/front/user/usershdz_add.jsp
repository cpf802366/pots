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
    <div class="hall-dz">
        <ul class="sub-nav">
            <li><a href="userCenter.shtml">我的紫砂</a></li>
            <li><a href="userCenter_shdz.shtml">收货地址</a></li>
            <li><a>新地址</a></li>
        </ul>
        <div class="userCenter">
            <div class="title">
                <h2>添加新地址</h2>
            </div>
        </div>
        <form action="user/userCenter_shdz_save.shtml" name="form1"
              method="post">
            <div class="shdzForm">
                <dl class="inputText mb20">
                    <dt>姓名</dt>
                    <dd>
                        <input type="text" name="name" value="${t.name }">
                    </dd>
                </dl>
                <dl class="inputText mb20">
                    <dt>区域</dt>
                    <dd class="EC">
                        <div class="drop-down col mr10">
                            <div class="btn">
                                <span class="target">请选择省</span><i
                                    class="iconfont icon-shangxia2 fs12"></i>
                            </div>
                            <div class="list">
                                <ul class="province">

                                </ul>
                            </div>
                        </div>
                        <div class="drop-down col mr10">
                            <div class="btn">
                                <span class="target">请选择城市</span><i
                                    class="iconfont icon-shangxia2 fs12"></i>
                            </div>
                            <div class="list">
                                <ul class="city">

                                </ul>
                            </div>
                        </div>
                        <div class="drop-down col">
                            <div class="btn">
                                <span class="target">请选择区县</span><i
                                    class="iconfont icon-shangxia2 fs12"></i>
                            </div>
                            <div class="list">
                                <ul class="area">

                                </ul>
                            </div>
                        </div>
                    </dd>
                </dl>
                <dl class="inputText mb20">
                    <dt>街道地址</dt>
                    <dd>
                        <input type="text" name="jddz" value="${t.jddz }">
                    </dd>
                </dl>
                <dl class="inputText mb20">
                    <dt>邮政编码</dt>
                    <dd>
                        <input type="text" name="postcode" value="${t.postcode }">
                    </dd>
                </dl>
                <dl class="inputText mb20">
                    <dt>电话号码</dt>
                    <dd>
                        <input type="text" name="phone" value="${t.phone }">
                    </dd>
                    <dd>可以与您的配送结合使用</dd>
                </dl>
                <dl class="inputText mb20">
                    <dt>
                        身份证号码 <a class="ml10">了解更多信息<i class="iconfont icon-xia"></i></a>
                    </dt>
                    <dd>
                        <input type="text" name="idcard" value="${t.idcard }">
                    </dd>
                </dl>
                <a class="shdzForm-Btn btnColor-violet mb10"
                   href="javascript:setProvinceCity();form1.submit()">继续</a>
            </div>
            <input type="hidden" id="province" name="province"
                   value="${t.province }"> <input type="hidden" id="city"
                                                  name="city" value="${t.city }"> <input type="hidden"
                                                                                         id="area" name="area"
                                                                                         value="${t.area }"> <input
                type="hidden" id="id" name="id" value="${t.id }">
        </form>
    </div>
</div>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>
</body>
</html>