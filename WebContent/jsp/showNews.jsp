<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>软文详情</title>
		<link href="../css2/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Gifty Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
		<link rel="shortcut icon" type="image/x-icon" href="images/fav-icon.png" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		</script>
		<!----webfonts---->
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
		<!----//webfonts---->
		 <!-- Add fancyBox light-box -->
		 <script src="../js/showNews/jquery-1.9.1.min.js"></script> 
		<script src="../js/showNews/jquery.magnific-popup.js" type="text/javascript"></script>
		<link href="../css2/magnific-popup.css" rel="stylesheet" type="text/css">
				<script>
					$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
					});
				});
		</script>
		<!-- //End fancyBox light-box -->
	</head>
	<style type="css/type">
	#return{
	float:center;
	margin:0 auto;
	width:200px;
	}
	#chief{
	float:center;
	margin:0 auto;
		width:400px;
		height:400px;
	}
	#editor{
	
	}

	
	#picture{
	
	}
	</style>
	<body>
			<!--start-content--->
<div style="float:left;width:5%">
	<a href="/test_ssh/news/goback?type=${type}"><img src="../images/back.png" alt="返回" class="img-responsive"/>
	</a>
</div>		
				<div class="content">
					<!---start-get-download-link---->
					<div class="get-download get-download1">
						</br>
						<p>${news.name}</p>
						</br>
						<p id="chief">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="gray" size="2px">主编/<input value="${news.chiefEditor.name}"  style="border: none"/></font></p>
						<p id="editor">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font  color="gray" size="2px">采编/<input value="${news.editor.name}"  style="border: none"/></font></p>
					</div>
				</div>
				<!---//End-get-download-link---->
				<!----start-divice-features---->
				<div class="get-download get-download1">
					<div class="box1">
						<div class="wrap">
							<div class="box1-info">
							
							<c:if test="${news.picUrl!=null}">
								<p>
								<img id="picture" src="${news.picUrl}"
						readonly="readonly" />
								</p>
								</c:if>
								<p id="content">
									${news.content}
								</p>
							</div>
							<div class="clear"> </div>
						</div>
					</div>
				</div>
				<!----//End-divice-features---->
				<!---start-footer---->
				</br>
				<div class="get-download get-download1">
					<a href="#" id="return"><font color="blue">返回顶部</font></a>
				</div>
				<div class="wrap">
				<div class="footer">
						<div class="footer-left">
							<p>by <a href="">OneoneZero;</a> 2015 <span>OADD.</span> All Rights Reserved.</p>
						</div>
						<div class="footer-right">
						</div>
						<div class="clear"> </div>
					</div>
				</div>
				<!---//End-footer---->
				</div>
			</div>
			<!--//End-content--->
		<!----//End-wrap---->
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
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

