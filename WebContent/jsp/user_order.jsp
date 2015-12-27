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
<link href="../css/table.css" rel='stylesheet' type='text/css' />
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>

</head>
<body>
	<div class="header_top">
		<div class="container">
			<div class="header_top-box">
				<div class="header-top-left">
					<div class="clearfix"></div>
				</div>
				<div class="cssmenu">
					<ul>
						<%
							if (session.getAttribute("user") == null) {
						%>
						<li><a href="/test_ssh/jsp/login.jsp">登录/注册</a></li>
						<%
							} else {
						%>
						<li><a href="">申请成为艺术家</a></li>
						<li><a href=""> <%=((User) session.getAttribute("user")).getName()%></a></li>
						<li><a href="">我的订单</a></li>
						<li><a href="">登出</a></li>
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
						<a href="index.html"><img src="../images/logo_ooz.png"
							alt="首页" /></a>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="header_bottom_right">
					<div class="search">
						<input type="text" value="艺术品名称" onFocus="this.value = '';"
							onBlur="if (this.value == '') {this.value = '艺术品名称';}"> <input
							type="submit" value="">
					</div>
					<%
						if (session.getAttribute("user") != null) {
					%>
					<ul class="bag">
						<a href="#"><i class="bag_left"> </i></a>
						<a href="#"><li class="bag_right"><p>购物篮</p></li></a>
						<div class="clearfix"></div>
					</ul>
					<%
						}
					%>
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
					<li><a class="color2" href="index.jsp">首页</a></li>
					<li><a class="color4" href="">定制</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<ul>
											<li><a href="">全部</a></li>
											<c:forEach items="${TYPELIST}" var="type">
												<li><a href="">${type.}</a></li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</div></li>
					<li><a class="color10" href="#">商城</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<ul>
											<li><a href="">全部</a></li>
											<c:forEach items="${TYPELIST}" var="type">
												<li><a href="">${type.}</a></li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</div></li>
					<li><a class="color7" href="#">拍卖</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<ul>
											<li><a href="">全部</a></li>
											<c:forEach items="${TYPELIST}" var="type">
												<li><a href="">${type.}</a></li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</div></li>
					<li><a class="color8" href="">联系我们</a></li>
					<div class="clearfix"></div>
				</ul>
			</div>
		</div>
	</div>


	<div class="men">
		<div class="container">
			<div align="center">
				<div style="background-color: white; width: 100%">
					<a class="acount-btn">我的订单</a> <a class="acount-btn"
						href="/test_ssh/user/myCustomized" style="margin-top: 2em">我的定制</a>
					<div style="padding: 5%">
						<div class="menuhead1">
							<h3>我的订单</h3>
						</div>
						<div style="">
							<table class="table1" cellspacing="0">
								<tr>
									<th scope="col">图片</th>
									<th scope="col">艺术品名</th>
									<th scope="col">店铺</th>
									<th scope="col">价格</th>
									<th scope="col">订单状态</th>
									<th scope="col">操作</th>
								</tr>
								<c:forEach items="${orderList}" var="order">
									<tr>
										<td scope="row" class="spec"><img id="image" src="${order.commodityArtwork.picUrl}" class="img-responsive" style="width: 100%;max-height:100%;"/></td>
										<td>${order.commodityArtwork.name}</td>
										<td>${order.commodityArtwork.owner.name}</td>
										<td>${order.commodityArtwork.price}</td>
										<td>${order.state}</td>
										<td>
											<div class="btn" style="float: right">
											<c:if test="${order.isCancelled}">订单已取消</c:if>
											<c:if test="${!(order.isCancelled)}">
												<c:if test="${(order.state).equals('未支付')}">
												<a class="acount-btn" class="link" href="/test_ssh/user/goToOrderPay?orderId=${order.id}&type=1&total=${order.commodityArtwork.price}">支付</a>
                                                <a class="acount-btn" class="link" href="/test_ssh/user/cancelOrder?orderId=${order.id}&type=1">取消订单</a>
												</c:if>
												<c:if test="${(order.state).equals('已支付未发货')}">
												<a class="acount-btn" class="link">未发货</a>
												<a class="acount-btn" class="link" href="/test_ssh/user/cancelOrder?orderId=${order.id}&type=1">取消订单</a>
												</c:if>
												<c:if test="${(order.state).equals('已支付未收货')}">
												<a class="acount-btn" class="link" href="/test_ssh/user/getItem?orderId=${order.id}&type=1">收货</a>
												</c:if>
												<c:if test="${(order.state).equals('已支付已收货')}">
												已收货
												</c:if>
											</c:if>
											</div>
										</td>
									</tr>
								</c:forEach>
							</table>

						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<div class="pagination" id="page"></div>

	<div class="footer">
		<div class="container">
			<img src="../images/pay.png" class="img-responsive" alt="" />
			<ul class="footer_nav">
				<li><a href="#">首页</a></li>
				<li><a href="#">定制</a></li>
				<li><a href="#">商城</a></li>
				<li><a href="#">拍卖</a></li>
				<li><a href="#">关于我们</a></li>
				<li><a href="">联系我们</a></li>
			</ul>
			<p class="copy">
				Copyright &copy; 2015.厦门大学软件学院OneoneZero All rights reserved. More
				Information <a href="" target="_blank" title="OneoneZero">OneoneZero</a>
				- Made by <a href="" title="OneoneZero" target="_blank">OneoneZero</a>
			</p>
		</div>
	</div>

	<input hidden value="${current_page}" id="current">
	<input hidden value="${max_page}" id="max">
</body>
</html>
