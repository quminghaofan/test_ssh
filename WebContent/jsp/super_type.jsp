<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>产品类别管理</title>
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
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>产品类别编号</th>
        <th>产品类别名称</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:if test="${TYPELIST!=null}">
    <c:forEach items="${TYPELIST}" var="type">
        <tr>
                <td>${type.number}</td>
                <td>${type.name}</td>
                <td><a href="javascript:void(0)" onclick="if(window.confirm('确定删除该项吗？')) this.href='/test_ssh/super/delArtType?typeId=${type.id}'">删除</a></td>
            </tr>
    </c:forEach>
</c:if>
        </table>


<form class="form-inline definewidth m20" action="/test_ssh/super/addArtType" method="post" id="type" style="display:none"><!-- TODO 编号规则：两位整数，不存在数据库里的 -->
     <div>
     <span style="margin-left:38%">产品类别名称：</span>
     <input  type="text"  id="typename" name="typename" class="abc input-default" placeholder="" value="" style=";margin-left:42.5%;width:25%">
    </div>
    <br><br>
    <button  type="submit" class="btn btn-primary" id="confirm" style="margin-left:50%">确认</button>&nbsp;&nbsp;

</form>
<div style="margin-left:50%">
 <input type="button" class="btn btn-primary" id="cancel" onclick="cancel()"style="display:none" value="取消">&nbsp;&nbsp;
 <br>
 <input type="button" class="btn btn-primary" id="addnew" onclick="addnew()" value="新增">&nbsp;&nbsp; 
 </div>
</body>
</html>
<script>
function cancel(){
	
	document.getElementById("addnew").style.display="block";
	document.getElementById("type").style.display="none";
	document.getElementById("cancel").style.display="none";
}
function addnew(){
	document.getElementById("confirm").style.display="block";
	document.getElementById("addnew").style.display="none";
	document.getElementById("type").style.display="block";
	document.getElementById("cancel").style.display="block";
}
</script>
