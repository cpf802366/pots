<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@    taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}/" scope="request"/>
<div class="footer lineStyle-top">
    <div class="footer-bg bgStyle-white cb">
        <div class="declare">
            <p>
                <a>江苏省委宣传部</a>
                <span>/</span>
                <a>江苏省发展和改革委员会</a>
                <span>/</span>
                <a>江苏省商务厅</a>
                <span>/</span>
                <a>江苏省文化厅</a>
                <span>/</span>
                <a>江苏省广播电视局</a>
                <span>/</span>
                <a>江苏省新闻出版局</a>
            </p>
            <p>© COPYRIGHT 2017 江苏紫金文创新传媒股份有限公司 苏ICP备07000608号</p>
        </div>
    </div>
</div>
<div class="menu dn retract" >
    <div class="list">
        <ul>
            <li>
                <img src="${ctx}images/jdpart2.png" width="100%">
                <a class="menu-button-close"><i class="iconfont icon-xiangyoujiantou"></i></a>
            </li>


            <li>
                <a href="<%=basePath%>/index">首页</a>
            </li>
            <li>
                <a href="<%=basePath%>/index/jgjs">机构介绍</a>
            </li>
            <li>
                <a href="<%=basePath%>/index/zsyr">紫砂艺人</a>
            </li>
            <li>
                <a href="<%=basePath%>/index/zszp">紫砂作品</a>
            </li>

            <li>
                <a href="<%=basePath%>/index/zszj">紫砂专家</a>
            </li>

            <li>
                <a href="#">退出登录</a>
            </li>
        </ul>
        <p>
            <span>© 紫砂版权网 ,</span>
            <span>powered by 江苏紫金文创新传媒股份有限公司 </span>
        </p>
    </div>
</div>

