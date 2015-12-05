<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
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


    </style>
</head>
<body>

<form class="form-inline definewidth m20" action="/test_ssh/admin_user/getUser" method="get">
    用户名  <!-- TODO 根据用户名或角色查询，做成下拉框 -->
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary" id="search" name="search">搜索</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr><!-- 超级管理员：用户交易记录，平台收入查询（可根据时间），人员工资结算，查询某个用户的工资详情（可根据时间）-->
        <th>用户名</th>
        <th>角色</th>
        <th>银行卡号</th>
    </tr>
    </thead>
    <c:if test="${USERLIST!=null}">
    <c:forEach items="${USERLIST}" var="user">
        <tr>
                <td>${user.name}</td>
                <td>${user.role}</td>
                <td>${user.bankCardAccount}</td>
            </tr>
    </c:forEach>
</c:if>
        </table>

</body>
</html>
<script>
    

</script>