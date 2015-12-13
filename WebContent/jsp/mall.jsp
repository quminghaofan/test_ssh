<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>商城</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Gifty Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
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
$(document).ready(function(){$(".megamenu").megamenu();});
$(function(){
	$("#updown").css("top",window.screen.availHeight/2-100+"px");
	$(window).scroll(function() {		
		if($(window).scrollTop() >= 100){
			$('#updown').fadeIn(300); 
		}else{    
			$('#updown').fadeOut(300);    
		}  
	});
	$('#updown .up').click(function(){$('html,body').animate({scrollTop: '0px'}, 800);});
	$('#updown .down').click(function(){$('html,body').animate({scrollTop: document.body.clientHeight+'px'}, 800);});
});
</script>
<style type="text/css">
#updown {
	_top: expression(eval(( document.compatMode && document.compatMode ==
		"CSS1Compat")?documentElement.scrollTop+documentElement.clientHeight-this.clientHeight-1:document.body.scrollTop+document.body.clientHeight-this.clientHeight-1));
	position: fixed;
	_position: absolute;
	top: 70%;
	right: 5%;
	display: none;
	z-index: 10000
}

#updown span {
	cursor: pointer;
	width: 48px;
	height: 50px;
	display: block;
}

#updown .up {
	background: url(../images/updown.png) no-repeat;
}

#updown .up:hover {
	background: url(../images/updown.png) top right no-repeat;
}

#updown .down {
	background: url(../images/updown.png) bottom left no-repeat;
}

#updown .down:hover {
	background: url(../images/updown.png) bottom right no-repeat;
}

#top {
	background-color: #000;
	margin: 0em 0 10px 0em;
	border-style: solid;
	border-width: 1px;
	border-color: #E5E5E5;
	height: 50px;
	line-height: 50px;
}
</style>

</head>
<body>
	<div id="updown">
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
                	if(session.getAttribute("user")==null){
                %>
						<li><a
							href="/test_ssh/jsp/login?backUrl=/test_ssh/mall/enterMall">登录/注册</a></li>
						<%
                    }else{
                    %>
						<li><a href="">申请成为艺术家</a></li>
						<li><a href=""> <%=((User)session.getAttribute("user")).getName()%></a></li>
						<li><a href="">我的订单</a></li>
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
						<a href="/test_ssh/init/home"><img src="../images/logo_ooz.png"
							alt="首页" /></a>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="header_bottom_right">
					<div class="search">
						<input type="text" value="商品名称" onFocus="this.value = '';"
							onBlur="if (this.value == '') {this.value = '商品名称';}"> <input
							type="submit" value="">
					</div>
					<%
                	if(session.getAttribute("user")!=null){
                %>
					<ul class="bag">
						<a href="#"><i class="bag_left"> </i></a>
						<a href="/test_ssh/cart/showCart"><li class="bag_right"><p>购物篮</p></li></a>
						<div class="clearfix"></div>
					</ul>
					<%} %>
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
						</div></li>
					<li class="active grid"><a class="color10" href="/test_ssh/mall/enterMall">商城</a>
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
						</div></li>
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
						</div></li>
					<li><a class="color8" href="">联系我们</a></li>
					<div class="clearfix"></div>
				</ul>
			</div>
		</div>
	</div>
	<div class="men">
		<div class="container">

			<div class="col-md-9">
				<div class="mens-toolbar">
					<div class="sort">
						<div class="sort-by">
							<label>排序</label> <select>
								<option value="0"></option>
								<option value="1">价格：由高到低</option>
								<option value="2">价格：由低到高</option>
							</select>
						</div>
					</div>
					<!--   <div class="pager">   
	           <div class="limiter visible-desktop">
	            <label>显示</label>
	            <select>
	                            <option value="" selected="selected">
	                    9                </option>
	                            <option value="">
	                    15                </option>
	                            <option value="">
	                    30                </option>
	                        </select> 每页        
	             </div>
	       		<ul class="dc_pagination dc_paginationA dc_paginationA06">
				    <li><a href="#" class="previous">Pages</a></li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
			  	</ul>
		   		<div class="clearfix"></div>
	    	</div>-->
					<div class="clearfix"></div>
				</div>
				<div class="span_2">
					<c:forEach items="itemlist" var="item">
						<div class="col_1_of_single1 span_1_of_single1">
							<a href="single.html"> <img src="${item.picUrl}"
								class="img-responsive" alt="" href="" />
								<h3>${item.name}</h3>
								<h4>${item.price}</h4>
							</a>
							<ul class="list2">
								<li class="list2_left"><span class="m_1"><a href="#"
										class="link">添加购物篮</a></span></li>
								<li class="list2_right"><span class="m_2"><a
										href="#" class="link1">立即购买</a></span></li>
							</ul>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="pagging">

		<div class="left">共${totalpage}条记录</div>

		<div class="right">

			<c:if test="${currentPage == 1}">

				<span class="disabled">&lt;&lt; 前一页</span>

			</c:if>

			<c:if test="${currentPage != 1}">

				<a href="/test_ssh/mall/enterMall?page=${currentPage-1}">&lt;&lt;
					前一页</a>

			</c:if>

			<c:if test="${currentPage == 1}">

				<span class="current">1</span>

			</c:if>

			<c:if test="${currentPage != 1}">

				<a href=/test_ssh/mall/enterMall "?page=1">1</a>

			</c:if>

			<%

                 int pageTimes = (Integer)session.getAttribute("pageTimes");

                 for(int i=1;i<pageTimes;i++)

                 {

                     request.setAttribute("page", i+1);

         %>

			<c:if test="${currentPage == page}">

				<span class="current"><%=i+1%></span>

			</c:if>

			<c:if test="${currentPage != page}">

				<a href="/test_ssh/mall/enterMall?page=<%=i+1%>"><%=i+1%></a>

			</c:if>

			<%} %>



			<c:if test="${currentPage == pageTimes}">

				<span class="disabled">后一页 &gt;&gt;</span>

			</c:if>

			<c:if test="${currentPage != pageTimes}">

				<a href="/test_ssh/mall/enterMall?page=${currentPage+1}">后一页
					&gt;&gt;</a>

			</c:if>

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
