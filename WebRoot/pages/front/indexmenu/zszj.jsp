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
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>紫砂版权网</title>
    <link rel="stylesheet" href="http://at.alicdn.com/t/font_378986_59e5tkhu0418aor.css">
    <link rel="stylesheet" href="${ctx}css/com[0].css">
    <link rel="stylesheet" href="${ctx}css/com[main].css">
    <link rel="stylesheet" href="${ctx}css/com[fwjd].css">
    <link rel="stylesheet" href="${ctx}css/com[userCenter].css">
    <link rel="stylesheet" href="${ctx}css/com[phone].css">

    <script type="text/javascript" src="${ctx}js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${ctx}js/js.js"></script>


<body>
<jsp:include page="/pages/header-nav.jsp"></jsp:include>
<div class="main">
    <div class="section-0">
        <div class="part lineStyle-top expertInfo">
            <div class="bgStyle-black">
                <div class="warp oh">
                    <div class="title partTitle-black osTop">紫砂专家</div>
                    <p class="bs mb20 ac osTop fcBlack8 mb30">紫砂艺人的价值体现在于壶，壶的价值来源于艺人的品牌和记忆。</p>
                </div>
            </div>
        </div>
        <div class="part expertInfo">
            <div class="bgStyle-black">
                <div class="warp oh">
                    <div class="info EC">
                        <div class="pic"><img src="${ctx}upload/zhuanjia/Liuzheng02.jpg"></div>
                        <div class="text col">
                            <h4><span>刘政 生于1965年12月</span><span>苏省陶瓷艺术名人   江苏省收藏家协会紫砂鉴定专家</span></h4>
                            <p>
                                80年代开始收藏老紫砂，老字画，研究紫砂文化，师从鲍旭琦大师研习制壶，对传统紫砂壶的造型和文化意义有深入的研究，目前为墨渊阁陶瓷研究所所长，宜兴紫砂股份有限公司高级艺术顾问，技术总监。重庆理工大学文学院研究员，重庆金融资产交易所签约艺术家，国家高级紫砂鉴定评估师，江苏省收藏家协会紫砂鉴定专家。</p>
                            <p>其作品特征为：古意昂然，书卷气息浓郁。一三年所做“无惧壶”连续两年荣获全国性金奖，天津华艺杯和上海大师杯。先后在重庆理工大学，重庆文联及上海朵云轩，深圳罗湖电视台讲学。</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--
      <div class="part expertInfo">
              <div class="bgStyle-gray">
              <div class="warp oh">
              <div class="info EC pt50 fcWhite">
                      <div class="pic"><img src="images/person_content_2.png"></div>
                      <div class="text col">
                          <h4><span>袁国强，1970年出生于宜兴，2013年高工，</span><span>江苏省陶瓷艺术名人</span></h4>
                          <p>首届“景舟杯”金奖得主。八十年代末期学艺，至今二十年。90 年代初师从张庆臣，后与亲弟袁小强又得到国大师何道洪的悉心 指导,经刻苦钻研，技艺基本功扎实，尤以全手工见长。作品多以 难度较高的菱花、方器、素器等为主，制作工艺精湛，稳重而朴 实。九十年代作品都为台湾市场专销，成为紫砂工艺青年艺人中 的稳健型，实力派代表人物。</p>
                          <p>2001年，《葵仿古》获中国工艺美术大师精品博览会优秀作品奖;</p>
                          <p>2001年，《紫砂盉》获第三届中国工艺美术精品博览会铜奖; </p>
                          <p>2001年，《玉带壶》获苏州中国紫砂精品展金奖;</p>
                          <p>2001年10月，《龙生九子》获杭州国际民间手工艺品展金奖;</p>
                          <p>2002年9月，《圆珠》获杭州国际民间手工艺品展银奖;</p>
                          <p>2002年11月，《四方组合茶具》第四届中国工艺美术大师精品博 览会银奖;</p>
                          <p>2003年11月《千姿壶》获中国工艺美术大师精品博览会银奖;</p>
                          <p>2004年11月，《争艳》获中国工艺美术大师精品博览会银奖;</p>
                          <p>2015年10月，《菱花提梁》获得首届“景舟杯”金奖</p>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      <div class="part expertInfo" style="margin-top: 57px;">
          <div class="bgStyle-black">
              <div class="warp oh">
                  <div class="info EC">
                      <div class="pic"><img src="images/person_content_3.png"></div>
                      <div class="text col">
                          <h4><span>蒋艺华   省高级工艺美术师</span><span>紫砂花器泰斗、国家级大师、七老艺人之一蒋蓉大师嫡系传承人</span></h4>
                          <p>蒋艺华，女，2013年高工，1981年跟谁高丽君学壶，后又跟谁 跟随师父高丽君及小师父丁洪顺、季益顺学习紫砂基本成型技 术，1984年考进研究所跟随母亲蒋蓉学习，并接受诸多名师指点。</p>
                          <p>1997 年经考核，聘为助理工艺美术师。   蒋艺华自幼受养母蒋蓉大师的严格教育和培养，她在母亲 (养母)身边勤奋朴实地学习，经过几十年的刻苦磨练和钻研 实践，蒋艺华对花货类的制作已有相当的领悟，在不断的学习 中，更加拓宽了她的创作思路。她创作的作品「荷叶提梁壶」， 藏家非常喜爱。她将叶脉纹理细心地刻划出来，以卷叶为嘴使 出水顺畅，以有小刺的叶梗为壶把，把自然界的事物加以构思 取舍后，就成为一把既实用又美观的茶壶。   蒋艺华初步继承了母亲的艺术风格擅长制作花货类作品， 也兼做光货类作品。作品构思新颖，造型优美，做功精巧，具 有较高的艺术水平和收藏潜力，许多作品被国内外收藏家收藏。</p>
                      </div>
                  </div>
              </div>
          </div>
      </div>
      -->
    </div>
</div>
<jsp:include page="/pages/footer-nav.jsp"></jsp:include>
</body>
</html>