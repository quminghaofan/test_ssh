﻿<%@page import="cn.edu.xmu.oneonezero.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>后台管理系统</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="../assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
  <link href="../assets/css/bui-min.css" rel="stylesheet" type="text/css" />
   <link href="../assets/css/main-min.css" rel="stylesheet" type="text/css" />
 </head>
 <body>

  <div class="header">
    
      <div class="dl-title">
       <!--<img src="/chinapost/Public/assets/img/top.png">-->
      </div>

      <% User user=(User)session.getAttribute("user");%>
    <div class="dl-log">欢迎您，<span class="dl-log-user"><%=user.getName()%></span><a href="/test_ssh/init/logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
  </div>
   <div class="content">
    <div class="dl-main-nav">
      <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
      <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">软文</div></li>

      </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
   </div>
  <script type="text/javascript" src="../assets/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="../assets/js/bui-min.js"></script>
  <script type="text/javascript" src="../assets/js/common/main-min.js"></script>
  <script type="text/javascript" src="../assets/js/config-min.js"></script>
  <script>
    BUI.use('common/main',function(){ 
      var config = [{id:'1',homePage:'5',menu:[{text:'软文',items:[{id:'6',text:'个人信息修改',href:'/test_ssh/jsp/admin_info.jsp'},
                                                    {id:'12',text:'待审核',href:'/test_ssh/editor/getUnexamined'},
                                                    {id:'3',text:'未通过',href:'/test_ssh/editor/getUnPassed'},
                                                    {id:'4',text:'已通过',href:'/test_ssh/editor/getPassed'},
                                                    {id:'5',text:'草稿',href:'/test_ssh/editor/getDraft'}]}]}];
      new PageUtil.MainPage({
        modulesConfig : config
      });
    });
  </script>
 </body>
</html>