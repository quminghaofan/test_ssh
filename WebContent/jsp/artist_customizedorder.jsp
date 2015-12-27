<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>艺术家定制记录</title>
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
						<input type="text" value="艺术品名称" onFocus="this.value = '';"
							onBlur="if (this.value == '') {this.value = '艺术品名称';}"> <input
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
			<div style="display: none;" id="price" align="center">
				<div id="masklayer"></div>
				<input type="hidden" id="orderid" name="orderid">
				<div
					style="z-index: 10; position: absolute; left: 30%; background-color: white; width: 30%; height: 35%">
					<h3>价格</h3>
					<form class="form-inline definewidth m20" action="" method="post"
						id="priceform">
						<label>第一期价格</label><input type="text" name="price1"
							class="abc input-default" placeholder="" value=""> <label>第二期价格</label><input
							type="text" name="price2" class="abc input-default"
							placeholder="" value=""> <label>第三期价格</label><input
							type="text" name="price3" class="abc input-default"
							placeholder="" value="">
						<button type="submit" class="btn btn-primary"
							onclick="editprice()">确定</button>
					</form>
				</div>
			</div>
			<div align="center">
				<a class="acount-btn" href="/test_ssh/artist/myArt">我的艺术品</a> <a
					class="acount-btn" href="/test_ssh/artist/mySale"
					style="margin-top: 2em">我的出售记录</a> <a class="acount-btn"
					style="margin-top: 2em">我的定制记录</a>
				<div style="background-color: white; width: 100%">
					<div style="padding: 5%">
						<div class="menuhead1">

							<h3>我的定制记录</h3>
						</div>
						<div style="">
							<table class="table1" cellspacing="0">
								<tr>
									<th scope="col">艺术品名</th>
									<th scope="col">买家</th>
									<th scope="col">地址</th>
									<th scope="col">电话</th>
									<th scope="col">操作</th>
								</tr>
								<c:forEach items="${orderList}" var="order">
									<tr>
										<td>${order.customizedArtwork.name}</td>
										<td>${order.user.name}</td>
										<td>${order.user.address}</td>
										<td>${order.mobile}</td>
										<td>
										<c:if test="${order.isCancelled}">
											<a>订单已取消</a>
										</c:if>
										<c:if test="${!(order.isCancelled)}">
											<c:if test="${(order.isAccept).equals('2')}">
													<a href="javascript:accept(${order.id})">接受</a>
													<a href="/test_ssh/artist/isAccept?orderId=${order.id}&type=1">拒绝</a>
												</c:if> <c:if test="${(order.isAccept).equals('0')}">已拒绝</c:if> <c:if
													test="${(order.isAccept).equals('1')}">
													<a href="/test_ssh/artist/goToPicUp?orderId=${order.id}">上传小样</a>
													<c:if test="${(order.state).equals('已支付未发货')}">
														<a
															href="/test_ssh/artist/deliverGoods?orderId=${order.id}">发货</a>
													</c:if>
													<c:if test="${(order.state).equals('已支付已发货')}">
														<a>已发货</a>
													</c:if>
												</c:if>
										</c:if>
										<a href="/test_ssh/artist/customizedorderDetail?orderId=${order.id}">详情</a>
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
<script>
	function accept(orderid) {
		document.getElementById("price").style.display = "block";
		document.getElementById("orderid").value = orderid;
	}
	function editprice() {
		var orderid = document.getElementById("orderid").value;
		var price = document.getElementById("priceform");
		price.action = "/test_ssh/artist/isAccept?orderId=" + orderid
				+ "&type=0";
		price.submit();
	}
</script>
