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
    <link rel="stylesheet" href="${ctx}layui/css/layui.css" media="all">

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
                <a href="#.html">收货地址</a>
            </li>
        </ul>
        <div class="userCenter">
            <div class="title">
                <h2>请选择配送地址</h2>
            </div>
        </div>
        <div class="salesProcess">

            <div>
                <ul>
                    <c:forEach var="memaddr" items="${memAddrList}" varStatus="status">
                    <li>
                        <div>
                            <%--<div id="selected" class="layui-icon  lefticon" style="font-size: 90px; color: #5FB878" onclick="selected(${memaddr.id})" >&#xe627;</div>--%>
                           <%-- <div class="layui-icon  lefticon" style="font-size: 90px; color: #c2c2c2;" >&#xe626;</div>--%>

                                <input type="radio"   class="lefticon"   name="maddrid" value="${memaddr.id}"  ${memaddr.defaultdz=='1'?"checked":"" } />
                              <p class="pc_mb30 ph_mb20 fb">

                                <span>${memaddr.name}</span><span>${memaddr.province}</span><span>${memaddr.city}</span><span>${memaddr.area}</span><span>${memaddr.jddz}</span>
                                  <span>${memaddr.postcode}</span>
                            </p>
                            <p class="pc_mb30 fb"><span>电话：</span><span>${memaddr.phone}</span></p>
                        </div>
                    </li>
                    </c:forEach>
                </ul>
                <div class="buttons">
                    <a href="salesProcess_1.html">发货到该地址</a>
                    <a href="javascript:void(0)" onclick="selected()">不取货</a>
                    <input type="hidden" id="selectedshdz">
                    <input type="hidden" id="pono" value="${pono}">
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>
<script type="text/javascript">

     function selected( ){
         var val = $('input[name="maddrid"]:checked').val();
         window.location.href="<%=basePath%>sales/zffs/"+val+'/'+$('#pono').val();


    };

</script>
</body>
</html>