<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@    taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
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


</div>
<%--<div class="main" ng-app="myApp" ng-controller="customersCtrl">--%>
<div class="main" app="myApp" controller="customersCtrl">
    <div class="section-3">
        <div class="part lineStyle-top potBar">
            <div class="bgStyle-black">
                <div class="warp oh">
                    <div class="title partTitle-black osTop">紫砂作品</div>
                    <p class="bs mb20 ac osTop fcBlack8">“泥”、“形”、“工”、“款”、“意”。</p>
                    <ul class="potList cb ">
                        <c:forEach var="designlist" items="${designlist}" varStatus="status" begin="0" end="5" step="1">
                            <li onclick='location.href="${ctx}design?designId=${designlist.design_id}"' class="osScale">
                                <img src="${ctx}${designlist.productimg}" style="max-height:195px">
                                <div class="change">
                                    <p class="name mb10">${designlist.name}</p>
                                    <p class="info mb10 ph_mb5 cb">
                                        <span>作者：${designlist.author}</span><span>编号：${designlist.design_id}</span><span
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
    <%--<div class="section-2">
            <div class="part expertBar">
         <div class="warp">
             <div class="title partTitle-white osTop">紫砂专家</div>
             <p class="bs mb20 osTop fcWhite8">紫砂真假鉴定了解原矿泥料，鉴别古壶。</p>
             <div class="scrollBar osBottom">
                 <div class="sbBox">
                     <ul class="cb">
                      <c:forEach var="art" items="${artlist}" varStatus="status"  begin="0" end="0" step="1">
                         <li   >
                             <div class="pg">
                                 <div class="pic"><img src="${ctx}${art.img}"></div>
                                 <div class="info">
                                     <div class="box">
                                         <p class="fb"><span class="mr20">${art.name}</span><span class="fs14">职称：${art.title}</span></p>
                                         <p>${art.title_By}</p>
                                     </div>
                                 </div>
                             </div>
                         </li>
                          </c:forEach>
                     </ul>
                     <a class="sbPage prev ph_dn" style="display:none"><i class="iconfont icon-xiangzuojiantou"></i></a>
                     <a class="sbPage next ph_dn" style="display:none"><i class="iconfont icon-xiangyoujiantou"></i></a>
                 </div>
                 <div class="dotNav" style="display:none"></div>
             </div>
             <div class="logo-sub"><img src="images/logo-sub2.png"></div>
         </div>
     </div>
    </div>
 <div class="section-1 cb oh">
     <div class="part lineStyle-top profunBar">
         <div class="bgStyle-black">
             <div class="warp cb">
                <div class="profun">
                     <div class="title"><img src="images/profun_t1.png"></div>
                     <p class="fs12"> 制定行业规范振兴紫砂事业，通过融合多项目技术建立真正意义上的紫砂交易平台，“鉴真章”寓意平台的鉴真功能，“真章”意味着真实结果，也体现我们平台坚持正品，维护版权的决心。</p>
                     <a class="btn openWin" name="win_fwjd.html"><i class="iconfont icon-baijianyuhu"></i>开始鉴定</a>
                 </div>
                 <div class="profun">
                     <div class="title"><img src="images/profun_t2.png"></div>
                     <p class="fs12">为了弘扬版权创新的精神，提升版权拥有者的知名度，保护紫砂艺人的利益。通过平台，通过正规及多样的交易途径，让更多的紫砂艺人可以参与其中和接触到心仪的作品。</p>
                     <a class="btn openWin" name="win_bqsq_1.html"><i class="iconfont icon-baijianyuhu"></i>递交资料</a>
                 </div>
                 <div class="profun">
                     <div class="title"><img src="images/profun_t3.png"></div>
                     <p class="fs12">为了弘扬版权创新的精神，提升版权拥有者的知名度，保护紫砂艺人的利益。通过平台，通过正规及多样的交易途径，让更多的紫砂艺人可以参与其中和接触到心仪的作品。</p>
                     <a class="btn openWin" name="win_csbq.html"><i class="iconfont icon-baijianyuhu"></i>出售版权</a>
                 </div>
             </div>
         </div>
     </div>
 </div>

 <div class="section-3">
 <div class="part ensureBar">
         <div class="bgStyle-white">
             <div class="warp">
                 <div class="title partTitle-white osTop">真伪保障技术</div>
                 <p class="bs mb20 ac osTop fcWhite8">最前沿的技术保护你的紫砂</p>
                 <ul class="ensureList osBottom oh">
                     <li>
                         <p>
                             <span class="mb15"><i class="iconfont icon-rfid"></i>防伪证书</span>
                             <span class="mb15">技术具有防磁、耐高温、使用寿命长、读取距离大、标签上数据可加密、存储数据容量更大、存储信息更改自如等优点</span>
                         </p>
                         <img src="images/ensureList-img1.jpg">
                     </li>
                     <li>
                         <p>
                             <span class="mb15"><i class="iconfont icon-kejituxing"></i>360全息扫描</span>
                             <span class="mb15">可以让从物体发射的衍射光能够被重现，其位置和大小同之前一模一样。从不同的位置观测此物体，其显示的像也会变化。</span>
                         </p>
                         <img src="images/ensureList-img3.jpg">
                     </li>
                     <li>
                         <p>
                             <span class="mb15"><i class="iconfont icon-1"></i>专家鉴定</span>
                             <span class="mb15">鉴别紫砂壶的好坏可以从泥料、颜色、器型、比例、细节、合理等六个方面来鉴定。<br>
                             &nbsp;</span>
                         </p>
                         <img src="images/ensureList-img2.png">
                     </li>
                 </ul>
             </div>
         </div>
     </div>--%>
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


    <!--   <div class="part newsBar">
          <div class="bgStyle-white">
              <div class="warp">
                  <div class="title partTitle-white osTop">紫砂资讯</div>
                  <ul class="newsList cb osBottom">
                      <li  ng-repeat="item in index.zxTop">
                          <div class="info">
                              <h4>{{item.title}}</h4>
                              <p>{{item.content}}</p>
                          </div>
                          <div class="time">{{item.createDate}} <strong>{{item.author}}</strong></div>
                          <div class="pic"><img ng-src="{{item.img}}"></div>
                      </li>
                  </ul>
              </div>
          </div>
      </div> -->
    <div class="part sas bgStyle-black">
    </div>
</div>
</div>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>


<!--menu end-->
<script type="text/javascript" src="${ctx}js/owl.carousel.min.js"></script>
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
 