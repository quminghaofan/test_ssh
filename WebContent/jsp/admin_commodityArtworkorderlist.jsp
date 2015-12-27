<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>制成品订单列表</title>
<link rel="stylesheet" type="text/css" href="../Css1/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../Css1/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../Css1/style.css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.sorted.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/ckform.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script language="javascript" type="text/javascript"
	src="../My97DatePicker/WdatePicker.js"></script>
<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>
<body>

	<form class="form-inline definewidth m20"
		action="/test_ssh/admin_user/getOrder?type=1" method="post">
		根据<select style="width: auto" id="sign" name="sign">
			<option value="1">订单编号</option>
			<option value="2">艺术品名</option>
			<option value="3">卖家用户名</option>
			<option value="4">买家用户名</option>
		</select>搜索
		 <input type="text" name="username" id="username" class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		 艺术品类型<select style="width: auto" id="typeId" name="typeId">
		 <option value="">全部</option>
			<c:forEach items="${TYPELIST}" var="type">
				<li><option value="${type.name}">${type.name}</option></li>
			</c:forEach>
		</select>
		起始时间 <input name="txtDate time1" id="txtDate time1" class="Wdate"
			type="text"
			onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
			onchange="price_count()" />
		终止时间<input name="txtDate time1"
			id="txtDate time1" class="Wdate" type="text"
			onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
			onchange="price_count()" />
		<button type="submit" class="btn btn-primary" id="search"
			name="search">搜索</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>订单编号</th>
				<th>艺术品名</th>
				<th>艺术品类别</th>
				<th>卖家用户名</th>
				<th>买家用户名</th>
				<th>订单时间</th>
				<th>订单状态</th>
			</tr>
		</thead>
		<c:if test="${ORDERLIST!=null}">
			<c:forEach items="${ORDERLIST}" var="order">
				<tr>
					<td>${order.orderId}</td>
					<td>${order.commodityArtwork.name}</td>
					<td>${order.commodityArtwork.type.name}</td>
					<td>${order.commodityArtwork.owner.name}</td>
					<td>${order.user.name}</td>
					<td>${order.placeDate}</td>
					<td>${order.state}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</body>
</html>
