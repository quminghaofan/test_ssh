<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>艺术家详情及艺术品列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
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
<link rel="stylesheet" href="../css/general.css" media="all" />
<!-- Custom Theme files -->
<!--webfont-->
<link
	href='http://fonts.useso.com/css?family=Raleway:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css' />
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
<style type="text/css">
#headPhotoValue {
	width: 100px;
	height: 100px;
	border-radius: 100px
}

#nick {
	width: 110px;
}

#make {
	width: 100px;
	color: blue;
	text-decoration: underline;
}
</style>
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

	<div style="float: left; width: 8%">
		<a href=""><img src="../images/back.png" alt="返回"
			class="img-responsive" /></a>
	</div>
	<div style="float: right; width: 20%; height: 35%">
		<a href="/test_ssh/jsp/customizeArt"><img
			src="../images/customize.jpg" alt="申请定制" class="img-responsive" /></a>
	</div>
	</br>
	</br>
	<form action="" method="post">
		<div>
			<img id="headPhotoValue" src="${artist.headPhoto}" />
		</div>
		<input id="nick" value="${artist.nickName}" style="border: none"
			readonly="true"> <!--<p id="CommodityList">点击查看艺术家的<a href="#"><font color="#FA8072" bold="true" size="">作品</font></a></p>-->
			<div id="header">
				<h1 id="title">
					<font color="">艺术家简介</font>
				</h1>
			</div> </br>
			<div id="general">
				<div class="row">
					<label id="realname">真实姓名:</label> <label id="realnameValue"><input
						value="${artist.realName}" style="border: none"
						readonly="true"></label>
				</div>
				<div class="row">
					<label id="phone">手机号:</label> <label id="phoneValue"><input
						value="${artist.mobile}" style="border: none" readonly="true"></label>
				</div>
				<div class="row">
					<label id="address">联系地址:</label> <label id="addressValue"><input
						value="${artist.address}" style="border: none"
						readonly="true"></label>
				</div>
				<div class="row">
					<label id="card">银行帐号:</label> <label id="cardValue"><input
						value="${artist.bankCardAccount}" style="border: none"
						readonly="true"></label>
				</div>
				<div class="row">
					<label id="description">艺术家描述:</label> <label id="desValue"><input
						value="${artist.description}" style="border: none"
						readonly="true"></label>
				</div>
				</br>
				<p id="manu">
					您要<a href="/test_ssh/jsp/customizeArt" id="make">申请定制</a>吗？
				</p>
				<p>--------------------------------------------------------------------------------------------</p>

			</div>
	</form>
	<div id="header">
		<h1 id="title">
			<font color="">我的艺术品</font>
		</h1>
	</div>
	</br>
	<form action="" method="get">
		<c:forEach items="${artCommodList}" var="artCommodity">
			<div class="span_3">
				<div class="col-sm-3 grid_1">
					<a href="/test_ssh/jsp/customizeArt"> <img
						src="${artWork.name}" class.jpg="img-responsive" alt="" />
						<h3>
							<input value="${artWork.type}" style="border: none"
								readonly="true" />
						</h3> <!--<p><input value="${artWork.artworkDescription}" style="border:none" readonly="true"/></p>-->
						<h4>
							<input value="${artWork.name}" style="border: none"
								readonly="true" />
						</h4>
					</a>
				</div>
				<div class="clearfix"></div>
			</div>
		</c:forEach>
	</form>
	<a href="#"><font color="black">返回顶部</font></a>
	<!--<p id="manu">您要<a href="/test_ssh/jsp/customizeArt" id="make">申请定制</a>吗？</p>-->

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