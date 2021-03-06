﻿<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>我的个人信息修改</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Gifty Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartusername Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="../css/style.css" rel='stylesheet' type='text/css' />
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
<script type="text/javascript" src="../js/username_repeat.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script type="text/javascript" src="../js/pictureload.js"></script>
<style type="text/css">
#headPhotoValue{
position:absolute:
left:100px;
top:400px;
 width:100px;height:100px;border-radius:100px
 }
.btn {
	width: 100px;
	margin: 0 auto;
	display: block;
}
#username_blank{
	color:red;
}
#address_blank{
	color:red;
}
#mobile_blank{
	color:red;
}
#check_blank{
	color:red;
}
#card_blank{color:red;}

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
</div>
	<div class="men">
		<div class="container">
			<div class="register">
				
				<div class="col-md-6 login-right">
					<p>
						如果您要修改密码，请点击 <a href="/test_ssh/jsp/changePassword.jsp"><font
							color="blue">修改密码</font></a>
					</p>
					<h3 style="color: blue" align="center-left">我的个人信息</h3></br>
					<form id="registerform" method="post" onsubmit="return before_register()" action="/test_ssh/user/changeInfo" enctype="multipart/form-data">
						
						<div>
				<span>头像<label>*</label></span>
				<div id="preview">
						<span><img id="headPhotoValue" src="<%=user.getHeadPhoto()%>"/></span>
					</div> <span><input id="img" name="img" type="file"
						accept="images/*" onchange="previewImage(this,'preview','headPhotoValue')"/></span>

</div>
						<div>
							<span> 昵称 <label>*</label></span> 
							<input type="text"
								id="username" name="username" value="<%=user.getNickName()%>"
								onfocus="display1()" onblur="judgeUserName()">
							<span style="display: none" id="username_blank"> <font
								color="red"></font></span>
						</div>
						<div>
							<span> 手机号 <label>*</label></span> 
							<input type="text"
								id="mobile" name="mobile" value="<%=user.getMobile()%>"
								onfocus="display2()" onblur="judgeMobile()">
							<span style="display: none" id="mobile_blank"> <font
								color="red"></font></span>
						</div>						
						<div>
							<span> 联系地址 <label>*</label></span> 
							<input name="address"
								type="text" id="address" value="<%=user.getAddress()%>"
								onfocus="display3()"> <span
								style="display: none" id="address_blank"><font color="red"></font></span>
						</div>
						<div>
							<span>银行账号<label>*</label></span> 
							<input name="card"	type="text" id="card" value="<%=user.getBankCardAccount()%>"
								 onfocus="display4()"> 
							<span style="display: none"
								id="card_blank"><font color="red"></font></span>
						</div>
						<div>
							<span>个性签名<label>*</label></span> 
							<input name="description"	type="text" id="description" value="<%=user.getDescription()%>"
								onfocus="display5()">
							<span style="display: none"
								id="description_blank"><font color="red"></font></span>
						</div>
						<div class="clearfix"></div>
	
<!--<p id="password" value="${user.password}" readonly="true"></p>
<input id="changePassword" type="button" value="修改密码" onclick="changePassword()"/>-->
	
						
						<input type="submit" value="完成" class="btn" id="tj" onClick="registerform.onsubmit()"> 
					</form>
				</div>
				<div class="clearfix"></div>
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

<script type="text/javascript">
function before_register(){
	var flag=0;
	var tel=document.getElementById("mobile").value;
	/*if(document.getElementById("username").value==""){
		document.getElementById("username_blank").style.display="block";
		$("#username_blank").text("您的昵称是空的~"); 
		flag=1;
	}	*/
	if(!(/^1\d{10}$/.test(tel)))
	{ 
		document.getElementById("mobile_blank").style.display="block";
		$("#mobile_blank").text("您输入的手机号不正确");
		flag=1; 
	}
	/*if(document.getElementById("address").value==""){
		document.getElementById("address_blank").style.display="block";
		$("#address_blank").text("地址不能为空");
        flag=1;
	}*/
	if(document.getElementById("card").value==""||document.getElementById("card").value==null){
		document.getElementById("card_blank").style.display="block";
		$("#card_blank").text("银行卡号不能为空");
		flag=1;
	}	
	/*if(document.getElementById("description").value=="")
	{
		document.getElementById("psw_blank1").style.display="block";
		$("#description_blank").text("您不打算设置个性签名吗？");
	}
	*/
	
	if(flag==1)
		return false;
	
}
function display1(){
	document.getElementById("username_blank").style.display="none";
}
function display2(){
	document.getElementById("mobile_blank").style.display="none";
}
function display3(){
	document.getElementById("address_blank").style.display="none";
}
function display4(){
	document.getElementById("card_blank").style.display="none";
}
function display5(){
	document.getElementById("description_blank").style.display="none";
}

function changePassword(){
var o=document.getElementById("password");
var c=o.innerHTML;
o.innerHTML="<input type='text' value='"+c+"'/>";
}
</script>
