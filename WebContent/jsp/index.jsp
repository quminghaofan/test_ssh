<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>首页</title>
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
<script src="../js/responsiveslides.min.js"></script>

<script>
	$(function() {
		$("#slider").responsiveSlides({
			auto : true,
			nav : false,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
	$(function() {
		$("#updown").css("top", window.screen.availHeight / 2 - 100 + "px");
		$(window).scroll(function() {
			if ($(window).scrollTop() >= 100) {
				$('#updown').fadeIn(300);
			} else {
				$('#updown').fadeOut(300);
			}
		});
		$('#updown .up').click(function() {
			$('html,body').animate({
				scrollTop : '0px'
			}, 800);
		});
		$('#updown .down').click(function() {
			$('html,body').animate({
				scrollTop : document.body.clientHeight + 'px'
			}, 800);
		});
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
<script src="../js/jquery.countdown.js"></script>
<script src="../js/script.js"></script>
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
							if (session.getAttribute("username") == null) {
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
						<a href="index.jsp"><img src="../images/logo_ooz.png" alt="首页" /></a>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="header_bottom_right">
					<%
						if (session.getAttribute("user") != null) {
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
						</div></li>
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
	<div class="index_slider">
		<div class="container">
			<div class="callbacks_container">
				<ul class="rslides" id="slider">
					<!-- 广告 -->
					<c:forEach items="adlist" var="ad">
						<li><img src="../images/slider1.jpg" class="img-responsive"
							alt="" /></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<div class="content_top">
		<div class="container">
			<div class="grid_1">
				<div class="col-md-3">
					<div class="box2">
						<ul class="list1">
							<i class="lock"> </i>
							<li class="list1_right"><p>种类繁多的艺术品</p></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
				<div class="col-md-3">
					<div class="box3">
						<ul class="list1">
							<i class="clock1"> </i>
							<li class="list1_right"><p>完善的售后服务</p></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
				<div class="col-md-3">
					<div class="box4">
						<ul class="list1">
							<i class="vehicle"> </i>
							<li class="list1_right"><p>安全的配送流程</p></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
				<div class="col-md-3">
					<div class="box5">
						<ul class="list1">
							<i class="dollar"> </i>
							<li class="list1_right"><p>个性的定制服务</p></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="column_center">
				<h1>最好的艺术品交易网站</h1>
				<h2>带给你不一样的购物体验，让艺术成为生活的一部分</h2>
			</div>
			<div class="sellers_grid">
				<ul class="sellers">
					<i class="star"> </i>
					<li class="sellers_desc"><h2>商城</h2></li>
					<div class="clearfix"></div>
				</ul>
			</div>
			<div class="grid_2">
				<c:forEach items="itemlist" var="item">
					<div class="col-md-3 span_6">
						<div class="box_inner">
							<img src="images/p1.jpg" class="img-responsive" alt="" />
							<div class="sale-box"></div>
							<div class="desc">
								<h3>Ullamcorper suscipit</h3>
								<h4>178,90 $</h4>
								<ul class="list2">
									<%
										if (session.getAttribute("user") != null) {
									%>
									<li class="list2_left"><span class="m_1"><a
											href="/test_ssh/init/add2Cart?itemId=&name=&type=&price="
											class="link">Add to Cart</a></span></li>
									<%
										} else {
									%>
									<li class="list2_left"><span class="m_1"><a
											href="/test_ssh/init/login" class="link">Add to Cart</a></span></li>
									<%
										}
									%>
									<li class="list2_right"><span class="m_2"><a
											href="#" class="link1">See More</a></span></li>
									<div class="clearfix"></div>
								</ul>
								<div class="heart"></div>
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="content_middle">
		<div class="container">
			<ul class="promote">
				<i class="promote_icon"> </i>
				<li class="promote_head"><h3>定制</h3></li>
			</ul>
			<ul id="flexiselDemo3">
				<li><img src="images/n1.jpg" class="img-responsive" />
				<div class="grid-flex">
						<h4>Contrary to popular</h4>
						<p>589,90 $</p>
						<div class="m_3">
							<a href="#" class="link2">Add to Cart</a>
						</div>
						<div class="ticket"></div>
					</div></li>
				<li><img src="images/n2.jpg" class="img-responsive" />
				<div class="grid-flex">
						<h4>Contrary to popular</h4>
						<p>589,90 $</p>
						<div class="m_3">
							<a href="#" class="link2">Add to Cart</a>
						</div>
						<div class="ticket"></div>
					</div></li>
				<li><img src="images/n3.jpg" class="img-responsive" />
				<div class="grid-flex">
						<h4>Contrary to popular</h4>
						<p>589,90 $</p>
						<div class="m_3">
							<a href="#" class="link2">Add to Cart</a>
						</div>
						<div class="ticket"></div>
					</div></li>
				<li><img src="images/n4.jpg" class="img-responsive" />
				<div class="grid-flex">
						<h4>Contrary to popular</h4>
						<p>589,90 $</p>
						<div class="m_3">
							<a href="#" class="link2">Add to Cart</a>
						</div>
						<div class="ticket"></div>
					</div></li>
				<li><img src="images/n5.jpg" class="img-responsive" />
				<div class="grid-flex">
						<h4>Contrary to popular</h4>
						<p>589,90 $</p>
						<div class="m_3">
							<a href="#" class="link2">Add to Cart</a>
						</div>
						<div class="ticket"></div>
					</div></li>
			</ul>
			<script type="text/javascript">
				$(window).load(function() {
					$("#flexiselDemo3").flexisel({
						visibleItems : 6,
						animationSpeed : 1000,
						autoPlay : true,
						autoPlaySpeed : 3000,
						pauseOnHover : true,
						enableResponsiveBreakpoints : true,
						responsiveBreakpoints : {
							portrait : {
								changePoint : 480,
								visibleItems : 1
							},
							landscape : {
								changePoint : 640,
								visibleItems : 2
							},
							tablet : {
								changePoint : 768,
								visibleItems : 3
							}
						}
					});

				});
			</script>
			<script type="text/javascript" src="js/jquery.flexisel.js"></script>
		</div>
	</div>
	<div class="container">
		<div class="content_middle_bottom">
			<div class="col-md-4">
				<ul class="spinner">
					<i class="spinner_icon"> </i>
					<li class="spinner_head"><h3>拍卖</h3></li>
					<div class="clearfix"></div>
				</ul>
				<div class="timer_box">
					<div class="thumb"></div>
					<div class="timer_grid">
						<ul id="countdown">
						</ul>
						<ul class="navigation">
							<li>
								<p class="timeRefDays">DAYS</p>
							</li>
							<li>
								<p class="timeRefHours">HOURS</p>
							</li>
							<li>
								<p class="timeRefMinutes">MINUTES</p>
							</li>
							<li>
								<p class="timeRefSeconds">SECONDS</p>
							</li>
						</ul>
					</div>
					<div class="thumb_desc">
						<h3>totam rem aperiam</h3>
						<div class="price">
							<span class="reducedfrom">$140.00</span> <span class="actual">$120.00</span>
						</div>
					</div>
					<a href="#"><div class="m_3 deal">
							<div class="link3">Buy this deal</div>
						</div></a>
				</div>
			</div>
			<!--è½¯æ-->
			<div class="col-md-8">
				<ul class="spinner">
					<i class="paperclip"> </i>
					<li class="spinner_head"><h3>新闻资讯</h3></li>
					<div class="clearfix"></div>
				</ul>
				<c:forEach items="${RRlist}" var="rr">
					<div class="a-top">
						<div class="left-grid">
							<img src="images/n2.jpg" class="img-responsive" alt="" />
						</div>
						<div class="right-grid">
							<h4>
								<a href="#">${rr.name}</a>
							</h4>
							<p>${rr.content}</p>
							<!-- 保留前15或20个字符即可，然后加省略号 -->
						</div>
						<div class="but">
							<a class="arrow" href="#"> </a>
						</div>
						<div class="clearfix"></div>
					</div>

				</c:forEach>
				<div class="clearfix"></div>
			</div>
			<div class="content_bottom">
				<div class="col-md-3 span_1">
					<ul class="spinner">
						<i class="box_icon"> </i>
						<li class="spinner_head"><h3>mazim pla</h3></li>
						<div class="clearfix"></div>
					</ul>
					<img src="images/t8.jpg" class="img-responsive" alt="" />
				</div>
				<div class="col-md-3 span_1">
					<ul class="spinner">
						<i class="bubble"> </i>
						<li class="spinner_head"><h3>About Us</h3></li>
						<div class="clearfix"></div>
					</ul>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
						sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna
						aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud
						exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea
						commodo consequat</p>
				</div>
				<div class="col-md-3 span_1">
					<ul class="spinner">
						<i class="mail"> </i>
						<li class="spinner_head"><h3>Contact Us</h3></li>
						<div class="clearfix"></div>
					</ul>
					<ul class="social">
						<li><a href=""> <i class="fb"> </i>
						</a></li>
						<li><a href=""><i class="tw"> </i> </a></li>
						<li><a href=""><i class="google"> </i> </a></li>
						<li><a href=""><i class="linkedin"> </i> </a></li>
						<li><a href=""><i class="skype"> </i> </a></li>
					</ul>
				</div>
				<div class="col-md-3 span_1">
					<ul class="spinner">
						<i class="mail"> </i>
						<li class="spinner_head"><h3>Contact Us</h3></li>
						<div class="clearfix"></div>
					</ul>
					<p>500 Lorem Ipsum Dolor Sit,</p>
					<p>22-56-2-9 Sit Amet, Lorem,</p>
					<p>Phone:(00) 222 666 444</p>
					<p>
						<a href="mailto:info@demo.com"> info(at)gifty.com</a>
					</p>
				</div>
				<div class="clearfix"></div>
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
	</div>
</body>
</html>