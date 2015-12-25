<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>管理员信息</title>
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
<%User user=(User)session.getAttribute("user"); %>
  <table class="table table-bordered table-hover m10">
  		<tr>
            <td width="10%" class="tableleft">用户名</td>
            <td><input type="text"  value="<%=user.getName() %>" readonly="readonly"/></td>
        </tr>
		<tr>
            <td width="10%" class="tableleft">角色</td>
            <td><input type="text" value="<%=user.getRole().getName() %>" readonly="readonly"/></td>
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><input type="text"  value="<%=user.getRealName() %>" readonly="readonly"/></td>
        </tr>
        <tr id="psw_edit">
            <td class="tableleft"></td>
            <td>
            <input type="button" class="btn btn-primary" onclick="myform.style.display='block';psw_edit.style.display='none'" value="修改密码">
             	</td>	
             	</tr>	
        </table>
        <form method="post" class="definewidth m10" id="myform" style="display:none" onsubmit="return before_edit()" action="/test_ssh/super/changePsw?userId=<%=user.getId() %>">
        <table class="table table-bordered table-hover m10">
        <tr>
            <td class="tableleft">新密码</td>
            <td><input type="password" id="password" name="password" placeholder="请输入您的新密码"/>
            <span id="psw_blank" style="display: none"><font color="red">密码不能为空</font></span></td>
        </tr>
        <tr>
            <td class="tableleft">确认新密码</td>
            <td><input type="password" id="password2"  placeholder="请再次输入您的新密码"/>
            <span id="psw_blank1" style="display: none"><font color="red">密码不一致</font></span></td>
        </tr>
		<tr>
            <td class="tableleft"></td>
            <td>
             <input class="btn btn-primary" type="submit"  name="btnid" id="btnid" onClick="myform.onsubmit()"  value="确定">				 &nbsp;&nbsp;<input class="btn btn-primary" type="button"  name="btnid" id="btnid" value="取消" onclick="psw_edit.style.display='block';myform.style.display='none'">				 </td>
        </tr>
  </table>
</form>
</body>
</html>
<script>
function before_edit(){
	var flag=0;

	if(document.getElementById("password").value==""){
		document.getElementById("psw_blank").style.display="block";
        flag=1;
	}
	if(document.getElementById("password2").value==""){
		document.getElementById("psw_blank1").style.display="block";
		flag=1;
	}	
	if(document.getElementById("password").value!=document.getElementById("password2").value)
	{
		document.getElementById("psw_blank1").style.display="block";
		flag=1;
	}	
	
	if(flag==1)
		return false;
	
}
</script>
