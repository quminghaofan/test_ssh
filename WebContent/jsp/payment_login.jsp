<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Gifty Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="../css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<link href='http://fonts.useso.com/css?family=Raleway:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<!-- dropdown -->
<script src="../js/jquery.easydropdown.js"></script>
<!-- start menu -->
<link href="../css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="../js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
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
<div class="men">
	<div class="container">
	    <div class="register">
			  
			   <div class="col-md-6 login-right">
			  	<h3>支付宝支付</h3>
				
				<form id="loginform" method="post" onsubmit="return before_login()" action="${picUrl}">
					<c:if test="${result==0}">
					<div id="result"><font color="red">用户名不存在或密码错误</font></div>
				</c:if>
				<c:if test="${result==-1}">
					<div id="result"><font color="red">余额不足</font></div>
				</c:if>
				<div>
					<span>支付金额</span>
					<input type="text" name="price" id="price" readonly="readonly" value="${total}"> 
				  </div>
				  <div>
					<span>支付宝账号<label>*</label></span>
					<input type="text" name="username" id="username" onfocus="display1()"> 
					<span style="display:none" id="username_blank"><font color="red">不能为空</font></span>
				  </div>
				  <div>
					<span>密码<label>*</label></span>
					<input type="password" name="psw" id="psw" onfocus="display2()"> 
					<span style="display:none" id="psw_blank"><font color="red">不能为空</font></span>
				  </div>
				  
				  <input type="submit" value="支付" onClick="loginform.onsubmit()">
			    </form>
			   </div>	
			   <div class="clearfix"> </div>
		</div>
	 </div>
</div>
<div class="footer">
	<div class="container">
		<img src="../images/pay.png" class="img-responsive" alt=""/>
		<ul class="footer_nav">
		  <li><a href="/test_ssh/init/home">首页</a></li>
					<li><a href="/test_ssh/mall/enterMall?go=0">定制</a></li>
					<li><a href="/test_ssh/mall/enterMall?go=1">商城</a></li>
					<li><a href="">联系我们</a></li>
		</ul>
		<p class="copy">Copyright &copy; 2015.厦门大学软件学院OneoneZero All rights reserved. More Information <a href="" target="_blank" title="OneoneZero">OneoneZero</a> - Made by <a href="" title="OneoneZero" target="_blank">OneoneZero</a></p>
	</div>
</div>

</body>
</html>

<script type="text/javascript">
function before_login(){
	var flag=0;
	if(document.getElementById("username").value==""){
		document.getElementById("username_blank").style.display="block";
		flag=1;
	}	
	if(document.getElementById("psw").value==""){
document.getElementById("psw_blank").style.display="block";
flag=1;
	}
	if(flag==1)
		return false;
}

function display1(){
	document.getElementById("username_blank").style.display="none";
}
function display2(){
	document.getElementById("psw_blank").style.display="none";
}
</script>
