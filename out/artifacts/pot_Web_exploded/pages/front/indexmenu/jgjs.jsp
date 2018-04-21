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





 <%--   <link rel="stylesheet" href="${ctx}css/owl.carousel.css">

    <link rel="stylesheet" href="${ctx}css/com[phone].css">--%>
    <link rel="stylesheet" href="${ctx}css/com[animation].css">
    <%--<link rel="stylesheet" href="${ctx}layui/css/layui.css" media="all">--%>


    <script type="text/javascript" src="${ctx}js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}js/js.js"></script>


<body>
<jsp:include page="/pages/header-nav.jsp"></jsp:include>
<div class="main">
    <div class="section-3">
        <div class="part lineStyle-top jqjsBar">
            <div class="bgStyle-black">
                <div class="warp oh">
                    <div class="content mt100 mb100">
                        <h1 class="mb30">江苏紫金文创新传媒股份有限公司</h1>
                        <p class="mb30 fb">
                            江苏紫金文创新传媒股份有限公司是江苏省文化产业聚合服务平台，公司是由江苏省委宣传部牵头江苏省发改委、江苏省文化厅、江苏省新闻出版广电局、江苏省统计局、江苏省金融办、人民银行南京分行共同组建，由江苏省文化改革发展领导小组办公室主管、中国江苏网主办。公司成立于2014年11月，注册资本5000万人民币。</p>
                        <p class="mb30">
                            公司整合政府各类资源，为企业提供权威、高效、专业、实用有价值的服务，以服务为抓手、平台为纽带，聚合各类资源打造江苏省文化产业的“资源共享平台”。公司通过承办“紫金奖”文化创意设计大赛，全面聚合了江苏、全国、乃至全球的文化高端资源，同时也沉淀了大量的人才、需求和项目等相关价值资源。公司积极推动市场要素的跨界流动，运用大数据技术和互联网思维对资源进行整合、分析和推广，加强技术引领，推动文化、科技、金融、人才等多种要素资源</p>
                        <div class="mb30 EC">
                            <div class="col mr20"><img src="${ctx}images/jgjs1.png" width="100%"></div>
                            <div class="col mr20"><img src="${ctx}images/jgjs2.png" width="100%"></div>
                            <div class="col mr20"><img src="${ctx}images/jgjs3.png" width="100%"></div>
                        </div>
                        <dl class="mb30 fb">
                            <dt>指导单位</dt>
                            <dd><span>江苏省委宣传部</span></dd>
                            <dd><span>江苏省文化厅</span></dd>
                            <dd><span>江苏省统计局</span></dd>
                            <dd><span>江苏省发展和改革委员会</span></dd>
                            <dd><span>江苏省广播电影电视局</span></dd>
                            <dd><span>江苏省金融办</span></dd>
                            <dd><span>江苏省商务厅</span></dd>
                            <dd><span>江苏省新闻出版局</span></dd>
                            <dd><span>中国人民银行南京分行</span></dd>
                        </dl>
                        <dl class="mb30 fb">
                            <dt>承办单位</dt>
                            <dd class="w100"><span>江苏紫金文创新传媒股份有限公司</span></dd>
                            <dd class="w100"><span>江苏中江网传媒股份有限公司</span></dd>
                        </dl>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>
</body>
</html>