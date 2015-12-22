<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>管理员管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css1/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css1/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css1/style.css" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
    <script type="text/javascript" src="../js/ckform.js"></script>
    <script type="text/javascript" src="../js/common.js"></script>

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


    </style>
</head>
<body>
<form class="form-inline definewidth m20" action="/test_ssh/super/getAdmin" method="get">
    管理员账号
    <input type="text" name="rolename" id="rolename"class="abc input-default" placeholder="" value="">&nbsp;&nbsp;
    <button type="submit" class="btn btn-primary" id="search" name="search">搜索</button>&nbsp;&nbsp; <input type="button" class="btn btn-success" id="addnew" onclick="window.location.href='/test_ssh/super/goToAddAdmin'" value="新增管理员"/>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>管理员账号</th>
        <th>真实姓名</th>
        <th>角色</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:if test="${ADIMLIST!=null}">
    <c:forEach items="${ADMINLIST}" var="admin">
        <tr>
                <td>${admin.name}</td>
                <td>${admin.role.name}</td>
                <td><a href="/test_ssh/super/goToEdit?userId=${admin.id}">编辑</a>
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="/test_ssh/super/delAdmin?userId=${admin.id}">禁用</a></td>
            </tr>
    </c:forEach>
</c:if>
        </table>

</body>
</html>