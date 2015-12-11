<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>确认订单</title>
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
<link href="../css/table.css" rel='stylesheet' type='text/css' />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,800,700,600,300'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
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
						<li><a href="">${username}</a></li>
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
					<div class="search">
						<input type="text" value="商品名称" onFocus="this.value = '';"
							onBlur="if (this.value == '') {this.value = '商品名称';}"> <input
							type="submit" value="">
					</div>
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
					<li><a class="color2" href="index.jsp">首页</a></li>
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
						</div></li>
					<li class="active grid"><a class="color10" href="#">商城</a>
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
						</div></li>
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
						</div></li>
					<li><a class="color8" href="">联系我们</a></li>
					<div class="clearfix"></div>
				</ul>
			</div>
		</div>
	</div>

<div class="men">
<div class="container">
<div align="center">
    <div style="width: 90%;">
        <div style="padding: 6%" align="left">
 
<div class="orderdiv" style="margin-top:2%">
                <c:forEach items="${orderlist}" var="order">
                    <div style="width:20%;" class="left-grid"><img class="img-responsive" src="${order.picUrl}"></div>
                
                <div class="info" align="left">
                    <div style="font-size: large" class="infomargin">
                        <label>${order.name}</label>
                    </div>
                    <div align="right">
                    <label>类别:&nbsp;&nbsp;${order.type}</label>
                        <label>价格:&nbsp;&nbsp;&nbsp;&nbsp;¥&nbsp;&nbsp;${order.price}</label>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            </c:forEach>
            
            <div class="breakline"></div>

            <div align="right" style="font-weight: bolder">
                <lable>总价&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;</lable>
                <lable>¥ ${total}</lable>
            </div>

           <div style="margin-top: 3%;text-align:left" >
                <div style="margin-bottom: 2%;">
                    <lable>用户名:&nbsp;&nbsp;</lable>
                    <lable style="font-weight: bold">${username}</lable>
                </div>
                <div style="margin-bottom: 2%;">
                    <lable>地址:&nbsp;&nbsp;&nbsp;&nbsp;</lable>
                    <lable class="txt1" style="vertical-align:bottom" id="modi_address">用户地址</lable>
                  <input type="button" style="display: inline;vertical-align:bottom" type="button" value="编辑" id="edit" class="btn1"/>
                   <input type="button" style="display: none;vertical-align:bottom" type="button" value="确认" id="edit" class="btn3" />
                    <input type="button" style="display: none;vertical-align:bottom" type="button" value="取消" id="edit" class="btn2" />
                </div>
                <div>
                    <lable>电话:&nbsp;&nbsp;&nbsp;&nbsp;</lable>
                    <lable class="txt2" style="vertical-align:bottom" id="modi_phone">1344354545</lable>
                 <input type="button"  style="display: inline;vertical-align:bottom" type="button" value="编辑" id="edit" class="btn4"/>
                 <input type="button" style="display: none;vertical-align:bottom" type="button" value="确认" id="edit" class="btn6" />
                   <input type="button" style="display: none;vertical-align:bottom" type="button" value="取消" id="edit" class="btn5" />
                </div>
            </div>




            <div align="right" style="margin-top: 3%;">
                <a href="/test_ssh/cart/showCart"><input type="button" class="orderbutton" style="margin-right:1.5%" value="返回购物篮"/></a>
                <a href=""><input type="button" class="orderbutton" value="确认支付"/></a>
            </div>
        </div>
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


function updateInfo(type) {

	
    var form = document.createElement("form");
    form.setAttribute("method","post");
    form.setAttribute("action", "");
	var attr=document.getElementById("modi_"+type).getElementByTagName("input").getAttribute("value");
    	
    var hiddenField = document.createElement("input");
    hiddenField.setAttribute("name",type );
    hiddenField.setAttribute("value",attr);
    form.appendChild(hiddenField);
 
    var typeField=document.createElement("input");
    typeField.setAttribute("name","type" );
    typeField.setAttribute("value",type);
    form.appendChild(typeField);
    
    
    document.body.appendChild(form);
    form.submit();
}

    $(function () {
        $(".btn1").click(function () {
            var txt1 = $(".txt1").text();    //获取.txt的文本内容
            var input = $("<input type='text'value='" + txt1 + "' class='input'/>");     //定义变量input
            $(".txt1").html(input);       // 设置.txt的内容（定义的input）
            $(".btn1").css('display','none');
            $(".btn3").css('display','inline');
            $(".btn2").css('display','inline');
            $(".btn2").click(function () {
                $(".txt1").html(txt1)    //设置.txt的内容（input表单字段的值）
                $(".btn2").css('display','none');
                $(".btn3").css('display','none');
                $(".btn1").css('display','inline');
            });
            $(".btn3").click(function () {
                $(".txt1").html(input.val())    //设置.txt的内容（input表单字段的值）
                $(".btn2").css('display','none');
                $(".btn3").css('display','none');
                $(".btn1").css('display','inline');
                updateInfo("address");
            });
            
        });
    });

    $(function () {
        $(".btn4").click(function () {
            var txt1 = $(".txt2").text();    //获取.txt的文本内容
            var input = $("<input type='text'value='" + txt1 + "' class='input'/>");     //定义变量input
            $(".txt2").html(input);       // 设置.txt的内容（定义的input）
            $(".btn4").css('display','none');
            $(".btn6").css('display','inline');
            $(".btn5").css('display','inline');
            $(".btn6").click(function () {
                $(".txt2").html(input.val())    //设置.txt的内容（input表单字段的值）
                $(".btn5").css('display','none');
                $(".btn6").css('display','none');
                $(".btn4").css('display','inline');
                updateInfo("phone");
            });
            $(".btn5").click(function () {
                $(".txt2").html(txt1)    //设置.txt的内容（input表单字段的值）
                $(".btn5").css('display','none');
                $(".btn6").css('display','none');
                $(".btn4").css('display','inline');
            });
        });
    });

</script>
