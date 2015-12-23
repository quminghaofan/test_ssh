<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>软文详情</title>
		<link href="../css2/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<body>
			<!--start-content--->
			<a href="/test_ssh/news/goback?type=${type}"><font color="blue">返回</font></a>
			<div class="content">
				<!---start-get-download-link---->
				<div class="get-download get-download1">
					</br>
					<p>"${news.name}"</p>
					</br>
					<p><font color="gray" size="2px">主编/<input value="${news.chiefEditor.name}"  style="border: none"/></font></p>
					<p><font  color="gray" size="2px">采编/<input value="${news.editor.name}"  style="border: none"/></font></p>
				</div>
				</div>
				<!---//End-get-download-link---->
				<!----start-divice-features---->
				<div class="single-page">
					<div class="box1">
						<div class="wrap">
							<div class="box1-info">
							<c:if test="${news.picUrl!=null}">
								<p>
								<img id="picture" src="${news.picUrl}" height="350" width="500"
						readonly="readonly" />
								</p>
								</c:if>
								<p>
									"${news.content}"
								</p>
							</div>
							<div class="box1-demo">
								
							</div>
							<div class="clear"> </div>
						</div>
					</div>
				</div>
				<!----//End-divice-features---->
				<!---start-footer---->
				
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
			<a href="#"><style align="center">返回顶部</style></a>
		<!----//End-wrap---->
	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

