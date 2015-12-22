<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="ajaxupload.3.5.js" type="text/javascript"> </script>
<script src="jquery-1.4.4.min.js" type="text/javascript"> </script>
<body>
<div class="y_nextto_left">
      <h1>头像</h1>
      <div class="y_tou_img" id="status1">
	<%-- <c:if test="${empty sysuserinfo.headimgpath}"><img src="${path }/home/images/y_rentou.gif" /></c:if>
	<c:if test="${not empty sysuserinfo.headimgpath}"><img src="${path}/${sysuserinfo.headimgpath}" /></c:if> --%>
      </div>
      <div id="files1"></div>
      <p><label>更改头像：</label><br />
	<input type="hidden" id="headimgpath" name="headimgpath" value="${sysuserinfo.headimgpath}"/>
	<input type="button" value="上传头像" id="upload1" style="width: 70px;height: 25px" onmouseover="uploadAll('${path}','upload1','status1','files1','SystemUserInfo','headimgpath')"/>
      </p>
    </div>
</body>
</html>