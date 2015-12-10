<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已通过</title>
<link rel="stylesheet" type="text/css" href="../Css1/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../Css1/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../Css1/style.css" />
<script type="text/javascript" src="../Js/jquery.js"></script>
<script type="text/javascript" src="../Js/jquery.sorted.js"></script>
<script type="text/javascript" src="../Js/bootstrap.js"></script>
<script type="text/javascript" src="../Js/ckform.js"></script>
<script type="text/javascript" src="../Js/common.js"></script>
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
		action="/test_ssh/editor/getPassedByNewsName" method="get">
		软文名称 <input type="text" name="RRname" id="RRname"
			class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary" id="search">搜索</button>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>软文标题</th>
				<th>图片</th>
				<th>审核人</th>
				<th>上架时间</th>
				<th>下架时间</th>
				<th>等级</th>
				<th>操作</th>
			</tr>
		</thead>
		<c:if test="${RRLIST!=null}">
			<c:forEach items="${RRLIST}" var="rr">
				<tr>
					<td>${rr.name}</td>
					<td>${rr.picUrl}</td>
					<td>${rr.chiefEditor.name}</td>
					<td>${rr.onShowTime}</td>
					<td>${rr.offShowTime}</td>
					<td>${rr.rank}</td>
					<%
						java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
										"yyyy-MM-dd");
						java.util.Date now = new java.util.Date();
						String str_date = formatter.format(now); 
					%>
					<c:if test="${rr.onShowTime.compareTo(str_date)<=0}">
						<td><a href="/test_ssh/news/showNews?type=6">查看</a>&nbsp;&nbsp;<a href="/test_ssh/editor/withdraw?newsId=${rr.id}&type=2">撤回</a></td>
					</c:if>
					<c:if test="${rr.onShowTime.compareTo(str_date)>0}">
						<td><a href="/test_ssh/news/showNews?type=6">查看</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
	</table>

</body>
</html>