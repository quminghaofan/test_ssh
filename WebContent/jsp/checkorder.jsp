<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>确认订单</title>
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
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,800,700,600,300'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
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
						<li><a href="jsp/login.jsp">登录/注册</a></li>
						<%
							} else {
								User user = (User) session.getAttribute("user");
						%>
						<li><a href="">申请成为艺术家</a></li>
						<li><a href=""><%=user.getName()%></a></li>
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
						<a href="/test_ssh/init/home"><img
							src="../images/logo_ooz.png" alt="首页" /></a>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="header_bottom_right">

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
					<li><a class="color2" href="/test_ssh/init/home">首页</a></li>
					<li><a class="color4" href="">定制</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<ul>
											<c:forEach items="${TYPELIST}" var="type">
												<li><a href="">${type.}</a></li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</div></li>
					<li class="active grid"><a class="color10"
						href="/test_ssh/mall/enterMall">商城</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<ul>
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
				<div style="width: 90%;">
					<div style="padding: 6%" align="left">

						<div class="orderdiv" style="margin-top: 2%">
							<c:forEach items="${orderlist}" var="order">
								<div style="width: 20%;" class="left-grid">
									<img class="img-responsive" src="${order.picUrl}">
								</div>

								<div class="info" align="left">
									<div style="font-size: large" class="infomargin">
										<label>${order.name}</label>
									</div>
									<div align="right">
										<label>类别:&nbsp;${order.type.name}</label>&nbsp;&nbsp; <label>价格:&nbsp;¥&nbsp;${order.price}</label>
									</div>
								</div>
								<div class="clearfix"></div>
							</c:forEach>

							<div class="breakline"></div>

							<div align="right" style="font-weight: bolder">
								<label>总价&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;</label> <label
									id="total">¥ ${total}</label>
							</div>


							<div style="margin-top: 3%; text-align: left">
								<%
									User user = (User) session.getAttribute("user");
									String address;
									String mobile;
									if (session.getAttribute("address") == null) {
										address = user.getAddress();
										mobile = user.getMobile();
									} else {
										address = (String) session.getAttribute("address");
										mobile = (String) session.getAttribute("mobile");
									}
								%>
								<div style="margin-bottom: 2%;">
									<label>用户名:&nbsp;&nbsp;</label> <label
										style="font-weight: bold"><%=user.getName()%></label>
								</div>
								<div style="margin-bottom: 2%;">
									<label>地址:&nbsp;&nbsp;&nbsp;&nbsp;</label> <label class="txt1"
										style="vertical-align: bottom" id="modi_address"><%=address%></label>
								</div>
								<div>
									<label>电话:&nbsp;&nbsp;&nbsp;&nbsp;</label> <label class="txt2"
										style="vertical-align: bottom" id="modi_phone"><%=mobile%></label>
								</div>
								<input type="button"
									style="display: inline; vertical-align: bottom" value="编辑"
									id="edit" class="btn4" onclick="window.location.href = '/test_ssh/mall/editOrder?address=<%=address%>&mobile=<%=mobile%>&type=${type}&wh=0'" />
							</div>


							<div align="right" style="margin-top: 3%;">
								<a href="/test_ssh/cart/showCart"><input type="button"
									class="orderbutton" style="margin-right: 1.5%" value="返回购物篮" /></a>
								<a href="/test_ssh/mall/goToPay?type=${type}&total=${total}"><input
									type="button" class="orderbutton" value="确认支付" /></a>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>



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
</body>
</html>

