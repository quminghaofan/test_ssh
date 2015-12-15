<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
<link rel="stylesheet" type="text/css" href="../Css1/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css1/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css1/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>
<script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
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
    根据<select style="width:auto">
    <option value="艺术品名">艺术品名</option>
    <option value="卖家">卖家</option>
    <option value="买家">买家</option>
    </select>搜索<br>
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp; <br>
    <input name="txtDate time1" id="txtDate time1" class="Wdate" type="text" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" onchange="price_count()"/><br>
    <input name="txtDate time1" id="txtDate time1" class="Wdate" type="text" onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" onchange="price_count()"/>
    <button type="submit" class="btn btn-primary" id="search" name="search">搜索</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>艺术品名</th>
        <th>卖家</th>
        <th>买家</th>
        <th>价格</th>
        <th>类型</th>
        <th>订单时间</th>
        <th>订单状态</th>
        <th></th>
    </tr>
    </thead>
    <c:if test="${ORDERLIST!=null}">
    <c:forEach items="${ORDERLIST}" var="user">
        <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
    </c:forEach>
</c:if>
        </table>

</body>
</html>
