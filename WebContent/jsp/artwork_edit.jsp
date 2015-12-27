<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>艺术品编辑</title>
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
<script type="text/javascript" src="../js/pictureload.js"></script>
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
<link href="../css/table.css" rel='stylesheet' type='text/css' />
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<link rel="stylesheet" href="../page/jqpagination.css"/>
 <script src="../page/jquery-1.6.2.min.js"></script>
 <script src="../page/jquery.jqpagination.min.js"></script>
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
						<a href="/test_ssh/init/home"><img src="../images/logo_ooz.png"
							alt="首页" /></a>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="header_bottom_right">
					<div class="search">
						<input type="text" value="艺术品名称" onFocus="this.value = '';"
							onBlur="if (this.value == '') {this.value = '艺术品名称';}"> <input
							type="submit" value="">
					</div>
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
					<li><a class="color2" href="/test_ssh/init/home">首页</a></li>
					<li><a class="color4" href="/test_ssh/mall/enterMall?go=0">定制</a></li>
					<li><a class="color10" href="/test_ssh/mall/enterMall?go=1">商城</a></li>
					<li><a class="color7" href="#">拍卖</a></li>
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
				<form method="post"  action="/test_ssh/artist/editOrAddArtwork?itemId=${item.id}" class="artworkform" enctype="multipart/form-data">
				<div>
				<span>图片<label>*</label></span>
				<div id="preview" style="border:solid 1px">
						<span><img id="image" src="${item.picUrl}" width="30%"
							height="30%" /></span>
					</div> <span>
            <span><input id="img" name="img" type="file" accept="image/*" onchange="previewImage(this,'preview','image')"/></span></span>

</div>
				  <div>
					<span>艺术品名<label>*</label></span>
					<input id="name" name="name" type="text" value="${item.name}"> 
					
				  </div>
				  <div>
					<span>类别<label>*</label></span>
					<select id="type" name="type">
					<c:forEach items="${TYPELIST}" var="type">
                <option value="${type.name}">${type.name}</option>
                </c:forEach>
            </select>
				  </div>
				  <div>
					<span>种类<label>*</label></span>
					<select id="select2" onchange="select2_change()" name="select2">
                <option value="1">展品</option>
              <option value="0" selected="selected">商品</option>
            </select>
				  </div>
				   <div id="price">
					<span>价格</span>
					<input type="text" value="${item.price}" id="price" name="price" onblur="before_submit()" onfocus="pp.style.display=none">
					<font color="red"><span id="pp" style="display: none">价格不正确</span></font>
				  </div>
				   <div id="description">
					<span>介绍</span>
					<textarea id="description" name="description">${item.artworkDescription}</textarea> 
				  </div>
				  <input type="submit" value="确认">
				  <input type="button" onclick="if(window.confirm('确定返回吗？未保存的内容可能丢失')) window.location.href='/test_ssh/artist//myArt'" value="返回">
			    </form>
			   </div>	
			   <div class="clearfix"> </div>
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
function select2_change(){
	var select2=document.getElementById("select2").value;
	if(select2=="展品")
		document.getElementById("price").style.display="none";
	else
		document.getElementById("price").style.display="block";
}
function before_submit(){
	var price=document.getElementById("price").value;
	var flag=0;
	if(price==""||!price.match(/^[0-9]+\.{0,1}[0-9]{0,2}$/g)){
		document.getElementById("select2").style.display="block";
		flag=1;
			}
}
</script>