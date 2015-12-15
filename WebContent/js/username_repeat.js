
/** 
* 验证用户名是否重复的js 
* 
* @name username_repeat.js 
* @author jason<msn:x334@eyou.com> 
* @use 验证用户名是否存在 
* @todo 
*/ 
$(document).ready(function(){ 
checkConfirm(); 
}); 
//验证用户名是否存在 
function checkConfirm(){ 
$("#username").blur(function(){ 
var name = $(this).val(); 
var changeUrl = "UsernameAdmin.php?action=check&name="+name; 
$.get(changeUrl,function(str){ 
if(str == '1'){ 
$("#username_blank").text("您输入的用户名存在！请重新输入！"); 
}else{ 
$("#username_blank").text(""); 
} 
}) 
return false; 
}) 
} 