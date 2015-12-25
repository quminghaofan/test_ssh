<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>申请成为艺术家</title>
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
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<script type="text/javascript" src="../js/pictureload.js"></script>
<script src="../js/responsiveslides.min.js"></script>
<link href='../css/totop.css' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="../js/addcart.js"></script>
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
						<li>成为艺术家的申请正在审核...</li>
						<%
							} else {
						%>
						<li><a href="/test_ssh/artist/myArt">我的店铺</a></li>
						<%
							}
						%>
						<li><a href=""> <%=user.getName()%></a></li>
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
				<div class="header_bottom_right">
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
					<li class="active grid"><a class="color2"
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
  <div class="register">
			   <h1>申请成为艺术家</h1>
			   <div class="col-md-6 login-right">
				<form id="applyform" method="post"  action="/test_ssh/artist/artistApply" onsubmit="return before_apply()" enctype="multipart/form-data">
				  <div>
					<span>真实姓名<label>*</label></span>
					<input type="text" name="realname" id="realname" onfocus="name_blank.style.display='none'"> 
					<span id="name_blank" style="display:none"><font color="red">真实姓名不能为空</font></span>
				  </div>
				  <div>
					<span>银行卡号<label>*</label></span>
					<input type="text" name="account" id="account" onfocus="card_blank.style.display='none'"> 
					<span id="card_blank" style="display:none"><font color="red">银行卡号不能为空</font></span>
				  </div>
				  <div>
					<span>个人介绍</span>
					<textarea name="intro" id="intro"></textarea>
                 </div>
                 <div>
                 <span>身份证照片</span>
					<span><input id="img" name="img" type="file"
						accept="images/*" onchange="previewImage(this,'preview','image')" style="width: 60%"/></span>
						<span id="photo_blank" style="display: none"><font color="red">身份证照片不能为空</font></span>
				  <div id="preview" style="border:solid 1px">
						<span><img id="image" src="" width="30%"
							height="30%" /></span>
					</div> 
					</div>
				  <input type="submit" value="提交" onClick="applyform.onsubmit()">
			    </form>
			   </div>	
		</div>

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
<script>
function before_apply(){
	var realname=document.getElementById("realname");
	var account=document.getElementById("account");
	var img=document.getElementById("img");
	var flag=0;
	if(realname.value==""){
		flag=1;
		document.getElementById("name_blank").style.display="block";
	}
	if(realname.value==""){
		flag=1;
		document.getElementById("card_blank").style.display="block";
	}
	if(img.value==""){
		flag=1;
		document.getElementById("photo_blank").style.display="block";
	}
	if(flag==1)
		return false;
}
</script>
