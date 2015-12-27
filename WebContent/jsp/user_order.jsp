<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>我的订单</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Gifty Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="../css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="../css/jquery.countdown.css" />
<!-- Custom Theme files -->
<!--webfont-->
<link
	href='http://fonts.useso.com/css?family=Raleway:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<!-- dropdown -->
<script src="../js/jquery.easydropdown.js"></script>
<!-- start menu -->
<link href="../css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="../js/megamenu.js"></script>
<script src="../js/responsiveslides.min.js"></script>

<script type="text/javascript" src="../js/addcart.js"></script>
<script src="../ogLaVp_data/requestAnimationFrame.js"></script>
<script src="../ogLaVp_data/jquery_002.js"></script>
<script
	src="../ogLaVp_data/stopExecutionOnTimeout-6c99970ade81e43be51fa877be0f7600.js"></script>
<link href='../css/totop.css' rel='stylesheet' type='text/css'>
<script>
$(document).ready(function() {
	$(".megamenu").megamenu();
});
</script>

<style type="text/css">
</style>
<script src="../js/jquery.countdown.js"></script>
<script src="../js/script.js"></script>
</head>
<body>
	<div id="updown">
		<%if (session.getAttribute("user") != null) {
					%>
		<a href="/test_ssh/cart/showCart"><span id="end" class="cart"></span></a>
		<%
						}
					%>

		<span class="up"></span><span class="down"></span>
	</div>
	<div class="header_top">
		<div class="container">
			<div class="header_top-box">
				<div class="header-top-left">

					<div class="clearfix"></div>
				</div>
				<div class="cssmenu">
					<ul>
						<%
						    User user=(User)session.getAttribute("user");
							if (user == null) {
						%>
						<li><a
							href="/test_ssh/init/goToLogin?backUrl='/test_ssh/init/home'">登录/注册</a></li>
						<%
							} else {
								if (!(user.getRole()).getName() .equals("艺术家") 
										&&!(user.getRole()).getName().equals("预备艺术家")) {//角色判断
						%>
						<li><a href="/test_ssh/jsp/artist_apply.jsp">我的店铺</a></li>
						<%
							} else if ((user.getRole()).getName().equals("预备艺术家")) {
						%>
						<li><a>成为艺术家的申请正在审核...</a></li>
						<%
							} else {
						%>
						<li><a href="/test_ssh/artist/myArt">我的店铺</a></li>
						<%
							}
								if(user.getNickName()==null){
						%>
						<li><a href="/test_ssh/jsp/personalInfoChange.jsp"> <%=user.getName()%></a></li>
						<% }else{%>
						<li><a href="/test_ssh/jsp/personalInfoChange.jsp"> <%=user.getNickName()%></a></li>
						<%} %>
						<li><a href="/test_ssh/user/myOrder">我的订单</a></li>
						<li><a
							href="/test_ssh/init/logout?backUrl=/test_ssh/init/home">登出</a></li>
						<%
							}
						%>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="header_bottom">
		<div class="container">
			<div class="header_bottom-box">
				<div class="header_bottom_left">
					<div class="logo">
						<a href="/test_ssh/init/home"><img src="../images/logo_ooz.png" alt="首页" /></a>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="copyrights">
		Collect from <a href="">OneoneZero</a>
	</div>
	<div class="menu">
		<div class="container">
			<div class="menu_box">
				<ul class="megamenu skyblue">
					<li><a class="color2"
						href="/test_ssh/init/home">首页</a></li>
					<li><a class="color7" href="/test_ssh/mall/enterMall?go=0">定制</a>
						</li>
					<li><a class="color10" href="/test_ssh/mall/enterMall?go=1">商城</a>
						</li>
					<li><a class="color8" href="">联系我们</a></li>
					<div class="clearfix"></div>
				</ul>
			</div>
		</div>
	</div>


	<div class="men">
		<div class="container">
			<div align="center">

				<div align="center">
					<div style="background-color: white; width: 100%">
						<a class="acount-btn" href="/test_ssh/user/myOrder">我的订单</a> <a
							class="acount-btn" style="margin-top: 2em"  href="/test_ssh/user/myCustomized">我的定制</a>
					</div>
				</div>
				<br> <br> <br>
				<c:forEach items="${orderList}" var="order">
					<div class="a-top">
						<div class="left-grid">
							<img src="${order.commodityArtwork.picUrl}"
								class="img-responsive" />
						</div>
						<div class="right-grid">
							<h4>艺术品名：${order.commodityArtwork.name}</h4>
							<p>艺术家姓名：${order.commodityArtwork.owner.name}</p>
							<!-- 艺术家 -->
							<p>价格：${order.commodityArtwork.price}</p>
							<p>订单状态：${order.state}</p>
							<!-- 价格 -->
							<div class="btn" style="float: right">
								<c:if test="${order.isCancelled}">订单已取消</c:if>
								<c:if test="${!(order.isCancelled)}">
									<c:if test="${(order.state).equals('未支付')}">
										<a class="acount-btn"
											href="/test_ssh/user/goToOrderPay?orderId=${order.id}&type=1&total=${order.commodityArtwork.price}">支付</a>
										<a class="acount-btn"
											href="/test_ssh/user/cancelOrder?orderId=${order.id}&type=1">取消订单</a>
									</c:if>
									<c:if test="${(order.state).equals('已支付未收货')}">
										<a class="acount-btn" href="/test_ssh/user/getItem?orderId=${order.id}&type=1">收货</a>
									</c:if>
								</c:if>
							</div>
						</div>

						<div class="clearfix"></div>
					</div>
				</c:forEach>


			</div>
		</div>
		<div class="pagination" id="page"></div>

		<div class="footer">
			<div class="container">
				<img src="../images/pay.png" class="img-responsive" alt="" />
				<ul class="footer_nav">
					<li><a href="/test_ssh/init/home">首页</a></li>
					<li><a href="/test_ssh/mall/enterMall?go=0">定制</a></li>
					<li><a href="/test_ssh/mall/enterMall?go=1">商城</a></li>
					<li><a href="">联系我们</a></li>
				</ul>
				<p class="copy">
					Copyright &copy; 2015.厦门大学软件学院OneoneZero All rights reserved. More
					Information <a href="" target="_blank" title="OneoneZero">OneoneZero</a>
					- Made by <a href="" title="OneoneZero" target="_blank">OneoneZero</a>
				</p>
			</div>
		</div>

		<input hidden value="${current_page}" id="current"> <input
			hidden value="${max_page}" id="max">
</body>
</html>
