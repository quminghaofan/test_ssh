<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>定制</title>
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

</head>
<body>
	<div id="updown">
		<%
			if (session.getAttribute("user") != null) {
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
							href="/test_ssh/init/goToLogin?backUrl='/test_ssh/mall/enterMall?go=0'">登录/注册</a></li>
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
						<a href="/test_ssh/init/home"><img
							src="../images/logo_ooz.png" alt="首页" /></a>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="header_bottom_right">
					<div class="search">
						<form action="/test_ssh/mall/enterMall?typeId=${typeId}&go=0"
							method="post">
							<input id="itemname" name="itemname" type="text"
								value="${itemname}" onFocus="this.value = '';"
								onBlur="if (this.value == '') {this.value = '商品名称';}"> <input
								type="submit" value="">
						</form>
					</div>
					<%
						if (session.getAttribute("user") != null) {
					%>
					<ul class="bag">
						<a href="#"><i class="bag_left"> </i></a>
						<a href="/test_ssh/cart/showCart"><li class="bag_right"><p>购物篮</p></li></a>
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
					<li class="active grid"><a class="color4" href="#">定制</a>
						<div class="megapanel">
							<div class="row">
								<div class="col1">
									<div class="h_nav">
										<ul>
											<li><a href="/test_ssh/mall/enterMall?go=0">全部</a></li>
											<c:forEach items="${TYPELIST}" var="type">
												<li><a href="/test_ssh/mall/enterMall?typeId=${type.id}&go=0">${type.name}</a></li>
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
											<li><a href="/test_ssh/mall/enterMall?go=1">全部</a></li>
											<c:forEach items="${TYPELIST}" var="type">
												<li><a href="/test_ssh/mall/enterMall?typeId=${type.id}&go=1">${type.name}</a></li>
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

			<div class="col-md-9">
				<div class="mens-toolbar">

					<div class="clearfix"></div>
				</div>
				<div class="span_2">
					<c:forEach items="${itemlist}" var="item">
						<div class="col_1_of_single1 span_1_of_single1">
							<a href="/test_ssh/customized/seeMore?artistId=${item.owner.id}">
								<img src="${item.picUrl}" class="img-responsive" alt="" />
								<h3>${item.name}</h3>
								<h4>${item.type.name}</h4>
								<h4>${item.owner.realName}</h4>
							</a>
							<ul class="list2">
								<%
									if (session.getAttribute("user") != null) {
								%>
								<li class="list2_left"><span class="m_1"> <a
										class="link"
										href="/test_ssh/customized/goToCustomizationApplying?artistId=${item.owner.id}">申请定制</a></span></li>
								<%
									} else {
								%>
								<li class="list2_left"><span class="m_1"><a
										href="/test_ssh/init/goToLogin?backUrl=${backUrl}"
										class="link">申请定制</a></span></li>
								<%
									}
								%>
								<li class="list2_right"><span class="m_2"><a
										href="/test_ssh/customized/seeMore?artistId=${item.owner.id}"
										class="link1">查看艺术家</a></span></li>

							</ul>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="pagging">

		<div class="right">

			<c:if test="${currentPage == 1}">

				<span class="disabled">&lt;&lt; 前一页</span>

			</c:if>

			<c:if test="${currentPage != 1}">

				<a
					href="/test_ssh/mall/enterMall?page=${currentPage-1}&typeId=${typeId}&go=0">&lt;&lt;
					前一页</a>

			</c:if>

			<c:if test="${currentPage == 1}">

				<span class="current">1</span>

			</c:if>

			<c:if test="${currentPage != 1}">

				<a href="/test_ssh/mall/enterMall?page=1&typeId=${typeId}&go=0">1</a>

			</c:if>

			<%
				int pageTimes = (Integer) session.getAttribute("pageTimes");

				for (int i = 1; i < pageTimes; i++)

				{

					request.setAttribute("page", i + 1);
			%>

			<c:if test="${currentPage == page}">

				<span class="current"><%=i + 1%></span>

			</c:if>

			<c:if test="${currentPage != page}">

				<a
					href="/test_ssh/mall/enterMall?page=<%=i + 1%>&typeId=${typeId}&go=0"><%=i + 1%></a>

			</c:if>

			<%
				}
			%>



			<c:if test="${currentPage == pageTimes}">

				<span class="disabled">后一页 &gt;&gt;</span>

			</c:if>

			<c:if test="${currentPage != pageTimes}">

				<a
					href="/test_ssh/mall/enterMall?page=${currentPage+1}&typeId=${typeId}&go=0">后一页
					&gt;&gt;</a>

			</c:if>

		</div>

	</div>

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

</body>
</html>
