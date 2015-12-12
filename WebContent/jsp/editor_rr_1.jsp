<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>待审核</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css1/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css1/bootstrap-responsive.css" />
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

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }
		#type{
			width:115px;		
		}
		#onShowTime{
			width:140px;
			height:25px;
		}
		#offShowTime{
			width:140px;
			height:25px;
		}
		#RRname{
			height:25px;
		}


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="/test_ssh/editor/getUnreviewedByNewsName" method="get">
 	<font color="blue">软文类型: </font><select id="type" name="category" class="category"> 
	<option>广告</option>
	<option>新闻资讯</option>
	</select>
	<font color="blue">上架时间: </font><input id="onShowTime" type="date" name="user_date" />
	<font color="blue">下架时间: </font><input id="offShowTime" type="date" name="user_date" />
	<input type="text" name="RRname" id="RRname"class="abc input-default" placeholder="请输入搜索内容......" value="">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary" id="search" name="search">搜索</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>软文标题</th>
        <th>上架时间</th>
		<th>下架时间</th>
		<th>软文类型</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:if test="${RRLIST!=null}">
    <c:forEach items="${RRLIST}" var="rr">
        <tr>
                <td>${rr.editor.name}</td>
				<td>${rr.editor.onShowTime}</td>
				<td>${rr.editor.offShowTime}</td>
				<td>${rr.editor.type}</td>
                <td><a href="">查看</a>&nbsp;&nbsp;<a href="">撤回</a>&nbsp;&nbsp;<a href="javascript:void(0)" onclick="if(window.confirm('确定删除该项吗？')) this.href='/test_ssh/editor/delNews?newsId=${rr.id}'">删除</a></td>
            </tr>
    </c:forEach>
</c:if>
        </table>

</body>
</html>