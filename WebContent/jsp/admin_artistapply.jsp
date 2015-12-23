<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>艺术家申请审核</title>
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

#masklayer{
    
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: rgba(0,0,0,.7);
    z-index: 9;
}
    </style>
</head>
<body>

<form class="form-inline definewidth m20" action="/test_ssh/admin_user/getUser" method="get">
  
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary" id="search" name="search">搜索</button>
</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>用户名</th>
        <th>真实姓名</th>
        <th>银行卡号</th>
        <th>个人介绍</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:if test="${USERLIST!=null}">
    <c:forEach items="${USERLIST}" var="user">
        <tr>
                <td>${user.name}</td>
                <td>${user.realName}</td>
                <td>${user.bankCardAccount}</td>
                 <td>${user.description}</td>
                 <td><a href="/test_ssh/admin_user/exmineArtist/userId=${user.id}&type=1">通过</a>&nbsp;&nbsp;<a href="javascript:showreason(${user.id})">不通过</a></td>
            </tr>
    </c:forEach>
</c:if> 
        </table>

<div style="display: none;" id="reason" align="center">
<div id="masklayer" ></div>
<input type="hidden" id="userid" name="userid">
<div style="z-index:10;position:absolute;left:30%;background-color:white;width:30%;height:30%" >
<h3>未通过理由</h3>
<form class="form-inline definewidth m20" action="" method="post" id="reasonform">
    <input type="text" name="username" id="username"class="abc input-default" placeholder="" value="">&nbsp;&nbsp; 
    <button type="submit" class="btn btn-primary" onclick="fail()">确定</button>
</form>
</div>
</div>

</body>
</html>
<script>
    function showreason(userid){
        document.getElementById("reason").style.display="block";
        document.getElementById("userid").value=userid;
        }
function fail(){alert("a");
	var userid=document.getElementById("userid").value;
	var reason=document.getElementById("reasonform");
	reason.action="/test_ssh/admin_user/exmineArtist/userId="+userid+"&type=0";
	reason.submit();
}
</script>