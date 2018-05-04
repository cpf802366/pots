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
    <link rel="stylesheet" href="http://at.alicdn.com/t/font_378986_zphe2fa8aac0izfr.css">
    <link rel="stylesheet" href="${ctx}css/com[0].css">
    <link rel="stylesheet" href="${ctx}css/com[animation].css">
    <link rel="stylesheet" href="${ctx}css/com[fwjd].css">
    <script type="text/javascript" src="${ctx}js/jquery-1.11.3.min.js"></script>
    <style>
        .uum {
            position: absolute;
            top: 125px;
            right: 80px
        }

        .uum .ffa {
            font-size: 14px;
            line-height: 32px;
        }

        .uum .ffb {
            font-size: 24px;
            color: #bb1417;
            margin-bottom: 10px;
        }

        .uum .ffc {
            display: block;
            background-color: #bb1417;
            color: #fff;
            padding: 0 40px;
            line-height: 52px;
            font-size: 16px;
            text-align: center
        }

        .kkh {
            padding: 30px 0;
            border-top: dashed 1px #737373
        }

        .kkh .ttt {
            font-weight: 800;
            font-size: 26px;
            margin-bottom: 10px;
        }

        ._fs64 {
            font-size: 64px;
        }

        ._fs18 {
            font-size: 18px;
        }

        @media screen and (max-width: 720px) {
            .uum {
                position: static;
                margin-bottom: 20px;
            }

            .kkh .ttt {
                font-size: 16px;
            }

            ._fs64 {
                font-size: 32px;
            }

            ._fs18 {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
<div class="warpper zszs" style="background-color: #fff; position: relative">

    <div class="title">

        <span class="_fs64">${design.name}</span>
    </div>
    <div class="uum">
        <p class="ffa">当前价格</p>
  <c:choose>
            <c:when test="${design.kucun >0}">
                <p class="ffb">${sales.price}</p>
                <a class="ffc"   href="<%=basePath%>memAddr/shdzselected/${design.design_id}/${sales.so_id}">我要购买</a>
                <input type="hidden" id="design" value="${design.design_id}">
            </c:when>

            <c:otherwise>
                <p class="ffb">暂无定价</p>
                <a class="ffc"   href="javascript:void(0)">暂无库存</a>
            </c:otherwise>
        </c:choose>


    </div>
    <div class="number EC mb30">
        <div class="col mr20">
            <p>紫砂壶鉴定证号</p>
            <span>${design.jdzh}
			<a style="font-size: 16px; margin-left: 30px; color:#bb1417"><img src="${ctx}images/ppa.jpg"
                                                                              style="display: inline; height: 16px; margin-right: 10px;">查看证书</a>
			</span>
        </div>
    </div>
    <ul class="info mb30">
        <li><span>品名：</span><span>${design.pm}</span></li>
        <li><span>泥料：</span><span>${design.niliao}</span></li>
        <li><span>作者：</span><span>${design.author}
			<a style="text-decoration: underline; color: #bb1417; margin-left: 35px;">师承</a>
			</span></li>
        <li><span>容量：</span><span>${design.rongliang}</span></li>
        <li><span>工艺：</span><span>${design.cs}</span></li>
        <li><span>出水：</span><span>${design.price}</span></li>
        <li><span>造型：</span><span>${design.zx}</span></li>
        <li><span>完成日期：</span><span>${design.finshdate}</span></li>
        <!--<li><span>规格：</span><span>高5.6cm/宽8.1cm/长12.8cm/口径5.9cm</span></li>-->
    </ul>
    <div class="intr mb50" style="line-height: 1.75em">
        ${design.productsm }

    </div>
    <div class="pic EC mb30">
        <div class="col mr20"><img src="${ctx}${design.productimg}">
            <p>作品照片</p>
        </div>
        <div class="col"><img src="${ctx}${design.authorproductimage}">
            <p>作品执壶照片</p>
        </div>
    </div>
    <div class="state mb30">
        <h3 style="font-weight: normal">${design.authorcr}</h3>
    </div>
    <div class="pic EC mb30">
        <div class="col mr20"><img src="${ctx}${design.authoryz}">
            <p>作者印章</p>
        </div>
        <div class="col mr20"><img src="${ctx}${design.authorqm}">
            <p>作者签名</p>
        </div>
        <div class="col"><img src="${ctx}${design.authorzw}">
            <p>作者指纹</p>
        </div>
    </div>
    <div class="kkh">
        <div class="ttt">360度全息图</div>
        <!-- <div class="_fs18">您还没有登录我的紫砂，请
            <a style="text-decoration: underline; color: #bb1417">登录</a>
            后观看。</div>
    </div> -->
        <div class="kkh">
            <!-- <div class="ttt">价格曲线</div> -->
            <%-- <div><img src="${ctx}images/ppa6.jpg" style="display: block; width: 100%"></div>  --%>
            <div id="jgqx" style="width: 600px;height:400px;"></div>
            <!-- <div class="_fs18">您还没有登录我的紫砂，请
                <a style="text-decoration: underline; color: #bb1417">登录</a>
                后观看。</div>
        </div> -->
            <div class="kkh">
                <div class="ttt">交易记录</div>
                <div class="_fs18">《禅机》还未售出，现持壶人为作者，今日价格：<span style="color: #bb1417">¥500000.00</span>元。</div>
            </div>
            <!-- <div class="kkh">
                <div class="ttt">我要评论</div>
                <div>
                    <textarea style="border: solid 1px #737373; width: 100%; min-height: 200px;"></textarea>
                </div>
                <div class="_fs18">您还没有登录我的紫砂，请登录后留下评论。
                    <a style="text-decoration: underline; color: #bb1417">立即登录</a>
                </div>
            </div> -->
            <div class="next2 mt50 mb50 cb">
                <a class="fr">返回</a>
            </div>
        </div>
    </div>
</div>

        <script src="${ctx}js/echarts.min.js"></script>
        <script>
            function  wygm(obj) {

            }
            //取页面高度传递给父级页面
            function setHeight() {
                var contHeight = $('.warpper').height();
                var cc = contHeight + 60
                window.parent.test(cc);
            }

            setHeight();
            $(function () {
                $(window).resize(function () {
                    setHeight();
                });
                $(window).mouseup(function () {
                    setHeight();
                });
                $(window).click(function () {
                    setHeight();
                });
            })


        </script>
        <script type="text/javascript">
            var myChart = echarts.init(document.getElementById('jgqx'));
            var option = {
                title: {
                    text: '价格曲线'
                },
                tooltip: {},
                legend: {
                    data: ['价格(万元)']
                },
                xAxis: {
                    data: [ ]
                },
                yAxis: {},
                series: [{
                    name: '价格(万元)',
                    type: 'line',
                    data: [ ]
                }]
            };
            myChart.setOption(option);
       $(function () {
                var names=[];    //类别数组（实际用来盛放X轴坐标值）
                var nums=[];    //销量数组（实际用来盛放Y坐标值）
                var url = "<%=basePath%>price/listBydesignid ";
                var param = "designid="+ $("#design").val()  ;
             $.ajax({
                    url: url,   // 请求路径
                    type: "POST",  //提交方式
                    dataType: 'json', //获取数据类型，还可以是json、xml
                    data: param,      //传入的参数
                    success: function (result) {  //请求成功后返回的数据
                        for(var i=0;i<result.length;i++){
                            names.push(dateutil(result[i].updatedate));    //挨个取出类别并填入类别数组
                        }
                        for(var i=0;i<result.length;i++){
                            nums.push(result[i].price);    //挨个取出销量并填入销量数组
                        }
                        //myChart.hideLoading();    //隐藏加载动画
                        myChart.setOption({        //加载数据图表
                            xAxis: {
                                data: names
                            },
                            series: [{
                                // 根据名字对应到相应的系列
                                name: '价格',
                                data: nums
                            }]
                        });

                    } ,
                 error : function(errorMsg) {
                     //请求失败时执行该函数
                     alert("图表请求数据失败!");
                     myChart.hideLoading();
                 }

                });
            })

         function  dateutil(inputTime) {
             var date = new Date(inputTime);
             var y = date.getFullYear();
             var m = date.getMonth() + 1;
             m = m < 10 ? ('0' + m) : m;
             var d = date.getDate();
             d = d < 10 ? ('0' + d) : d;
             var h = date.getHours();
             h = h < 10 ? ('0' + h) : h;
             var minute = date.getMinutes();
             var second = date.getSeconds();
             minute = minute < 10 ? ('0' + minute) : minute;
             second = second < 10 ? ('0' + second) : second;
             return y + '-' + m + '-' + d ;
         }
        </script>

</body>
</html>