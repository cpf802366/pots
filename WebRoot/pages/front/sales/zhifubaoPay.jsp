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
    <script type="text/javascript" src="${ctx}js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}js/js.js"></script>

<body>
<jsp:include page="/pages/header-nav.jsp"></jsp:include>
<div class="main">
    <div class="hall-dz">
        <div class="userCenter">
            <div class="title">
                <h2>交易完成</h2>
            </div>
        </div>
        <div class="salesProcess">
            <div class="payInfo">
                <ul>
                    <li>
                        <div class="cc">
                            <table class="address">
                                <tr>
                                    <td>发货至：</td>
                                    <td><span>${purchaes.buyer_name}</span><span> ${purchaes.delivery_addr}</span></td>
                                </tr>
                             <%--   <tr>
                                    <td>预计送达：</td>
                                    <td>2018年5月15日-2018年5月28日</td>
                                </tr>--%>
                            </table>
                        </div>
                        <div class="cc">
                            <table class="price">
                                <tr>
                                    <td>商品：</td>
                                    <td><span>¥</span><span>${purchaes.price}</span></td>
                                </tr>
                                <tr>
                                    <td>运费：</td>
                                    <td><span>¥</span><span> </span></td>
                                </tr>
                                <tr>
                                    <td>小计：</td>
                                    <td><span>¥</span><span>${purchaes.price}</span></td>
                                </tr>-
                            </table>
                        </div>
                        <div class="cc">
                            <table class="total">
                                <tr>
                                    <td>订单总价：</td>
                                    <td><span>¥</span><span>${purchaes.price}</span></td>
                                </tr>
                            </table>
                        </div>
                    </li>
                </ul>
            </div>
          <%--  <div class="buttons">
                <a href="salesProcess_3.html">打开支付宝支付</a>
            </div>--%>
        </div>
    </div>
</div>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>
</body>
</html>