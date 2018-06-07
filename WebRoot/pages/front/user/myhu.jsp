<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@    taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@    taglib prefix="fn" uri="/WEB-INF/tld/fn.tld" %>
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
    <link rel="stylesheet" href="${ctx}css/com[salesProcess].css">
    <script type="text/javascript" src="${ctx}js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}js/js.js"></script>





    <script type="text/javascript" src="javascript/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="javascript/js.js"></script>
</head>

<body>
<jsp:include page="/pages/header-nav.jsp"></jsp:include>
<div class="main">
    <div class="hall-dz">
        <ul class="sub-nav ph_dn">
        </ul>
        <div class="userCenter">
            <div class="title">
                <h2>我的紫砂壶</h2>
            </div>
        </div>
        <div class="myhu">
            <div class="mb20">
                <h2 class="fcViolet">
                    现有紫砂壶<span>${fn:length(myhuList) } </span>个，出售<span>${cntMySales}</span>个
                </h2>
            </div>
            <c:forEach var="t" items="${myhuList}" varStatus="status">
                <div class="myhuContent">
                    <h3 class="title fcViolet">
                        <span class="pc_fl ph_db">订单编号：${t.po_no}</span><span
                            class="pc_fr ph_db">购买时间：${t.po_dttm_str}</span>
                    </h3>
                    <div class="cc pc_EC">
                        <div class="huImg">
                            <img src="${t.design_img}"  />
                        </div>
                        <div class="huInfo pc_col">
                            <h2 class="mb20">紫砂壶《${t.design_name }》</h2>
                            <h3 class="mb10">购买价格：¥${t.po_price_str}</h3>
                            <h3 class="mb10">紫砂壶鉴定证号：NO.${t.jdzh}</h3>
                            <h3 class="btn">${t.taken?"":"未提货" }</h3>
                        </div>
                    </div>
                    <div class="ct">
                        <table>
                            <tr>
                                <th>持壶人</th>
                                <th>价格</th>
                                <th>持壶时间</th>
                            </tr>
                            <c:forEach var="his" items="${t.hisDOList}" varStatus="status">
                                <tr>
                                    <td>${his.owner_name}</td>
                                    <td>${his.po_price_str}</td>
                                    <td>${his.po_dttm_str}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
                <div class="buttons">
                <c:choose>
                    <c:when test="${t.flagSales>0}">
                        <a href="javascript:void(0)">出售中</a>
                    </c:when>

                    <c:otherwise>

                            <a href="<%=basePath%>sales/add?potId=${t.pot_id}">出售</a>
                            <a href="javascript:void(0)">取壶</a>

                    </c:otherwise>
                </c:choose>
                </div>


            </c:forEach>

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
    $(function () {
        var salesProcess = $('.salesProcess')
        var select = salesProcess.find('.paySelect')
        var btn = select.find('li a')
        var icon = btn.find('i')

        btn.click(function () {
            btn.removeClass('active')
            $(this).addClass('active')
        })
    })
</script>
</body>
</html>
