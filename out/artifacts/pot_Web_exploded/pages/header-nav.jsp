<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@    taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="header">
    <div class="header-tips bgStyle-white">
        <div class="warp">
            <div class="fl">
                <span class="mr5">江苏紫金文创新传媒股份有限公司</span><span>紫砂版权网</span>
            </div>
            <ul class="fr ph_dn">
                <li><a href="/login/usercenter">我的紫砂</a></li>

                <li><a>服务中心</a></li>
                <li>
                    <a href="/login/tologin">登录</a>
                </li>
            </ul>
            <a href="/login/usercenter" class="fr dn ph_db ph_mr10">我的紫砂</a>
        </div>
    </div>
    <div class="header-nav">
        <div class="nav">
            <div class="warp">
                <div class="navlogo fl">
                    <img src="/images/logo.png">
                </div>
                <ul class="fr ph_dn">
                    <li><a class="openMenu" href="<%=basePath%>/index"><span>首页</span>
                    </a></li>
                    <li><a class="openMenu" href="<%=basePath%>/index/jgjs"><span>机构介绍</span>
                    </a></li>
                    <li><a class="openMenu" href="<%=basePath%>/index/zsyr"><span>紫砂艺人</span>
                    </a></li>
                    <li><a class="openMenu" href="<%=basePath%>/index/zszp"><span>紫砂作品</span>

                    <li><a class="openMenu" href="<%=basePath%>/index/zszj"><span>紫砂专家</span>

                    <li><a><i class="iconfont icon-sousuo fs14"></i></a></li>
                </ul>
                <a class="leftmenuBtn fr menu-button-open dn ph_db"><i
                        class="iconfont icon-caidan1"></i></a>
            </div>
        </div>
        <div class="menu">
            <div class="warp">
                <ul>
                </ul>
            </div>
        </div>
    </div>
</div>