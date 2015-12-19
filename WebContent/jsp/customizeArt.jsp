<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户定制艺术品</title>
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
<link href="../css/style1.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<link
	href='http://fonts.useso.com/css?family=Raleway:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:700,300,600,800,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Marvel:400,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400italic,700italic,400,300,700' rel='stylesheet' type='text/css'>

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
<script>var __links = document.querySelectorAll('a');function __linkClick(e) { parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script>$(document).ready(function(c) {
	$('.sky-close').on('click', function(c){
		$('.green-button').fadeOut('slow', function(c){
	  		$('.green-button').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.oran-close').on('click', function(c){
		$('.orange-button').fadeOut('slow', function(c){
	  		$('.orange-button').remove();
		});
	});	  
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

</br>
<h1><font color="red">欢迎您定制艺术品</font></h1>
<div class="contact">
	<div class="contact-main">
	<form>
		<h3>姓名</h3>
		<input type="text" value="如：张三" class="hola" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请填写您的姓名';}"/>
		<h3>手机号</h3>
		<input type="text" value="如：18106987217" class="hola" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请填写您的手机号';}"/>
		<h3>地址</h3>
		<input type="text" value="如：**省**市**街道**" class="hola" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请填写您的地址';}"/>
		<h3>定制品名称</h3>
		<input type="text" value="如：八骏图" class="hola" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请填写定制品名称';}"/>
		<h3>定制品类别</h3>
		<input type="text" value="如：油画" class="hola" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请填写定制品类别';}"/>
		<h3>第一阶段价格</h3>
		<input type="text" value="如：200.0元" class="hola" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请填写第一阶段的定制价格';}"/>
		<h3>备注（选填）</h3>
		<textarea  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入定制品的相关备注，以便更好地为您服务';}"/>请输入定制品的相关备注，以便更好地为您服务</textarea>
	</form>
	</div>
	<div class="enviar">
	
    <div class="contact-enviar">
		<a href=""><input type="submit" value="提交"></a>
		</div>
		<div class="clear"> </div>
	</div>
</div>
	

</body>
</html>