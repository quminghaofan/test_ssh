<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>定制品列表</title>
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
		action="/test_ssh/admin_user/getArtwork?type=0" method="post">
		根据<select style="width: auto" name="sign" id="sign">
			<option value="0">艺术品名</option>
			<option value="1">卖家用户名</option>
		</select>搜索 <input type="text" name="username" id="username"
			class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<select name="typeId" id="typeId">
			<option selected="selected" value="0">全部</option>
			<c:forEach items="${TYPELIST}" var="type">
				<option value="${type.name}">${type.name}</option>
			</c:forEach>
		</select>
		<button type="submit" class="btn btn-primary" id="search"
			name="search">搜索</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>第一期图片</th>
				<th>第二期图片</th>
				<th>第三期图片</th>
				<th>艺术品名</th>
				<th>艺术品类型</th>
				<th>卖家用户名</th>
				<th>是否存在</th>
			</tr>
		</thead>
		<c:if test="${ITEMLIST!=null}">
			<c:forEach items="${ITEMLIST}" var="item">
				<tr>
					<td style="width: 15%;"><img id="image1" src="${item.startImg}" style="width: 100%;"/></td>
					<td style="width: 15%;"><img id="image2" src="${item.midImg}" style="width: 100%;"/></td>
					<td style="width: 15%;"><img id="image3" src="${item.endImg}" style="width: 100%;"/></td>
					<td>${item.name}</td>
					<td>${item.type.name}</td>
					<td>${item.owner.name}</td>

					<c:if test="${item.isExist}">
						<td>存在</td>
					</c:if>

					<c:if test="${!(item.isExist)}">
						<td>已删除</td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</body>
</html>
