
/** 
* ��֤�û����Ƿ��ظ���js 
* 
* @name username_repeat.js 
* @author jason<msn:x334@eyou.com> 
* @use ��֤�û����Ƿ���� 
* @todo 
*/ 
$(document).ready(function(){ 
checkConfirm(); 
}); 
//��֤�û����Ƿ���� 
function checkConfirm(){ 
$("#username").blur(function(){ 
var name = $(this).val(); 
var changeUrl = "UsernameAdmin.php?action=check&name="+name; 
$.get(changeUrl,function(str){ 
if(str == '1'){ 
$("#username_blank").text("��������û������ڣ����������룡"); 
}else{ 
$("#username_blank").text(""); 
} 
}) 
return false; 
}) 
} 