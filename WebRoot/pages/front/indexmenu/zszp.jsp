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


<div class="main activate">
    <div class="section-3">
        <div class="part lineStyle-top potBar">
            <div class="bgStyle-black">
                <div class="warp oh">
                    <div class="title partTitle-black  ">紫砂作品</div>
                    <p class="bs mb20 ac   fcBlack8">“泥”、“形”、“工”、“款”、“意”。</p>
                    <ul class="potList cb ">
                        <c:forEach var="designlist" items="${designlist}" varStatus="status" begin="0" end="3" step="1">
                            <li onclick='location.href="${ctx}design?designId=${designlist.design_Id}"' class="osScale">
                                <img src="${ctx}${designlist.productimg}" style="max-height:195px">
                                <div class="change">
                                    <p class="name mb10">${designlist.name}</p>
                                    <p class="info mb10 ph_mb5 cb">
                                        <span>作者：${designlist.author}</span><span>编号：${designlist.design_Id}</span><span
                                            class="ph_dn">泥料：${designlist.niliao}</span><span
                                            class="ph_dn">容量：${designlist.rongliang}</span></p>
                                    <div class="fun ac ph_dn">
                                        <a class=" mr10"><i class="iconfont icon-lianjie"></i></a>
                                        <a><i class="iconfont icon-gouwuche"></i></a>
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

        /*   $(document).ready(function(){

        /!*       (".main .dtlist li .osBottom").addClass("activate");*!/
           });*/
        $(document).ready(function () {

            setTimeout(function () {
                AngularJS_Init();
            }, 10);
        });

        //scrollBar
        function AngularJS_Init() {

            var scrollBar = $('.scrollBar')
            var sbb0 = scrollBar.find('.sbBox')
            var sbUl = scrollBar.find('ul')
            var sbLi = scrollBar.find('li')
            var sbLinum = sbLi.length
            var sbWidth = scrollBar.innerWidth()
            var sbDot = scrollBar.find('.dotNav')

            //布局
            sbUl.css({
                width: sbWidth * sbLinum
            })
            sbLi.css({
                width: sbWidth
            })

            //当页面宽度改变时
            $(window).resize(function () {
                var sbWidth0 = scrollBar.innerWidth()
                var targetTag = scrollBar.attr('name')
                console.log(sbWidth0 * targetTag)
                //布局
                sbUl.css({
                    width: sbWidth0 * sbLinum,
                    marginLeft: sbWidth0 * targetTag * (0 - 1)
                })
                sbLi.css({
                    width: sbWidth0
                })
            })

            //添加圆点并初始化
            var sbDotHtml = '';
            for (var i = 0; i < sbLinum; i++) {
                sbDotHtml += '<span></span>';
            }
            sbDot.append(sbDotHtml);
            sbDot.find('span:first-child').addClass('active')
            scrollBar.attr('name', 0)


            //点击导航圆点时
            sbDot.find('span').on('click', function () {
                var thisEq = $(this).index()
                var sbW0 = scrollBar.innerWidth()

                if ($(this).is('.active')) {

                } else {
                    sbUl.css({
                        marginLeft: sbW0 * thisEq * (0 - 1)
                    })
                    $(this).siblings('span').removeClass('active')
                    $(this).addClass('active')
                    scrollBar.attr('name', thisEq)
                }
            })

            var sbPageL = scrollBar.find('.prev')
            var sbPageR = scrollBar.find('.next')

            //点击上一页时
            sbPageL.on('click', function () {
                var thisSB = $(this).parents('.scrollBar')
                var thisUl = thisSB.find('ul')
                var thisDOT = thisSB.find('.dotNav')
                var thisDOTn = (thisDOT.find('span').length) - 1
                var sbbW1 = thisSB.innerWidth()
                var noo = parseInt(thisSB.attr('name'))

                if (noo > 0) {
                    thisSB.attr('name', noo - 1)
                    thisDOT.find('span').removeClass('active')
                    thisDOT.find('span:eq(' + (noo - 1) + ')').addClass('active')
                    thisUl.css({
                        marginLeft: sbbW1 * (noo - 1) * (0 - 1)
                    })
                } else if (noo == 0) {
                    thisSB.attr('name', thisDOTn)
                    thisDOT.find('span').removeClass('active')
                    thisDOT.find('span:eq(' + thisDOTn + ')').addClass('active')
                    thisUl.css({
                        marginLeft: thisDOTn * sbbW1 * (0 - 1)
                    })
                }
            })

            //点击下一页时
            sbPageR.on('click', function () {
                var thisSB = $(this).parents('.scrollBar')
                var thisUl = thisSB.find('ul')
                var thisDOT = thisSB.find('.dotNav')
                var thisDOTn = (thisDOT.find('span').length) - 1
                var sbbW2 = thisSB.innerWidth()
                var noo = parseInt(thisSB.attr('name'))

                if (noo < thisDOTn) {
                    thisSB.attr('name', noo + 1)
                    thisDOT.find('span').removeClass('active')
                    thisDOT.find('span:eq(' + (noo + 1) + ')').addClass('active')
                    thisUl.css({
                        marginLeft: sbbW2 * (noo + 1) * (0 - 1)
                    })
                } else if (noo == thisDOTn) {
                    thisSB.attr('name', 0)
                    thisDOT.find('span').removeClass('active')
                    thisDOT.find('span:eq(0)').addClass('active')
                    thisUl.css({
                        marginLeft: 0
                    })
                }
            })

            //触控部分
            var touchEvents = {
                touchstart: "touchstart",
                touchmove: "touchmove",
                touchend: "touchend",
                initTouchEvents: function () {
                    var self = this;
                    if (self.isPC()) {
                        self.touchstart = "mousedown";
                        self.touchmove = "mousemove";
                        self.touchend = "mouseup";
                    }
                },
                isPC: function () {  //判断pc端与移动端
                    var userAgentInfo = navigator.userAgent;
                    var Agents = new Array("Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod");  //判断用户代理头信息
                    var flag = true;
                    for (var v = 0; v < Agents.length; v++) {
                        if (userAgentInfo.indexOf(Agents[v]) > 0) {
                            flag = false;
                            break;
                        }
                    }
                    return flag;   //true为pc端，false为非pc端

                }
            };
            touchEvents.initTouchEvents()
            var addHandler = function (element, type, handler) {
                if (element.addEventListener) {
                    element.addEventListener(type, handler, false);
                } else if (element.attachEvent) {
                    element.attachEvent("on" + type, handler);
                } else {
                    element["on" + type] = handler;
                }
            }
            var start = 'ontouchstart' in document ? 'touchstart' : 'mousedown';
            var move = 'ontouchmove' in document ? 'touchmove' : 'mousemove';
            var end = 'ontouchend' in document ? 'touchend' : 'mouseup';
            var state = false
            sbb0.on(touchEvents.touchstart, function () {
                state = true
            })
            $(document).on(touchEvents.touchend, function () {
                state = false
            })
            var startX = 0
            var moveX = 0
            addHandler(sbb0[0], start, function (e) {
                if (state) {
                    var ev = 'ontouchstart' in document ? e.touches[0] : e;
                    var ex0 = ev.pageX;
                    startX = ex0
                }
            });
            addHandler(sbb0[0], move, function (e) {
                if (state) {
                    var ev = 'ontouchmove' in document ? e.touches[0] : e;
                    var ex1 = ev.pageX;
                    moveX = ex1 - startX
                }
            });
            addHandler(sbb0[0], end, function (e) {
                //console.log('触发位置：'+startX,'移动距离：'+moveX)
                if (moveX > 60) {
                    var thisUl = sbb0.find('ul')
                    var thisUlleft = thisUl.css('margin-left')
                    var thisUlleftT = parseInt(thisUlleft)
                    var thisUlN = thisUl.find('li').length
                    var sbbW = sbb0.innerWidth()

                    if (thisUlleftT < 0) {
                        thisUl.css({
                            marginLeft: thisUlleftT + sbbW
                        })
                        var noo = parseInt($('.scrollBar').attr('name'))
                        scrollBar.attr('name', noo - 1)
                        $('.scrollBar .dotNav span').removeClass('active')
                        $('.scrollBar .dotNav').find('span:eq(' + (noo - 1) + ')').addClass('active')
                    }
                }
                else if (moveX < 60) {
                    var thisUl = sbb0.find('ul')
                    var thisUlleft = thisUl.css('margin-left')
                    var thisUlleftT = parseInt(thisUlleft)
                    var thisUlN = thisUl.find('li').length
                    var sbbW = sbb0.innerWidth()

                    if (thisUlleftT > sbbW * (thisUlN - 1) * (0 - 1)) {
                        //rightB.addClass('active')
                        thisUl.css({
                            marginLeft: thisUlleftT - sbbW
                        })
                        //rightB.removeClass('active')
                        var noo = parseInt($('.scrollBar').attr('name'))
                        scrollBar.attr('name', noo + 1)
                        $('.scrollBar .dotNav span').removeClass('active')
                        $('.scrollBar .dotNav').find('span:eq(' + (noo + 1) + ')').addClass('active')
                    }
                }
            });
        }
    </script>
</body>
</html>