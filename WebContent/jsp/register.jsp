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
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
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
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<style type="text/css">
.btn {
	width: 100px;
	margin: 0 auto;
	display: block;
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
                    <li><a href="">登出</a></li> 
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
			<li class="active grid"><a class="color2" href="index.jsp">首页</a></li>
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
					</div>
			</li>				
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
					</div>
			</li>
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
					<h2 style="color: red">欢迎来到注册界面</h2>
					<p>
						如果您已有账号，请直接 <a href="/test_ssh/jsp/login.jsp"><font
							color="blue">登录</font></a>
					</p>
				</div>
				<div class="col-md-6 login-right">
					<h3 style="color: red" align="center-left">注册</h3>
					<form id="registerform" method="post"
						onsubmit="return before_register()"
						action="/test_ssh/init/register">
						<div>
							<span> 账号 <label>*</label></span> <input type="text"
								id="username" name="username" placeholder="请用您的手机号注册"
								onfocus="display1()" onblur="return checkPhoneNumber()"
								onchange="" />
							<span style="display: none" id="username_blank"> <font
								color="red">不能为空</font></span> <span style="display: none"
								id="username_exist"><font color="red">用戶名已存在</font></span>
						</div>
						<div>
							<span> 密码 <label>*</label></span> <input name="password"
								type="password" id="password" placeholder="密码由6-15位字母、数字或下划线组成"
								onfocus="display2()" onblur="return checkPassword()" /> <span
								style="display: none" id="psw_blank"><font color="red">不能为空</font></span>
						</div>
						<div>
							<span>确认密码<label>*</label></span> <input name="password2"
								type="password" id="password2" placeholder="请再次输入您的密码"
								onblur="return checkPassword2()" /> <span style="display: none"
								id="psw_blank1"><font color="red">不能为空</font></span>
						</div>
						<div>
							<span> 验证码<label>*</label></span> <input type="check"
								onblur="return verify()"> <input type="button"
								name="send" value="发送验证码" style="float: center"
								onclick=sendSMS() /> <span style="display: none"
								id="check_blank"><font color="red">不能为空</font></span>
						</div>
						<div class="clearfix"></div>
						<a class="news-letter" href="#"> <label class="checkbox">
								<input type="checkbox" name="confirm" id="cb" onclick="agree();"
								checked="checked" /><i> </i>我同意该网站协定
						</label></a>
				<input type="submit" value="提交" class="btn" id="tj"
					onClick="registerform.onsubmit()" /> <br />
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	</div>
	<div class="footer">
	<div class="container">
		<img src="images/pay.png" class="img-responsive" alt=""/>
		<ul class="footer_nav">
		  <li><a href="#">首页</a></li>
		  <li><a href="#">定制</a></li>
		  <li><a href="#">商城</a></li>
		  <li><a href="#">拍卖</a></li>
		  <li><a href="#">关于我们</a></li>
		  <li><a href="">联系我们</a></li>
		</ul>
		<p class="copy">Copyright &copy; 2015.厦门大学软件学院OneoneZero All rights reserved. More Information <a href="" target="_blank" title="OneoneZero">OneoneZero</a> - Made by <a href="" title="OneoneZero" target="_blank">OneoneZero</a></p>
	</div>
</div>
</body>
</html>

<script type="text/javascript">
function before_register(){
	var flag=0;
	if(document.getElementById("username").value==""){
		document.getElementById("username_blank").style.display="block";
		flag=1;
	}	
	if(document.getElementById("password").value==""){
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
function register()
{
	if(!checkPhoneNumber())
	{
		return false;
	}
	else if(!checkPassword())
	{
		return false;
	}
	else if(!checkPassword2())
		return false;
	else if(!verify())
		return false;
	else if(!agree())
		return false;
} 
function checkPhoneNumber()
{
	var id=document.getElementById("username");
	var phone = id.value;     
	if(phone=="")
	{
		document.getElementById(id.name).innerHTML="请输入您的手机号";
		return false;
	}
	if(!(/^1[3|5][0-9]\d{4,8}$/.test(phone)))
	{ 
		document.getElementById(id.name).innerHTML="您输入的手机号不存在";
		return false; 
	}
	return true;
}             

function checkPassword()
{
	var id = document.getElementById("password");  
	var password=id.value;
	var reg = /^[0-9a-zA-Z_]+$;
	if(id.length<6 || id.length>15)
	{
		document.getElementById(id.name).innerHTML="密码长度必须在6-15之间";
		return false;
	}
	if(password=="")
	{
		document.getElementById(id.name).innerHTML="请输入您的密码";
		return false;
	
	}
	if(!reg.test(password)) 
	{
		document.getElementById(id.name).innerHTML = "密码只能由数字、字母或下划线组成"; 
		return false;
	}
	return true;
}

function checkPassword2()
{
	var id=document.getElementById("password");
	var id2=document.getElementById("password2");
	var password = id.value;    
	var password2 = id2.value;
	if(password!=password2)
	{
		document.getElementById(id.name).innerHTML="两次输入的密码不一致";
		return false;
	}
	if(password2=="")
	{
		document.getElementById(id.name).innerHTML="请输入确认密码";
		return false;
	
	}
	return true;    
}

function verify()
{
	var id=document.getElementById("check");
	var check=id.value;
	if(check=="")
	{
		document.getElementById(id.name).innerHTML="验证码不能为空";
		return false;
	}
	
	return true;
}

function agree(){
   if(document.getElementById('cb').checked)
          document.getElementById('tj').disabled=false;
   else
    document.getElementById('tj').disabled='disabled';  
} 
</script>
