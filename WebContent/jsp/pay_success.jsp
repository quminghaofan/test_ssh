<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>支付成功</title>
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
<meta http-equiv="refresh" content="5;URl=index(real).jsp">
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
							if (session.getAttribute("username") == null) {
						%>
						<li><a href="jsp/login.jsp">登录/注册</a></li>
						<%
							} else {
						%>
						<li><a href="">申请成为艺术家</a></li>
						<li><a href=""> <%=session.getAttribute("username")%></a></li>
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
						<input type="text" value="商品名称" onFocus="this.value = '';"
							onBlur="if (this.value == '') {this.value = '商品名称';}"> <input
							type="submit" value="">
					</div>
					<%
						if (session.getAttribute("username") != null) {
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
											<c:forEach items="${TYPELIST}" var="type">
												<li><a href="">${type.}</a></li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</div></li>
					<li class="active grid"><a class="color10" href="#">商城</a>
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
<p class="headtext1">支付成功!</p>
    <div style="background-color: white;width: 55%;">
        <div style="padding: 6%" align=" left">

            <div align="center" style="margin: 5% 0 0 0">
                <img style="width: 30%" src="../images/success.jpg">
            </div>
            <div class="tip">
                <h3>......</h3>
            </div>
            <div class="tip" style="margin-top: 3%">
                <p>
                    
                    你将会在5秒钟后返回主页
                    或者点击 <a href='index(real).jsp'>这里</a> 直接访问.
                </p>
            </div>
        </div>
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