<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核</title>
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
<form method="post" class="definewidth m10" id="myform">
  <table class="table table-bordered table-hover m10">
  		<tr>
            <td width="10%" class="tableleft">软文类型</td>
            <td><input type="text" name="RRname" value="${news.newsType}" readonly="readonly"/></td>  <!--TODO-->
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
            <td><span><img id="image" src="${news.picUrl}" width="30%" height="30%""></span>
        </tr>
        <tr>
            <td width="10%" class="tableleft">上架时间</td>
            <td>
		<input name="txtDate time1" id="txtDate time1"
					class="Wdate" type="text"
					onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
					onchange="price_count()" value="${news.onShowTime}"/>
		
			</td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">下架时间</td>
            <td>
		<input name="txtDate time2" id="txtDate time2"
					class="Wdate" type="text"
					onfocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
					onchange="price_count()" value="${news.offShowTime}"/> 	
						
			</td>
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
             <input class="btn btn-primary" type="submit"  name="btnid" id="btnid" onclick="submit1()" value="通过">				 &nbsp;&nbsp;
             <input class="btn btn-primary" type="submit"  name="btnid" id="btnid" onclick="submit2()" value="不通过">				 &nbsp;&nbsp;
             <input type="button" class="btn btn-success" name="backid" id="backid" onclick="if(window.confirm('确定返回吗？未保存的内容可能丢失')) window.location.href='/test_ssh/chiefEditor/goback?type=${typeExamine}'" value="返回列表"> </td>
        </tr>
  </table>
</form>
<input type="hidden" id="typeExamine" value="${typeExamine}">
</body>
</html>



<script type="text/javascript">  
$(function(){  
	$('#img').change(function(){  
		var file = this.files[0]; //选择上传的文件  
		var r = new FileReader();  
		r.readAsDataURL(file); //Base64  
		document.getElementById("image").src=this.result;
		});  });
		
$(function(){  
	$('#img').change(function(){  
		var file = this.files[0]; //选择上传的文件  
		var r = new FileReader();  
		r.readAsDataURL(file); //Base64  
		document.getElementById("video").src=this.result;
		});  });
		
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
function submit1(){
	var myform=document.getElementById("myform");
	var typeExamine=document.getElementById("typeExamine").value;
	myform.action="/test_ssh/chiefEditor/examineNews?type=1&typeExamine="+typeExamine;
	myform.submit();
	//return true;
}
function submit2(){
	var myform=document.getElementById("myform");
	var typeExamine=document.getElementById("typeExamine").value;
	myform.action="/test_ssh/chiefEditor/examineNews?type=0&typeExamine="+typeExamine;
	myform.submit();
}

</script>
