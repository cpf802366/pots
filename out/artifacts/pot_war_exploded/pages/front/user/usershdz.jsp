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
        <div class="userCenter">
            <ul class="sub-nav">
                <li><a href="user/userCenter.shtml">我的紫砂</a></li>
                <li><a>收货地址</a></li>
            </ul>
            <div class="title">
                <h2>我的紫砂</h2>
                <span>请确认或编辑您想要使用的地址。</span>
            </div>
            <ul class="shdzList cb">
                <li class="addNew"><a href="/memAddr/add">添加新地址</a>
                </li>
                <c:forEach var="memaddr" items="${memAddrList}" varStatus="status">
                    <%-- <c:forEach list="${list }" var="t">--%>
                    <li>
                        <div class="con">
                            <div class="target">
                                <h5></h5>
                            </div>
                            <div class="info">
                                <h5>${memaddr.name}</h5>
                                <p>
                                    <span>${memaddr.province}</span><span>${memaddr.city}</span><span>${memaddr.area}</span>
                                </p>
                                <p>
                                    <span>${memaddr.jddz}</span>
                                </p>
                                <p>${memaddr.postcode}</p>
                                <p>电话：${memaddr.phone}</p>
                            </div>
                            <div class="btns cb">
                                <a href="user/userCenter_shdz_edit.shtml?id=${t.id}">编辑</a> <a
                                    class="delete openWin" id="${t.id}">删除</a> <a
                                    class="target-btn" ${t.defaultDz?'style="display: none"':''}
                                    href="javascript:setDefaultDz(${t.id})">设为默认地址</a>
                            </div>
                        </div>
                    </li>
                </c:forEach>

            </ul>
        </div>
    </div>
</div>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>
</body>
</html>