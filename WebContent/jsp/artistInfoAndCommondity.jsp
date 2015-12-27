<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>艺术家详情及艺术品列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
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
<link rel="stylesheet" href="../css/general.css" media="all" />
<!-- Custom Theme files -->
<!--webfont-->
<link
	href='http://fonts.useso.com/css?family=Raleway:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css' />
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
<style type="text/css">

#headPhotoValue {
	width: 100px;
	height: 100px;
	border-radius: 100px;
	

	
	margin-left:50px;
	padding:0px;text-align:center;
	
}

#nick {
	width: 110px;
}

#make {
	width: 120px;
	color: blue;
	text-decoration: underline;
}
#artart{
	width:150px;
	height:200px;
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

	<div style="float: left; width: 8%">
		<a href=""><img src="../images/back.png" alt="返回"
			class="img-responsive" /></a>
	</div>

	
	<div style="float: right; width: 20%; height: 35%">
	<%User user=(User)session.getAttribute("user");
	if(user!=null){%>
		<a href="/test_ssh/customized/goToCustomizationApplying?artistId=${artist.id}"><img
			src="../images/customize.jpg" alt="申请定制" class="img-responsive" /></a>
	<%}else{ %>
	<a href="/test_ssh/init/goToLogin?backUrl='/test_ssh/customized/seeMore?artistId=${artist.id}'"><img
			src="../images/customize.jpg" alt="申请定制" class="img-responsive" /></a>
	<%} %>
	</div>	
	
	</br>
	</br>
	<form action="" method="post">
			<div id="logo">
				<img id="headPhotoValue" src="${artist.headPhoto}"/>
			</div>
			<div>
				<h1>
					<font color="red">艺术家简介</font>
				</h1>
			</div> </br>
			<div>
				<div>
					<p>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label id="nickname">昵称:</label> <label id="nicknameValue">${artist.realName}</label></p>
				</div>
				<div>
					<p> &nbsp;<label id="realname">真实姓名:</label>&nbsp;&nbsp;<label id="realnameValue">${artist.realName}</label></p>
				</div>
				<div>
					<p> &nbsp;&nbsp;<label id="phone">手机号:</label> <label id="phoneValue">${artist.mobile}</label></p>
				</div>
				<div>
					<p><label id="address">联系地址:</label> <label id="addressValue">${artist.address}</label></p>
				</div>
				<div>
					<p>&nbsp;&nbsp;<label id="description">艺术家描述:</label> <label id="desValue">${artist.description}</label></p>
				</div>

			</div>
	</form></br></br>
	<div>
		<h1 id="showart">
			<font color="red">艺术家成就展示</font>
		</h1>
	</div>
	</br>
		
	<form action="" method="get">
		<div class="span_3">
		<c:forEach items="${artCommodList}" var="artWork">
			<div class="col-sm-3 grid_1">
				<img id="artart" src="${artWork.picUrl}" class="img-responsive" alt="" />
				<h3>${artWork.type.name}</h3>
				<h4>${artWork.name}</h4>
			</div>
		</c:forEach>
		<div class="clearfix"></div>
	   </div>
	</form>

	<!--<p id="manu">您要<a href="/test_ssh/jsp/customizeArt" id="make">申请定制</a>吗？</p>-->
	

	<%if(user!=null){%>
		<a href="/test_ssh/customized/goToCustomizationApplying?artistId=${artist.id}">申请定制</a>
	<%}else{ %>
	<a href="/test_ssh/init/goToLogin?backUrl='/test_ssh/customized/seeMore?artistId=${artist.id}'">申请定制</a>
	<%} %>


	
	</br>
	</br>
	<a href="#"><font color="black">返回顶部</font></a>

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