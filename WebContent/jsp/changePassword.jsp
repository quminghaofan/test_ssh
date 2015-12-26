<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>我的密码修改</title>
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
#psw_blank{
	color:red;
}
#psw_blank1{
	color:red;
}
#check_blank{
	color:red;
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
                	if(session.getAttribute("username")==null){
                %>
					<li><a href="jsp/login.jsp">登录/注册</a></li> 
					<%
                    }else{
                    %>
                    <li><a href="">申请成为艺术家</a></li> 
                    <li><a href=""> <%=session.getAttribute("username")%></a></li>
                    <li><a href="">订单</a></li>
                    <li><a href="">购物车</a></li>
                    <li><a href="">退出</a></li> 
                    <%} %>
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
				<a href="index.html"><img src="../images/logo_ooz.png" alt=""/></a>
			</div>
			
			<div class="clearfix"> </div>
		</div>
		
		<div class="clearfix"> </div>
	</div>
</div>
</div>
<div class="copyrights">Collect from <a href="" >OneoneZero</a></div>
<div class="menu">
	<div class="container">
		<div class="menu_box">
	     <ul class="megamenu skyblue">
			<li class="active grid"><a class="color2" href="/test_ssh/init/home">首页</a></li>
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
					</div>
			</li>				
			<li><a class="color10" href="/test_ssh/mall/enterMall">商城</a>
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
					</div>
			</li>
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
					</div>
			</li>
			<li><a class="color8" href="">联系我们</a></li>
			<div class="clearfix"> </div>
		 </ul>
	  </div>
</div>
</div>
	<div class="men">
		<div class="container">
			<div class="register">
				<div class="col-md-6 login-left">
					<h2 style="color: red"></h2>
				</div>
				<div class="col-md-6 login-right">
<%User user=(User)session.getAttribute("user"); %>
					<form id="changeform" method="post" onsubmit="return before_register()" action="/test_ssh/super/changePsw?userId=<%=user.getId() %>&type=1">
					<h2 style="color: blue" align="center-left">我的密码修改</h2></br>
						<!--<div>
							<span> 新密码 <label>*</label></span> 
							<input name="password"
								type="password" id="password" placeholder="请输入您的密码"
								onfocus="display2()"> <span
								style="display: none" id="psw_blank"><font color="red"></font></span>
						</div>-->
						<div>
							<span> 新密码 <label>*</label></span> 
							<input name="password"
								type="password" id="password" placeholder="请输入您的新密码"
								onfocus="display2()"> <span
								style="display: none" id="psw_blank"><font color="red"></font></span>
						</div>
						<div>
							<span>确认新密码<label>*</label></span> 
							<input name="password2"	type="password" id="password2" placeholder="请确认您的新密码"
								 onfocus="display3()"> 
							<span style="display: none"
								id="psw_blank1"><font color="red"></font></span>
						</div>
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
				<li><a href="#">Home</a></li>
				<li><a href="#">Blog</a></li>
				<li><a href="#">Shop</a></li>
				<li><a href="#">Media</a></li>
				<li><a href="#">Features</a></li>
				<li><a href="#">About Us</a></li>
				<li><a href="contact.html">Contact Us</a></li>
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
	if(document.getElementById("password").value==""){
		document.getElementById("psw_blank").style.display="block";
		$("#psw_blank").text("密码不能为空");
        flag=1;
	}
	if(document.getElementById("password2").value==""){
		document.getElementById("psw_blank1").style.display="block";
		$("#psw_blank1").text("请确认您的新密码");
		flag=1;
	}	
	if(document.getElementById("password").value!=document.getElementById("password2").value)
	{
		document.getElementById("psw_blank1").style.display="block";
		$("#psw_blank1").text("密码不一致，请重新输入");
		flag=1;
	}	
		
	document.getElementById('tj').disabled=false;
	if(flag==1)
		return false;
	
}
function display2(){
	document.getElementById("psw_blank").style.display="none";
}
function display3(){
	document.getElementById("psw_blank1").style.display="none";
}
</script>
