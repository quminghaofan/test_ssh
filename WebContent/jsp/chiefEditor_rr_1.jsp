<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>未审核</title>
<link rel="stylesheet" type="text/css" href="../Css1/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="../Css1/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="../Css1/style.css" />
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/jquery.sorted.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/ckform.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/pictureload.js"></script>
<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}

#vedio {
	height: 50px;
}

		date{display:block;}
	
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
		#newType{
		  height:30px;
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

<link rel="stylesheet" href="../texteditor/themes/default/default.css" />
<script charset="utf-8" src="../texteditor/kindeditor-min.js"></script>
<script charset="utf-8" src="../texteditor/lang/zh_CN.js"></script>
<script>
            var editor;
            KindEditor.ready(function(K) {
                editor = K.create('textarea[name="content"]', {
                	 resizeType : 1,
                     allowPreviewEmoticons: false,
                     allowImageUpload:true,//允许上传图片
                    allowFileManager : true,
                    uploadJson:'../texteditor/jsp/upload_json.jsp', //上传图片的java代码，只不过放在jsp中
                    fileManagerJson:'../texteditor/jsp/file_manager_json.jsp',
                    afterUpload: function(){this.sync();}, //图片上传后，将上传内容同步到textarea中
                    afterBlur: function(){this.sync();},   ////失去焦点时，将上传内容同步到textarea中
                });
            });
                </script>
<script language="javascript" type="text/javascript"
	src="../My97DatePicker/WdatePicker.js"></script>
</head>
<body>

<form class="form-inline definewidth m20"
		action="/test_ssh/chiefEditor/search?type=1" method="post">
		<font color="blue">软文类型: </font><select id="newsType" name="category" class="category">
			<option selected></option>
			<option value="广告">广告</option>
			<option value="资讯">资讯</option>
		</select> <font color="blue">开始时间: </font>
			<input name="txtDate time1" id="txtDate time1"
					class="Wdate" type="text"
					onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
					onchange="price_count()" />
			
			<font color="blue">结束时间: </font>
		<input name="txtDate time2" id="txtDate time2"
					class="Wdate" type="text"
					onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
					onchange="price_count()" /> <span id="time_err"
					style="display: none"><font color="red">下架时间不能小于上架时间</font></span>				
			<input type="text"
			name="RRname" id="RRname" class="abc input-default"
			placeholder="请输入软文名称关键字......" value="">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary" id="search"
			name="search">搜索</button>
	</form>
<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
        <th>软文标题</th>
        <th>作者</th>
        <th>上架时间</th>
        <th>下架时间</th>
        <th>价格</th>
        <th>类型</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:if test="${RRLIST!=null}">
    <c:forEach items="${RRLIST}" var="rr">
        <tr>
                <td>${rr.name}</td>
                <td>${rr.editor.name}</td>
                <td>${rr.onShowTime}</td>
                <td>${rr.offShowTime}</td>
                <td>${rr.price}</td>
                <td>${rr.newsType}</td>
            <td><a href="/test_ssh/news/showNews?newsId=${rr.id}&type=2">查看</a>&nbsp;&nbsp;<a href="/test_ssh/chiefEditor/getNews?type=1&newsId=${rr.id}">审核</a></td>
            </tr>
    </c:forEach>
	</c:if>
</table>
</body>
</html>
<script type="text/javascript">  
		
function price_count(){
	var sDate1=document.getElementById("txtDate time1").value;
	var sDate2=document.getElementById("txtDate time2").value;
	document.getElementById("time_err").style.display="none";
	if(sDate1!=""&&sDate2!=""){
	  var  aDate,  oDate1,  oDate2,  iDays  
      aDate  =  sDate1.split("-")  
      oDate1  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])    //转换为12-18-2002格式  
      aDate  =  sDate2.split("-")  
      oDate2  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0]) 
	  if(oDate1>oDate2)
		  document.getElementById("time_err").style.display="block";
	  else{
      iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24) ;   //把相差的毫秒数转换为天数  
      var price=iDays*300;
	  document.getElementById("price").value=price;
	  }
	}
}


</script>