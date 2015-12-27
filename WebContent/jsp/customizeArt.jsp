<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>艺术品定制</title>
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
							if (session.getAttribute("user") == null) {
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
												<li><a href="">${type.name}</a></li>
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
												<li><a href="">${type.name}</a></li>
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
												<li><a href="">${type.name}</a></li>
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
  <div class="register">
			   <h1>欢迎您定制艺术品</h1>
			   <div class="col-md-6 login-right">
				<form id="customizeform" method="post"  action="/test_ssh/customized/customizationApplying?artistId=${artistId}" onsubmit="return before_customize()" enctype="multipart/form-data">
				  <div>
					<span>定制品类别<label>*</label></span>
					<!--<input type="text" name="type" id="type" onfocus="type_blank.style.display='none'">--> 

					<select name="arttype" id="arttype">
						<option>----------请选择----------</option>
						<c:forEach items="${TYPELIST}" var="type">
						<option value="${type.name}">${type.name}</option>
						</c:forEach>
					</select> 
					<span id="type_blank" style="display:none"><font color="red">请选择您要定制的艺术品类别</font></span>
				  </div>				  
				  <div>
					<span>定制品名称<label>*</label></span>
					<input type="text" name="artname" id="artname" onfocus="name_blank.style.display='none'"> 
					<span id="name_blank" style="display:none"><font color="red">定制品名称不能为空</font></span>
				  </div>
				  <div>
					<span>手机号<label>*</label></span>
					<input type="text" name="telephone" id="telephone" onfocus="telephone_blank.style.display='none'"> 
					<span id="telephone_blank" style="display:none"><font color="red">手机号不能为空</font></span>
				  </div>
				  <div>
					<span>联系地址<label>*</label></span>
					<input type="text" name="address" id="address" onfocus="address_blank.style.display='none'"> 
					<span id="address_blank" style="display:none"><font color="red">不能为空</font></span>
				  </div>				  
				  <div>
					<span>备注</span>
					<textarea name="intro" id="intro"></textarea>
                 </div>
                 <div>
                 <span>样本图片</span>
					<span><input id="img" name="img" type="file"
						accept="images/*" onchange="previewImage(this,'preview','image')" style="width: 60%"/></span>
				  <div id="preview" style="border:solid 1px">
						<span><img id="image" src="" width="30%"
							height="30%" /></span>
					</div> 
				</div>
				  <input type="button" class="btn btn-success" name="backid" id="backid" onclick="if(window.confirm('确定返回吗？未保存的内容可能丢失')) window.location.href='/test_ssh/mall/enterMall?go=0'" value="返回"></a>
				  <input type="submit" value="提交" align="center-right" onClick="customizeform.onsubmit()">
				  
			    </form>
			   </div>	
		</div>

			</div>
</div>


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
</body>
</html>
<script>
function before_customize(){
	var arttype=document.getElementById("arttype");
	var artname=document.getElementById("artname");
	var telephone=document.getElementById("telephone");
	var address=document.getElementById("address");
	var img=document.getElementById("img");
	var flag=0;
	if((arttype.value=="") || (arttype.value=="----------请选择----------")){
		flag=1;
		document.getElementById("type_blank").style.display="block";
	}
	if(artname.value==""){
		flag=1;
		document.getElementById("name_blank").style.display="block";
	}
	if(telephone.value==""){
		flag=1;
		document.getElementById("telephone_blank").style.display="block";
	}
	else if(!(/^1\d{10}$/.test(telephone.value)))
	{ 
		document.getElementById("telephone_blank").style.display="block";
		$("#telephone_blank").text("您输入的手机号不正确");
		flag=1; 
	}
	if(address.value==""){
		flag=1;
		document.getElementById("address_blank").style.display="block";
	}
	if(flag==1)
		return false;
}
</script>
