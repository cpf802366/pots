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
    <link rel="stylesheet" href="http://at.alicdn.com/t/font_378986_agapjrjbkn50o1or.css">
    <link rel="stylesheet" type="text/css" href="${ctx}layui/css/layui.css"/>
    <link rel="stylesheet" href="${ctx}css/com[0].css">
    <link rel="stylesheet" href="${ctx}css/owl.carousel.css">
    <link rel="stylesheet" href="${ctx}css/com[main].css">
    <link rel="stylesheet" href="${ctx}css/com[phone].css">
    <link rel="stylesheet" href="${ctx}css/com[animation].css">
    <link rel="stylesheet" href="${ctx}layui/css/layui.css" media="all">
    <script type="text/javascript" src="${ctx}js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}js/js.js"></script>

    <script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>


<body>
<jsp:include page="/pages/header-nav.jsp"></jsp:include>
<div class="layui-carousel header-banner   " id="test1" lay-filter="test1" style="background: #5e2662;">
    <div carousel-item="" style="height: 250px;">
        <div><a class="item"><img style="width:  100%;height: 100%" src="${ctx}images/header_banner1.jpg" alt=""></a>
        </div>
        <div><a class="item"><img style="width:  100%;height: 100%" src="${ctx}images/header_banner2.jpg" alt=""></a>
        </div>

    </div>
</div>

<div class="main" ng-app="myApp" ng-controller="customersCtrl">
    <div class="section-3">
        <div class="part lineStyle-top artisanBar2" style="display:none">
            <div class="bgStyle-black">
                <div class="warp oh">
                    <div class="title partTitle-black osTop">名家推荐</div>
                    <p class="bs mb20 ac osTop fcBlack8">紫砂艺术的创作与传承人</p>
                    <ul class="artisans-col2 pb50 cb">

                        <c:forEach var="art" items="${artlist}" varStatus="status" begin="0" end="7" step="1">


                            <li class="osBottom cb">
                                <div class="info EC">
                                    <div class="pic"><img src="${ctx}${art.img}"></div>
                                    <div class="tbox col">
                                        <h4>${art.name}</h4>
                                        <p><span>职称：${art.title}</span>
                                                <%--<span>性别：${art.title_By}</span>--%>

                                            <a class="more" href="ZhiShaYiRen_{{item.id}}.shtml">${art.resume}</a></p>
                                    </div>
                                    <div class="artisanBar-personFun thisTop">
                                        <a class="mr10"><i class="iconfont icon-dianzan"></i></a>
                                        <a><i class="iconfont icon-liaotian"></i></a>
                                    </div>
                                </div>
                                <div class="fun EC">
                                    <a class="col">承诺书</a>
                                    <a class="col">作品</a>
                                    <a class="col">版权</a>
                                </div>
                            </li>

                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="part potShopBar">
            <div class="bgStyle-white">
                <div class="warp">
                    <div class="title partTitle-white osTop">紫砂艺人</div>
                    <ul class="potShopList cb osBottom">
                        <li>
                            <a ng-click="getYiren($event)">
                                <nobr>研究员级</nobr>
                            </a>
                        </li>
                        <li>
                            <a ng-click="getYiren($event)">
                                <nobr>高级工艺美术师</nobr>
                            </a>
                        </li>
                        <li>
                            <a ng-click="getYiren($event)">
                                <nobr>工艺美术师</nobr>
                            </a>
                        </li>
                        <li>
                            <a ng-click="getYiren($event)">
                                <nobr>助理工艺美术师</nobr>
                            </a>
                        </li>
                        <li>
                            <a ng-click="getYiren($event)">
                                <nobr>工艺美术员</nobr>
                            </a>
                        </li>
                        <li>
                            <a ng-click="getYiren($event)">
                                <nobr>陶艺艺人</nobr>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="part lineStyle-top artisanBar">
            <div class="bgStyle-black">
                <div class="warp oh">
                    <div class="title partTitle-black osTop">紫砂艺人</div>
                    <p class="bs mb20 ac osTop fcBlack8">紫砂艺术的创作与传承人</p>
                    <ul class="artisans cb">
                        <c:forEach var="art" items="${artlist}" varStatus="status" begin="0" end="7" step="1">
                            <li class="osScale">
                                <img class=" layui-col-xs4" src="${ctx}${art.img}">
                                <div class="info">
                                    <div class="artisanBar-personFun thisTop">
                                        <a class="mr10"><i class="iconfont icon-dianzan"></i></a>
                                        <a><i class="iconfont icon-liaotian"></i></a>
                                    </div>
                                    <div class="thisBottom">
                                        <p class="name">${art.name}</p>
                                        <p class="rank">职称：${art.title_By}</p>
                                        <p class="link">
                                            <a href='ZhiShaYiRen_{{item.id}}.shtml'>承诺书</a>
                                        </p>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

    </div>
    <jsp:include page="/pages/footer-nav.jsp"></jsp:include>
    <script src="${ctx}layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript">
        layui.use(['carousel', 'form'], function () {
            var carousel = layui.carousel
                , form = layui.form;

            //常规轮播
            carousel.render({
                elem: '#test1'
                , arrow: 'always'
                , width: '100%'
                , height: '300px'
            });
        });


        $(document).ready(function () {
            alert(123)
            setTimeout(function () {

                $(".main .dtlist li.osBottom").addClass("activate")

            }, 200);
        });
    </script>
</body>
</html>