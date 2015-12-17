<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>审核</title>
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
<form action="/test_ssh/jsp/chiefEditor_rr_1.jsp" method="post" class="definewidth m10">
  <table class="table table-bordered table-hover m10">
  		<tr>
            <td width="10%" class="tableleft">软文类型</td>
            <td><input type="text" name="RRname" value="${news.type}" readonly="readonly"/></td>  <!--TODO-->
        </tr>
		<tr>
            <td width="10%" class="tableleft">软文标题</td>
            <td><input type="text" name="RRname" value="${news.name}" readonly="readonly"/></td>  <!--TODO-->
        </tr>
        <tr>
            <td class="tableleft">内容</td>
            <td><textarea name="content" readonly="readonly">${news.content}</textarea></td>  <!--TODO-->
        </tr>
        <tr>
            <td class="tableleft">图片</td>
            <td><span><img id="image" src="${news.picUrl}"></span>
        </tr>
        <tr>
            <td width="10%" class="tableleft">上架时间</td>
            <td><input name="txtDate time1" id="txtDate time1" class="Wdate" type="date" readonly="readonly"/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">下架时间</td>
            <td><input name="txtDate time2" id="txtDate time2" class="Wdate" type="date" readonly="readonly"/></td>
        </tr>
         <tr>
            <td width="10%" class="tableleft">价格</td>
            <td><input type="text" name="RRname" value="${news.name}" readonly="readonly"/></td>  <!--TODO-->
        </tr>
        <tr>
            <td width="10%" class="tableleft">等级</td>
            <td><select name="rank" id="rank">
                <option selected="selected" value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select></td>
        </tr>
		<tr>
            <td class="tableleft"></td>
            <td>
             <input class="btn btn-primary" type="submit"  name="btnid" id="btnid" onclick="submit1()" value="通过">				 &nbsp;&nbsp;<input class="btn btn-primary" type="submit"  name="btnid" id="btnid" onclick="submit2()" value="不通过">				 &nbsp;&nbsp;<input type="button" class="btn btn-success" name="backid" id="backid" onclick="if(window.confirm('确定返回吗？未保存的内容可能丢失')) window.location.href='/test_ssh/chiefEditor/getUnExamined'" value="返回列表"> </td>
        </tr>
  </table>
</form>
</body>
</html>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script>
function submit1(){
	var myform=document.getElementById("myform");
	myform.action="/test_ssh/chiefEditor/examineNews?type=1&typeExamine=${typeExamine}";
	myform.submit();
	//return true;
}
function submit2(){
	var myform=document.getElementById("myform");
	myform.action="/test_ssh/chiefEditor/examineNews?type=0&typeExamine=${typeExamine}";
	myform.submit();
}
</script>
