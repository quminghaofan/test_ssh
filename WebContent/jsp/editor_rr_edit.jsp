<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑</title>
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
<form action="/test_ssh/editor/editNews" method="post" class="definewidth m10">
<table class="table table-bordered table-hover m10">
    <tr>
            <td width="10%" class="tableleft">软文标题</td>
            <td><input type="text" name="RRname" value="${news.name}"/></td>  <!--TODO-->
        </tr>
        <tr>
            <td class="tableleft">内容</td>
            <td><input id="RRcontent" type="text" name="RRcontent" value="${news.content}"/></td>  <!--TODO-->
        </tr>
        <tr>
            <td class="tableleft">图片</td>
            <td><img id="image" src="${news.picUrl}"></td>
            <td><input id="img" name="img" type="file" accept="image/*" /></td>
        </tr>
    <tr>
            <td class="tableleft"></td>
            <td>
                <button type="submit" class="btn btn-primary" type="button"  name="btnid" id="btnid">发送</button>				 &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
            </td>
        </tr>
</table>
</form>
</body>
</html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>  
<script type="text/javascript">  
$(function(){  
	$('#img').change(function(){  
		var file = this.files[0]; //选择上传的文件  
		var r = new FileReader();  
		r.readAsDataURL(file); //Base64  
		document.getElementById("image").src=this.result;
		});  });

$(function () {       
	$('#backid').click(function(){
			window.location.href="/test_ssh/jsp/editor_rr_1.jsp";
	 });

});
</script>