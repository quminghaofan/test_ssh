<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>软文详情</title>
<meta name="keywords" content=""/>
    <!--视频不兼容前调-->
    <script src="http://v.ifeng.com/include/citeswfobject.js"></script>
    <!--头部不兼容前调-->
    <script src="http://y1.ifengimg.com/BX/min/BX.1.0.1.U.js" ></script>
	<script src="http://y0.ifengimg.com/base/jQuery/jquery-1.9.1.min.js"></script>
    <script src="http://y0.ifengimg.com/commonpage/1130/F-RequireJS.min.js"></script>
	<script>var jq=jQuery.noConflict();</script>
	<script src="http://y0.ifengimg.com/38716b164e0f5e63/2013/1213/md5.js"></script>
    <link rel="stylesheet" href="http://res.img.ifeng.com/css/basic_new_v2.css" />
    <link rel="stylesheet" type="text/css" href="http://y2.ifengimg.com/a/2014/1110/dxrw-1110.css"/>
	<cmpp><script src="http://m1.ifengimg.com/ifeng/sources/inice_v1.js"></script></cmpp>
	<cmpp><script src="http://h0.ifengimg.com/20150625/fa.min.js"></script></cmpp>
				<style type="text/css">
			#textarea{
				resize : none;
				width:590;
				overflow:auto;
				background-attachment:fixed;
				background-repeat:no-repeat;
				border-style:solid; 
				border-color:#FFFFFF
			}
			</style>
</head>
<body>
<!--Header begin-->
<script src="http://y1.ifengimg.com/BX/min/BX.1.0.1.U.js"></script>
<style>
    .allHeader { background: #fff; text-align: left; line-height: 14px; }
    .allHeader a { color: #000; text-decoration: none; }
    .allHeader a:hover { color: #000; text-decoration: underline; }
    .clear { clear: both; }
    .allHeader .speHeader { width: 988px; height: 30px; _height: 26px; margin: 0 auto; padding: 3px 6px; _padding-bottom: 0px; background: #fff; font-family: simsun, Arial; font-size: 12px; }
    .allHeader .speLogo { float: left; height: 30px; height: 30px; }
    .allHeader .speLogo img { display: block; border: 0px; }
    .allHeader .speLink { float: left; height: 18px; font-size: 14px; padding-top: 12px; color: #416472; }
    .allHeader .speLink a { color: #416472; padding: 0px 7px; }
    .allHeader .speNav { float: left; height: 16px; padding: 14px 10px 0px 1px; color: #666; line-height: 12px; }
    .allHeader .speNav a { color: #666; }
    .allHeader .navFind { float: right; margin-right: 7px; _margin-right: 3px; width: 273px; padding: 5px 0 8px; _padding-bottom: 6px; }
    .allHeader .navFind span { float: left; }
    .allHeader .navFind .headText { width: 141px; height: 16px; padding: 2px 0 0 5px; margin-top: 1px !important; *margin-top: 0px !important; margin-top: 0; margin-right: 7px; background: #fff; border: 1px solid #819bb4; color: #646464; font-size: 12px; line-height: 16px; }
    .allHeader .navFind .headSel { width: 46px; height: 18px; margin: 1px 9px 0 0; padding: 0px 0 0 11px; border: 1px solid #819bb4; border-right: none; background: #fff url(http://img.ifeng.com/tres/TemplateRes/14415/14415/images/general_head/nav0416_04.gif) no-repeat right center; font-size: 12px; color: #646464; cursor: pointer; line-height: 18px; }
    .allHeader .navFind .headButton { width: 51px; height: 20px; padding: 1px 0 0 2px; margin: 1px 0 0; border: none; background: url(http://img.ifeng.com/tres/TemplateRes/14415/14415/images/general_head/navFind.gif) no-repeat 0 0; color: #000; font-weight: bold; cursor: pointer; }
    .allHeader #searchFormOption { position: relative; float: left; z-index: 80; }
    .allHeader #loginFldselectop { position: absolute; border: 1px solid #DFDFDF; top: 20px; left: 0px; width: 73px; background: #fff; z-index: 99; margin: 0px; padding: 0px; }
    .allHeader #loginFldselectop li { line-height: 20px; height: 20px; list-style: none; }
    .allHeader #loginFldselectop li a { line-height: 20px; height: 20px; text-decoration: none; color: #000; padding-left: 11px; }
    .allHeader .stockList { position: absolute; top: 45px; left: 0; width: 300px; border: 1px solid #195184; background: #fff; z-index: 999; }
    .allHeader .stockList a, .stockList a:visited { color: #0A5EA6; }
    .allHeader .stockList .headTab td { border-bottom: 1px solid #ECECEC; height: 21px !important; *height: 20px !important; height: 20px; padding-left: 12px; text-align: left; color: #333; }
    .allHeader .stockList .headTab tr.current { background: #194E80; }
    .allHeader .stockList .headTab tr.current td { color: #fff; background: #194E80; }
    .allHeader .stockList .headTab tr.current td a { color: #fff; }
    .allHeader .stockList .headRed { color: #f00; }
    .allHeader .speHeaLin { background: #d9d9d9; height: 1px; line-height: 1px; font-size: 1px; clear: both; }
</style>
<script src="http://y0.ifengimg.com/20140822/inice.min.js"></script>
<div class="allHeader">
    <div class="speHeaLin"></div>
    <script src="http://y0.ifengimg.com/base/jQuery/jquery-1.8.3.min.js"></script>
</div>
<!--Title begin-->
<div class="ExcTit">
		<div class="ExcTitCon clearfix">
            <div class="ExcShare fr">
                <!--share begin-->
                <div>
                    <script src="http://y0.ifengimg.com/commonpage/1130/F-RequireJS.min.js"></script>
                    <script>
                        var suffix = device.type === "pc" ? ".pc" : ".mobile";                       
                        requirejs.config({
                        paths: {
                            // 基础模块
                            "F": "http://y0.ifengimg.com/base/origin/F-amd-1.2.0.min",
                            "FM":  "http://y0.ifengimg.com/commonpage/1130/F-amd-mobile-1.1.0.min",
                            "debug": "http://y0.ifengimg.com/commonpage/1130/F-amd-mobile-1.1.0.min",
                                              
                            // 视频播放器
                            "video.pc": "http://y0.ifengimg.com/commonpage/2014/0304/video.pc.min",
                            "video.mobile": "http://y0.ifengimg.com/commonpage/1130/video.mobile.min",
                        
							//返回顶部
                            "utils": "http://y0.ifengimg.com/commonpage/2014/0304/utils.pc.min",
                            
                            // 通用登录
                            "public_login": "http://y0.ifengimg.com/p/login/20131227/public_login.min",
                            // 统计脚本
                            "sta": "http://y3.ifengimg.com/sta_collection.3.3.10.min"
                        },
                        waitSeconds: 20,
                        shim: {}
                        });
                        tasker.runAfterDomReady();
                    </script>
                    <style>
                        .new_share{margin:0 7px;}
                    </style>
					<div>
					<a class="Excbds_tsina js_swShare new_share" data-type="sina" href="#"></a>
                        <a class="Excbds_qzone js_qzShare new_share" data-type="qqZone" href="#"></a>
                        <a class="Excbds_twx js_qrcode new_share" data-type="weixin" href="#"></a>
                    </div>
                </div>
                <script>
                    var data_info = eval('('+jq(".js_shareList").closest("[data-info]").attr("data-info")+')');
                    var url = data_info.url;

                    updateQrcode();

                    function updateQrcode(){
                        jq.ajax({
                            type:'GET',
                            url:"http://qrcode.ifeng.com/qrcode.php",
                            dataType:'jsonp',
                            data:{url:url},
                            success: function(data) {
                                var src = data.qrcode_url; 
                                jq('.js_qrcode').attr('src',src);
                            }
                        });
                    }

                    jq('.Excbds_twx').click(function(){
                        jq('.js_weixin').toggle(200);
                    });
                    jq('.js_wx_close').click(function(){
                        jq('.js_weixin').toggle(200);
                    });
                    
                </script>
            </div>
        </div>
    </div>
<!--Title end-->

<!--Contain begin-->
<div class="ExcConBox">
	<div class="ExcAllCon">
		<div class="ExcCon">
			<div class="ExcCon01">
				<a href="/test_ssh/news/goback?type=${type}">返回首页</a>
				<h1 align="center">软文标题：<input type="text" name="RRname" style="border:none" value="${news.name}" readonly="readonly"/></h1>
				<pre class="f14 cGray" align="center">
				主编：<input type="text" name="RRname" style="border:none" value="${news.chiefEditor}" readonly="readonly"/>
				</pre>
				<pre class="f14 cGray" align="center">
				采编：<input type="text" name="RRname" style="border:none" value="${news.editor}" readonly="readonly"/>
				</pre> 
			</div>
			<div>
				<video width="590" height="340" controls>
					<source src="__VIDEO__.MP4"  type="video/mp4" />
					<source src="__VIDEO__.OGV"  type="video/ogg" />
					<object width="640" height="360" type="application/x-shockwave-flash" data="__FLASH__.SWF">
						<param name="movie" value="__FLASH__.SWF" />
						<param name="flashvars" value="controlbar=over&image=__POSTER__.JPG&file=__VIDEO__.MP4" />
						<img src="__VIDEO__.JPG" width="640" height="360" alt="__TITLE__" title="No video playback capabilities, please download the video below" />
					</object>
				</video>
			</div>
			<div class="ExcConPicBox">
				<img src="${news.picUrl}" height="340" width="590" readonly="readonly"/>
	        </div>
			<div class="ExcCon04 ExcWay" id="ExcWay01" name="ExcWay01">
				<span><textarea name="content" id="textarea" style="text-indent: 2em" wrap="virtual" readonly="readonly">${news.content}</textarea></span>	
			</div>
		</div>
		<div id="fright">
              <div class="bdsharebuttonbox">
				<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
				<a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
				<a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a>
				<a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a>
				<a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
			  </div>
		      <script>
				window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"24"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
			  </script>
			  <style type="text/css">
			    #fright{
					position:fixed;
				
				}
			  </style>
            </div>
		<div class="share clearfix">
			<div class="fleft" align="center"><a href="javascript:window.close()" class="close">关闭窗口</a></div>
        </div>
	</div>
</div>
</body>
</html>