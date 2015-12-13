<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增管理员</title>
<link rel="stylesheet" type="text/css" href="../Css1/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css1/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css1/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>
    <script type="text/javascript" src="../js/pictureload.js"></script>
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
    
     <link rel="stylesheet" href="../texteditor/themes/default/default.css" />
        <script charset="utf-8" src="../texteditor/kindeditor-min.js"></script>
        <script charset="utf-8" src="../texteditor/lang/zh_CN.js"></script>
        <script>
            var editor;
            KindEditor.ready(function(K) {
                editor = K.create('textarea[name="content"]', {
                    allowFileManager : true
                });
            });
                </script>
                <script language="javascript" type="text/javascript" src="../My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<form action=""  method="post" class="definewidth m10" id="myform" name="myform">
<table class="table table-bordered table-hover m10">
    <tr>
            <td width="10%" class="tableleft">管理员账号</td>
            <td><input type="text" name="adminname"/></td>  <!--TODO-->
        </tr>
        <tr>
            <td class="tableleft">真实姓名</td>
            <td><intput type="text" name="realname"></intput></td>  <!--TODO-->
        </tr>
       <tr>
            <td class="tableleft">角色</td>
            <td><select>
            <c:forEach items="${ROLELIST}" var="role">
            <option value="${role.name}">${role.name}</option>
            </c:forEach>
            </select></td>  <!--TODO-->
        </tr>
       

    <tr>
            <td class="tableleft"></td>
            <td>
            <input style="display:none" id="type" name="type"/>
               <input class="btn btn-primary" type="submit"  name="savebtnid" id="savebtnid" onclick="submit1()" value="保存">				 &nbsp;&nbsp; 
               <input type="button" class="btn btn-success" name="backid" id="backid" onclick="if(window.confirm('确定返回吗？未保存的内容可能丢失')) window.location.href='/test_ssh/editor/getDraft'" value="返回列表">
            </td>
        </tr>
</table>
</form>
</body>
</html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>  
