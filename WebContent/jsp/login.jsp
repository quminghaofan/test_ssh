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
						
						<li><a
							href="/test_ssh/init/goToLogin?backUrl='/test_ssh/init/home'">登录/注册</a></li>
						
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
			   <div class="col-md-6 login-left">
			  	 <h3>新用户</h3>
				 <p>创建一个账号，您将能够更好地进行艺术品交易，查看并跟踪您的订单。</p>
				 <a class="acount-btn" href="/test_ssh/jsp/register.jsp">创建账号</a>
			   </div>
			   <div class="col-md-6 login-right">
			  	<h3>登录</h3>
				<p>如果已有账号，请登录。</p>
				<form id="loginform" method="post" onsubmit="return before_login()" action="/test_ssh/init/login">
					<c:if test="${result.equals('fail')}">
					<div id="result"><font color="red">用户名不存在或密码错误</font></div>
				</c:if>
				  <div>
					<span>账号<label>*</label></span>
					<input type="text" name="username" id="username" onfocus="display1()"> 
					<span style="display:none" id="username_blank"><font color="red">不能为空</font></span>
				  </div>
				  <div>
					<span>密码<label>*</label></span>
					<input type="password" name="psw" id="psw" onfocus="display2()"> 
					<span style="display:none" id="psw_blank"><font color="red">不能为空</font></span>
				  </div>
				  <a class="forgot" href="#">忘记密码?</a>
				  <input type="submit" value="登录" onClick="loginform.onsubmit()">
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
