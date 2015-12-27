<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>注册</title>
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
					<h2 style="color: red">欢迎来到注册界面</h2>
				</div>
				<div class="col-md-6 login-right">
					<p>
						如果您已有账号，请直接 <a href="/test_ssh/jsp/login"><font
							color="blue">登录</font></a>
					</p>

					<h3 style="color: red" align="center-left">注册</h3>
					<form id="registerform" method="post"
						onsubmit="return before_register()"
						action="/test_ssh/init/register">
						<div>
							<span> 账号 <label>*</label></span> 
							<input type="text"
								id="username" name="username" placeholder="请用您的手机号注册"
								onfocus="display1()" onblur="judgeUserName()">
							<span style="display: none" id="username_blank"> <font
								color="red"></font></span>
						</div>
						<div>
							<span> 密码 <label>*</label></span> 
							<input name="password"
								type="password" id="password" placeholder="请输入您的密码"
								onfocus="display2()"> <span
								style="display: none" id="psw_blank"><font color="red"></font></span>
						</div>
						<div>
							<span>确认密码<label>*</label></span> 
							<input name="password2"	type="password" id="password2" placeholder="请再次输入您的密码"
								 onfocus="display3()"> 
							<span style="display: none"
								id="psw_blank1"><font color="red"></font></span>
						</div>
						<div>
							<span> 验证码<label>*</label></span> <input type="check"  id="checkok"
								 onfocus="display4()">
								<input type="button" id="check"	name="send" value="发送验证码" style="float: center"> 
								<span style="display: none" id="check_blank"><font color="red"></font></span>								
						</div>
						<div class="clearfix"></div>
						<a class="news-letter" href="#"> <label class="checkbox">
								<input type="checkbox" name="confirm" id="cb"
								checked="checked" /><i> </i>我同意该网站协定
						</label></a>
						<input type="submit" value="提交" class="btn" id="tj" onClick="registerform.onsubmit()"> 
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
	var tel=document.getElementById("username").value;
	if(document.getElementById("username").value==""){
		document.getElementById("username_blank").style.display="block";
		$("#username_blank").text("用户名不能为空"); 
		flag=1;
	}	
	else if(!(/^1\d{10}$/.test(tel)))
	{ 
		document.getElementById("username_blank").style.display="block";
		$("#username_blank").text("您输入的手机号不正确");
		flag=1; 
	}
	if(document.getElementById("password").value==""){
		document.getElementById("psw_blank").style.display="block";
		$("#psw_blank").text("密码不能为空");
        flag=1;
	}
	/*		if(document.getElementById("password").length<6 || document.getElementById("password").length>15)
		{
			$("#psw_blank").text("密码长度必须在6-15之间");
			flag=1;
		}
		if(!reg.test(document.getElementById("password").value)) 
		{
			$("#psw_blank").text("密码只能由数字、字母或下划线组成"); 
			flag=1;
		}*/
	if(document.getElementById("password2").value==""){
		document.getElementById("psw_blank1").style.display="block";
		$("#psw_blank1").text("请确认您的密码");
		flag=1;
	}	
	if(document.getElementById("password").value!=document.getElementById("password2").value)
	{
		document.getElementById("psw_blank1").style.display="block";
		$("#psw_blank1").text("密码不一致，请重新输入");
		flag=1;
	}	
	if(document.getElementById("checkok").value==""){
		document.getElementById("check_blank").style.display="block";
		$("#check_blank").text("验证码不能为空");
        flag=1;
	}
	if(document.getElementById('cb').checked)
    {
		document.getElementById('tj').disabled=false;
	}      
	else
    {
		document.getElementById('tj').disabled='disabled';  
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
function display3(){
	document.getElementById("psw_blank1").style.display="none";
}
function display4(){
	document.getElementById("check_blank").style.display="none";
}
function judgeUserName()
{  
	$.ajax({
			type : "post",
			url : "/test_ssh/init/judgeUserName",
			dataType : "text",
			data : {
				"username" : $("#username").val()
			},
			beforeSend : function(XMLHttpRequest) {
				document.getElementById("username_blank").style.display="block";
				$("#username_blank").text("正在查询");

			},
			success : function(msg) {
				document.getElementById("username_blank").style.display="block";
				if(msg=="success"){
					$("#username_blank").text("该用户名可用");
				}
				else if(msg=="error"){
					document.getElementById("username").value="";
					$("#username_blank").text("该用户名已存在，请重新输入！");
				}
			},

		});
	}
</script>
